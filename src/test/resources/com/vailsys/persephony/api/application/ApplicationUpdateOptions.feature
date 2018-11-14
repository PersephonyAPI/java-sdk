Feature: ApplicationUpdateOptions

  Scenario: The ApplicationUpdateOptions constructor should ensure all the fields are null
    Given an empty ApplicationUpdateOptions object
    Then check that all ApplicationUpdateOptions fields are null

    Scenario: The ApplicationUpdateOptions getters and setters should work
      Given an empty ApplicationUpdateOptions object
      Then set alias to appAlias in ApplicationUpdateOptions
      Then check that alias is appAlias in ApplicationUpdateOptions
      Then set voiceUrl to http://voice.url in ApplicationUpdateOptions
      Then check that voiceUrl is http://voice.url in ApplicationUpdateOptions
      Then set voiceFallbackUrl to http://fallback.url in ApplicationUpdateOptions
      Then check that voiceFallbackUrl is http://fallback.url in ApplicationUpdateOptions
      Then set callConnectUrl to http://connect.url in ApplicationUpdateOptions
      Then check that callConnectUrl is http://connect.url in ApplicationUpdateOptions
      Then set statusCallbackUrl to http://callback.url in ApplicationUpdateOptions
      Then check that statusCallbackUrl is http://callback.url in ApplicationUpdateOptions
      Then set smsUrl to http://sms.url in ApplicationUpdateOptions
      Then check that smsUrl is http://sms.url in ApplicationUpdateOptions
      Then set smsFallbackUrl to http://sms-fallback.url in ApplicationUpdateOptions
      Then check that smsFallbackUrl is http://sms-fallback.url in ApplicationUpdateOptions