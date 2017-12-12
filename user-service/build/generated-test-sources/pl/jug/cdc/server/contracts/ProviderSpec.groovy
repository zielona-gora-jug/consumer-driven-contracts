package pl.jug.cdc.server.contracts

import com.jayway.jsonpath.DocumentContext
import com.jayway.jsonpath.JsonPath
import pl.jug.cdc.server.ServerSpec

import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*
import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat

class ProviderSpec extends ServerSpec {

	def validate_delete_a_user() throws Exception {
		given:
			def request = given()
					.header("Content-Type", "application/json")

		when:
			def response = given().spec(request)
					.delete("/users/123")

		then:
			response.statusCode == 204
			response.header('Content-Type')  == 'application/json'
	}

}
