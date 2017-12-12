package pl.jerckov.cdc.ui.services;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceTest {

    @ClassRule
    public static StubRunnerRule STUBS = new StubRunnerRule().downloadLatestStub("pl.jerckov.cdc", "user-service", "stubs");
    private static RestTemplate REST_TEMPLATE = new RestTemplate();
    private static UserService USER_SERVICE;

    @BeforeClass
    public static void setUp() {
        USER_SERVICE = new UserService(REST_TEMPLATE, STUBS.findStubUrl("pl.jerckov.cdc", "user-service"));
    }

    @Test
    public void shouldCreateNewUser() {
        //given

        //when
        final UserResponse result = USER_SERVICE.createNewUser("Jan");

        //then
        assertThat(result.getId()).isNotNull();
    }
}