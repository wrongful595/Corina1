@Run
Feature: Add new user

  Scenario: Add new user to our website
    Given User navigate to the website homepage
    And User navigates to Register Page
    When User give userName
    When User give lastName
    When User give addressCity
    And User click on [Register] button
    When User has error message
    When User insert empty fields with valid data
    And User click on Register
    And User has account confirmation
    And User click on Open New Account
    And User chose Savings
    And User click on [Open new account] button
    And User Click on account number
    And User Click the button GO
    Then User insert pass