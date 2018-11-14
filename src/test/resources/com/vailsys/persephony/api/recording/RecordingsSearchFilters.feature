Feature: RecordingsSearchFilters

	Scenario: Create a RecordingsSearchFilters object
		Given an empty RecordingsSearchFilters object
		Then check that all fields in RecordingsSearchFilters are null

	Scenario: Set and get callId
		Given an empty RecordingsSearchFilters object
		Then set the RecordingsSearchFilters callId to CA1234567890123456789012345678901234abcdef
		Then check that the RecordingsSearchFilters callId field is CA1234567890123456789012345678901234abcdef

	Scenario: Set and get dateCreated
		Given an empty RecordingsSearchFilters object
		Then set the RecordingsSearchFilters dateCreated to 2016-08-12 as a String
		Then check that the RecordingsSearchFilters dateCreated field is 2016-08-12
		Then set the RecordingsSearchFilters dateCreated to 2016-08-12 as a Date
		Then check that the RecordingsSearchFilters dateCreated field is 2016-08-12

	Scenario: Can be converted to a String
		Given an empty RecordingsSearchFilters object
		Then set the RecordingsSearchFilters callId to CA1234567890123456789012345678901234abcdef
		Then set the RecordingsSearchFilters dateCreated to 2016-08-12 as a String
		Then check that the string representation of the RecordingsSearchFilters is correct
