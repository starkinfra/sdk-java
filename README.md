# Stark Infra Java SDK - Beta

Welcome to the Stark Infra Java SDK! This tool is made for Java
developers who want to easily integrate with our API.
This SDK version is compatible with the Stark Infra API v2.

# Introduction

## Index

- [Introduction](#introduction)
  - [Supported Java versions](#supported-java-versions)
  - [API documentation](#stark-infra-api-documentation)
  - [Versioning](#versioning)
- [Setup](#setup)
  - [Install our SDK](#1-install-our-sdk)
  - [Create your Private and Public Keys](#2-create-your-private-and-public-keys)
  - [Register your user credentials](#3-register-your-user-credentials)
  - [Setting up the user](#4-setting-up-the-user)
  - [Setting up the error language](#5-setting-up-the-error-language)
- [Resource listing and manual pagination](#resource-listing-and-manual-pagination)
- [Testing in Sandbox](#testing-in-sandbox)
- [Usage](#usage)
  - [PixRequests](#create-pix-requests): PIX receivables
  - [PixReversals](#create-pix-reversals): Reverse PIX transactions
  - [PixBalance](#get-pix-balance): Account balance
  - [PixStatement](#create-pix-statement): Account statement entry
  - [WebhookEvents](#process-webhook-events): Manage webhook events
- [Handling errors](#handling-errors)
- [Help and Feedback](#help-and-feedback)

## Supported Java Versions

This library supports the following Java versions:

* Java 8+

If you have specific version demands for your projects, feel free to contact us.

## Stark Infra API documentation

Feel free to take a look at our [API docs](https://www.starkinfra.com/docs/api).

## Versioning

This project adheres to the following versioning pattern:

Given a version number MAJOR.MINOR.PATCH, increment:

- MAJOR version when the **API** version is incremented. This may include backwards incompatible changes;
- MINOR version when **breaking changes** are introduced OR **new functionalities** are added in a backwards compatible manner;
- PATCH version when backwards compatible bug **fixes** are implemented.

# Setup

## 1. Install our SDK

Manually download the desired SDK version with the JAR found in our
[GitHub page](https://github.com/starkinfra/sdk-java/releases/latest)
and add it to your project.

1.1 If you are using Gradle, add this line to your dependencies in build.gradle:

```sh
dependencies {
  implementation 'com.starkinfra:sdk:0.0.1'
}
```

1.2 If you are using Maven, add this dependency to your pom.xml:

```xml
<dependency>
  <groupId>com.starkinfra</groupId>
  <artifactId>sdk</artifactId>
  <version>0.0.1</version>
</dependency>
```

**Note**: If you are using Android, don't forget to [add the compileOptions to your build.gradle](https://developer.android.com/studio/write/java8-support):

```gradle
compileOptions {
    sourceCompatibility JavaVersion.VERSION_1_8
    targetCompatibility JavaVersion.VERSION_1_8
}
```

## 2. Create your Private and Public Keys

We use ECDSA. That means you need to generate a secp256k1 private
key to sign your requests to our API, and register your public key
with us, so we can validate those requests.

You can use one of the following methods:

2.1. Check out the options in our [tutorial](https://starkbank.com/faq/how-to-create-ecdsa-keys).

2.2. Use our SDK:

```java
import com.starkinfra.*;

Key key = Key.create();

String privatePem = key.privatePem;
String publicPem = key.publicPem;

System.out.print(privatePem);
System.out.print(publicPem);

// or, to also save .pem files in a specific path
Key key = Key.create("file/keys/");

String privatePem = key.privatePem;
String publicPem = key.publicPem;

System.out.print(privatePem);
System.out.print(publicPem);
```

**NOTE**: When you are creating new credentials, it is recommended that you create the
keys inside the infrastructure that will use it, in order to avoid risky internet
transmissions of your **private-key**. Then you can export the **public-key** alone to the
computer where it will be used in the new Project creation.

## 3. Register your user credentials

You can interact directly with our API using two types of users: Projects and Organizations.

- **Projects** are workspace-specific users, that is, they are bound to the workspaces they are created in.
  One workspace can have multiple Projects.
- **Organizations** are general users that control your entire organization.
  They can control all your Workspaces and even create new ones. The Organization is bound to your company's tax ID only.
  Since this user is unique in your entire organization, only one credential can be linked to it.

3.1. To create a Project in Sandbox:

3.1.1. Log into [StarkInfra Sandbox](https://web.sandbox.starkinfra.com)

3.1.2. Go to Menu > Integrations

3.1.3. Click on the "New Project" button

3.1.4. Create a Project: Give it a name and upload the public key you created in section 2

3.1.5. After creating the Project, get its Project ID

3.1.6. Use the Project ID and private key to create the object below:

```java
import com.starkinfra.*;

// Get your private key from an environment variable or an encrypted database.
// This is only an example of a private key content. You should use your own key.
String privateKeyContent = """
-----BEGIN EC PARAMETERS-----
BgUrgQQACg==
-----END EC PARAMETERS-----
-----BEGIN EC PRIVATE KEY-----
MHQCAQEEIMCwW74H6egQkTiz87WDvLNm7fK/cA+ctA2vg/bbHx3woAcGBSuBBAAK
oUQDQgAE0iaeEHEgr3oTbCfh8U2L+r7zoaeOX964xaAnND5jATGpD/tHec6Oe9U1
IF16ZoTVt1FzZ8WkYQ3XomRD4HS13A==
-----END EC PRIVATE KEY-----
""";

Project project = new Project(
    "sandbox",
    "5656565656565656",
    privateKeyContent
);
```

3.2. To create Organization credentials in Sandbox:

3.2.1. Log into [Starkinfra Sandbox](https://web.sandbox.starkinfra.com)

3.2.2. Go to Menu > Integrations

3.2.3. Click on the "Organization public key" button

3.2.4. Upload the public key you created in section 2 (only a legal representative of the organization can upload the public key)

3.2.5. Click on your profile picture and then on the "Organization" menu to get the Organization ID

3.2.6. Use the Organization ID and private key to create the object below:

```java
import com.starinfra.*;

// Get your private key from an environment variable or an encrypted database.
// This is only an example of a private key content. You should use your own key.
String privateKeyContent = """
-----BEGIN EC PARAMETERS-----
BgUrgQQACg==
-----END EC PARAMETERS-----
-----BEGIN EC PRIVATE KEY-----
MHQCAQEEIMCwW74H6egQkTiz87WDvLNm7fK/cA+ctA2vg/bbHx3woAcGBSuBBAAK
oUQDQgAE0iaeEHEgr3oTbCfh8U2L+r7zoaeOX964xaAnND5jATGpD/tHec6Oe9U1
IF16ZoTVt1FzZ8WkYQ3XomRD4HS13A==
-----END EC PRIVATE KEY-----
""";

Organization organization = new Organization(
    "5656565656565656",
    "sandbox",
    privateKeyContent,
    null, // You only need to set the workspaceId when you are operating a specific workspaceId
);

// To dynamically use your organization credentials in a specific workspaceId,
// you can use the Organization.replace() method:
Balance balance = Balance.get(Organization.replace(organization, "4848484848484848"));
System.out.println(balance);
```

NOTE 1: Never hard-code your private key. Get it from an environment variable or an encrypted database.

NOTE 2: We support `'sandbox'` and `'production'` as environments.

NOTE 3: The credentials you registered in `sandbox` do not exist in `production` and vice versa.


## 4. Setting up the user

There are three kinds of users that can access our API: **Organization**, **Project**, and **Member**.

- `Project` and `Organization` are designed for integrations and are the ones meant for our SDKs.
- `Member` is the one you use when you log into our webpage with your e-mail.

There are two ways to inform the user to the SDK:

4.1 Passing the user as an argument in all functions:

```java
import com.starkinfra.*;

Balance balance = Balance.get(project); # or organization
```

4.2 Set it as a default user in the SDK:

```java
import com.starkinfra.*;

Settings.user = project; # or organization

Balance balance = Balance.get();
```

Just select the way of passing the user that is more convenient to you.
On all following examples, we will assume a default user has been set.

## 5. Setting up the error language

The error language can also be set in the same way as the default user:

```java
import com.starkinfra.*;

Settings.language = "en-US";
```

Language options are "en-US" for English and "pt-BR" for Brazilian Portuguese. English is the default.

# Resource listing and manual pagination

Almost all SDK resources provide a `query` and a `page` function.

- The `query` function provides a straightforward way to efficiently iterate through all results that match the filters you inform,
  seamlessly retrieving the next batch of elements from the API only when you reach the end of the current batch.
  If you are not worried about data volume or processing time, this is the way to go.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 200);
Generator<PixRequest> requests = PixRequest.query(params);

for (PixRequest request : requests){
    System.out.println(request);
}
```

- The `page` function gives you full control over the API pagination. With each function call, you receive up to
  100 results and the cursor to retrieve the next batch of elements. This allows you to stop your queries and
  pick up from where you left off whenever it is convenient. When there are no more elements to be retrieved, the returned cursor will be `None`.

```java
import com.starkinfra.*;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 50);
params.put("cursor", null);

while (true) {
    Transaction.Page page = Transaction.page(params);
    for (Transaction transaction: page.transactions) {
        System.out.println(transaction);
    }
    if (page.cursor == null) {
        break;
    }
    params.put("cursor", page.cursor);
}
```

To simplify the following SDK examples, we will only use the `query` function, but feel free to use `page` instead.

# Testing in Sandbox

Your initial balance is zero. For many operations in Stark Infra, you'll need funds
in your account, which can be added to your balance by creating a Pix Request.

In the Sandbox environment, most of the created Pix Requests will be automatically paid,
so there's nothing else you need to do to add funds to your account. Just create
a few Pix Request and wait around a bit.

In Production, you (or one of your clients) will need to actually pay this Pix Request
for the value to be credited to your account.


# Usage

Here are a few examples on how to use the SDK. If you have any doubts, use the built-in
`help()` function to get more info on the desired functionality
(for example: `help(starkinfra.boleto.create)`)

## Create pix requests
You can create a Pix request to charge a user:

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

List<PixRequest> requests = new ArrayList<>();
HashMap<String, Object> data = new HashMap<>();
data.put("amount", 1000);
data.put("externalId", "my-external-id:021243543252345");
data.put("senderAccountNumber", "76543-8");
data.put("senderBranchCode", "2201");
data.put("senderAccountType", "checking");
data.put("senderName", "checking");
data.put("senderTaxId", "594.739.480-42");
data.put("receiverBankCode", "341");
data.put("receiverAccountNumber", "00000-0");
data.put("receiverBranchCode", "0001");
data.put("receiverAccountType", "checking");
data.put("receiverName", "Daenerys Targaryen Stormborn");
data.put("receiverTaxId", "012.345.678-90");
data.put("endToEndId",EndToEndId.create("20018183"));
requests.add(new PixRequest(data));

requests = PixRequest.create(requests);

for (PixRequest request : requests){
    System.out.println(request);
}
```

**Note**: Instead of using Pix Request objects, you can also pass each transaction element in dictionary format

## Query pix requests

You can query multiple pix requests according to filters.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("fields", new String[] {"amount", "senderName"});
params.put("limit", 10);
params.put("after", "2020-04-01");
params.put("before", "2020-04-30");
params.put("status", "success");
params.put("fields", new String[] {"iron", "suit"});
params.put("endToEndId", "E79457883202101262140HHX553UPqeq");
Generator<PixRequest> requests = PixRequest.query(params);

for (PixRequest request : requests){
    System.out.println(request);
}
```

## Get a pix request

After its creation, information on a pix request may be retrieved by its id. Its status indicates whether it has been paid.

```java
import com.starkinfra.*;

PixRequest request = PixRequest.get("5155966664310784");

System.out.println(request);
```

## Process pix request authorization requests

It's easy to process authorization requests that arrived in your handler. Remember to pass the
signature header so the SDK can make sure it's StarkInfra that sent you
the event.

```java
import com.starkinfra.*;

Request request = Listener.listen(); // this is the method you made to get the events posted to your webhook

String content = request.content.toString();
String signature = request.headers.get("Digital-Signature");

PixRequest request = PixRequest.parse(content, signature);

System.out.println(request);
```

## Query pix request logs

You can query pix request logs to better understand pix request life cycles.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 10);
params.put("after", "2020-04-01");
params.put("before", "2020-04-30");
Generator<PixRequest.Log> logs = PixRequest.Log.query(params);

for (PixRequest.Log log : logs){
    System.out.println(log);
}
```

## Get a pix request log

You can also get a specific log by its id.

```java
import com.starkinfra.*;

PixRequest.Log log = PixRequest.Log.get("6532638269505536");

System.out.println(log);
```

## Create pix reversals

You can reverse a pix request by whole or by a fraction of its amount using a pix reversal.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

List<PixReversal> reversals = new ArrayList<>();
HashMap<String, Object> data = new HashMap<>();
data.put("amount", 1000);
data.put("externalId", "my-external-id:17238435823958934");
data.put("endToEndId", "E00000000202201060100rzsJzG9PzMg");
data.put("reason", "fraud");
reversals.add(new PixReversal(data));

reversals = PixReversal.create(reversals);

for (PixReversal reversal : reversals){
    System.out.println(reversal);
}
```

## Query pix reversals

You can query multiple pix reversals according to filters.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("fields", new String[] {"amount", "senderName"});
params.put("limit", 10);
params.put("after", "2020-04-01");
params.put("before", "2020-04-30");
params.put("status", "success");
params.put("fields", new String[] {"iron", "suit"});
params.put("returnId", "D20018183202202030109X3OoBHG74wo");
Generator<PixReversal> reversals = PixReversal.query(params);

for (PixReversal reversal : reversals){
    System.out.println(reversal);
}
```

## Get a pix reversal

After its creation, information on a pix reversal may be retrieved by its id. Its status indicates whether it has been paid.

```java
import com.starkinfra.*;

PixReversal reversal = PixReversal.get("5155966664310784");

System.out.println(reversal);
```

## Process pix reversal authorization reversals

It's easy to process authorization reversals that arrived in your handler. Remember to pass the
signature header so the SDK can make sure it's StarkInfra that sent you
the event.

```java
import com.starkinfra.*;

Reversal reversal = Listener.listen(); // this is the method you made to get the events posted to your webhook

String content = reversal.content.toString();
String signature = reversal.headers.get("Digital-Signature");

PixReversal reversal = PixReversal.parse(content, signature);

System.out.println(reversal);
```

## Query pix reversal logs

You can query pix reversal logs to better understand pix reversal life cycles.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 10);
params.put("after", "2020-04-01");
params.put("before", "2020-04-30");
Generator<PixReversal.Log> logs = PixReversal.Log.query(params);

for (PixReversal.Log log : logs){
    System.out.println(log);
}
```

## Get a pix reversal log

You can also get a specific log by its id.

```java
import com.starkinfra.*;

PixReversal.Log log = PixReversal.Log.get("6532638269505536");

System.out.println(log);
```

## Get pix balance

To know how much money you have in your workspace, run:

```java
import com.starkinfra.*;

PixBalance balance = PixBalance.Log.get("6532638269505536");

System.out.println(balance);
```

## Create pix statement

Statements are only available for direct participants. To create a statement of all the transactions that happened on your workspace during a specific day, run:

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

PixStatement statement;
HashMap<String, Object> data = new HashMap<>();
data.put("after", "2022-01-01");
data.put("before", "2022-01-01");
data.put("type", "transaction");
statement.add(new PixStatement(data));

statement = PixStatement.create(statement);

System.out.println(statement);
```
## Query pix statements

You can query multiple pix statements according to filters.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 10);
params.put("ids", "2020-04-01");
Generator<PixStatement> statements = PixStatement.query(params);

for (PixStatement statement : statements){
    System.out.println(statement);
}
```

## Get a pix statement

Statements are only available for direct participants. To get a pix statement by its id:

```java
import com.starkinfra.*;

PixStatement statement = PixStatement.get("5155966664310784");

System.out.println(statement);
```

## Get a pix statement .csv file

To get a .csv file of a pix statement using its id, run:

```java
import java.io.File;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;
import com.starkinfra.*;

InputStream csv = PixStatement.csv("6266195376340992");

java.nio.file.Files.copy(
    csv,
    new File("statement.zip").toPath(),
    StandardCopyOption.REPLACE_EXISTING
);
```

## Process webhook events

It's easy to process events delivered to your Webhook endpoint. Remember to pass the
signature header so the SDK can make sure it was really StarkInfra that sent you
the event.

```java
import com.starkinfra.*;

Request request = Listener.listen(); // this is the method you made to get the events posted to your webhook

String content = request.content.toString();
String signature = request.headers.get("Digital-Signature");

Event event = Event.parse(content, signature);
if (event.subscription.contains("pix-request")) {
    PixRequest.Log log = ((Event.PixRequestEvent) event).log;
    System.out.println(log.request);
}
else if (event.subscription.contains("pix-reversal")) {
    PixReversal.Log log = ((Event.PixReversalEvent) event).log;
    System.out.println(log.reversal);
}
```

# Handling errors

The SDK may raise one of four types of errors: __InputErrors__, __InternalServerError__, __UnknownError__, __InvalidSignatureError__

__InputErrors__ will be raised whenever the API detects an error in your request (status code 400).
If you catch such an error, you can get its elements to verify each of the
individual errors that were detected in your request by the API.
For example:

```java
import com.starkinfra.*;
import com.starkinfra.error.InputErrors;
import com.starkinfra.error.ErrorElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

List<PixReversal> reversals = new ArrayList<>();
HashMap<String, Object> data = new HashMap<>();
data.put("amount", 1000);
data.put("externalId", "my-external-id:17238435823958934");
data.put("endToEndId", "E00000000202201060100rzsJzG9PzMg");
data.put("reason", "fraud");
reversals.add(new PixReversal(data));

try {
    PixReversal.create(reversals);
} catch (InputErrors e) {
    for (ErrorElement error : e.errors){
        System.out.println(error.code);
        System.out.println(error.message);
    }
}
```

__InternalServerError__ will be raised if the API runs into an internal error.
If you ever stumble upon this one, rest assured that the development team
is already rushing in to fix the mistake and get you back up to speed.

__UnknownError__ will be raised if a request encounters an error that is
neither __InputErrors__ nor an __InternalServerError__, such as connectivity problems.

__InvalidSignatureError__ will be raised specifically by starkinfra.event.parse()
when the provided content and signature do not check out with the Stark Infra public
key.

# Help and Feedback

If you have any questions about our SDK, just send us an email.
We will respond you quickly, pinky promise. We are here to help you integrate with us ASAP.
We also love feedback, so don't be shy about sharing your thoughts with us.

Email: developers@starkbank.com
