package pl.jerckov.cdc.crm.services;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URL;

class UserServiceRestClient {

    private final RestTemplate restTemplate;
    private final URL userServiceUrl;

    UserServiceRestClient(final RestTemplate restTemplate, final URL userServiceUrl) {
        this.restTemplate = restTemplate;
        this.userServiceUrl = userServiceUrl;
    }

    ResponseEntity<UserResponse> getUser(final int id) {
        return this.restTemplate.exchange(
                RequestEntity
                        .get(URI.create(userServiceUrl.toString() + "/users/" + id)).build(),
                UserResponse.class);
    }
}
