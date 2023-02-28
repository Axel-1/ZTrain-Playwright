package io.github.axel1.steps;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.axel1.page.LoginPage;
import io.github.axel1.page.SignUpPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BaseSteps {
    static Playwright playwright;
    static Browser browser;
    static BrowserContext context;
    private LoginPage loginPage;
    private SignUpPage signUpPage;
    private Page page;

    @BeforeAll
    public static void beforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
    }

    @AfterAll
    public static void afterAll() {
        browser.close();
    }

    @Before
    public void before() {
        context = BaseSteps.browser.newContext();
        page = context.newPage();
        loginPage = new LoginPage(page);
        signUpPage = new SignUpPage(page);
    }

    @After
    public void after() {
        if (loginPage != null) {
            loginPage.close();
        }
        if (signUpPage != null) {
            signUpPage.close();
        }
    }

    @Given("User launched ZTrain application")
    public void user_launched_ztrain_application() {
        loginPage.navigate();
    }

    @When("User logged in the app using username {string} and password {string}")
    public void user_logged_in_the_app_using_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @When("User clicked on the login button")
    public void userClickedOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @When("User clicked on the sign up button on the Login page")
    public void userClickedOnTheSignUpButtonOnTheLoginPage() {
        loginPage.clickSignUpButton();
    }

    @Then("User should be able to log in")
    public void logInSuccessful() {
        assertNotEquals("https://ztrain-web.vercel.app/home", loginPage.url());
    }

    @Then("User should not be able to log in with incorrect email or password error message")
    public void logInUnsuccessfulIncorrectEmailOrPassword() {
        assertNotEquals("https://ztrain-web.vercel.app/home", loginPage.url());
        assertEquals("Email ou mot de passe incorrect", loginPage.getErrorMessage());
    }

    @Then("User should not be able to log in with invalid email message")
    public void logInUnsuccessfulInvalidEmail() {
        assertNotEquals("https://ztrain-web.vercel.app/home", loginPage.url());
        assertEquals("Le format de l'email est invalid", loginPage.getErrorMessage());
    }

    @Given("User launched ZTrain application on the register page")
    public void userLaunchedZTrainApplicationOnTheRegisterPage() {
        signUpPage.navigate();
    }

    @When("User clicked on the sign up button")
    public void userClickedOnTheSignUpButton() {
        signUpPage.clickSignUpButton();
    }

    @Then("User should be able to sign up successfully")
    public void userShouldBeAbleToSignUpSuccessfully() {
        assertNotEquals("https://ztrain-web.vercel.app/home", signUpPage.url());
    }

    @Then("User should not be able to sign up successfully with invalid email")
    public void userShouldNotBeAbleToSignUpSuccessfully() {
        assertEquals("Le format de l'email est invalid", signUpPage.getErrorMessage());
    }

    @Then("User should not be able to sign up successfully with invalid password")
    public void userShouldNotBeAbleToSignUpSuccessfullyWithInvalidPassword() {
        assertEquals("Le mot de passe doit contenir au moins 8 caractères", signUpPage.getErrorMessage());
    }

    @Then("User should not be able to sign up successfully with invalid confirm password")
    public void userShouldNotBeAbleToSignUpSuccessfullyWithInvalidConfirmPassword() {
        assertEquals("Les mots de passe ne correspondent pas", signUpPage.getErrorMessage());
    }

    @When("User signed up the app using email {string} password {string} and confirm password {string}")
    public void userSignedUpTheAppUsingEmailStringPasswordStringAndConfirmPasswordString(String email, String password, String confirmPassword) {
        signUpPage.signUp(email, password, confirmPassword);
    }
}
