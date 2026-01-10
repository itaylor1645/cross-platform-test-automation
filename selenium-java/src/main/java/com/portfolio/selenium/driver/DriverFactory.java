package com.portfolio.selenium.driver;

import com.portfolio.selenium.config.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Creates WebDriver instances with sane defaults for local + CI execution.
 *
 * Key design points:
 * - Browser choice via system property (e.g., -Dbrowser=chrome|firefox)
 * - Headless defaults to true for CI readiness (override with -Dheadless=false)
 * - Uses Selenium Manager (Selenium 4+) so you don't manage driver binaries manually
 */
public final class DriverFactory {

    private DriverFactory() { }

    public static WebDriver create() {
        String browser = TestConfig.browser().toLowerCase();

        return switch (browser) {
            case "chrome" -> createChrome();
            case "firefox" -> createFirefox();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        };
    }

    private static WebDriver createChrome() {
        ChromeOptions options = new ChromeOptions();

        if (TestConfig.headless()) {
            // "new" headless mode for modern Chrome
            options.addArguments("--headless=new");
        }

        // CI-friendly stability flags
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        return new ChromeDriver(options);
    }

    private static WebDriver createFirefox() {
        FirefoxOptions options = new FirefoxOptions();

        if (TestConfig.headless()) {
            options.addArguments("-headless");
        }

        return new FirefoxDriver(options);
    }
}
