# new feature
# Tags: optional

Feature: JSON File

  Scenario: Load JSON File
    #Given I choose a json file
    Given I have an empty Inventory
    #Then The piechart is empty
    When the user click on the load file button
    Then items are add to the inventory
    Then there are 12 items in the inventory
    #Then the piechart is updated

  Scenario: User click on update button
    Given I have an inventory
    Then the quality of each items is initialized
    When The user click on button update
    Then the quality of each items is updated
