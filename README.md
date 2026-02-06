# Automation Test Portfolio — Java (Selenium)

A Java-based UI automation project (Selenium + JUnit/TestNG) intended as an automation portfolio.
This README focuses on **getting the project running after cloning/copying the repo** onto a new machine.

---

## Tech Stack (Current)
- Java (JDK)
- Maven
- Selenium WebDriver
- Test framework: JUnit or TestNG (see `pom.xml`)
- Reporting (optional): Allure (if configured)

---

## Quick Start (Fresh Machine / New PC)

### 1) Install prerequisites
**Required**
- **Git** (to clone the repo)
- **Java JDK** (recommend **JDK 17** or whatever your `pom.xml` is set for)
- **Maven** (or use the included Maven Wrapper if you add it later)
- **Google Chrome** (recommended default browser)

Download Git here: https://git-scm.com/download/win
Download Maven here: https://maven.apache.org/download.cgi

## Allure Reporting (Optional)

This project uses **Allure** for rich test reports.

### Install Allure (Windows)

**Winget (recommended):**
```powershell
winget install --id Qameta.Allure --source winget
Download(for manulal install): https://github.com/allure-framework/allure2/releases

#Viewing Reports
From the project folder: allure serve target/allure-results

## Corporate Network Notes
If running behind a VPN with SSL inspection, Java may require the corporate
root CA to be added to its truststore for Maven dependency resolution.

Verify installs:
```bash
java -version
mvn -version
git --version

### Running the script

mvn clean test ^
  -Dheadless=false ^
  -DslowMode=true ^
  -DslowDelayMs=800
