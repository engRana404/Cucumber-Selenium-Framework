Feature: Account page features

  Scenario: Verify account page title
    Given I am on the login page
    And I enter credentials with username "admin" and password "admin123"
    And I am on the account page
    Then the title should be "Manage Accounts"

  Scenario: Verify account details are displayed
    Given I am on the login page
    And I enter credentials with username "admin" and password "admin123"
    And I am on the account page
    Then I should see my account details


