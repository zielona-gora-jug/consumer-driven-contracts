package pl.jug.cdc.server.services;

import java.util.Optional;

public interface UserService {

    User createUser(final String name);
    Optional<User> findUser(final int id);
    void removeUser(final int id);
}
