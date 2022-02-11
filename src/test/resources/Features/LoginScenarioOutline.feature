@regression
Feature: Login Secenario Outline

  @loginScenarioOutline
  Scenario Outline: As a validator I want to have a login functionality so that i can use it for multiple user
    Given validator open application
    When validator enter <userName> and enter <password> in the app
    Then validator click login button
    And validate successfully login message

    Examples: 
      | userName | password      |
      | 'admin'  | 'admin_test'  |
      | 'admin1' | 'admin_test1' |
