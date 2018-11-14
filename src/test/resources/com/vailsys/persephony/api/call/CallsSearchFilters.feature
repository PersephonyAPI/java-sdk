Feature: CallsSearchFilters

	Scenario: Create a CallsSearchFilters object
		Given an empty CallsSearchFilters object
		Then check that all fields are null

	Scenario: Can accept (start|end)Times in Date form
		Given an empty CallsSearchFilters object
		Then store the current time in a Date object
		Then insert the saved Date into the startTime and endTime fucntions as a Date
		Then check that the saved startTime and endTime are the saved Date truncated to seconds

	Scenario: Can accept (start|end)Times in unix timestamp form
		Given an empty CallsSearchFilters object
		Then store the current time in a Date object
		Then insert the saved Date into the startTime and endTime fucntions as a Long representing the the unix timestamp in seconds
		Then check that the saved startTime and endTime are the saved Date truncated to seconds

	Scenario: Can set to number
		Given an empty CallsSearchFilters object
		Then set the to number to +13125551234
		Then check that the to number is +13125551234

	Scenario: Can set from number
		Given an empty CallsSearchFilters object
		Then set the from number to +13125554321
		Then check that the from number is +13125554321

	Scenario: Can set status
		Given an empty CallsSearchFilters object
		Then set the status to inProgress
		Then check that the status is inProgress

	Scenario: Can set parentCallId
		Given an empty CallsSearchFilters object
		Then set the parentCallId to CA1234567890123456789012345678901234abcdef
		Then check that the parentCallId is CA1234567890123456789012345678901234abcdef

	Scenario: Can be converted to a String
		Given an empty CallsSearchFilters object
		Then set the parentCallId to CA1234567890123456789012345678901234abcdef
		Then set the status to inProgress
		Then set the to number to +13125551234
		Then check that the string representation is correct
