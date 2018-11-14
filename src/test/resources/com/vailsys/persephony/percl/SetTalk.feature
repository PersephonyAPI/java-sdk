Feature: SetTalk

  Scenario: Create a SetTalk
    Given a SetTalk command with the callId CA123456
    Then the callId of the SetTalk should be CA123456
    Then check all optional fields in SetTalk are null

  Scenario: Set callId and value
    Given a SetTalk command with the callId CA123456
    Then set the callId of the SetTalk command to CA09876
    Then the callId of the SetTalk should be CA09876
    Then set the talk of the SetTalk command to true
    Then the talk of the SetTalk command should be true