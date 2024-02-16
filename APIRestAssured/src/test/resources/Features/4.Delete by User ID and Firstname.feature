
@UserModule-Delete
Feature: User API Module - DELETE Users by user ID and First Name

  #@Get_All_users_01
  #Scenario: Authorized user able to view all users
  #Given Authorized 	User creates the GET request with valid baseUrl,valid endpoint 
  #When User sends GET request 
  #Then User receives 200 OK Status in response body
    
  @Delete_user_by_firstname_02
  Scenario: Unauthorized user not able to delete the user with valid url, end point by valid user first name
  Given Unauthorized User sets request with valid Url,valid endpoint by valid user first name
  When User sends DELETE request with valid Url,valid endpoint by valid user first name
  Then User receives 401 Unauthorized  Status in response body
  
  @Delete_user_by_firstname_03
  Scenario: User not able to delete the user with valid url, end point by invalid user first name
  Given User sets request with valid Url,valid endpoint by invalid user first name
  When User sends DELETE request with valid Url,valid endpoint by invalid user first name
  Then User receives 404 Not found  Status in response body
  
  @Delete_user_by_firstname_04
  Scenario: User not able to delete the user with invalid url, end point by valid user first name
  Given User sets request with invalid Url,valid endpoint by valid user first name
  When User sends DELETE request with invalid Url,valid endpoint by valid user first name
  Then User receives 404 Not found  Status in response body
  
  @Delete_user_by_firstname_05
  Scenario: User not able to delete the user with valid url, invalid end point by valid user first name
  Given Authorized User sets request with valid Url, invalid endpoint by valid user first name
  When User sends DELETE request with valid Url, invalid endpoint by valid user first name
  Then User receives 404 Not found  Status in response body
  
  @Delete_user_by_firstname_01
  Scenario: Authorized user able to delete the user with valid url, end point by valid user first name
  Given Authorized User sets request with valid Url,valid endpoint by valid user first name
  When User sends DELETE request with valid Url,valid endpoint by valid user first name
  Then User receives 200 OK  Status in response body
  
  @Delete_user_by_userID_07
  Scenario: Unauthorized user able to delete the user with valid url, end point by valid user ID
  Given Unauthorized User sets request with valid Url,valid endpoint by valid user ID
  When User sends DELETE request with valid Url,valid endpoint by valid user ID
  Then User receives 401 Unauthorized  Status in response body
  
  @Delete_user_by_userID_08
  Scenario: User able to delete the user with valid url, end point by invalid user ID using id which is not created
  Given Authorized User sets request with valid Url,valid endpoint by valid user ID using id which is not created
  When User sends DELETE request with valid Url,valid endpoint by valid user ID using id which is not created
  Then User receives 404 Not found  Status in response body
  
  @Delete_user_by_userID_09
  Scenario: User able to delete the user with invalid url, valid end point by valid user ID
  Given Authorized User sets request with invalid Url, valid endpoint by valid user ID
  When User sends DELETE request with invalid Url, valid endpoint by valid user ID
  Then User receives 404 Not found  Status in response body
  
  @Delete_user_by_userID_10
  Scenario: User able to delete the user with valid url, valid end point by invalid user ID with alphabets
  Given Authorized User sets request with valid Url,valid endpoint by valid user ID with alphabets
  When User sends DELETE request with valid Url,valid endpoint by valid user ID with alphabets
  Then User receives 400 Bad Request status in response body  
  
  @Delete_user_by_userID_11
  Scenario: User able to delete the user with valid url, invalid end point by valid user ID
  Given Authorized User sets request with valid Url, invalid endpoint by valid user ID
  When User sends DELETE request with valid Url, invalid endpoint by valid user ID
  Then User receives 404 Not found  Status in response body
  
  @Delete_user_by_userID_06
  Scenario: Authorized user able to delete the user with valid url, end point by valid user ID
  Given Authorized User sets request with valid Url,valid endpoint by valid user ID
  When User sends DELETE request with valid Url,valid endpoint by valid user ID
  Then User receives 200 OK  Status in response body
  