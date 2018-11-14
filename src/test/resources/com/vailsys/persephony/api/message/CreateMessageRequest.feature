Feature: CreateMessageRequest

	Scenario: The CreateMessageRequest constructor should be able to accept MessageOptions.
		Given a CreateMessageRequest with options.
		Then check that it set all CreateMessageRequest fields correctly.
		Then check that it can produce JSON for a create message request from the object with options.

	Scenario: The CreateMessageRequest constructor should be able to accept no MessageOptions.
		Given a CreateMessageRequest without options.
		Then check that it set all CreateMessageRequest fields correctly.
		Then check that it can produce JSON for a create message request from the object without options.


