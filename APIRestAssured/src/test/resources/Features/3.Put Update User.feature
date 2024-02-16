@UserFeature-Put
Feature: User API Module - PUT Update Requests

  @Put_user_01_05to08_11to19
  Scenario Outline: Verify PUT request to update user details with valid Url, end point and valid request body
    Given User sets put request for User Module, to update user with valid Url, endpoint and request body
    When User sends PUT request with "<TestCaseNumber>" and "<Sheetname>" from excel
    Then User receives updated Status in response body for respective "<TestCaseNumber>"

    Examples: 
      | TestCaseNumber                        | Sheetname |
      | Put_user_1_2_UpdateAllMandatoryFields | PUT       |
      | Put_user_3_4_10_InvalidURL_EndPoint   | PUT       |
      | Put_user_5_UpdateFirstname            | PUT       |
      | Put_user_6_UpdateLastname             | PUT       |
      | Put_user_7_UpdateContactNumber        | PUT       |
      | Put_user_8_UpdateEmailID              | PUT       |
      | Put_user_9_InvalidUserID              | PUT       |
      | Put_user_11_UpdateMissingFirstname    | PUT       |
      | Put_user_12_UpdateMissingLastname     | PUT       |
      | Put_user_13_UpdateMissingContact      | PUT       |
      | Put_user_14_UpdateMissingEmailID      | PUT       |
      | Put_user_15_UpdateMissingPlotNo       | PUT       |
      | Put_user_16_UpdateMissingStreet       | PUT       |
      | Put_user_17_UpdateMissingState        | PUT       |
      | Put_user_18_UpdateMissingCountry      | PUT       |
      | Put_user_19_UpdateMissingZipcode      | PUT       |

  @Put_user_02
  Scenario: Verify PUT request of Unauthorized user, to update user details with valid Url, end point and request body
    Given Unauthorized User sets request with valid Url,valid endpoint and valid request body with madetory fields
    When Unauthorized User sends PUT request with "<TestCaseNumber>" and "<Sheetname>" from excel
    Then User receives 401 Unauthorized status in response body

  @Put_user_03_10
  Scenario: Verify PUT request to update first name and last name with valid Url, invalid end point and request body
    Given User sets request for with valid Url, invalid endpoint and valid request body
    When User sends PUT request with invalid endpoint and "<TestCaseNumber>" and "<Sheetname>" from excel
    Then User receives 404 Not found status in response body

  @Put_user_04
  Scenario: Verify PUT request to update  first name with invalid Url,valid end point and request body
    Given User sets request for with invalid Url, valid endpoint and valid request body
    When User sends PUT request with invalid Url and "<TestCaseNumber>" and "<Sheetname>" from excel
    Then User receives 404 Not found status in response body

  @Put_user_09
  Scenario: Verify PUT request to update user details with valid Url but invalid user id
    Given User sets put request for User Module, to update user details with valid Url but invalid user id
    When User sends PUT request with invalid UserID and "<TestCaseNumber>" and "<Sheetname>" from excel
    Then User receives 404 Not found status in response body
