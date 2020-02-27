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

  Scenario: Create list
    Given User has list basic data
      | name        | description    | language |
      | My Try List | My description |    en    |
    When The user sends a request to create list
    Then The service responds with a status code "201"
    And The response body contains a status_code "1"
    And The response body contains a list id
