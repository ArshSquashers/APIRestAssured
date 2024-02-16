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

public class Get_SD {
	
	ValidatableResponse valid_response;
	RequestSpecification request;
	Response response;
 
//Get_All_users_01
	@Given("Authorized 	User creates the GET request with valid baseUrl,valid endpoint")
	public void authorized_user_creates_the_get_request_with_valid_base_url_valid_endpoint() {
		 
			RestAssured.baseURI = RouteURL.base_url;
		 
		    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123").pathParam(null, request)
		    .and().header("Content_Type", "application/json").log().all();
	}

	@When("User sends GET request")
	public void user_sends_get_request() {
		
			this.response = request.when().get(RouteURL.GetUsers_Url);
	}

	@Then("User receives {int} OK Status in response body")
	public void user_receives_ok_status_in_response_body(Integer OK) {

			valid_response = response.then().log().all().assertThat().statusCode(OK).contentType(ContentType.JSON);
	}

//Get_All_users_02
	@Given("Unauthorized User creates the GET request with valid baseUrl,valid endpoint")
	public void unauthorized_user_creates_the_get_request_with_valid_base_url_valid_endpoint() {
		
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy123@gmail.com","welcome123")
	    .and().header("Content_Type", "application/json").log().all();    
	}

	@Then("User receives {int} Unauthorized Status in response body")
	public void user_receives_unauthorized_status_in_response_body(Integer UnAuth) {
	    
		valid_response = response.then().log().all().assertThat().statusCode(UnAuth).contentType(ContentType.JSON);
	}

//Get_All_users_03
	@Given("Authorized User creates the GET request with valid baseUrl,invalid endpoint")
	public void authorized_user_creates_the_get_request_with_valid_base_url_invalid_endpoint() {
		 
			RestAssured.baseURI = RouteURL.base_url;
		 
		    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
		    .and().header("Content_Type", "application/json").log().all();	    
	}
	
	@When("User sends GET request with invalid endpoint")
	public void user_sends_get_request_with_invalid_endpoint() {
		
		this.response = request.when().get(RouteURL.GetUsers_InvalidEP);
	}
	
	@Then("User receives {int} Not found Status in response body")
	public void user_receives_not_found_status_in_response_body(Integer NotF) {
	   
		valid_response = response.then().log().all().assertThat().statusCode(NotF).contentType(ContentType.JSON);
	}

//Get_All_users_04
	@Given("Authorized User creates the GET request with invalid baseUrl,valid endpoint")
	public void authorized_user_creates_the_get_request_with_invalid_base_url_valid_endpoint() {

		RestAssured.baseURI = RouteURL.base_url;
	 
	    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
	    .and().header("Content_Type", "application/json").log().all();	    
	}
	
	@When("User sends GET request with invalid baseurl")
	public void user_sends_get_request_with_invalid_baseurl() {
		
		this.response = request.when().get(RouteURL.GetUsers_InvalidUrl);
	}

//Get_All_users_05
	@Given("Authorized 	User creates the GET request with valid baseUrl,valid endpoint ,valid id")
	public void authorized_user_creates_the_get_request_with_valid_base_url_valid_endpoint_valid_id() {
		 
			RestAssured.baseURI = RouteURL.base_url;
		 
		    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
		    .and().header("Content_Type", "application/json").log().all();       
	}

	@When("User sends GET request with valid baseUrl,valid endpoint ,valid id")
	public void user_sends_get_request_with_valid_base_url_valid_endpoint_valid_id() {
	    
		this.response = request.when().get(RouteURL.GetUserID_Url);
	}

//Get_All_users_06
	@Given("Authorized 	User creates the GET request with valid baseUrl,valid endpoint ,invalid id")
	public void authorized_user_creates_the_get_request_with_valid_base_url_valid_endpoint_invalid_id() {
	    
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
	    .and().header("Content_Type", "application/json").log().all();   	    
	}
	
