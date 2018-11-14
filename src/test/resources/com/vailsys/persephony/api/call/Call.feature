Feature: Call

	Scenario: Create a call from JSON
	Given Some JSON representing a call.
	Then build a Call object from that JSON.
	Then check the contents of that object.
