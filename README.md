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

## ⚙️ Setup & Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/AutomateWithKent/OpenCartAutomationFramework.git
   ```
2. Import the project into **Eclipse** or **IntelliJ IDEA** as a Maven project.  
3. Run Maven to install dependencies:
   ```bash
   mvn clean install
   ```
4. Configure the `config.properties` file with:
   - `email`  
   - `password`  

---

## ▶️ Running Tests
- Run any of the TestNG XML files (`master.xml`, `crossbrowser.xml`, `groupings.xml`, etc.) directly from your IDE.  
- Alternatively, execute via Maven:  
  ```bash
  mvn test -DsuiteXmlFile=master.xml
---

## 📊 Reports
- After execution, **ExtentReports** will be automatically generated.  
- The report will open in **Chrome** once the test execution is complete.
  
---

## ✨ Features
- Page Object Model (POM) for better code maintainability  
- Data-Driven Testing using **Apache POI** for reading/writing Excel files  
- Cross-Browser and Parallel Testing support with TestNG  
- Easy configuration through `config.properties`  
- Scalable for **Regression, Smoke, and Sanity** test suites  
- Centralized Reporting with **ExtentReports**  
- Automatic Screenshot capture on test failures  
- **Auto-generation of HTML Reports** after test execution  
- **Report auto-launch in Chrome** upon test completion  

---

## 👨‍💻 Author
- [AutomateWithKent](https://github.com/AutomateWithKent)
