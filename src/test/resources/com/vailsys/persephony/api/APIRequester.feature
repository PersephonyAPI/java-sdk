@Mockserver
Feature: APIRequester

	Scenario: Need to make an APIRequester
		Given an accountId of AC1234567890123456789012345678901234567890 and an authToken of 12eba896a69876c87697e9876d0f987123456a67 to make a default APIRequester
		Then stored in the APIRequester should be the accountId AC1234567890123456789012345678901234567890 and the authToken 12eba896a69876c87697e9876d0f987123456a67

	Scenario: Need to make a test APIRequester
		Given an accountId of AC1234567890123456789012345678901234567890 and an authToken of 12eba896a69876c87697e9876d0f987123456a67 to make a test APIRequester
		Then stored in the test APIRequester should be the accountId AC1234567890123456789012345678901234567890 and the authToken 12eba896a69876c87697e9876d0f987123456a67

	Scenario: Need change the persyUrl of an APIRequester
		Given an accountId of AC1234567890123456789012345678901234567890 and an authToken of 12eba896a69876c87697e9876d0f987123456a67 to make a default APIRequester
		Then change the persyUrl to http://localhost:16000

	Scenario: Need to make an HTTP GET request to Persephony API
		Given an accountId of AC1234567890123456789012345678901234567890 and an authToken of 12eba896a69876c87697e9876d0f987123456a67 to make a test APIRequester
		Then make a successful GET request to the API
		Then make a successful GET request to the API without a query string
		Then make an unsuccessful GET request to the API

	Scenario: Need to make an HTTP POST request to Persephony API
		Given an accountId of AC1234567890123456789012345678901234567890 and an authToken of 12eba896a69876c87697e9876d0f987123456a67 to make a test APIRequester
		Then make a successful POST request to the API
		Then make an unsuccessful POST request to the API

	Scenario: Need to make an HTTP POST request to Persephony API with an empty payload
		Given an accountId of AC1234567890123456789012345678901234567890 and an authToken of 12eba896a69876c87697e9876d0f987123456a67 to make a test APIRequester
		Then make a successful POST request to the API with an empty payload
		Then make an unsuccessful POST request to the API with an empty payload


	Scenario: Need to make an HTTP DELETE request to Persephony API
		Given an accountId of AC1234567890123456789012345678901234567890 and an authToken of 12eba896a69876c87697e9876d0f987123456a67 to make a test APIRequester
		Then make a successful DELETE request to the API
		Then make an unsuccessful DELETE request to the API
