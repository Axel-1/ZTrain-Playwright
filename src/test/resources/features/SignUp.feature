Feature: SignUp
  Scenario Outline: Sign Up to ZTrain application with correct email and passwords
    Given User launched ZTrain application
    When User clicked on the sign up button on the Login page
    And User signed up the app using email "<Email>" password "<Password>" and confirm password "<ConfirmPassword>"
    And User clicked on the sign up button
    Then User should be able to sign up successfully

    Examples:
      | Email             | Password | ConfirmPassword  |
      | bbbbb@local.test | 12345678 | 12345678         |

  Scenario Outline: Sign Up to ZTrain application with already used email
    Given User launched ZTrain application
    When User clicked on the sign up button on the Login page
    And User signed up the app using email "<Email>" password "<Password>" and confirm password "<ConfirmPassword>"
    And User clicked on the sign up button
    Then User should not be able to sign up successfully with already used email

    Examples:
      | Email             | Password | ConfirmPassword  |
      | local@local.local | 12345678 | 12345678         |