package pl.jerckov.cdc.crm.services;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class UserServiceRestClientTest {

    @ClassRule
    public static StubRunnerRule STUBS = new StubRunnerRule().downloadLatestStub("pl.jerckov.cdc", "user-service", "stubs");
    private static RestTemplate REST_TEMPLATE = new RestTemplate();
    private static UserServiceRestClient USER_SERVICE;

    @BeforeClass
    public static void setUp() {
        USER_SERVICE = new UserServiceRestClient(REST_TEMPLATE, STUBS.findStubUrl("pl.jerckov.cdc", "user-service"));
    }

    @Test
    public void shouldGetUser() {
        //given

        //when
        final ResponseEntity<UserResponse> result = USER_SERVICE.getUser(123);

        //then
        assertThat(result.getStatusCodeValue()).isEqualTo(200);
        assertThat(result.getBody()).isEqualToComparingFieldByField(new UserResponse("Kowalski"));
    }

    @Test
    public void shouldNotFoundUser() {
        //given

        //when
        final Throwable result = catchThrowable(() -> USER_SERVICE.getUser(456));

        //then
        assertThat(result).isInstanceOf(HttpClientErrorException.class);
        assertThat(((HttpClientErrorException)result).getRawStatusCode()).isEqualTo(404);
    }
}