Feature: Add random post to favorites
  Background:
    Given Url https://avito.ru is opened

  Scenario:
    When I fill the search bar
    And I click Submit button
    And I add random post to favorites
    Then Heart icon of the post becomes red