Feature : Backstage Item
# a backstage passes item quality ...

  Scenario : backstage item update
    Given I have a new inventory
    Then the quality of the backstage item is initialized as 6
    When I update the inventory
    Then the quality of the backstage item is 4