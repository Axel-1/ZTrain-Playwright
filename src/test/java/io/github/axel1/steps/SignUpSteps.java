package io.github.axel1.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class SignUpSteps {
    private final PageContainer pageContainer = PageContainer.getInstance();

    @Given("User launched ZTrain application on the register page")
    public void userLaunchedZTrainApplicationOnTheRegisterPage() {
        pageContainer.getSignUpPage().navigate();
    }

    @When("User clicked on the sign up button")
    public void userClickedOnTheSignUpButton() {
        pageContainer.getSignUpPage().clickSignUpButton();
    }

    @Then("User should be able to sign up successfully")
    public void userShouldBeAbleToSignUpSuccessfully() {
        assertTrue(pageContainer.getSignUpPage().isLoginSuccessful());
    }

    @Then("User should not be able to sign up successfully with invalid email")
    public void userShouldNotBeAbleToSignUpSuccessfully() {
        assertEquals("Le format de l'email est invalid", pageContainer.getSignUpPage().getErrorMessage());
    }

    @Then("User should not be able to sign up successfully with invalid password")
    public void userShouldNotBeAbleToSignUpSuccessfullyWithInvalidPassword() {
        assertEquals("Le mot de passe doit contenir au moins 8 caractères", pageContainer.getSignUpPage().getErrorMessage());
    }

    @Then("User should not be able to sign up successfully with invalid confirm password")
    public void userShouldNotBeAbleToSignUpSuccessfullyWithInvalidConfirmPassword() {
        assertEquals("Les mots de passe ne correspondent pas", pageContainer.getSignUpPage().getErrorMessage());
    }

    @Then("User should not be able to sign up successfully with already used email")
    public void userShouldNotBeAbleToSignUpSuccessfullyWithAlreadyUsedEmail() {
        assertEquals("Cet utilisateur existe déjà", pageContainer.getSignUpPage().getErrorMessage());
    }

    @When("User signed up the app using email {string} password {string} and confirm password {string}")
    public void userSignedUpTheAppUsingEmailStringPasswordStringAndConfirmPasswordString(String email, String password, String confirmPassword) {
        pageContainer.getSignUpPage().signUp(email, password, confirmPassword);
    }
}
