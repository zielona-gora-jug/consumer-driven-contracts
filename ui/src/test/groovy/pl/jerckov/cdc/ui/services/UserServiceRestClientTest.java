package pl.jerckov.cdc.ui.services;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceRestClientTest {

    @ClassRule
    public static StubRunnerRule STUBS = new StubRunnerRule().downloadLatestStub("pl.jerckov.cdc", "user-service", "stubs");
    private static UserServiceRestClient USER_SERVICE;

    @BeforeClass
    public static void setUp() {
        USER_SERVICE = new UserServiceRestClient(new RestTemplate(), STUBS.findStubUrl("pl.jerckov.cdc", "user-service"));
    }

    @Test
    public void shouldCreateNewUser() {
        //given

        //when
        final ResponseEntity<UserResponse> result = USER_SERVICE.createNewUser("Jan");

        //then
        assertThat(result.getStatusCodeValue()).isEqualTo(201);
        assertThat(result.getBody()).isEqualToComparingFieldByField(new UserResponse(123));
    }
}