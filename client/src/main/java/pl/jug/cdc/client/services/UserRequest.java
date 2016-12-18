package pl.jug.cdc.client.services;

public class UserRequest {

    private final String name;

    public UserRequest(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
