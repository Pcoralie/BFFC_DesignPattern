# new feature
# Tags: optional

Feature: JSON File

  Scenario: Load JSON File
    #Given I choose a json file
    Given I have an empty Inventory
    #Then The piechart is empty
    When the user click on the load file button
    Then items are add to the inventory
   # Then the piechart is updated