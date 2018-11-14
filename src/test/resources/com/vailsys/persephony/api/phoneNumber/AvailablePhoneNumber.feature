Feature: AvailablePhoneNumber

  Scenario: Create an available phone number from JSON
    Given some JSON representing an available phone number
    Then build an availablePhoneNumber object from that JSON
    Then check the contents of the availablePhoneNumber

  Scenario: Compare available phone numbers for equality
    Given some JSON representing an available phone number
    Then build an availablePhoneNumber object from that JSON
    Then compare the availablePhoneNumber to equal and unequal objects