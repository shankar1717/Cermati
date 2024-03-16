eBay Automation Test Suite
This repository contains automation tests for the eBay website using Selenium WebDriver and the Cucumber framework.

Prerequisites
Language: Java
Testing Framework: Selenium, Cucumber
Browser: Chrome
Operating System: Windows 11

Setup Instructions
Clone the repository or download the source code from the following URL: https://github.com/shankar1717/Cermati.git.
Execute the script by running TestRunner located in the src\test\java\runner package.
Change feature file for Scenario 1: features = "Features//mutipleFilters.feature".
Change feature file for Scenario 2: features = "Features//productSearch.feature".

Scenarios
Scenario 1: Access a Product via category after applying multiple filters.
Scenario 2: Access a Product via Search.

Project Structure
Features Folder: Contains feature files written in Gherkin syntax describing the scenarios.

mutipleFilters.feature
productSearch.feature
src/test/java: Contains the main Java code for the automation tests.

Runner Package: Contains TestRunner class to execute the Cucumber scenarios.
TestRunner.java

StepDefinition Package: Contains Java classes implementing step definitions for the scenarios.
StepsForMultipleFilters.java
StepsForProductSearch.java

Utilities: Contains utility classes for configuration.

Readconfig.java - To read data from the properties file.
Configuration Folder: Contains the config.properties file.

Contributor
Name: SHANKAR

License
This project is licensed under the MIT License - see the LICENSE file for details.

