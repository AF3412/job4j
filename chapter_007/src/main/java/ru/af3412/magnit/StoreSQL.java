package ru.af3412.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Store sql.
 */
public class StoreSQL implements AutoCloseable {
    private static final Logger LOG = LogManager.getLogger(StoreSQL.class.getName());

    private final Config config;
    private Connection connect;

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }

    /**
     * Instantiates a new Store sql.
     *
     * @param config the config
     */
    public StoreSQL(Config config) {
        this.config = config;
        String fileName = config.get("sqlite.url").replaceFirst("jdbc:sqlite:", "");
        File dbFile = new File(fileName);
        if (!dbFile.exists()) {
            LOG.info("Database {} not found", dbFile.getName());
            createNewDatabase();
        }
    }

    /**
     * Generate.
     *
     * @param size the size
     */
    public void generate(int size) {
        final String insertField = "INSERT INTO entry(field) VALUES(?)";
        if (connect()) {
            createNewTable();
            try (PreparedStatement stmt = this.connect.prepareStatement(insertField)) {
                connect.setAutoCommit(false);
                for (int i = 1; i <= size; i++) {
                    stmt.setInt(1, i);
                    stmt.executeUpdate();
                }
            } catch (SQLException e) {
                LOG.warn("Rollback DB after insert into table 'entry'. {}", e.getMessage(), e);
                try {
                    connect.rollback();
                } catch (SQLException ex) {
                    LOG.error("Rollback DB error {}", ex.getMessage(), e);
                }
            } finally {
                try {
                    connect.setAutoCommit(true);
                } catch (SQLException e) {
                    LOG.error("Set 'AutoCommit' parameter error {}", e.getMessage(), e);
                }
            }
        }
    }

    /**
     * Load list.
     *
     * @return the list
     */
    public List<Entry> load() {
        final String sql = "SELECT field FROM entry";
        List<Entry> result = new ArrayList<>();
        if (connect()) {
            try (Statement stmt = connect.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    result.add(new Entry(rs.getInt("field")));
                }
            } catch (SQLException e) {
                LOG.error("Error load data from table 'entry'. {}", e.getMessage(), e);
            }
        }
        return result;
    }

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private boolean connect() {
        if (this.connect == null) {
            String url = config.get("sqlite.url");
            String user = config.get("sqlite.user");
            String password = config.get("sqlite.password");
            try {
                this.connect = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        }
        return this.connect != null;
    }

    private void createNewDatabase() {
        LOG.info("Trying create database file");
        String url = config.get("sqlite.url");
        String user = config.get("sqlite.user");
        String password = config.get("sqlite.password");
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                LOG.info("A new database has been created.");
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Create a new table in the test database
     */
    public void createNewTable() {
        final String sqlCreateTable = "CREATE TABLE IF NOT EXISTS entry (field integer)";
        final String sqlDeleteAllData = "DELETE FROM entry";
        try (Statement stmt = this.connect.createStatement()) {
            int newTable = stmt.executeUpdate(sqlCreateTable);
            if (newTable == 0) {
                LOG.info("Clean table 'entry'");
                int delRow = stmt.executeUpdate(sqlDeleteAllData);
                LOG.info("Delete {} rows", delRow);
            }
        } catch (SQLException e) {
            LOG.error("Error create table 'entry' {}", e.getMessage(), e);
        }
    }

}
