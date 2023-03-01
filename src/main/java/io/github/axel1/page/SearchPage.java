package io.github.axel1.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class SearchPage extends BasePage {
    private final Locator searchInput;
    private final Locator firstResult;

    public SearchPage(Page page) {
        super(page);
        this.searchInput = page.locator("#style_input_navbar_search__Scaxy");
        this.firstResult = page.locator("#style_popular_product_wrapper__z6J0h").getByRole(AriaRole.IMG);
    }

    @Override
    public String getPath() {
        return "/home";
    }

    public void search(String search) {
        searchInput.type(search, new Locator.TypeOptions().setDelay(100));
    }

    public void clickFirstResult() {
        firstResult.click();
    }
}
