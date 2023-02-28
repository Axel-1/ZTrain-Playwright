package io.github.axel1.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ProductPage extends BasePage {
    private final Locator addToCartButton;

    public ProductPage(Page page) {
        super(page);
        this.addToCartButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ajouter au panier"));
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }
}
