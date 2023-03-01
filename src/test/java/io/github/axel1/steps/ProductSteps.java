package io.github.axel1.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductSteps {
    private final PageContainer pageContainer = PageContainer.getInstance();

    @When("User clicked on the add to cart button")
    public void userClickedOnTheAddToCartButton() {
        pageContainer.getProductPage().clickAddToCartButton();
    }

    @Then("User should see the product pop-up")
    public void userShouldSeeTheProductPopUp() {
        assertTrue(pageContainer.getProductPage().isProductPopUpVisible());
    }

    @Then("User should see the product pop-up for the product {string}")
    public void userShouldSeeTheProductName(String productName) {
        assertTrue(pageContainer.getProductPage().productNameContains(productName));
    }
}
