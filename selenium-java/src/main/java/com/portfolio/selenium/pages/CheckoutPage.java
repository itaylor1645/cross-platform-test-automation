package com.portfolio.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for Checkout: Your Information.
 *
 * Responsibilities:
 * - Fill required customer info fields
 * - Continue to overview on success
 * - Expose validation errors on failure
 */
public final class CheckoutPage extends BasePage {

    // ---- Locators ----
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");

    private final By continueButton = By.id("continue");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Fills the form fields. Passing null means "leave it blank".
     * This supports negative validation tests cleanly.
     */
    public CheckoutPage fill(String firstName, String lastName, String postalCode) {
        if (firstName != null) type(firstNameField, firstName);
        if (lastName != null) type(lastNameField, lastName);
        if (postalCode != null) type(postalCodeField, postalCode);
        return this;
    }

    /**
     * Continues to the overview page (happy path).
     */
    public CheckoutOverviewPage continueToOverview() {
        click(continueButton);
        return new CheckoutOverviewPage(driver);
    }


    /**
     * Clicks continue when you expect validation to fail and remain on the same page.
     * Keeps the test code honest about intent.
     */
    public CheckoutPage continueExpectingError() {
        click(continueButton);
        return this;
    }

    public String errorMessage() {
        return text(errorMessage);
    }
}
