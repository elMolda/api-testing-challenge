Feature: Authentication

  Scenario: Create a request token
    Given User has api key
      | api_key                          |
      | 419f2f4be9b38e5b129c579a32277eb5 |
    When The user sends a request to get a token
    Then The service responds with a status code "200"
    And The response body contains the request token

  Scenario: Ask permission
    Given User has api key
      | api_key                          |
      | 419f2f4be9b38e5b129c579a32277eb5 |
    And The user sends a request to get a token
    And The service responds with a status code "200"
    And The response body contains the request token
    When User sends request to authorize with
      | username | password |
      | elMolda  | ABR06nov |
    Then The service responds with a status code "200"
    And The response body contains the request token