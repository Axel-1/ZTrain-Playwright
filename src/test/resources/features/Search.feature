Feature: Search
  Scenario Outline: Login to ZTrain Application and search for a product
    Given User launched ZTrain application
    When User navigated to the Login page
    Then User should be able to see the Login form
    When User logged in the app using e-mail "test@test.test" and password "12345678"
    And User clicked on the login button
    Then User should be able to log in
    When User searched for "<Product>"
    Then User should see the "<Product>" product in the result

    Examples:
      | Product |
      | Ampoule |

  @alreadyLoggedIn @search
  Scenario: Search for a product
    When User searched for "Ampoule"
    Then User should see the "Ampoule" product in the result