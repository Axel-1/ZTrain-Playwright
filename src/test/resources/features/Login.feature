Feature: Login
  Scenario Outline: Login to ZTrain Application with Correct credentials
    Given User launched ZTrain application
    When User navigated to the Login page
    Then User should be able to see the Login form
    When User logged in the app using e-mail "<Email>" and password "<Password>"
    And User clicked on the login button
    Then User should be able to log in

    Examples:
      | Email              | Password     |
      | test@test.test     | 12345678     |

  Scenario Outline: Login to ZTrain Application with Incorrect credentials
    Given User launched ZTrain application
    When User navigated to the Login page
    Then User should be able to see the Login form
    When User logged in the app using e-mail "<Email>" and password "<Password>"
    And User clicked on the login button
    Then User should not be able to log in with incorrect email or password

    Examples:
      | Email              | Password     |
      | nope@test.test     | 12345678     |
      | test@test.test     | 00000000     |
      | nope@test.test     | 00000000     |

  Scenario Outline: Login to ZTrain Application with Invalid emails
    Given User launched ZTrain application
    When User navigated to the Login page
    Then User should be able to see the Login form
    When User logged in the app using e-mail "<Email>" and password "<Password>"
    And User clicked on the login button
    Then User should not be able to log in with invalid email

    Examples:
      | Email              | Password     |
      | nope@test          | 12345678     |
      | AAA                | 12345678     |
      | nope@              | 12345678     |

  Scenario: Login to ZTrain Application without credentials
    Given User launched ZTrain application
    When User navigated to the Login page
    Then User should be able to see the Login form
    When User clicked on the login button
    Then User should not be able to log in with invalid email

  @login
  Scenario: Login to ZTrain Application
    Given User launched ZTrain application
    When User navigated to the Login page
    Then User should be able to see the Login form
    When User logged in the app using e-mail "test@test.test" and password "12345678"
    And User clicked on the login button
    Then User should be able to log in
