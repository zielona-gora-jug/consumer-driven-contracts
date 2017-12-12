package pl.jerckov.cdc.ui.services;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URL;

class UserService {

    private final RestTemplate restTemplate;
    private final URL userServiceUrl;

    UserService(final RestTemplate restTemplate, final URL userServiceUrl) {
        this.restTemplate = restTemplate;
        this.userServiceUrl = userServiceUrl;
    }

    UserResponse createNewUser(final String name) {
        final ResponseEntity<UserResponse> response = this.restTemplate.exchange(
                RequestEntity
                        .post(URI.create(userServiceUrl.toString() + "/users"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(new UserRequest(name)),
                UserResponse.class);

        return response.getBody();
    }
}
