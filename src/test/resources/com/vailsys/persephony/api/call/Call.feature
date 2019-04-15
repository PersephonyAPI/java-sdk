Feature: Call

	Scenario: Create a call from JSON
	Given Some JSON representing a call.
	Then build a Call object from that JSON.
	Then check the contents of that object.

	Scenario: Check the Call equals method
		Given Some JSON representing a call.
		Then build a Call object from that JSON.
		Then check the call is equal.
		Then check the call is not equal.
