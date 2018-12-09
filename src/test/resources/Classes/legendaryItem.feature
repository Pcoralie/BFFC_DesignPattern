Feature: Legendary Item
# Sulfuras is a legendary item, never has to be sold or decreases in Quality

  Scenario: legendary item update
    Given I have a new inventoryC
    Then the quality of the legendary item is initialized as 80
    When I update the inventoryC
    Then the quality of the legendary item is 80