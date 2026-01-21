package com.portfolio.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for Checkout: Complete.
 *
 * This represents the terminal state of the purchase workflow.
 */
public final class CheckoutCompletePage extends BasePage {

    // ---- Locators ----
    private final By completeHeader = By.cssSelector(".complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Returns the visible completion header text.
     * Used as the primary assertion anchor for a successful purchase.
     */
    public String header() {
        return text(completeHeader);
    }
}
