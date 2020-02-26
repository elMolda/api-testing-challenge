Feature: Authentication

  Scenario: Get session id
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