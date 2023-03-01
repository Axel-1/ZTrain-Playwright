package io.github.axel1.steps;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;

public class BaseSteps {
    static Playwright playwright;
    static Browser browser;
    static BrowserContext context;
    private final PageContainer pageContainer = PageContainer.getInstance();
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
        pageContainer.init(page);
    }

    @After
    public void after() {
        if (page != null) {
            page.close();
        }
    }

    @Given("User launched ZTrain application")
    public void userLaunchedZtrainApplication() {
        pageContainer.navigateBasePage();
    }
}
