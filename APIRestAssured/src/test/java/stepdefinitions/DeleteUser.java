package stepdefinitions;

import endpoints.RouteURL;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteUser {
	
	Response response;
	RequestSpecification requestSpecification;
	ValidatableResponse valid_response;
	
	@Given("User creates Delete Request for the API end point with valid {string}")
	public void user_creates_delete_request_for_the_api_end_point_with_valid(String user_first_name) {
	    
		RestAssured.baseURI = RouteURL.base_url;
		this.requestSpecification = RestAssured.given().auth().basic("Numpy@gmail.com", "tim123")
//				 .and().header("Content_Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).log().all();
				 .log().all().pathParam("userFirstName", user_first_name );
	}

	@When("User sends HTTPS Request by valid {string} to delete")
	public void user_sends_https_request_by_valid_to_delete(String user_first_name) {
		this.response = requestSpecification.when().delete(RouteURL.DeleteFirstName_Url);	    
	}

	@Then("User receive {int} OKStatus with response body.")
	public void user_receive_ok_status_with_response_body(Integer int1) {
		valid_response = response.then().log().all()
				.assertThat().statusCode(200).contentType(ContentType.JSON);	    
	}

	@Given("User creates Delete Request with valid {string}")
	public void user_creates_delete_request_with_valid(String user_id) {
		RestAssured.baseURI = RouteURL.base_url;
		this.requestSpecification = RestAssured.given().auth().basic("Numpy@gmail.com", "tim123").log().all()
				.pathParam("userId", user_id );	    
	}

	@When("User sends HTTPS delete Request by valid {string}")
	public void user_sends_https_delete_request_by_valid(String user_id) {
		this.response = requestSpecification.when().delete(RouteURL.DeleteID_Url);	    
	}

	@Then("User receives {int} OKStatus with responsebody.")
	public void user_receives_ok_status_with_responsebody(Integer int1) {
		valid_response = response.then().log().all()
				.assertThat().statusCode(200).contentType(ContentType.JSON);	    
	}
	@Given("User creates Delete Request for the API end point with invalid {string}")
	public void user_creates_delete_request_for_the_api_end_point_with_invalid(String user_first_name) {
	    
		RestAssured.baseURI = RouteURL.base_url;
		this.requestSpecification = RestAssured.given().auth().basic("Numpy@gmail.com", "tim123").log().all()
				.pathParam("userFirstName", user_first_name );
	}

	@When("User sends HTTPS Request by invalid {string} to delete")
	public void user_sends_https_request_by_invalid_to_delete(String user_first_name) {
	    
		this.response = requestSpecification.when().delete(RouteURL.DeleteFirstName_Url);
	}

	@Then("User receives {int} Statuswith response body.")
	public void user_receives_statuswith_response_body(Integer int1) {
	    
		valid_response = response.then().log().all()
				.assertThat().statusCode(404).contentType(ContentType.JSON);
	}

	@Given("User creates Delete Request with invalid {string}")
	public void user_creates_delete_request_with_invalid(String user_id) {
		RestAssured.baseURI = RouteURL.base_url;
		this.requestSpecification = RestAssured.given().auth().basic("Numpy@gmail.com", "tim123").log().all()
				.pathParam("userId", user_id );	    
	}

	@When("User sends HTTP delete Request by invalid {string}")
	public void user_sends_http_delete_request_by_invalid(String user_id) {
	    
		this.response = requestSpecification.when().delete(RouteURL.DeleteID_Url);
	}

	@Then("User receives {int} Status with responsebody.")
	public void user_receives_status_with_responsebody(Integer int1) {
	    
		valid_response = response.then().log().all()
				.assertThat().statusCode(404).contentType(ContentType.JSON);
	}
}
