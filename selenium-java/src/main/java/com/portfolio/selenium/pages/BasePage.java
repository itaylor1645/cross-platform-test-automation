package com.portfolio.selenium.pages;

import com.portfolio.selenium.config.TestConfig;
import com.portfolio.selenium.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/**
 * Base class for all Page Objects.
 *
 * Responsibilities:
 * - Hold the WebDriver reference
 * - Enforce explicit waits before interaction
 * - Provide concise, safe interaction helpers
 *
 * This class is intentionally small.
 * Page Objects should describe behavior, not Selenium mechanics.
 */
public abstract class BasePage {

    protected final WebDriver driver;
    protected final Duration timeout;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.timeout = TestConfig.timeout();
    }

    protected WebElement $(By locator) {
        return Waits.visible(driver, locator, timeout);
    }

    protected void click(By locator) {
        slowDownIfEnabled();
        WebElement el = Waits.clickable(driver, locator, timeout);
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", el);
        el.click();
    }


    protected void type(By locator, String text) {
        slowDownIfEnabled();
        WebElement element = $(locator);
        element.clear();
        element.sendKeys(text);
    }


    protected String text(By locator) {
        return $(locator).getText().trim();
    }

    protected void slowDownIfEnabled() {
        if (TestConfig.slowMode()) {
            try {
                Thread.sleep(TestConfig.slowDelayMs());
            } catch (InterruptedException ignored) {
            }
        }
    }
}
