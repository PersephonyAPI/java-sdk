Feature: CallOptions

	Scenario: The CallOptions constructor should ensure all the fields are null.
	Given An empty CallOptions object.
	Then check that all fields are null.

	Scenario: The CallOptions getters and setters should work.
	Given An empty CallOptions object.
	Then check that setSendDigits() and getSendDigits() are setting and retrieving the correct value.
	Then check that setIfMachine() and getIfMachine() are setting and retrieving the correct value.
	Then check that setTimeout() and getTimeout() are setting and retrieving the correct value.
	Then check that setParentCallId() and getParentCallId() are setting and retrieving the correct value.
