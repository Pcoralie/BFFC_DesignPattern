Feature : Dexterity Item
# Dexterity bla bla bla
  Scenario : dexterity item update
    Given I have a new inventory
    Then the quality of the dexterity item is initialized as 80
    When I update the inventory
    Then the quality of the dexterity item is 80