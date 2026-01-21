package com.portfolio.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for the shopping cart page.
 *
 * Responsibilities:
 * - Confirm items are present in the cart
 * - Transition into the checkout flow
 *
 * This page intentionally stays minimal.
 */
public final class CartPage extends BasePage {

    // ---- Locators ----
    private final By cartItem = By.cssSelector(".cart_item");
    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Returns true if at least one item exists in the cart.
     */
    public boolean hasAnyItems() {
        return !driver.findElements(cartItem).isEmpty();
    }

    /**
     * Begins the checkout process.
     */
    public CheckoutPage checkout() {
        click(checkoutButton);
        return new CheckoutPage(driver);
    }
}
