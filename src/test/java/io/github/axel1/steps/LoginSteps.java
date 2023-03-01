package io.github.axel1.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LoginSteps {
    private final PageContainer pageContainer = PageContainer.getInstance();

    @Given("User launched ZTrain application")
    public void user_launched_ztrain_application() {
        pageContainer.getLoginPage().navigate();
    }

    @When("User logged in the app using username {string} and password {string}")
    public void user_logged_in_the_app_using_username_and_password(String username, String password) {
        pageContainer.getLoginPage().login(username, password);
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
        assertNotEquals("https://ztrain-web.vercel.app/home", pageContainer.getLoginPage().url());
    }

    @Then("User should not be able to log in with incorrect email or password error message")
    public void logInUnsuccessfulIncorrectEmailOrPassword() {
        assertNotEquals("https://ztrain-web.vercel.app/home", pageContainer.getLoginPage().url());
        assertEquals("Email ou mot de passe incorrect", pageContainer.getLoginPage().getErrorMessage());
    }

    @Then("User should not be able to log in with invalid email message")
    public void logInUnsuccessfulInvalidEmail() {
        assertNotEquals("https://ztrain-web.vercel.app/home", pageContainer.getLoginPage().url());
        assertEquals("Le format de l'email est invalid", pageContainer.getLoginPage().getErrorMessage());
    }
}
