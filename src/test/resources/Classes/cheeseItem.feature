Feature : Cheese Item
# a aged brie item actually increases in quality the older it gets

  Scenario : cheese item update
    Given I have a new inventoryA
    Then the quality of the cheese item is initialized as 6
    When I update the inventoryA
    Then the quality of the cheese item is 8