Feature: ApplicationsSearchFilters

  Scenario: Create an ApplicationsSearchFilters object
    Given an empty ApplicationsSearchFilters object
    Then check that all fields in ApplicationsSearchFilters are null

    Scenario: Set/get the alias field
      Given an empty ApplicationsSearchFilters object
      Then set the ApplicationsSearchFilters alias field to test alias
      Then check that the ApplicationsSearchFilters alias field is test alias