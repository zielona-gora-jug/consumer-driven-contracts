package pl.jug.cdc.server.contracts.consumer

import com.jayway.jsonpath.DocumentContext
import com.jayway.jsonpath.JsonPath
import pl.jug.cdc.server.ServerSpec

import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*
import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat

class CrmSpec extends ServerSpec {

	def validate_get_a_user() throws Exception {
		given:
			def request = given()

		when:
			def response = given().spec(request)
					.get("/users/123")

		then:
			response.statusCode == 200
			response.header('Content-Type')  == 'application/json'
		and:
			DocumentContext parsedJson = JsonPath.parse(response.body.asString())
			assertThatJson(parsedJson).field("['name']").matches("[a-zA-Z]+")
	}

	def validate_user_not_found() throws Exception {
		given:
			def request = given()

		when:
			def response = given().spec(request)
					.get("/users/456")

		then:
			response.statusCode == 404
	}

}
