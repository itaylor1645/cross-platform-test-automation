package com.portfolio.selenium.driver;

import org.openqa.selenium.WebDriver;

/**
 * Thread-safe storage for WebDriver instances.
 *
 * Why this exists:
 * - Prevents driver sharing between tests
 * - Enables safe parallel execution in the future
 * - Keeps driver access clean (driver() instead of passing it everywhere)
 */
public final class WebDriverProvider {

    private WebDriverProvider() { }

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static void set(WebDriver driver) {
        DRIVER.set(driver);
    }

    public static WebDriver get() {
        WebDriver driver = DRIVER.get();
        if (driver == null) {
            throw new IllegalStateException("WebDriver has not been initialized for this thread.");
        }
        return driver;
    }

    public static void remove() {
        DRIVER.remove();
    }
}
