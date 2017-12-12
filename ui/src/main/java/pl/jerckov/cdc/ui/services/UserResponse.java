package pl.jerckov.cdc.ui.services;

import com.fasterxml.jackson.annotation.JsonProperty;

class UserResponse {

    private final Integer id;

    UserResponse(@JsonProperty("id") final Integer id) {
        this.id = id;
    }

    Integer getId() {
        return id;
    }
}
