package io.github.axel1.page;

import com.microsoft.playwright.Page;

abstract class BasePage {
    protected final Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public String url() {
        return page.url();
    }

    public void close() {
        page.close();
    }
}
