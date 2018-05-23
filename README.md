# Courgette-JVM with Selenium Example

An example project showing how to use Courgette-JVM with Selenium tests.

## System Requirements

* Latest Google Chrome
* Latest Firefox
* MacOS / Windows / Linux

## Test Execution

There are 2 scenarios in this project. Each scenario navigates to a site and validates the page title. This example project will demostrate how to run a single Cucumber scenario against 2 different browsers.

Each scenario will run on an instance Chrome and an instance Firefox in parallel (_A total of 4 browser windows will open at the same time_)


#### Mac OS / Ubuntu

* JUnit
    * Run shell script 'courgette-selenium-junit.sh'

* TestNG
    * Run shell script 'courgette-selenium-testng.sh'
