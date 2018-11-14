Feature: AvailablePhoneNumberSearchFilters

  Scenario: Create an AvailablePhoneNumberSearchFilters object
    Given an empty AvailablePhoneNumberSearchFilters object
    Then check that all fields in AvailablePhoneNumberSearchFilters are null

  Scenario: Set and get alias
    Given an empty AvailablePhoneNumberSearchFilters object
    Then set the AvailablePhoneNumberSearchFilters alias to (841) 321-8437
    Then check that the AvailablePhoneNumberSearchFilters alias field is (841) 321-8437

  Scenario: Set and get phoneNumber
    Given an empty AvailablePhoneNumberSearchFilters object
    Then set the AvailablePhoneNumberSearchFilters phoneNumber to ^\+1847[0-9]{7}$
    Then check that the AvailablePhoneNumberSearchFilters phoneNumber field is ^\+1847[0-9]{7}$
