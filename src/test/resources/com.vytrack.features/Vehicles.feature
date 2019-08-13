Feature: Vehicles

  Background:
    Given I login as a "sales manager"
    When I go to "Fleet" "Vehicles"

  Scenario: Verify default order
    When I click on header "LICENSE PLATE"
    Then All records are displayed by "LICENSE PLATE" in "ascending" order
    When I click on header "LICENSE PLATE"
    Then All records are displayed by "LICENSE PLATE" in "descending" order

  Scenario: Verify that all records that are displayed can be sorted by DRIVER column
    When I click on header "DRIVER"
    Then All records are displayed by "DRIVER" in "ascending" order
    When I click on header "DRIVER"
    Then All records are displayed by "DRIVER" in "descending" order

  Scenario: Select All checkbox
    Then None of the checkboxes are selected
    When I click on the checkbox in the headers row
    Then All of the checkboxes are selected

