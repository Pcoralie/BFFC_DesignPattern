Feature : Sulfuras Item
# Sulfuras is a legendary item, never has to be sold or decreases in Quality

  Scenario : sulfuras item update
    Given I have a new inventory
    Then the quality of the sulfuras item is initialized as 80
    When I update the inventory
    Then the quality of the conjured item is 80