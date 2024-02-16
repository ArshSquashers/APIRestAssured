@UserModule-Post
Feature: User API Module - POST Create Requests

  @POST_user_01,06-23
  Scenario Outline: Authorized user able to create new user with valid Url,end point,request body with mandetory fields
    Given Authorized User sets request with valid Url,valid endpoint and valid request body with madetory fields
    When User sends POST request with "<TestCaseNumber>" and "<Sheetname>" from excel
    Then User receives Status in response body for respective "<TestCaseNumber>"

    Examples: 
      | TestCaseNumber                           | Sheetname |
      | Post_user_01_Created_02_03_04            | POST      |
      #| Post_user_06_Missing_Firstname           | POST      |
      #| Post_user_07_Missing_Lastname            | POST      |
      #| Post_user_08_Missing_Contact             | POST      |
      #| Post_user_09_Missing_EmailID             | POST      |
      #| Post_user_10_Existing_Contact            | POST      |
      #| Post_user_11_Existing_EmailID            | POST      |
      #| Post_user_12_Mobile_Stringvalue          | POST      |
      #| Post_user_13_Mobile_Alphanumericvalue    | POST      |
      #| Post_user_14_Mobile_Greaerthan10numbers  | POST      |
      #| Post_user_15_Firstname_Alphanumericvalue | POST      |
      #| Post_user_16_Firstname_Numericvalue      | POST      |
      #| Post_user_17_Lastname_Numericvalue       | POST      |
      #| Post_user_18_Lastname_Alphanumericvalue  | POST      |
      #| Post_user_19_EmailID_Format              | POST      |
      #| Post_user_20_Optionalfield_NullValues    | POST      |
      #| Post_user_21_Mobile_StartswithZero       | POST      |
      #| Post_user_22_Mobile_Lessthan10numbers    | POST      |
      #| Post_user_23_Mandatoryfields_NullValues  | POST      |
#
  #@POST_user_02
  #Scenario Outline: Unauthorized user  should not be able to create new user with valid Url,end point,request body with mandetory fields
    #Given Unauthorized User sets request with valid Url,valid endpoint and valid request body with madetory fields
    #When Unauthorized User sends POST request with "<TestCaseNumber>" and "<Sheetname>" from excel
    #Then User receives 401 Unauthorized status in response body
#
    #Examples: 
      #| TestCaseNumber       | Sheetname |
      #| Post_user_01_Created | POST      |
#
  #@POST_user_03
  #Scenario Outline: User should not be able to create new user with valid Url,request body and invalid end point
    #Given User sets request for with valid Url, invalid endpoint and valid request body
    #When User sends POST request with invalid endpoint and "<TestCaseNumber>" and "<Sheetname>" from excel
    #Then User receives 404 Not found status in response body
#
    #Examples: 
      #| TestCaseNumber       | Sheetname |
      #| Post_user_01_Created | POST      |
#
  #@POST_user_04
  #Scenario Outline: User should not be able to create new user with invalid Url and valid request body, end point
    #Given User sets request for with invalid Url, valid endpoint and valid request body
    #When User sends POST request with invalid Url and "<TestCaseNumber>" and "<Sheetname>" from excel
    #Then User receives 404 Not found status in response body
#
    #Examples: 
      #| TestCaseNumber       | Sheetname |
      #| Post_user_01_Created | POST      |
#
  #@POST_user_05
  #Scenario: User should not be able to create new user with valid Url,end point and without request body
    #Given User sets request for with valid Url,valid endpoint and without request body
    #When User sends POST request without request body
    #Then User receives 400 BAD_REQUEST status in response body
