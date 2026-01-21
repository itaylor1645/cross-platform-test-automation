package com.portfolio.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for the Sauce Demo login page.
 *
 * Purpose:
 * - Encapsulate all login-related UI behavior
 * - Hide selectors and Selenium details from tests
 * - Model successful vs unsuccessful login flows explicitly
 */
public final class LoginPage extends BasePage {

    // ---- Locators ----
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Opens the login page directly.
     */
    public LoginPage open(String baseUrl) {
        driver.get(baseUrl);
        return this;
    }

    /**
     * Performs a successful login and returns the next page.
     */
    public InventoryPage loginValid(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);

        return new InventoryPage(driver);
    }

    /**
     * Attempts login expected to fail and stays on the same page.
     */
    public LoginPage loginInvalid(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);

        return this;
    }

    /**
     * Reads the visible login error message.
     */
    public String errorMessage() {
        return text(errorMessage);
    }
}
