Feature: Conference

	Scenario: Create a conference from JSON
	Given Some JSON representing a conference.
	Then build a Conference object from that JSON.
	Then check the contents of that conference.

	Scenario: Check the conference equals method
	Given Some JSON representing a conference.
	Then build a Conference object from that JSON.
	Then check the conference is equal
	Then check the conference is not equal