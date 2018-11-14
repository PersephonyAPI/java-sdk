Feature: AddToConference

  Scenario: Create a AddToConference
    Given an AddToConference command with conferenceId CF024417978995574707a0774874c053e3 and callId CA024417978995574707a0774874c053e3
    Then check that conferenceId equals CF024417978995574707a0774874c053e3 in AddToConference object
    Then check that callId equals CA024417978995574707a0774874c053e3 in AddToConference object
    Then check all optional fields in AddToConference are null

  Scenario: Create a non-empty AddToConference
    Given an AddToConference command with conferenceId CF024417978995574707a0774874c053e3 and callId CA024417978995574707a0774874c053e3
    Then set AddToConference conferenceId to CF123456789995574707a0774874c053e3
    Then check that conferenceId equals CF123456789995574707a0774874c053e3 in AddToConference object
    Then set AddToConference callId to CA123456789995574707a0774874c053e3
    Then check that callId equals CA123456789995574707a0774874c053e3 in AddToConference object
    Then set AddToConference optional properties
    Then check AddToConference optional properties