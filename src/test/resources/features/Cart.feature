Feature: Cart
  Scenario Outline: Login to ZTrain Application, search for a product, view product page and add to cart
    Given User launched ZTrain application
    When User navigated to the Login page
    Then User should be able to see the Login form
    When User logged in the app using e-mail "test@test.test" and password "12345678"
    And User clicked on the login button
    Then User should be able to log in
    When User searched for "<Product>"
    Then User should see the "<Product>" product in the result
    When User clicked on the result
    Then User should see the product pop-up
    Then User should see the product pop-up for the product "<Product>"
    When User clicked on the add to cart button
    When User clicked on the cart button
    Then User should see the cart
    Then User should see the product "<Product>" in the cart

    Examples:
      | Product |
      | Yucca   |

  Scenario Outline: Login to ZTrain Application, search for a product, view product page, add to cart and empty cart
    Given User launched ZTrain application
    When User navigated to the Login page
    Then User should be able to see the Login form
    When User logged in the app using e-mail "test@test.test" and password "12345678"
    And User clicked on the login button
    Then User should be able to log in
    When User searched for "<Product>"
    Then User should see the "<Product>" product in the result
    When User clicked on the result
    Then User should see the product pop-up
    Then User should see the product pop-up for the product "<Product>"
    When User clicked on the add to cart button
    When User clicked on the cart button
    Then User should see the cart
    Then User should see the product "<Product>" in the cart
    When User clicked on the empty cart button
    When User clicked on the cart button
    Then User should see an empty cart

    Examples:
      | Product |
      | Yucca   |