Feature: QueuesSearchFilters

  Scenario: Create a QueuesSearchFilters object
    Given an empty QueuesSearchFilters object
    Then check that all fields in QueuesSearchFilters are null

  Scenario: Set/Get the alias field
    Given an empty QueuesSearchFilters object
    Then set the QueuesSearchFilters alias field to queueAlias
    Then check that the QueuesSearchFilters alias field is queueAlias