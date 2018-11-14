Feature: Calling Number Create Options

  Scenario: Create a calling number create options
    Given a CallingNumberCreateOptions object
    Then verify the CallingNumberCreateOptions fields are null

    Scenario: Set / get alias
      Given a CallingNumberCreateOptions object
      Then set the CallingNumberCreateOptions alias to test alias
      Then the CallingNumberCreateOptions alias field should be test alias

    Scenario: Set / get phoneNumber
      Given a CallingNumberCreateOptions object
      Then set the CallingNumberCreateOptions phoneNumber to +19384362723
      Then the CallingNumberCreateOptions phoneNumber field should be +19384362723