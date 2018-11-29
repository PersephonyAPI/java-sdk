Feature: CreateCallRequest

	Scenario: The CreateCallRequest constructor works correctly.
	Given a CreateCallRequest without options.
	Then check that it set all fields correctly.
	Then check that it can produce JSON from the base object.

	Scenario: The CreateCallRequest constructor should be able to accept application Ids and CallOptions.
	Given a CreateCallRequest with options.
	Then check that it set all fields correctly.


