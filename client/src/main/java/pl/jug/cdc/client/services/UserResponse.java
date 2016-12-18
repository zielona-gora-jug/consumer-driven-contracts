package pl.jug.cdc.client.services;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {

    private final Integer id;
    private final String name;

    public UserResponse(@JsonProperty("id") final Integer id,
                        @JsonProperty("name") final String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
