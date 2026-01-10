# ---------- Create directories ----------
$dirs = @(
  "selenium-java/src/main/java/com/portfolio/selenium/config",
  "selenium-java/src/main/java/com/portfolio/selenium/driver",
  "selenium-java/src/main/java/com/portfolio/selenium/pages",
  "selenium-java/src/main/java/com/portfolio/selenium/utils",
  "selenium-java/src/test/java/com/portfolio/selenium/tests",
  "selenium-java/src/test/resources"
)

foreach ($dir in $dirs) {
  New-Item -ItemType Directory -Force -Path $dir | Out-Null
}

# ---------- Create files ----------
$files = @(
  "selenium-java/pom.xml",
  "selenium-java/README.md",
  "selenium-java/allure.properties",
  "selenium-java/junit-platform.properties",
  "selenium-java/src/test/resources/logback.xml",

  "selenium-java/src/main/java/com/portfolio/selenium/config/TestConfig.java",
  "selenium-java/src/main/java/com/portfolio/selenium/driver/DriverFactory.java",
  "selenium-java/src/main/java/com/portfolio/selenium/driver/WebDriverProvider.java",

  "selenium-java/src/main/java/com/portfolio/selenium/pages/BasePage.java",
  "selenium-java/src/main/java/com/portfolio/selenium/pages/LoginPage.java",
  "selenium-java/src/main/java/com/portfolio/selenium/pages/InventoryPage.java",
  "selenium-java/src/main/java/com/portfolio/selenium/pages/CartPage.java",
  "selenium-java/src/main/java/com/portfolio/selenium/pages/CheckoutPage.java",
  "selenium-java/src/main/java/com/portfolio/selenium/pages/CheckoutOverviewPage.java",
  "selenium-java/src/main/java/com/portfolio/selenium/pages/CheckoutCompletePage.java",

  "selenium-java/src/main/java/com/portfolio/selenium/utils/Waits.java",

  "selenium-java/src/test/java/com/portfolio/selenium/tests/BaseUiTest.java",
  "selenium-java/src/test/java/com/portfolio/selenium/tests/LoginTests.java",
  "selenium-java/src/test/java/com/portfolio/selenium/tests/CheckoutTests.java"
)

foreach ($file in $files) {
  New-Item -ItemType File -Force -Path $file | Out-Null
}

Write-Host "Selenium project structure created successfully."
