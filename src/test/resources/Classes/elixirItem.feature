Feature: Elixir Item

  Scenario: elixir item update
    Given I have a new inventoryD
    Then the quality of the elixir item is initialized as 7
    When I update the inventoryD
    Then the quality of the elixir item is 6