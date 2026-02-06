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

**Recommended**
- IntelliJ IDEA (Community is fine)

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
