Feature: Participant

  Scenario: Create a participant from JSON
    Given Some JSON representing a participant
    When a Participant object is built from that JSON
    Then check the contents of that participant

  Scenario: Check the participant equals method
    Given Some JSON representing a participant
    When a Participant object is built from that JSON
    Then check the participant is equal
    Then check the participant is not equal