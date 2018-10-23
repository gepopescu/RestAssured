Feature: GET request and POST request

  Scenario: User calls web services in order to get all pet types
    Given I have access to perform GET request
    When  I perform GET request to "/pettypes"
    Then I will have status code "200"

  Scenario: User calls web services in order to add a new pet type
    Given I have access to perform POST request
    When I perform a POST to "/pettypes"
    Then I will have status code "201"

  Scenario: User calls web services in order to put a pet type
    Given  I have access to perform Put request
    When I perform a PUT to "/pettypes/{petTypeId}"
    Then I will have status code "204"
      
  Scenario: User calls web services in order to delete a pet type
    Given I have access to perform Delete request
    When I perform a Delete to "/pettypes/{petTypeId}"
    Then I will have status code "204"

