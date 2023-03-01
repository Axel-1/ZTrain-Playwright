package io.github.axel1.steps;

import com.microsoft.playwright.Page;
import io.github.axel1.page.*;

public class PageContainer {
    private static PageContainer instance;
    private LoginPage loginPage;
    private SearchPage searchPage;
    private CartPage cartPage;
    private ProductPage productPage;
    private SignUpPage signUpPage;
    private Page page;

    private PageContainer() {
    }

    public static PageContainer getInstance() {
        if (instance == null) {
            instance = new PageContainer();
        }
        return instance;
    }

    public void init(Page page) {
        this.page = page;
        loginPage = new LoginPage(page);
        searchPage = new SearchPage(page);
        cartPage = new CartPage(page);
        productPage = new ProductPage(page);
        signUpPage = new SignUpPage(page);
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public SearchPage getSearchPage() {
        return searchPage;
    }

    public CartPage getCartPage() {
        return cartPage;
    }

    public ProductPage getProductPage() {
        return productPage;
    }

    public SignUpPage getSignUpPage() {
        return signUpPage;
    }
}
