Feature: ParticipantsSearchFilters

  Scenario: Create a ParticipantsSearchFilters object
    Given an empty ParticipantsSearchFilters object
    Then check that all fields in ParticipantsSearchFilters are null

  Scenario: Set/Get the talk field
    Given an empty ParticipantsSearchFilters object
    Then set the ParticipantsSearchFilters talk field to false
    Then check that the ParticipantsSearchFilters talk field is false

  Scenario: Set/Get the listen field
    Given an empty ParticipantsSearchFilters object
    Then set the ParticipantsSearchFilters listen field to false
    Then check that the ParticipantsSearchFilters listen field is false
