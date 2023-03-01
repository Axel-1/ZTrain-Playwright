package io.github.axel1.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {
    private final PageContainer pageContainer = PageContainer.getInstance();

    @When("User navigated to the Login page")
    public void userNavigatedToTheLoginPage() {
        pageContainer.getLoginPage().navigate();
    }

    @Then("User should be able to see the Login form")
    public void userShouldBeAbleToSeeTheLoginPage() {
        assertTrue(pageContainer.getLoginPage().isLoginFormVisible());
    }

    @When("User logged in the app using e-mail {string} and password {string}")
    public void userLoggedInTheAppUsingEmailAndPassword(String email, String password) {
        pageContainer.getLoginPage().login(email, password);
    }

    @When("User clicked on the login button")
    public void userClickedOnTheLoginButton() {
        pageContainer.getLoginPage().clickLoginButton();
    }

    @When("User clicked on the sign up button on the Login page")
    public void userClickedOnTheSignUpButtonOnTheLoginPage() {
        pageContainer.getLoginPage().clickSignUpButton();
    }

    @Then("User should be able to log in")
    public void logInSuccessful() {
        assertTrue(pageContainer.getLoginPage().isLoginSuccessful());
    }

    @Then("User should not be able to log in with incorrect email or password")
    public void logInUnsuccessfulIncorrectEmailOrPassword() {
        assertEquals("Email ou mot de passe incorrect", pageContainer.getLoginPage().getErrorMessage());
    }

    @Then("User should not be able to log in with invalid email")
    public void logInUnsuccessfulInvalidEmail() {
        assertEquals("Le format de l'email est invalid", pageContainer.getLoginPage().getErrorMessage());
    }
}
