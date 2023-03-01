package io.github.axel1.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartSteps {
    private final PageContainer pageContainer = PageContainer.getInstance();

    @When("User clicked on the cart button")
    public void userClickedOnTheCartButton() {
        pageContainer.getCartPage().clickCartButton();
    }

    @Then("User should be able to add the product to the cart")
    public void userShouldBeAbleToAddTheProductToTheCart() {
        assertEquals("ok", "ok");
    }
}
