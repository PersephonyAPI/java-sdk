Feature: TerminateConference

  Scenario: Create a TerminateConference
    Given a TerminateConference with conferenceId CF024417978995574707a0774874c053e3
    Then check that the conferenceId of the TerminateConference is CF024417978995574707a0774874c053e3

  Scenario: Set conferenceId
    Given a TerminateConference with conferenceId CF024417978995574707a0774874c053e3
    Then set the conferenceId of the TerminateConference to CF1234567890
    Then check that the conferenceId of the TerminateConference is CF1234567890