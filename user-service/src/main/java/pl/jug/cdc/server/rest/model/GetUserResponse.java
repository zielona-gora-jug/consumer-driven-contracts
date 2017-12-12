package pl.jug.cdc.server.rest.model;

public class GetUserResponse {

    private final String name;

    public GetUserResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
