@login @regression
Feature: I want to test login feature so that I can test login fanctinality.

  
  Scenario: Valid login
    Given user open application
    When I enter valid username and password
    Then I successfully login

  
