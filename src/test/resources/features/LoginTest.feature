Feature: login

  Background:

  @smoke @sprint3
  Scenario: valid admin login
    When user enters valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in
  @Regression
  Scenario: valid ess login
    When user enters valid ess username and password
    And user clicks on login button
    Then ess user is successfully logged in
  @smoke @sprint1
  Scenario: valid username and invalid password
    When user enters valid username and invalid password
    And user clicks on login button
    Then user see invalid credentials message on login page