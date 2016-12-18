package pl.jug.cdc.client.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureStubRunner( workOffline = true, ids = {"pl.jug.cdc:server:+:stubs:8090"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void shouldCreateNewUser() {
        //given

        //when
        final UserResponse result = userService.createNewUser("Jan");

        //then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getName()).isNotBlank();
    }
}