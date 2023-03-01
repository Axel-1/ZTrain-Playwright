package io.github.axel1.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ProductPage extends BasePage {
    private final Locator addToCartButton;
    private final Locator productName;
    private final Locator prodcutPopUp;

    public ProductPage(Page page) {
        super(page);
        this.addToCartButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ajouter au panier"));
        this.productName = page.locator("#style_detail_wrapper__a7fpS");
        this.prodcutPopUp = page.locator("#style_content_detail__ZNkX9");
    }

    @Override
    public String getPath() {
        return "/home";
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public boolean productNameContains(String name) {
        return productName.textContent().contains(name);
    }

    public boolean isProductPopUpVisible() {
        return prodcutPopUp.isVisible();
    }
}
