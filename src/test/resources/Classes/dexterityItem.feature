Feature: Dexterity Item

  Scenario: dexterity item update
    Given I have a new inventoryE
    Then the quality of the dexterity item is initialized as 20
    When I update the inventoryE
    Then the quality of the dexterity item is 19