Feature: SignUp
  Scenario Outline: Sign Up to ZTrain application with correct email and passwords
    Given User launched ZTrain application
    When User clicked on the sign up button on the Login page
    And User signed up the app using email "<Email>" password "<Password>" and confirm password "<ConfirmPassword>"
    Then User should be able to sign up successfully

    Examples:
      | Email             | Password | ConfirmPassword  |
      | local@local.local | 12345678 | 12345678         |