	@When("User sends GET request with valid baseUrl,valid endpoint ,invalid id")
	public void user_sends_get_request_with_valid_base_url_valid_endpoint_invalid_id() {
		
		this.response = request.when().get(RouteURL.GetUserID_InvalidID);
	}

//Get_All_users_07
	@Given("Unauthorized User creates the GET request with valid baseUrl,valid endpoint ,valid id")
	public void unauthorized_user_creates_the_get_request_with_valid_base_url_valid_endpoint_valid_id() {
	    
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy123@gmail.com","welcome123")
	    .and().header("Content_Type", "application/json").log().all();	    
	}

//Get_All_users_08
	@Given("Authorized User creates the GET request with invalid baseUrl,valid endpoint ,valid id")
	public void authorized_user_creates_the_get_request_with_invalid_base_url_valid_endpoint_valid_id() {
	    
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
	    .and().header("Content_Type", "application/json").log().all();
	}

	@When("User sends GET request with invalid baseUrl,valid endpoint ,valid id")
	public void user_sends_get_request_with_invalid_base_url_valid_endpoint_valid_id() {
	    
		this.response = request.when().get(RouteURL.GetUserID_InvalidUrl);
	}

//Get_All_users_09
	@Given("Authorized User creates the GET request with valid baseUrl,invalid endpoint ,valid id")
	public void authorized_user_creates_the_get_request_with_valid_base_url_invalid_endpoint_valid_id() {
		
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
	    .and().header("Content_Type", "application/json").log().all();   
	}

	@When("User sends GET request with valid baseUrl,invalid endpoint ,valid id")
	public void user_sends_get_request_with_valid_base_url_invalid_endpoint_valid_id() {
	    
		this.response = request.when().get(RouteURL.GetUserID_InvalidEP);
	}

	@Given("Authorized 	User creates the GET request with valid baseUrl,valid endpoint ,valid firstname")
	public void authorized_user_creates_the_get_request_with_valid_base_url_valid_endpoint_valid_firstname() {
	    
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
	    .and().header("Content_Type", "application/json").log().all();  
	}

	@When("User sends GET request with valid baseUrl,valid endpoint ,valid firstname")
	public void user_sends_get_request_with_valid_base_url_valid_endpoint_valid_firstname() {
	    
		this.response = request.when().get(RouteURL.GetUserFirstName_Url);
	}

	@Given("Authorized 	User creates the GET request with valid baseUrl,valid endpoint ,invalid firstname")
	public void authorized_user_creates_the_get_request_with_valid_base_url_valid_endpoint_invalid_firstname() {
		
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
	    .and().header("Content_Type", "application/json").log().all();  
	    
	}

	@When("User sends GET request with valid baseUrl,valid endpoint ,invalid firstname")
	public void user_sends_get_request_with_valid_base_url_valid_endpoint_invalid_firstname() {
	    
		this.response = request.when().get(RouteURL.GetUserFirstName_InvalidFN);
	}

	@Given("Unauthorized User creates the GET request with valid baseUrl,valid endpoint ,valid firstname")
	public void unauthorized_user_creates_the_get_request_with_valid_base_url_valid_endpoint_valid_firstname() {
	    
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy12@gmail.com","welcome123")
	    .and().header("Content_Type", "application/json").log().all();  
	    
	}

	@Given("Authorized User creates the GET request with invalid baseUrl,valid endpoint ,valid firstname")
	public void authorized_user_creates_the_get_request_with_invalid_base_url_valid_endpoint_valid_firstname() {
	    
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
	    .and().header("Content_Type", "application/json").log().all();  
	}

	@When("User sends GET request with invalid baseUrl,valid endpoint ,valid firstname")
	public void user_sends_get_request_with_invalid_base_url_valid_endpoint_valid_firstname() {
	    
		this.response = request.when().get(RouteURL.GetUserFirstName_InvalidUrl);
	}

	@Given("Authorized User creates the GET request with valid baseUrl,invalid endpoint ,valid firstname")
	public void authorized_user_creates_the_get_request_with_valid_base_url_invalid_endpoint_valid_firstname() {
	    
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
	    .and().header("Content_Type", "application/json").log().all();  
	}

	@When("User sends GET request with valid baseUrl,invalid endpoint ,valid firstname")
	public void user_sends_get_request_with_valid_base_url_invalid_endpoint_valid_firstname() {
	    
		this.response = request.when().get(RouteURL.GetUserFirstName_InvalidEP);
	}
}