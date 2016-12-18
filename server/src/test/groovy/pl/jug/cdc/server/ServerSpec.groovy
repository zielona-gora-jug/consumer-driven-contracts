package pl.jug.cdc.server

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc
import pl.jug.cdc.server.rest.UserRestController
import pl.jug.cdc.server.services.User
import pl.jug.cdc.server.services.UserService
import spock.lang.Specification

class ServerSpec extends Specification {

    UserService usersServiceMock = Stub(UserService) {
        createUser(_) >> new User(123, "Jan")
    }

    def setup() {
        def userController = new UserRestController(usersServiceMock)
        RestAssuredMockMvc.standaloneSetup(userController)
    }
}
