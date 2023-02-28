package io.github.axel1.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SignUpPage extends BasePage {

    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator confirmPasswordInput;
    private final Locator signUpButton;

    public SignUpPage(Page page) {
        super(page);
        this.emailInput = page.locator("#email_register");
        this.passwordInput = page.locator("#password_register");
        this.confirmPasswordInput = page.locator("#confirm_password_register");
        this.signUpButton = page.locator("#btn_register");
    }

    public void navigate() {
        page.navigate("https://ztrain-web.vercel.app/auth/register");
    }

    public void signUp(String email, String password, String confirmPassword) {
        emailInput.fill(email);
        passwordInput.fill(password);
        confirmPasswordInput.fill(confirmPassword);
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public String getErrorMessage() {
        return page.textContent(".style_messageError__LxTAG");
    }
}
