Feature: SetListen

  Scenario: Create a SetListen
    Given a SetListen command with the callId CA123456
    Then the callId of the SetListen should be CA123456
    Then check all optional fields in SetListen are null

    Scenario: Set callId and value
      Given a SetListen command with the callId CA123456
      Then set the callId of the SetListen command to CA09876
      Then the callId of the SetListen should be CA09876
      Then set the listen of the SetListen command to true
      Then the listen of the SetListen command should be true