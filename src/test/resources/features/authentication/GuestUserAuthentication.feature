Feature: Authentication

  Scenario: Create a guest session with session id
    Given User has api key
    | api_key                          |
    | 419f2f4be9b38e5b129c579a32277eb5 |
    When The user sends a request to get a guest session id
    Then The service responds with a status code "200"
    And The response body contains a guest session id