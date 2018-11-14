Feature: RecordUtterance

	Scenario: Create a default RecordUtterance
		Given a RecordUtterance with actionUrl http://actionUrl.loc/aActionUrl.wav
		Then check that actionUrl is http://actionUrl.loc/aActionUrl.wav in the RecordUtterance object

	Scenario: Setting and checking RecordUtterance fields
		Given a RecordUtterance with actionUrl http://actionUrl.loc/aActionUrl.wav
		Then set actionUrl to http://actionUrl.loc/aDifferentActionUrl.wav in the RecordUtterance object
		Then check that actionUrl is http://actionUrl.loc/aDifferentActionUrl.wav in the RecordUtterance object
		Then set silenceTimeoutMs to 3300 in the RecordUtterance object
		Then check that silenceTimeoutMs is 3300 in the RecordUtterance object
		Then set finishOnKey to 9 in the RecordUtterance object
		Then check that finishOnKey is 9 in the RecordUtterance object
		Then set maxLengthSec to 10 in the RecordUtterance object
		Then check that maxLengthSec is 10 in the RecordUtterance object
		Then set playBeep to true in the RecordUtterance object
		Then check that playBeep is true in the RecordUtterance object
		Then set autoStart to false in the RecordUtterance object
		Then check that autoStart is false in the RecordUtterance object
