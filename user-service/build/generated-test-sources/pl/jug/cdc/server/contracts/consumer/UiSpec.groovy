package pl.jug.cdc.server.contracts.consumer

import com.jayway.jsonpath.DocumentContext
import com.jayway.jsonpath.JsonPath
import pl.jug.cdc.server.ServerSpec

import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*
import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat

class UiSpec extends ServerSpec {

	def validate_create_a_user() throws Exception {
		given:
			def request = given()
					.header("Content-Type", "application/json")
					.body('''{"name":"Jan"}''')

		when:
			def response = given().spec(request)
					.post("/users")

		then:
			response.statusCode == 201
			response.header('Content-Type')  == 'application/json'
		and:
			DocumentContext parsedJson = JsonPath.parse(response.body.asString())
			assertThatJson(parsedJson).field("['id']").matches("\\d+")
	}

}
