@SmokeScenario
Feature: To Test Create Account functionality

  @SmokeTest
  Scenario: Create New Account
    Given User is on Create Account Page
    And Enter the details
    When I click create an Account
    Then Account should create successfully
    And Sign Out the Account
