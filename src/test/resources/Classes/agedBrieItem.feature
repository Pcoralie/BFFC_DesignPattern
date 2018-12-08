Feature : AgedBrie Item
# a aged brie item actually increases in quality the older it gets

  Scenario : agedBrie item update
    Given I have a new inventory
    Then the quality of the aged brie item is initialized as 6
    When I update the inventory
    Then the quality of the aged brie item is 8