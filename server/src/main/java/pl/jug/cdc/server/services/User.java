package pl.jug.cdc.server.services;

public class User {

    private final int id;
    private final String name;

    public User(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
