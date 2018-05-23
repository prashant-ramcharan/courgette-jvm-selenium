@regression
Feature: NavigateToStackOverflow

  Scenario: Validate StackOverflow page title
    When I navigate to http://www.stackoverflow.com
    Then I verify the page title contains Stack Overflow - Where Developers Learn