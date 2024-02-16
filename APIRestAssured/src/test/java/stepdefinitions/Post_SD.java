package stepdefinitions;

//import com.fasterxml.jackson.databind.ObjectMapper;

import Pojo.UserAPI_Pojo;
import RequestBody.UserRequestBody;
import endpoints.RouteURL;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

public class Post_SD {
	
	public static ConfigReader readconfig;
	public static UserRequestBody UReqbody;
	public static UserAPI_Pojo pojo;
	
	RequestSpecification request;
	Response response;
	ValidatableResponse valid_resp;
	public static int userId;
	public static String userfirstname;

//@POST_user_01,06-23
	@Given("Authorized User sets request with valid Url,valid endpoint and valid request body with madetory fields")
	public void authorized_user_sets_request_with_valid_url_valid_endpoint_and_valid_request_body_with_madetory_fields() {
		
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
	    .and().header("Content_Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).log().all();	    
	}

	@When("User sends POST request with {string} and {string} from excel")
	public void user_sends_post_request_with_and_and_from_excel(String TestCaseNumber, String sheetname) {
	    
	    try {
			pojo = UserRequestBody.UserRequest(TestCaseNumber,sheetname);
//			ObjectMapper mapper = new ObjectMapper();
//		    String json = mapper.writeValueAsString(pojo); 
//		    this.response =  request.when().formParam("userinfo",json)
//		   			.post(RouteURL.PostUser_Url);
			response = this.request.body(pojo).when().post(RouteURL.PostUser_Url).then().log().all().extract().response();
		    System.out.println("UserAPI POST request Body:"+response.asString());   
			} 
	    catch (Exception e) {			
			e.printStackTrace();
		}
	}

	@Then("User receives Status in response body for respective {string}")
	public void user_receives_Status_in_response_body_for_respective(String TestCaseNumber) {
	    
		try {
			if(TestCaseNumber.equals("Post_user_06_Missing_Firstname")
					||TestCaseNumber.equals("Post_user_07_Missing_Lastname")
					||TestCaseNumber.equals("Post_user_08_Missing_Contact")
					||TestCaseNumber.equals("Post_user_09_Missing_EmailID")
					||TestCaseNumber.equals("Post_user_12_Mobile_Stringvalue")
					||TestCaseNumber.equals("Post_user_13_Mobile_Alphanumericvalue")
					||TestCaseNumber.equals("Post_user_14_Mobile_Greaerthan10numbers")
					||TestCaseNumber.equals("Post_user_15_Firstname_Alphanumericvalue")
					||TestCaseNumber.equals("Post_user_16_Firstname_Numericvalue")
					||TestCaseNumber.equals("Post_user_17_Lastname_Numericvalue")
					||TestCaseNumber.equals("Post_user_18_Lastname_Alphanumericvalue")
					||TestCaseNumber.equals("Post_user_19_EmailID_Format")
					||TestCaseNumber.equals("Post_user_21_Mobile_StartswithZero")
					||TestCaseNumber.equals("Post_user_22_Mobile_Lessthan10numbers")
					||TestCaseNumber.equals("Post_user_23_Mandatoryfields_NullValues"))	
				{
					valid_resp = response.then().log().all().assertThat().statusCode(400);	
					
				}
				else if(TestCaseNumber.equals("Post_user_10_Existing_Contact")
						||TestCaseNumber.equals("Post_user_11_Existing_EmailID"))
				{
					
					valid_resp = response.then().log().all().assertThat().statusCode(409);
					
				}
				else if (TestCaseNumber.equals("Post_user_01_Created_02_03_04")
						||TestCaseNumber.equals("Post_user_20_Optionalfield_NullValues"))
				{
					
					valid_resp = response.then().log().all().assertThat().statusCode(201);
					 					
					userId = response.body().path("user_id");
					String jsonString = response.asString();
					System.out.println("userId: "+jsonString);
					System.out.println("User created:"+userId);
					
					userfirstname = response.body().path("user_first_name");
					String jsonString1 = response.asString();
					System.out.println("userfirstname: "+jsonString1);
					System.out.println("User created:"+userfirstname);
				}
		} catch (Exception e) {
				e.printStackTrace();
		}
}	    

//@POST_user_02
	@Given("Unauthorized User sets request with valid Url,valid endpoint and valid request body with madetory fields")
	public void unauthorized_user_sets_request_with_valid_url_valid_endpoint_and_valid_request_body_with_madetory_fields() {
	    
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy123@gmail.com","welcome123")
	    .and().header("Content_Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).log().all();	  
	    
	}

	@When("Unauthorized User sends POST request with {string} and {string} from excel")
	public void unauthorized_user_sends_post_request_with_and_from_excel(String TestCaseNumber, String sheetname) {
	    
	    try {
			pojo = UserRequestBody.UserRequest(TestCaseNumber,sheetname);
			response = this.request.body(pojo).when().post(RouteURL.PostUser_Url).then().log().all().extract().response();
		    System.out.println("UserAPI POST request Body:"+response.asString());   
			} 
	    catch (Exception e) {			
			e.printStackTrace();
		}
	}

	@Then("User receives {int} Unauthorized status in response body")
	public void user_receives_unauthorized_status_in_response_body(Integer UnAuth) {
	    
		valid_resp = response.then().log().all().assertThat().statusCode(UnAuth);
	}

//@POST_user_03
	@Given("User sets request for with valid Url, invalid endpoint and valid request body")
	public void user_sets_request_for_with_valid_url_invalid_endpoint_and_valid_request_body() {
		
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
	    .and().header("Content_Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).log().all();		    
	}

	@When("User sends POST request with invalid endpoint and {string} and {string} from excel")
	public void user_sends_post_request_with_invalid_endpoint_and_and_from_excel(String TestCaseNumber, String sheetname) {

	    try {
			pojo = UserRequestBody.UserRequest(TestCaseNumber,sheetname);
			response = this.request.body(pojo).when().post(RouteURL.PostUser_InvalidEP).then().log().all().extract().response();
		    System.out.println("UserAPI POST request Body:"+response.asString());   
			} 
	    catch (Exception e) {			
			e.printStackTrace();
		}	    
	}

	@Then("User receives {int} Not found status in response body")
	public void user_receives_not_found_status_in_response_body(Integer Notf) {
		
		valid_resp = response.then().log().all().assertThat().statusCode(Notf);	    
	}

//@POST_user_04
	@Given("User sets request for with invalid Url, valid endpoint and valid request body")
	public void user_sets_request_for_with_invalid_url_valid_endpoint_and_valid_request_body() {
	    
			RestAssured.baseURI = RouteURL.base_url;
			 
		    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
		    .and().header("Content_Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).log().all();  
	}
	
	@When("User sends POST request with invalid Url and {string} and {string} from excel")
	public void user_sends_post_request_with_invalid_url_and_and_from_excel(String TestCaseNumber, String sheetname) {
		 
		try {
				pojo = UserRequestBody.UserRequest(TestCaseNumber,sheetname);
				response = this.request.body(pojo).when().post(RouteURL.PostUser_InvalidUrl).then().log().all().extract().response();
			    System.out.println("UserAPI POST request Body:"+response.asString());   
				} 
		    catch (Exception e) {			
				e.printStackTrace();
			}	    
	}

//@POST_user_05
	@Given("User sets request for with valid Url,valid endpoint and without request body")
	public void user_sets_request_for_with_valid_url_valid_endpoint_and_without_request_body() {
	    
		RestAssured.baseURI = RouteURL.base_url;
		 
	    this.request = RestAssured.given().auth().basic("Numpy@gmail.com","tim123")
	    .and().header("Content_Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).log().all();	
	}
	
	@When("User sends POST request without request body")
	public void user_sends_post_request_without_request_body() {
	    
		response = this.request.when().post(RouteURL.PostUser_Url).then().log().all().extract().response();
	    System.out.println("UserAPI POST request Body:"+response.asString());   	    
	}
	
	@Then("User receives {int} BAD_REQUEST status in response body")
	public void user_receives_bad_request_status_in_response_body(Integer Nob) {
	    
		valid_resp = response.then().log().all().assertThat().statusCode(Nob);	
	}
}	
