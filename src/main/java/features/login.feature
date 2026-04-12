Feature: Test Login Functionality

  Scenario: Successful Login
    Given I am on the login page
    When I enter credentials with username "admin" and password "admin123"
    Then I should be redirected to the dashboard

  Scenario: Unsuccessful Login with Invalid Credentials
    Given I am on the login page
    When I enter credentials with username "wrongUser" and password "wrongPass"
    Then I should see an error message saying "Invalid username or password"

  Scenario: Unsuccessful Login with Empty Fields
    Given I am on the login page
    When I enter credentials with username "" and password ""
    Then I should see an error message saying "Username is required" and "Password is required"