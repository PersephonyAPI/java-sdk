Feature: RemoveFromConference

  Scenario: Create a RemoveFromConference
    Given a RemoveFromConference with callId CA024417978995574707a0774874c053e3
    Then check that the callId of the RemoveFromConference is CA024417978995574707a0774874c053e3

  Scenario: Set callId
    Given a RemoveFromConference with callId CA024417978995574707a0774874c053e3
    Then set the callId of the RemoveFromConference to CA1234567890
