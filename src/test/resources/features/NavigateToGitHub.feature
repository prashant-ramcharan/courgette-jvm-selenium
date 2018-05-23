@regression
Feature: Navigate to GitHub

  Scenario: Validate GitHub page title
    When I navigate to http://www.github.com
    Then I verify the page title contains GitHub