Feature: List management
  Background: User has a session id
    Given User has api key
      | api_key                          |
      | 419f2f4be9b38e5b129c579a32277eb5 |
    And The user sends a request to get a token
    And The service responds with a status code "200"
    And The response body contains the request token
    And User sends request to authorize with
      | username | password |
      | elMolda  | ABR06nov |
    And The service responds with a status code "200"
    And The response body contains the request token
    When  The user sends a request to get session id
    Then The service responds with a status code "200"
    And The response body contains a session id


  Scenario: Create List
    Given User has list basic data
      |name     |description       |language|
      |mynewlist|this is a new list|en      |
    When The user sends a request to create list
    And The response body contains a status_code "1"
    And The response body contains a list id

  Scenario: Retrieve list
    Given A list exists with
      | list_id |
      | 133849  |
    When The user sends a request to get a list
    Then The service responds with a status code "200"
    And The response body contains name
    And The response body contains description