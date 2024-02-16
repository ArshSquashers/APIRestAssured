Feature: Delete User Details
  
  @DeleteBYUserName
  Scenario Outline: DeleteBYUserName
    Given User creates Delete Request for the API end point with valid "<user_first_name>"
    When User sends HTTPS Request by valid "<user_first_name>" to delete 
    Then User receive 200 OKStatus with response body.
     Examples: 
      | user_first_name  |
      |shany|
      

  @DeleteBYUserID
  Scenario Outline:DeleteBYUserID 
    Given User creates Delete Request with valid "<user_id>"
    When User sends HTTPS delete Request by valid "<user_id>"
    Then User receives 200 OKStatus with responsebody.

    Examples: 
      | user_id  | 
      | 9131|
      
 @DeleteBYInvalidUserName
  Scenario Outline: DeleteBYInvalidUserName
    Given User creates Delete Request for the API end point with invalid "<user_first_name>"
    When User sends HTTPS Request by invalid "<user_first_name>" to delete 
    Then User receives 404 Statuswith response body.
     Examples: 
      | user_first_name  |
      |nimalan|
      |nimalansankar|

  @DeleteBYUserID
  Scenario Outline:DeleteBYInvalidUserID 
    Given User creates Delete Request with invalid "<user_id>"
    When User sends HTTP delete Request by invalid "<user_id>" 
    Then User receives 404 Status with responsebody.

    Examples: 
      | user_id  | 
      | 9999000|
      |32|
