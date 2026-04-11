Feature: Test Login Functionality

  Scenario: Successful Login
    Given I am on the login page
    When I enter valid credentials
    Then I should be redirected to the dashboard

  Scenario: Unsuccessful Login with Invalid Credentials
    Given I am on the login page
    When I enter invalid credentials
    Then I should see an error message

  Scenario: Unsuccessful Login with Empty Fields
    Given I am on the login page
    When I leave the username and password fields empty
    Then I should see an error message indicating that fields cannot be empty