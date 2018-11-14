Feature: PersyRequest

	Scenario: Build a PersyRequest object from JSON
		Given Given Some JSON create a PersyRequest
		Then verify the PersyRequest contents
