package io.github.axel1.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class SignUpPage extends BasePage {

    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator confirmPasswordInput;
    private final Locator signUpButton;
    private final Locator signUpForm;

    public SignUpPage(Page page) {
        super(page);
        this.emailInput = page.locator("#email_register");
        this.passwordInput = page.locator("#password_register");
        this.confirmPasswordInput = page.locator("#confirm_password_register");
        this.signUpButton = page.locator("#btn_register");
        this.signUpForm = page.locator("#style_content_form__yXJox");
    }

    @Override
    public String getPath() {
        return "/auth/register";
    }

    public void signUp(String email, String password, String confirmPassword) {
        emailInput.fill(email);
        passwordInput.fill(password);
        confirmPasswordInput.fill(confirmPassword);
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    private boolean isSignUpFormVisible() {
        return signUpForm.isVisible();
    }

    public String getErrorMessage() {
        return page.textContent(".style_messageError__LxTAG");
    }

    public boolean isLoginSuccessful() {
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return page.url().equals("https://ztrain-web.vercel.app/home");
    }
}
