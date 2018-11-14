## Introduction
The Persephony Java SDK will allow you to easily use the Persephony API in a Java application.

[![Release](https://jitpack.io/v/PersephonyAPI/java-sdk.svg)](https://jitpack.io/#PersephonyAPI/java-sdk)

### SDK Installation

To include the SDK in your build, follow the instructions on [Jitpack](https://jitpack.io/#PersephonyAPI/java-sdk)

## Testing your Installation

Test the SDK is working by sending yourself a phone call.

```java
public class Example {

    public static final String accountId = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    public static final String authToken = "your_auth_token";
    public static final String To = "your_phone_number";
    public static final String From = "a_persephony_phone_number_in_your_account";

    public static void main(String[] args) throws PersyException {
        PersyClient client = new PersyClient(accountId, authToken);

        client.calls.create(To, From, "https://www.persephony.com/testApp/voice", (String)null);
    }
}
```

When you run this code you should get a phone call. On answering the call, you should hear a short message ("Thanks for using Persephony!"). This indicates that you've successfully setup your SDK.

`https://www.persephony.com/testApp/voice` contains a small Persephony application that also uses the Persephony Java SDK. When a request is made to its `/voice` endpoint, it will respond with the following PerCL script, which produces the message you heard.

```json
[{"Say": {"text": "Thanks for using Persephony!"}}]
```

### Running Unit Tests

You can run `gradle test` to run the full test suite.

You can also specify cucumber tags with the usual boolean inclusion / exclusion, specific feature files, or the line of the scenario or scenario outline example to run.

```bash
gradle -Dcucumber.options=src/test/resources/com/vailsys/persephony/api/call/Call.feature:5 test
```

```bash
gradle -Dcucumber.options="--tags @Calls" test
```

## Documentation

The [Persephony documentation](https://www.persephony.com/docs) has guides on [getting started](https://www.persephony.com/docs/getting-started/) with Persephony, as well as the [API reference](https://www.persephony.com/docs/api/), [PerCL reference](https://www.persephony.com/docs/percl/), and several useful [tutorials.](https://www.persephony.com/docs/tutorials/).

## Getting Help

If you are experiencing difficulties, contact our support team at [support@persephony.com](mailto:support@persephony.com).

## Dependencies
This SDK targets Java 7.

Import these dependencies:
  
- com.google.code.gson:gson:2.6.2