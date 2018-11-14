Feature: CreateCallRequest

	Scenario: The CreateCallRequest constructor should be able to accept applicationIds.
	Given an applicationId based CreateCallRequest without options.
	Then check that it set all fields correctly.
	Then check that it can produce JSON from the applicationId based object.

	Scenario: The CreateCallRequest constructor should be able to accept a callConnectUrl and a statusCallbackUrl.
	Given an url based CreateCallRequest without options.
	Then check that it set all fields correctly.

	Scenario: The CreateCallRequest constructor should be able to accept application Ids and CallOptions.
	Given an applicationId based CreateCallRequest with options.
	Then check that it set all fields correctly.

	Scenario: The CreateCallRequest constructor should be able to accept a callConnectUrl and a statusCallbackUrl and CallOptions.
	Given an url based CreateCallRequest with options.
	Then check that it set all fields correctly.
	Then check that it can produce JSON from the url based object with options.


