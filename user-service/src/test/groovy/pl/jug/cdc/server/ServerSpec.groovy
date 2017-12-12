package pl.jug.cdc.server

import io.restassured.module.mockmvc.RestAssuredMockMvc
import pl.jug.cdc.server.rest.UserRestController
import pl.jug.cdc.server.services.User
import pl.jug.cdc.server.services.UserService
import spock.lang.Specification

class ServerSpec extends Specification {

    UserService usersServiceMock = Stub(UserService) {
        createUser(_) >> new User(123, "Jan")
        findUser(123) >> Optional.of(new User(123, "Kowalski"))
        findUser(456) >> Optional.empty()
    }

    def setup() {
        def userController = new UserRestController(usersServiceMock)
        RestAssuredMockMvc.standaloneSetup(userController)
    }
}
