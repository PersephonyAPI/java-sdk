Feature: Recording 

	Scenario: Create a recording from JSON
	Given Some JSON representing a recording.
	Then build a Recording object from that JSON.
	Then check that it can be checked for equality
