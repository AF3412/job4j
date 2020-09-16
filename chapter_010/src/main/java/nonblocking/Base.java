package nonblocking;

public class Base {
    int id;
    int version = 0;
    int values;

    public Base(int id, int values) {
        this.id = id;
        this.values = values;
    }

    public Base(int id, int version, int values) {
        this.id = id;
        this.version = version;
        this.values = values;
    }

    public void updateVersion() {
        this.version++;
    }

}
