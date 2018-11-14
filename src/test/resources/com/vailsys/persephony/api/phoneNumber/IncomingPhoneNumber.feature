Feature: Incoming Phone Number

  Scenario: Create an IncomingPhoneNumber from JSON
    Given some JSON representing an incoming phone number
    Then build an IncomingPhoneNumber object from that JSON
    Then check the contents of the IncomingPhoneNumber

    Scenario: Compare incoming phone number for equality
      Given some JSON representing an incoming phone number
      Then build an IncomingPhoneNumber object from that JSON
      Then compare the IncomingPhoneNumber to equal and unequal objects