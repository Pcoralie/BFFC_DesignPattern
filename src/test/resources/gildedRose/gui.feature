# new feature
# Tags: optional

Feature: JSON File

  Scenario: Load JSON File
    Given I have a json file "inventory.json"
    Then the inventory is
    When the user click on the load file button
    Then items are add to the inventory