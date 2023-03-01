package io.github.axel1.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartSteps {
    private final PageContainer pageContainer = PageContainer.getInstance();

    @When("User clicked on the cart button")
    public void userClickedOnTheCartButton() {
        pageContainer.getCartPage().clickCartButton();
    }

    @Then("User should see the product {string} in the cart")
    public void userShouldSeeTheProductInTheCart(String productName) {
        assertTrue(pageContainer.getCartPage().cartContains(productName));
    }

    @Then("User should see the cart")
    public void userShouldSeeTheCart() {
        assertTrue(pageContainer.getCartPage().isCartVisible());
    }

    @Then("User should see an empty cart")
    public void userShouldSeeAnEmptyCart() {
        assertTrue(pageContainer.getCartPage().isCartEmpty());
    }

    @When("User clicked on the empty cart button")
    public void userClickedOnTheEmptyCartButton() {
        pageContainer.getCartPage().clickEmptyCartButton();
    }
}
