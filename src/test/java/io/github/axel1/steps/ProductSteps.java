package io.github.axel1.steps;

import io.cucumber.java.en.When;

public class ProductSteps {
    private final PageContainer pageContainer = PageContainer.getInstance();

    @When("User clicked on the add to cart button")
    public void userClickedOnTheAddToCartButton() {
        pageContainer.getProductPage().clickAddToCartButton();
    }
}
