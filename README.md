# 🛠️ OpenCart Automation Framework

This repository contains a **Selenium Test Automation Framework** for testing the [OpenCart Demo Application](https://tutorialsninja.com/demo/).  
It is built using **Java, Selenium WebDriver, TestNG, and Maven**, and follows the **Page Object Model (POM)** design pattern.  

---

## 🚀 Tech Stack
- **Language:** Java  
- **Automation Tool:** Selenium WebDriver  
- **Test Runner:** TestNG  
- **Build Tool:** Maven  
- **Design Pattern:** Page Object Model (POM)  
- **Version Control:** Git  
- **Repository Hosting:** GitHub  

---

## 📂 Project Structure

```
OpenCartAutomationFramework
├── 📂 src
│   ├── 📂 test
│   │   ├── 📂 java
│   │   │   ├── 📂 pageObjects
│   │   │   │   └── # Page Object Classes
│   │   │   ├── 📂 testBase
│   │   │   │   └── # Base Test Class
│   │   │   ├── 📂 testCases
│   │   │   │   └── # Test Classes
│   │   │   └── 📂 utilities
│   │   │       ├── # DataProviders
│   │   │       ├── # ExcelUtilities
│   │   │       ├── # ExtentReportManager
│   │   │       └── # RandomStringUtils
│   │   ├── 📂 resources
│   │   │   ├── 📄 config.properties   # Configuration file
│   │   │   └── 📄 log4j2.xml          # Log4j logging configuration
│   │   ├── 📂 testData
│   │   │   └── # Contains test data for data-driven testing
│   │   ├── 📂 reports 
│   │   │   └── # ExtentReports output
│   │   └── 📂 screenshots
│   │       └── # Screenshots captured on failed tests
├── 📄 DataDriven.xml        # TestNG suite for data-driven tests
├── 📄 crossbrowser.xml      # TestNG suite for cross-browser testing
├── 📄 grid-docker.xml       # TestNG suite for running tests on Docker containers (remote)
├── 📄 groupings.xml         # TestNG suite for grouped tests (sanity, regression, master, DDT)
├── 📄 master.xml            # Master TestNG suite to execute all test classes
├── 📄 pom.xml               # Maven configuration & dependencies
└── 📄 README.md             # Project documentation
```
---

## 📋 Prerequisites
Before setting up the project, ensure you have the following installed:  

- **JDK 21+** (make sure `JAVA_HOME` is set)  
- **Maven 3.8+**  
- **Git**  
- An IDE such as **Eclipse** or **IntelliJ**  
- A modern browser (Chrome, Edge, Firefox)  
- Matching browser drivers (ChromeDriver, GeckoDriver, etc.) for Selenium  

---

## ⚙️ Setup & Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/AutomateWithKent/OpenCartAutomationFramework.git
   ```
2. Import the project into **Eclipse** or **IntelliJ** as a Maven project.
3. Configure Java SE 21 in your IDE

**Eclipse:**
- Right-click on the project → **Properties** → **Java Build Path** → **Libraries** tab → **Add Library** → **JRE System Library** → Select **JavaSE-21**.  
- Also go to **Properties → Java Compiler** and set **Compiler compliance level** to **21**.

**IntelliJ:**
- Go to **File → Project Structure → Project**.  
- Set **Project SDK** to **Java 21**.  
- Under **Modules → Dependencies**, make sure the SDK is set to **Java 21**.
4. Run Maven to install dependencies:
   ```bash
   mvn clean install
   ```
5. Configure the `config.properties` file with:
   - `email – Your login email.`  
   - `password - Your account password.`
   - `productSearch - The product name you want to search for in tests.`

---

## ▶️ Running Tests

You can run the tests in either of the following ways:

### 1. From your IDE
- Open any TestNG XML file (`master.xml`, `crossbrowser.xml`, `groupings.xml`, etc.).
- Run it directly using your IDE's TestNG runner.

### 2. Via Maven
```bash
# Open the command prompt
# Navigate to the project root (where the pom.xml is located)
cd /path/to/project

# Run tests
mvn clean test
```
---

## ✨ Features

### 🛠 Framework Features
- Page Object Model (POM) for better code maintainability
- Data-Driven Testing using Apache POI for reading/writing Excel files
- Cross-Browser and Parallel Testing support with TestNG
- Easy configuration through `config.properties`
- Scalable for Regression, Smoke, and Sanity test suites

### 📊 Reporting Features
- Centralized Reporting with ExtentReports
- Automatic Screenshot capture on test failures
- Auto-generation of HTML Reports after test execution
- Report auto-launch in Chrome upon test completion

---

## 👨‍💻 Author
- [AutomateWithKent](https://github.com/AutomateWithKent)
