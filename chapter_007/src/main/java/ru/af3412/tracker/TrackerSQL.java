package ru.af3412.tracker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * The type Tracker sql.
 */
public class TrackerSQL implements ITracker, AutoCloseable {

    private static final Logger LOG = LogManager.getLogger(ITracker.class.getName());

    private Connection connection;

    /**
     * initializing connect to DB
     *
     * @return the boolean
     */
    public boolean init() {
        boolean result;
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            if (in == null) {
                LOG.error("Error load file 'app.properties'");
                throw new IllegalStateException("Error load file 'app.properties'");
            }
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        result = this.connection != null;
        if (result) {
            createTrackerDataBaseStructureIfNotExists();
        }
        return this.connection != null;
    }

    /**
     * implements AutoCloseable interface to close DB connections
     */
    @Override
    public void close() {
        try {
            if (connection != null) {
                this.connection.close();
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }


    /**
     * Add item.
     *
     * @param name        the name
     * @param description the description
     * @return the item
     */
    @Override
    public Item add(String name, String description) {
        Item result = null;
        final String sql = "INSERT INTO items(name, description, datecreate) VALUES (?, ?, ?)";
        try (final PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            long createItemTime = System.currentTimeMillis();
            st.setString(1, name);
            st.setString(2, description);
            st.setTimestamp(3, new Timestamp(createItemTime));
            st.executeUpdate();
            try (ResultSet rs = st.getGeneratedKeys()) {
                if (rs.next()) {
                    result = new Item(name, description, Integer.toString(rs.getInt(1)), createItemTime);
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Add comments.
     *
     * @param item    the item
     * @param comment the comment
     */
    @Override
    public void addComments(Item item, String comment) {
        final String sql = "INSERT INTO comments(comment, item_id) VALUES (?, ?)";
        try (final PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, comment);
            st.setInt(2, Integer.parseInt(item.getId()));
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Item edit.
     *
     * @param item        the item
     * @param name        the name
     * @param description the description
     * @param comment     the comment
     */
    @Override
    public void itemEdit(Item item, String name, String description, String comment) {
        final String sql = "UPDATE items SET name = ?, description = ? WHERE id = ?";
        try (final PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, name);
            st.setString(2, description);
            st.setInt(3, Integer.parseInt(item.getId()));
            st.executeUpdate();
            this.addComments(item, comment);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Find by id item.
     *
     * @param id the id
     * @return the item
     */
    @Override
    public Item findById(String id) {
        Item result = null;
        String sql = "SELECT i.id, name, description, datecreate, c.comment FROM items AS i LEFT JOIN comments c ON i.id = c.item_id AND i.id = ?";
        try (final PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, Integer.parseInt(id));
            try (ResultSet rs = st.executeQuery()) {
                Map<Integer, Item> itemById = new HashMap<>();
                while (rs.next()) {
                    Integer idItem = rs.getInt("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    long dateCreate = rs.getTimestamp("datecreate").getTime();
                    Item item = itemById.get(idItem);
                    if (item == null) {
                        item = new Item(name, description, id, dateCreate);
                        itemById.put(idItem, item);
                    }
                    item.addComments(rs.getString("comment"));
                }
                result = itemById.get(Integer.parseInt(id));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @Override
    public void delete(String id) {
        deleteCommentsByItemId(id);
        deleteItemById(id);
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @Override
    public ArrayList<Item> getAll() {
        final ArrayList<Item> items = new ArrayList<>();
        final String sql = "SELECT id, name, description, datecreate FROM items";
        try (final Statement st = connection.createStatement()) {
            try (ResultSet rs = st.executeQuery(sql)) {
                while (rs.next()) {
                    String id = String.valueOf(rs.getInt("id"));
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    long dateCreate = rs.getTimestamp("datecreate").getTime();
                    items.add(new Item(id, name, description, dateCreate));
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return items;
    }

    private void createTrackerDataBaseStructureIfNotExists() {
        String createTableItem = "CREATE TABLE IF NOT EXISTS items (id serial PRIMARY KEY, name text, description text, dateCreate timestamp)";
        String createTableComments = "CREATE TABLE IF NOT EXISTS comments (id serial PRIMARY KEY, comment text, item_id int REFERENCES items(id))";
        try (Statement st = connection.createStatement()) {
            st.execute(createTableItem);
            st.execute(createTableComments);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private void deleteCommentsByItemId(String id) {
        final String sqlDeleteComments = "DELETE FROM comments WHERE item_id = ?";
        try (PreparedStatement st = connection.prepareStatement(sqlDeleteComments)) {
            st.setInt(1, Integer.parseInt(id));
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private void deleteItemById(String id) {
        final String sqlDeleteItem = "DELETE FROM items WHERE id = ?";
        try (PreparedStatement st = connection.prepareStatement(sqlDeleteItem)) {
            st.setInt(1, Integer.parseInt(id));
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

}
