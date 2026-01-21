package com.portfolio.selenium.tests;

import com.portfolio.selenium.config.TestConfig;
import com.portfolio.selenium.pages.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * End-to-end checkout workflow tests.
 *
 * These tests demonstrate:
 * - Multi-page navigation
 * - Data entry and validation
 * - Stable end-state assertions
 */
@Tag("ui")
@Tag("checkout")
public class CheckoutTests extends BaseUiTest {

    @Test
    void checkout_happyPath_completesPurchase() {
        InventoryPage inventory = new LoginPage(driver())
                .open(TestConfig.baseUrl())
                .loginValid(TestConfig.standardUser(), TestConfig.password());

        inventory.addBackpackToCart();
        assertEquals(1, inventory.cartCount());

        CheckoutCompletePage completePage = inventory
                .goToCart()
                .checkout()
                .fill("Ian", "Taylor", "84000")
                .continueToOverview()
                .finish();

        assertTrue(
                completePage.header().toLowerCase().contains("thank you"),
                "Expected confirmation header after successful checkout."
        );
    }

    @Test
    void checkout_missingFirstName_showsValidationError() {
        InventoryPage inventory = new LoginPage(driver())
                .open(TestConfig.baseUrl())
                .loginValid(TestConfig.standardUser(), TestConfig.password());

        inventory.addBackpackToCart();

        CheckoutPage checkoutPage = inventory
                .goToCart()
                .checkout()
                .fill(null, "Taylor", "84000")
                .continueExpectingError();

        assertTrue(
                checkoutPage.errorMessage().toLowerCase().contains("first name"),
                "Expected missing first name validation error."
        );
    }
}
