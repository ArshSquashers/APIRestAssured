package stepdefinitions;

import endpoints.RouteURL;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
//import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Delete_SD {
	
	ValidatableResponse valid_response;
	RequestSpecification request;
	Response response;
 	
	@Given("Unauthorized User sets request with valid Url,valid endpoint by valid user first name")
	public void unauthorized_user_sets_request_with_valid_url_valid_endpoint_by_valid_user_first_name() {
	    
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy12@gmail.com","tim09123")
	    .and().header("Content_Type", "application/json").log().all();
	}

	@When("User sends DELETE request with valid Url,valid endpoint by valid user first name")
	public void user_sends_delete_request_with_valid_url_valid_endpoint_by_valid_user_first_name() {
	    
		this.response = request.when().delete(RouteURL.DeleteUserFirstName_Url);
	}
	
	@Then("User receives {int} Unauthorized  Status in response body")
	public void user_receives_unauthorized_status_in_response_body(Integer UnAuth) {
	   
		valid_response = response.then().log().all().assertThat().statusCode(UnAuth).contentType(ContentType.JSON);
	}

	@Given("User sets request with valid Url,valid endpoint by invalid user first name")
	public void user_sets_request_with_valid_url_valid_endpoint_by_invalid_user_first_name() {   
		  
		RestAssured.baseURI = RouteURL.base_url;
				 
		this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
			    .and().header("Content_Type", "application/json").log().all();    
	}

	@When("User sends DELETE request with valid Url,valid endpoint by invalid user first name")
	public void user_sends_delete_request_with_valid_url_valid_endpoint_by_invalid_user_first_name() {
	    
		this.response = request.when().delete(RouteURL.DeleteUserFirstName_InvalidFN);
	}
	
	@Then("User receives {int} Not found  Status in response body")
	public void user_receives_not_found_status_in_response_body(Integer NotF) {
	   
		valid_response = response.then().log().all().assertThat().statusCode(NotF).contentType(ContentType.JSON);
	}

	@Given("User sets request with invalid Url,valid endpoint by valid user first name")
	public void user_sets_request_with_invalid_url_valid_endpoint_by_valid_user_first_name() {
		
		RestAssured.baseURI = RouteURL.base_url;
		 
		this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
			    .and().header("Content_Type", "application/json").log().all();  
	    
	}

	@When("User sends DELETE request with invalid Url,valid endpoint by valid user first name")
	public void user_sends_delete_request_with_invalid_url_valid_endpoint_by_valid_user_first_name() {
	    
		this.response = request.when().delete(RouteURL.DeleteUserFirstName_InvalidUrl);
	}

	@Given("Authorized User sets request with valid Url, invalid endpoint by valid user first name")
	public void authorized_user_sets_request_with_valid_url_invalid_endpoint_by_valid_user_first_name() {
	    
		RestAssured.baseURI = RouteURL.base_url;
		 
		this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
			    .and().header("Content_Type", "application/json").log().all();  
	}

	@When("User sends DELETE request with valid Url, invalid endpoint by valid user first name")
	public void user_sends_delete_request_with_valid_url_invalid_endpoint_by_valid_user_first_name() {
	    
		this.response = request.when().delete(RouteURL.DeleteUserFirstName_InvalidEP);
	}

	@Given("Authorized User sets request with valid Url,valid endpoint by valid user first name")
	public void authorized_user_sets_request_with_valid_url_valid_endpoint_by_valid_user_first_name() {
	    
		RestAssured.baseURI = RouteURL.base_url;
		 
		this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
			    .and().header("Content_Type", "application/json").log().all();  
	}
	
	@Then("User receives {int} OK  Status in response body")
	public void user_receives_ok_status_in_response_body(Integer OK) {
	   
		valid_response = response.then().log().all().assertThat().statusCode(OK).contentType(ContentType.JSON);
	}
	
	@Given("Unauthorized User sets request with valid Url,valid endpoint by valid user ID")
	public void unauthorized_user_sets_request_with_valid_url_valid_endpoint_by_valid_user_id() {
	    
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy12@gmail.com","tim09123")
	    .and().header("Content_Type", "application/json").log().all();
	    
	}

	@When("User sends DELETE request with valid Url,valid endpoint by valid user ID")
	public void user_sends_delete_request() {
	    
		this.response = request.when().delete(RouteURL.DeleteUserID_Url);
	}

	@Given("Authorized User sets request with valid Url,valid endpoint by valid user ID using id which is not created")
	public void authorized_user_sets_request_with_valid_url_valid_endpoint_by_valid_user_id_using_id_which_is_not_created() {
	    
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
	    .and().header("Content_Type", "application/json").log().all();
	}
	
	@When("User sends DELETE request with valid Url,valid endpoint by valid user ID using id which is not created")
	public void user_sends_delete_request_with_valid_url_valid_endpoint_by_valid_user_id_using_id_which_is_not_created() {
		
		this.response = request.when().delete(RouteURL.DeleteUserID_InvalidID);
	}

	@Given("Authorized User sets request with invalid Url, valid endpoint by valid user ID")
	public void authorized_user_sets_request_with_invalid_url_valid_endpoint_by_valid_user_id() {
	    
	    RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
	    .and().header("Content_Type", "application/json").log().all();
	}
	@When("User sends DELETE request with invalid Url, valid endpoint by valid user ID")
	public void user_sends_delete_request_with_invalid_url_valid_endpoint_by_valid_user_id() {

		this.response = request.when().delete(RouteURL.DeleteUserID_InvalidUrl);
	}

	@Given("Authorized User sets request with valid Url,valid endpoint by valid user ID with alphabets")
	public void authorized_user_sets_request_with_valid_url_valid_endpoint_by_valid_user_id_with_alphabets() {
	    
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
	    .and().header("Content_Type", "application/json").log().all();
	    
	}
	
	@When("User sends DELETE request with valid Url,valid endpoint by valid user ID with alphabets")
	public void user_sends_delete_request_with_valid_url_valid_endpoint_by_valid_user_id_with_alphabets() {
		
		this.response = request.when().delete(RouteURL.DeleteUserID_InvalidIDAlpha);
	}

	@Then("User receives {int} Bad Request status in response body")
	public void user_receives_bad_request_status_in_response_body(Integer BadR) {
	    
		valid_response = response.then().log().all().assertThat().statusCode(BadR).contentType(ContentType.JSON);
	}

	@Given("Authorized User sets request with valid Url, invalid endpoint by valid user ID")
	public void authorized_user_sets_request_with_valid_url_invalid_endpoint_by_valid_user_id() {
	    
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
	    .and().header("Content_Type", "application/json").log().all();
	    
	}

	@When("User sends DELETE request with valid Url, invalid endpoint by valid user ID")
	public void user_sends_delete_request_with_valid_url_invalid_endpoint_by_valid_user_id() {

		this.response = request.when().delete(RouteURL.DeleteUserID_InvalidEP);
	}
	
	@Given("Authorized User sets request with valid Url,valid endpoint by valid user ID")
	public void authorized_user_sets_request_with_valid_url_valid_endpoint_by_valid_user_id() {
	    
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
	    .and().header("Content_Type", "application/json").log().all();
	    
	}

}
