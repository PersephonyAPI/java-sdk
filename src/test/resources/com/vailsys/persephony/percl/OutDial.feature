Feature: OutDial

	Scenario: Create a default OutDial
		Given an OutDial with destination +17085551234, callingNumber +15551235512, actionUrl http://persephony.com/action, and callConnectUrl http://persephony.com/callConnect 
		Then check that the non-default fields are null in the OutDial object
		Then check that destination is +17085551234 in the OutDial object
		Then check that callingNumber is +15551235512 in the OutDial object
		Then check that actionUrl is http://persephony.com/action in the OutDial object
		Then check that callConnectUrl is http://persephony.com/callConnect in the OutDial object

	Scenario: Setting and checking OutDial fields
		Given an OutDial with destination +17085551234, callingNumber +15551235512, actionUrl http://persephony.com/action, and callConnectUrl http://persephony.com/callConnect 

		Then set destination to +17085551235 in OutDial object
		Then check that destination is +17085551235 in the OutDial object

		Then set callingNumber to +14445556667 in OutDial object
		Then check that callingNumber is +14445556667 in the OutDial object

		Then set actionUrl to http://persephony.com/v2/action in OutDial object
		Then check that actionUrl is http://persephony.com/v2/action in the OutDial object
		
		Then set callConnectUrl to http://persephony.com/v2/callConnect in OutDial object
		Then check that callConnectUrl is http://persephony.com/v2/callConnect in the OutDial object
		
		Then set sendDigits to 36#47 in OutDial object
		Then check that sendDigits is 36#47 in the OutDial object
		
		Then set timeout to 459 in OutDial object
		Then check that timeout is 459 in the OutDial object
		
		Then set ifMachine to redirect in OutDial object
		Then check that ifMachine is redirect in the OutDial object

		Then set ifMachine to hangup in OutDial object
		Then check that ifMachine is hangup in the OutDial object
		
		Then set ifMachineUrl to http://persephony.com/ifMachine in OutDial object
		Then check that ifMachineUrl is http://persephony.com/ifMachine in the OutDial object
		
		Then set statusCallbackUrl to http://persephony.com/statusCallback in OutDial object
		Then check that statusCallbackUrl is http://persephony.com/statusCallback in the OutDial object
		
