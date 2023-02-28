package io.github.axel1.steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.axel1.page.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LoginSteps {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    LoginPage loginPage;

    @BeforeAll
    public static void beforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
    }

    @Before
    public void before() {
        context = browser.newContext();
    }

    @Given("User launched ZTrain application")
    public void user_launched_ztrain_application() {
        loginPage = new LoginPage(context.newPage());
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


    @After
    public void after() {
        loginPage.close();
    }

    @AfterAll
    public static void afterAll() {
        browser.close();
    }
}
