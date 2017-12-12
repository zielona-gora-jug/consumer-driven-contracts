package pl.jug.cdc.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jug.cdc.server.rest.model.GetUserResponse;
import pl.jug.cdc.server.rest.model.PostUserResponse;
import pl.jug.cdc.server.services.User;
import pl.jug.cdc.server.services.UserService;

import java.util.Optional;

@RestController
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(final UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public ResponseEntity postUser(@RequestBody final String name) {
        final User user = userService.createUser(name);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(new PostUserResponse(user.getId()), headers, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable final int id) {
        final Optional<User> optionalUser = userService.findUser(id);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        if (optionalUser.isPresent()) {
            final User user = optionalUser.get();
            return new ResponseEntity<>(new GetUserResponse(user.getName()), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable final int id) {
        userService.removeUser(id);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }
}
