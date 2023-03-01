package io.github.axel1.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class CartPage extends BasePage {
    private final Locator cartButton;
    private final Locator emptyCart;
    private final Locator cart;

    public CartPage(Page page) {
        super(page);
        this.cartButton = page.locator("#style_content_cart_wrapper__mqNbf");
        this.emptyCart = page.locator("#style_empty_cart_wrapper__23a1z");
        this.cart = page.locator("#style_card_wrapper__hrc1I");
    }

    @Override
    public String getPath() {
        return "/home";
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public boolean isCartEmpty() {
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return emptyCart.isVisible();
    }

    public boolean isCartVisible() {
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return cart.isVisible();
    }

    public boolean cartContains(String productName) {
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return cart.textContent().contains(productName);
    }
}
