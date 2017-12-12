package pl.jerckov.cdc.ui.services;

import com.fasterxml.jackson.annotation.JsonProperty;

class UserResponse {

    private final Integer id;
    private final String name;

    UserResponse(@JsonProperty("id") final Integer id,
                 @JsonProperty("name") final String name) {
        this.id = id;
        this.name = name;
    }

    Integer getId() {
        return id;
    }

    String getName() {
        return name;
    }
}
