Feature : Backstage Item
# a backstage passes item like aged brie, increases in Quality as it's SellIn value approaches; Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the concert

  Scenario : backstage item update
    Given I have a new inventoryB
    Then the quality of the backstage item is initialized as 6
    When I update the inventoryB
    Then the quality of the backstage item is 4