package com.portfolio.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class CheckoutOverviewPage extends BasePage {

    private final By pageTitle = By.cssSelector(".title"); // should be "Checkout: Overview"
    private final By finishButton = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        // Prove we're actually on the page before any actions.
        $(pageTitle);
    }

    public String title() {
        return text(pageTitle);
    }

    public CheckoutCompletePage finish() {
        // Ensure button is clickable using BasePage.click() which waits
        click(finishButton);
        return new CheckoutCompletePage(driver);
    }
}
