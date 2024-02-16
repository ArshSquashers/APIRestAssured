
@UserModule-Get
Feature: User API Module - Get All users, UserID and First Name
 
  @Get_All_users_01
  Scenario: Authorized user able to view all users
  Given Authorized 	User creates the GET request with valid baseUrl,valid endpoint 
  When User sends GET request 
  Then User receives 200 OK Status in response body
  
  @Get_All_users_02
  Scenario: Unauthorized user not able to view all users
  Given Unauthorized User creates the GET request with valid baseUrl,valid endpoint 
  When User sends GET request
  Then User receives 401 Unauthorized Status in response body
  
  @Get_All_users_03
  Scenario: Authorized user should not be able to view all users with invalid endpoint and valid url
  Given Authorized User creates the GET request with valid baseUrl,invalid endpoint 
  When User sends GET request with invalid endpoint
  Then User receives 404 Not found Status in response body
  
  @Get_All_users_04
  Scenario: Authorized user should not be able to view all users with valid endpoint and invalid url
  Given Authorized User creates the GET request with invalid baseUrl,valid endpoint 
  When User sends GET request with invalid baseurl
  Then User receives 404 Not found Status in response body
   
  @Get_user_by_user_ID_05
  Scenario: Authorized user able to view respective user with valid endpoint,valid url,valid id
  Given Authorized 	User creates the GET request with valid baseUrl,valid endpoint ,valid id
  When User sends GET request with valid baseUrl,valid endpoint ,valid id
  Then User receives 200 OK Status in response body
  
  @Get_user_by_user_ID_06
  Scenario: Authorized user should not be able to view respective user with valid endpoint,valid url,invalid id
  Given Authorized 	User creates the GET request with valid baseUrl,valid endpoint ,invalid id
  When User sends GET request with valid baseUrl,valid endpoint ,invalid id
  Then User receives 404 Not found Status in response body
  
  @Get_user_by_user_ID_07
  Scenario: Unauthorized user should not be able to view respective users with valid endpoint,valid url,valid id
  Given Unauthorized User creates the GET request with valid baseUrl,valid endpoint ,valid id
  When User sends GET request with valid baseUrl,valid endpoint ,valid id
  Then User receives 401 Unauthorized Status in response body
  
  @Get_user_by_user_ID_08
  Scenario: Authorized user should not be able to view respective users with valid endpoint,invalid url,valid id
  Given Authorized User creates the GET request with invalid baseUrl,valid endpoint ,valid id
  When User sends GET request with invalid baseUrl,valid endpoint ,valid id
  Then User receives 404 Not found Status in response body
  
   @Get_user_by_user_ID_09
  Scenario: Authorized user should not be able to view respective users with invalid endpoint,valid url,valid id
  Given Authorized User creates the GET request with valid baseUrl,invalid endpoint ,valid id
  When User sends GET request with valid baseUrl,invalid endpoint ,valid id
  Then User receives 404 Not found Status in response body
  
  @Get_user_by_first_name_10
  Scenario: Authorized user able to view respective user with valid endpoint,valid url,valid firstname
  Given Authorized 	User creates the GET request with valid baseUrl,valid endpoint ,valid firstname
  When User sends GET request with valid baseUrl,valid endpoint ,valid firstname
  Then User receives 200 OK Status in response body
  
  @Get_user_by_first_name_11
  Scenario: Authorized user should not be able to view respective user with valid endpoint,valid url,invalid firstname
  Given Authorized 	User creates the GET request with valid baseUrl,valid endpoint ,invalid firstname
  When User sends GET request with valid baseUrl,valid endpoint ,invalid firstname
  Then User receives 404 Not found Status in response body
  
  @Get_user_by_first_name_12
  Scenario: Unauthorized user should not be able to view respective users with valid endpoint,valid url,valid firstname
  Given Unauthorized User creates the GET request with valid baseUrl,valid endpoint ,valid firstname
  When User sends GET request with valid baseUrl,valid endpoint ,valid firstname
  Then User receives 401 Unauthorized Status in response body
  
  @Get_user_by_first_name_13
  Scenario: Authorized user should not be able to view respective users with valid endpoint,invalid url,valid firstname
  Given Authorized User creates the GET request with invalid baseUrl,valid endpoint ,valid firstname
  When User sends GET request with invalid baseUrl,valid endpoint ,valid firstname
  Then User receives 404 Not found Status in response body
  
   @Get_user_by_first_name_14
  Scenario: Authorized user should not be able to view respective users with invalid endpoint,valid url,valid firstname
  Given Authorized User creates the GET request with valid baseUrl,invalid endpoint ,valid firstname
  When User sends GET request with valid baseUrl,invalid endpoint ,valid firstname
  Then User receives 404 Not found Status in response body
  