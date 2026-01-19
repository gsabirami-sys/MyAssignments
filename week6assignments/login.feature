Feature: Create Account in Salesforce

  Scenario: Create a new Account with Public ownership
    Given User launches Salesforce login page
    When User enters username and password
    And User clicks on Login button
    And User clicks on toggle menu button
    And User clicks View All and selects Sales
    And User clicks on Accounts tab
    And User clicks on New button
    And User enters account name
    And User selects ownership as Public
    Then User clicks Save and verifies account name