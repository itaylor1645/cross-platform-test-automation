package com.portfolio.selenium.tests;

import com.portfolio.selenium.config.TestConfig;
import com.portfolio.selenium.pages.InventoryPage;
import com.portfolio.selenium.pages.LoginPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * High-value authentication tests.
 *
 * Tags:
 * - ui: runs in full UI pipelines
 * - login: useful slice for smoke/regression selection
 */
@Tag("ui")
@Tag("login")
public class LoginTests extends BaseUiTest {

    @Test
    void login_validUser_landsOnInventory() {
        InventoryPage inventory = new LoginPage(driver())
                .open(TestConfig.baseUrl())
                .loginValid(TestConfig.standardUser(), TestConfig.password());

        assertEquals("Products", inventory.title());
    }

    @Test
    void login_invalidUser_showsError() {
        LoginPage login = new LoginPage(driver())
                .open(TestConfig.baseUrl())
                .loginInvalid("nope", "wrong");

        assertTrue(
                login.errorMessage().toLowerCase().contains("do not match"),
                "Expected login error message to mention username/password mismatch."
        );
    }

    @Test
    void login_lockedOutUser_showsLockedOutMessage() {
        LoginPage login = new LoginPage(driver())
                .open(TestConfig.baseUrl())
                .loginInvalid(TestConfig.lockedOutUser(), TestConfig.password());

        assertTrue(
                login.errorMessage().toLowerCase().contains("locked out"),
                "Expected locked out user message."
        );
    }
}
