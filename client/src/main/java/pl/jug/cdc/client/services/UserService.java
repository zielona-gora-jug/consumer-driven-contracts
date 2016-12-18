package pl.jug.cdc.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class UserService {

    private final RestTemplate restTemplate;

    @Autowired
    public UserService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserResponse createNewUser(final String name) {
        final ResponseEntity<UserResponse> response = this.restTemplate.exchange(
                RequestEntity
                        .post(URI.create("http://localhost:8090/users"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(new UserRequest(name)),
                UserResponse.class);

        return response.getBody();
    }
}
