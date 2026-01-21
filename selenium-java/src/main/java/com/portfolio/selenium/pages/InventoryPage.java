package com.portfolio.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for the Sauce Demo inventory (products) page.
 *
 * This page is the post-login landing page and a hub for core workflows:
 * - Validate login success (page title)
 * - Add an item to cart
 * - Navigate to cart
 */
public final class InventoryPage extends BasePage {

    // ---- Locators ----
    private final By pageTitle = By.cssSelector(".title");

    private final By cartLink = By.cssSelector(".shopping_cart_link");
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");

    // Example product we use consistently in tests (stable ID)
    private final By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String title() {
        return text(pageTitle);
    }

    public InventoryPage addBackpackToCart() {
        click(addBackpackButton);
        return this;
    }

    public int cartCount() {
        // Badge appears only when count > 0. Return 0 if not present.
        try {
            String value = driver.findElement(cartBadge).getText().trim();
            return Integer.parseInt(value);
        } catch (Exception ignored) {
            return 0;
        }
    }

    public CartPage goToCart() {
        click(cartLink);
        return new CartPage(driver);
    }
}
