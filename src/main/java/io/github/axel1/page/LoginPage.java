package io.github.axel1.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;


public class LoginPage extends BasePage {
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator signUpButton;

    public LoginPage(Page page) {
        super(page);
        this.emailInput = page.getByPlaceholder("Email");
        this.passwordInput = page.getByPlaceholder("Mot de passe");
        this.loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Connexion").setExact(true));
        this.signUpButton = page.locator(".style_link__unbWN");
    }

    public void navigate() {
        page.navigate("https://ztrain-web.vercel.app/auth/login");
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
}
