package io.github.axel1.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;


public class LoginPage {
    private Page page;
    private Locator emailInput;
    private Locator passwordInput;
    private Locator loginButton;

    public LoginPage(Page page) {
        this.page = page;
        this.emailInput = page.getByPlaceholder("Email");
        this.passwordInput = page.getByPlaceholder("Mot de passe");
        this.loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Connexion").setExact(true));
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

    public String url() {
        return page.url();
    }

    public void close() {
        page.close();
    }

    public String getErrorMessage() {
        return page.textContent(".style_messageError__LxTAG");
    }
}
