package io.github.axel1.page;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LoginPageTest {
    // Shared between all tests in this class.
    static Playwright playwright;
    static Browser browser;

    // New instance for each test method.
    BrowserContext context;
    LoginPage loginPage;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        loginPage = new LoginPage(context.newPage());
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    /*@Test
    void shouldLogIn() {
        loginPage.navigate();
        loginPage.login("test@test.test", "12345678");
        assertEquals("https://ztrain-web.vercel.app/home", loginPage.getPage().url());
    }*/

    @Test
    void shouldNotLogInWithIncorrectPassword() {
        loginPage.navigate();
        loginPage.login("test@test.test", "123456789");
        assertNotEquals("https://ztrain-web.vercel.app/home", loginPage.getPage().url());
        assertEquals("Email ou mot de passe incorrect", loginPage.getErrorMessage());
    }

    @Test
    void shouldNotLogInWithInvalidPassword() {
        loginPage.navigate();
        loginPage.login("test@test.test", "123456789");
        assertNotEquals("https://ztrain-web.vercel.app/home", loginPage.getPage().url());
        assertEquals("Email ou mot de passe incorrect", loginPage.getErrorMessage());
    }

    /*@Test
    void shouldClickButton() {
        page.navigate("data:text/html,<script>var result;</script><button onclick='result=\"Clicked\"'>Go</button>");
        page.locator("button").click();
        assertEquals("Clicked", page.evaluate("result"));
    }

    @Test
    void shouldCheckTheBox() {
        page.setContent("<input id='checkbox' type='checkbox'></input>");
        page.locator("input").check();
        assertTrue((Boolean) page.evaluate("() => window['checkbox'].checked"));
    }

    @Test
    void shouldSearchWiki() {
        page.navigate("https://www.wikipedia.org/");
        page.locator("input[name=\"search\"]").click();
        page.locator("input[name=\"search\"]").fill("playwright");
        page.locator("input[name=\"search\"]").press("Enter");
        assertEquals("https://en.wikipedia.org/wiki/Playwright", page.url());
    }*/

}