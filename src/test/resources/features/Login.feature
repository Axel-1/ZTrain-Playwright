Feature: Login
  Scenario Outline: Login to ZTrain Application with Correct credentials
    Given User launched ZTrain application
    When User logged in the app using username "<Email>" and password "<Password>"
    And User clicked on the login button
    Then User should be able to log in

    Examples:
      | Email              | Password     |
      | test@test.test     | 12345678     |

  Scenario Outline: Login to ZTrain Application with Incorrect credentials
    Given User launched ZTrain application
    When User logged in the app using username "<Email>" and password "<Password>"
    And User clicked on the login button
    Then User should not be able to log in

    Examples:
      | Email              | Password     |
      | nope@test.test     | 12345678     |
      | test@test.test     | 00000000     |
      | nope@test.test     | 00000000     |

  Scenario: Login to ZTrain Application without credentials
    Given User launched ZTrain application
    When User clicked on the login button
    Then User should not be able to log in
