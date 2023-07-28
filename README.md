# HomeStore Project

[![Selenium](https://img.shields.io/badge/Selenium-3.141.59-green.svg)](https://www.selenium.dev/)
[![WebDriverManager](https://img.shields.io/badge/WebDriverManager-5.0.3-green.svg)](https://github.com/bonigarcia/webdrivermanager)

This repository contains a Final Selenium Java project of HomeStore e-shop that demonstrates automated browser testing using WebDriver for Chrome and Firefox. The tests are implemented using the Page Object Model (POM) design pattern to improve code readability and maintainability.

## Prerequisites

Before running the tests, ensure you have the following software installed on your system:

- Java Development Kit (JDK) 8 or higher
- Maven (for build and dependency management)

## Dependencies

The project uses the following major dependencies:

- Selenium Java (v3.141.59): The core library for interacting with web elements and browsers.
- WebDriverManager (v5.0.3): A utility library to manage WebDriver binaries automatically.

## Setting Up

1. Clone the repository to your local machine:
   
git clone https://github.com/dovillee/FinalProject.git

2. Navigate to the project directory:
   
cd HomeStore

4. Install the project dependencies using Maven:

mvn clean install

4.Running Tests
You can run the tests using Maven commands. By default, the tests will be executed on Firefox. To run the tests on Chrome, specify the browser parameter:

# Run tests on Firefox (default)
mvn test

# Run tests on Chrome
mvn test -Dbrowser=Chrome

The test results and reports will be available in the target directory.

## Project Structure
The project follows a standard Maven directory structure:

|-- src
    |-- main
    |   |-- java             # Contains application code (if any)
    |-- test
        |-- java             # Contains test classes
        |-- resources        # Contains test configuration files
|-- pom.xml                  # Maven configuration file

The test classes are organized using the Page Object Model (POM) design pattern, which promotes reusable and maintainable test code.


## Test Classes
- BaseTest: This class sets up the WebDriver instances for Chrome and Firefox using WebDriverManager. It also includes basic test configurations, such as browser setup and test teardown.
- ShopPage: An example of a page class that represents the Shop page of the application. It contains web element locators and methods to interact with the page.


## Contributing
Contributions are welcome! If you find any issues or have suggestions to improve the project, please feel free to open an issue or submit a pull request.


Happy testing! 🚀
