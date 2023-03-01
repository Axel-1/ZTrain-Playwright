package io.github.axel1.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchSteps {
    private final PageContainer pageContainer = PageContainer.getInstance();

    @When("User searched for {string}")
    public void userSearchedFor(String search) {
        pageContainer.getSearchPage().search(search);
    }

    @When("User clicked on the result")
    public void userClickedOnTheResult() {
        pageContainer.getSearchPage().clickFirstResult();
    }

    @Then("User should see the {string} product in the result")
    public void userShouldSeeTheProductInTheResult(String productName) {
        assertTrue(pageContainer.getSearchPage().firstResultContains(productName));
    }
}
