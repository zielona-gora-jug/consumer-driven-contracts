package pl.jerckov.cdc.crm.services;

import com.fasterxml.jackson.annotation.JsonProperty;

class UserResponse {

    private final String name;

    UserResponse( @JsonProperty("name") final String name) {
        this.name = name;
    }
}
