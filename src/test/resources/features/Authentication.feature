Feature: Authentication

  Scenario: Create a request token
    Given User has a api key
      | api_key |
      |         |
    When The user sends a request to get a token
    Then The service responds with a status code "200"
    And The response body contains the request token


  Scenario: Ask permission
    Given User has api key
      | api_key |
      |         |
    And User sends a request to get a token
    And The service responds with a status code "200"
    And The response body contains the request token
    When User sends request to authorize with
      | username | password |
      | elMolda  | ABR06nov |
    Then The service responds with a status code "200"
    And The response body contains the request token

  Scenario: Get session id
    Given User has api key
      | api_key |
      |         |
    And User sends a request to get a token
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