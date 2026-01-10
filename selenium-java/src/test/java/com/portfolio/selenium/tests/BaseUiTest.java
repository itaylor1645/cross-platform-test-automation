package com.portfolio.selenium.tests;

import com.portfolio.selenium.driver.DriverFactory;
import com.portfolio.selenium.driver.WebDriverProvider;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public abstract class BaseUiTest {

    @BeforeEach
    void setUp() {
        WebDriver driver = DriverFactory.create();
        WebDriverProvider.set(driver);
    }

    @AfterEach
    void tearDown() {
        WebDriver driver = null;

        // Never let teardown throw and leave a browser running.
        try {
            driver = WebDriverProvider.get();
        } catch (Exception ignored) {
        }

        if (driver != null) {
            // Attach a screenshot for debugging.
            attachScreenshot(driver);

            driver.quit();
        }

        WebDriverProvider.remove();
    }

    protected WebDriver driver() {
        return WebDriverProvider.get();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] attachScreenshot(WebDriver driver) {
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            return new byte[0];
        }
    }
}
