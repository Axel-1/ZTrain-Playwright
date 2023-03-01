package io.github.axel1.page;

import com.microsoft.playwright.Page;

abstract class BasePage {
    protected final Page page;
    protected final String baseUrl = "https://ztrain-web.vercel.app";

    public BasePage(Page page) {
        this.page = page;
    }

    public String url() {
        return page.url();
    }

    public void close() {
        page.close();
    }

    public String getUrl() {
        return baseUrl + getPath();
    }

    public void navigate() {
        page.navigate(getUrl());
    }

    public abstract String getPath();
}
