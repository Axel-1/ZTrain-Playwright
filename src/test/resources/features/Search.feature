Feature: Search
  Scenario: Login to ZTrain application, search for a product and add to cart
    Given User launched ZTrain application
    When User logged in the app using username "test@test.test" and password "12345678"
    When User clicked on the login button
    And User searched for "Ampoule"
    And User clicked on the result
    And User clicked on the add to cart button
    And User clicked on the cart button
    Then User should be able to add the product to the cart

  Scenario: Login to ZTrain application and click on the cart
    Given User launched ZTrain application
    When User logged in the app using username "test@test.test" and password "12345678"
    When User clicked on the login button
    And User clicked on the cart button
    Then User should be able to add the product to the cart