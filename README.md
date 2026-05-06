# Cucumber-Selenium-Framework

[![Java](https://img.shields.io/badge/Java-24-orange)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.9.6-blue)](https://maven.apache.org/)
[![Cucumber](https://img.shields.io/badge/Cucumber-7.34.3-green)](https://cucumber.io/)
[![Selenium](https://img.shields.io/badge/Selenium-4.43.0-red)](https://www.selenium.dev/)
[![JUnit](https://img.shields.io/badge/JUnit-4.13.2-yellow)](https://junit.org/junit4/)

A robust and scalable test automation framework built with Cucumber, Selenium, and Java for Behavior-Driven Development (BDD) testing of web applications.

## 🚀 Features

- **BDD with Cucumber**: Write human-readable test scenarios in Gherkin syntax
- **Cross-Browser Testing**: Support for Chrome, Firefox, and other browsers via WebDriverManager
- **Page Object Model**: Organized page classes for maintainable code
- **Dependency Injection**: PicoContainer for managing test dependencies
- **Screenshot Capture**: Automatic screenshots on test failures
- **Comprehensive Reporting**: Cucumber HTML and JSON reports
- **Configurable**: Easy configuration via properties files
- **Hooks Support**: Setup and teardown with Cucumber hooks

## 🛠️ Tech Stack

- **Java 24**: Programming language
- **Maven**: Build and dependency management
- **Cucumber**: BDD framework
- **Selenium WebDriver 4**: Browser automation
- **WebDriverManager**: Automatic driver management
- **JUnit 4**: Test runner
- **PicoContainer**: Dependency injection

## 📋 Prerequisites

- Java 24 or higher
- Maven 3.6 or higher
- Chrome browser (or configure other browsers in config.properties)

## 🏗️ Project Structure

```
Cucumber-Selenium-Framework/
├── src/
│   ├── main/java/com/qaplayground/
│   │   ├── base/          # Browser and driver factories
│   │   ├── pages/         # Page Object Model classes
│   │   └── utils/         # Utility classes (config, waits, screenshots)
│   └── test/
│       ├── java/
│       │   ├── hooks/     # Cucumber hooks
│       │   ├── runners/   # Test runners
│       │   └── steps/     # Step definitions
│       └── resources/
│           ├── config.properties  # Configuration
│           └── features/          # Cucumber feature files
├── target/               # Build output and reports
└── pom.xml               # Maven configuration
```

## 🚀 Setup and Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/Cucumber-Selenium-Framework.git
   cd Cucumber-Selenium-Framework
   ```

2. **Install dependencies:**
   ```bash
   mvn clean install
   ```

3. **Configure your environment:**
   - Update `src/test/resources/config.properties` if needed
   - Default configuration uses Chrome browser and QA Playground URLs

## 🧪 Running Tests

### Run all tests:
```bash
mvn test
```

### Run specific tags:
```bash
mvn test -Dcucumber.filter.tags="@smoke"
mvn test -Dcucumber.filter.tags="@regression"
```

### Run specific feature:
```bash
mvn test -Dcucumber.features="src/test/resources/features/login.feature"
```

### Generate reports:
Reports are automatically generated in `target/reports/` after test execution.

## 📊 Test Scenarios

### Login Functionality
- ✅ Successful login with valid credentials
- ✅ Unsuccessful login with invalid credentials
- ✅ Validation for empty fields

### Account Management
- ✅ Verify account page title
- ✅ Display account details

## 🔧 Configuration

Edit `src/test/resources/config.properties`:

```properties
baseUrl=https://www.qaplayground.com/bank
accountUrl=https://www.qaplayground.com/bank/accounts
browser=chrome
timeout=10
```

## 📈 Reports and Screenshots

- **Cucumber Reports**: `target/reports/cucumber-reports.html`
- **JSON Reports**: `target/reports/cucumber-reports.json`
- **Screenshots**: `target/reports/screenshots/` (captured on failures)
