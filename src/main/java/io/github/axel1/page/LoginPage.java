package io.github.axel1.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;


public class LoginPage extends BasePage {
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator signUpButton;
    private final Locator loginForm;

    public LoginPage(Page page) {
        super(page);
        this.emailInput = page.getByPlaceholder("Email");
        this.passwordInput = page.getByPlaceholder("Mot de passe");
        this.loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Connexion").setExact(true));
        this.signUpButton = page.locator(".style_link__unbWN");
        this.loginForm = page.locator("#style_content_form__yXJox");
    }

    @Override
    public String getPath() {
        return "/auth/login";
    }

    public void navigate() {
        page.navigate(baseUrl + "/auth/login");
    }

    public void login(String email, String password) {
        emailInput.fill(email);
        passwordInput.fill(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public String getErrorMessage() {
        return page.textContent(".style_messageError__LxTAG");
    }

    public boolean isLoginFormVisible() {
        return loginForm.isVisible();
    }
    public boolean isLoginSuccessful() {
        page.waitForURL("https://ztrain-web.vercel.app/home");
        return page.url().equals("https://ztrain-web.vercel.app/home");
    }
}
