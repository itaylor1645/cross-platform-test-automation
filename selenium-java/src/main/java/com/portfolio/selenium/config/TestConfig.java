package com.portfolio.selenium.config;

import java.time.Duration;

/**
 * Centralized runtime configuration for UI tests.
 *
 * Design goals:
 * - No hardcoded environment values in test or page code
 * - All behavior overridable via JVM system properties
 * - Sensible defaults for local + CI execution
 */
public final class TestConfig {

    private TestConfig() { }

    public static String baseUrl() {
        return System.getProperty("baseUrl", "https://www.saucedemo.com/");
    }

    public static String browser() {
        return System.getProperty("browser", "chrome");
    }

    public static boolean headless() {
        return Boolean.parseBoolean(System.getProperty("headless", "true"));
    }

    public static Duration timeout() {
        return Duration.ofSeconds(
                Long.parseLong(System.getProperty("timeoutSeconds", "10"))
        );
    }

    // ---- Test users (demo-site safe defaults) ----

    public static String standardUser() {
        return System.getProperty("standardUser", "standard_user");
    }

    public static String lockedOutUser() {
        return System.getProperty("lockedOutUser", "locked_out_user");
    }

    public static String password() {
        return System.getProperty("password", "secret_sauce");
    }
}
