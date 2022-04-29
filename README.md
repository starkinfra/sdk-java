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
  - [Credit Note](#credit-note)
    - [CreditNote](#create-creditnotes): Create credit notes
  - [Pix](#pix)
    - [PixRequests](#create-pix-requests): Create Pix transactions
    - [PixReversals](#create-pix-reversals): Reverse Pix transactions
    - [PixBalance](#get-pix-balance): View your account balance
    - [PixStatement](#create-a-pix-statement): Request your account statement
    - [PixKey](#create-a-pix-key): Create a Pix Key
    - [PixClaim](#create-a-pix-claim): Claim a Pix Key
    - [InfractionReport](#create-an-infraction-report): Create a Pix Key
    - [ReversalRequest](#create-a-reversal-request): Claim a Pix Key
  - [Webhook Events](#webhook-events):
    - [WebhookEvents](#process-webhook-events): Manage Webhook events
    - [WebhookEventAttempts](#query-failed-webhook-event-delivery-attempts-information): Query failed webhook event deliveries
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
  pick up from where you left off whenever it is convenient. When there are no more elements to be retrieved, the returned cursor will be `null`.

```java
import com.starkinfra.*;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 50);
params.put("cursor", null);

while (true) {
    PixRequest.Page page = PixRequest.page(params);
    for (PixRequest request: page.request) {
        System.out.println(request);
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

## Pix

### Create pix requests
You can create a Pix request to charge a user:

```java
import com.starkinfra.*;
import com.starkinfra.utils.*;
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
data.put("receiverBankCode", "20018183");
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

### Query pix requests

You can query multiple pix requests according to filters.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 10);
params.put("after", "2020-04-01");
params.put("before", "2020-04-30");
params.put("status", new String[] {"success", "failed"});
params.put("tags", new String[] {"iron", "suit"});
params.put("endToEndIds", new String[] {"E79457883202101262140HHX553UPqeq", "E79457883202101262140HHX55ghz77r"});
Generator<PixRequest> requests = PixRequest.query(params);

for (PixRequest request : requests){
    System.out.println(request);
}
```

### Get a pix request

After its creation, information on a pix request may be retrieved by its id. Its status indicates whether it has been paid.

```java
import com.starkinfra.*;

PixRequest request = PixRequest.get("5155966664310784");

System.out.println(request);
```

### Process pix request authorization requests

It's easy to process authorization requests that arrived in your handler. Remember to pass the
signature header so the SDK can make sure it's StarkInfra that sent you
the event.

```java
import com.starkinfra.*;

Request request = Listener.listen(); // this is your handler to listen for authorization requests

String content = request.content.toString();
String signature = request.headers.get("Digital-Signature");

PixRequest request = PixRequest.parse(content, signature);

System.out.println(request);
```

### Query pix request logs

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

### Get a pix request log

You can also get a specific log by its id.

```java
import com.starkinfra.*;

PixRequest.Log log = PixRequest.Log.get("6532638269505536");

System.out.println(log);
```

### Create pix reversals

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

### Query pix reversals

You can query multiple pix reversals according to filters.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 10);
params.put("after", "2020-04-01");
params.put("before", "2020-04-30");
params.put("status", new String[] {"success", "failed"});
params.put("tags", new String[] {"iron", "suit"});
params.put("returnIds", new String[] {"D20018183202202030109X3OoBHG74wo", "D20018183202202030109X3OoBHGxc22"});
Generator<PixReversal> reversals = PixReversal.query(params);

for (PixReversal reversal : reversals){
    System.out.println(reversal);
}
```

### Get a pix reversal

After its creation, information on a pix reversal may be retrieved by its id. Its status indicates whether it has been paid.

```java
import com.starkinfra.*;

PixReversal reversal = PixReversal.get("5155966664310784");

System.out.println(reversal);
```

### Process pix reversal authorization requests

It's easy to process authorization requests that arrived in your handler. Remember to pass the
signature header so the SDK can make sure it's StarkInfra that sent you
the event.

```java
import com.starkinfra.*;

Request request = Listener.listen(); // this is your handler to listen for authorization requests

String content = request.content.toString();
String signature = request.headers.get("Digital-Signature");

PixReversal request = PixReversal.parse(content, signature);

System.out.println(request);
```

### Query pix reversal logs

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

### Get a pix reversal log

You can also get a specific log by its id.

```java
import com.starkinfra.*;

PixReversal.Log log = PixReversal.Log.get("6532638269505536");

System.out.println(log);
```

### Get pix balance

To know how much money you have in your workspace, run:

```java
import com.starkinfra.*;

PixBalance balance = PixBalance.Log.get("6532638269505536");

System.out.println(balance);
```

### Create a pix statement

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
PixStatement statemenet = new PixStatement(data);

statement = PixStatement.create(statement);

System.out.println(statement);
```
### Query pix statements

You can query multiple pix statements according to filters.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 10);
params.put("ids", new String[] {"5155966664310784", "4225966664310755"});
Generator<PixStatement> statements = PixStatement.query(params);

for (PixStatement statement : statements){
    System.out.println(statement);
}
```

### Get a pix statement

Statements are only available for direct participants. To get a pix statement by its id:

```java
import com.starkinfra.*;

PixStatement statement = PixStatement.get("5155966664310784");

System.out.println(statement);
```

### Get a pix statement .csv file

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

### Create a pix key

You can create a Pix Key to link bank account information to a key id:

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

HashMap<String, Object> data = new HashMap<>();
data.put("accountCreated", "2022-01-01");
data.put("accountNumber", "000000");
data.put("accountType", "savings");
data.put("branchCode", "000");
data.put("name", "Arya Stark");
data.put("taxId", "012.345.678-90");
data.put("id", "+5541998989898");
PixKey key = new PixKey(data);

key = PixKey.create(key);

System.out.println(key);
```

### Query pix keys

You can query multiple Pix keys according to filters.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 10);
params.put("after", "2022-01-20");
params.put("before", "2022-01-24");
params.put("status", "registered");
params.put("ids", new String[] {"+5541998989898", "+5541999999999"});
Generator<PixKey> keys = PixKey.query(params);

for (PixKey key : keys){
    System.out.println(key);
}
```

### Get a pix key

After its creation, information on a Pix key may be retrieved by its id and the tax id of the consulting agent.

```java
import com.starkinfra.*;

PixKey key = PixKey.get("+5541998989898");

System.out.println(key);
```

### Cancel a Pix key

To cancel a Pix key, run:

```java
import com.starkinfra.*;

PixKey key = PixKey.delete("+5541998989898");

System.out.println(key);
```

### Update a pix key

Update the account information or the holder's name linked to a Pix key.

```java
import com.starkinfra.*;
import java.util.HashMap;

HashMap<String, Object> patchData = new HashMap<>();
patchData.put("reason", "branchTransfer");
patchData.put("name", "Jamie Lannister");
PixKey key = PixKey.update("+5541998989898", patchData);

System.out.println(key);
```

### Query pix key logs

You can query Pix key logs to better understand Pix key life cycles.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 10);
params.put("after", "2020-04-01");
params.put("before", "2020-04-30");
Generator<PixKey.Log> logs = PixKey.Log.query(params);

for (PixKey.Log log : logs){
    System.out.println(log);
}
```

### Get a pix key log

You can also get a specific log by its id.

```java
import com.starkinfra.*;

PixKey.Log log = PixKey.Log.get("6532638269505536");

System.out.println(log);
```

### Create a pix claim

You can create a Pix claim to request the transfer of a Pix key to another account:

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

HashMap<String, Object> data = new HashMap<>();
data.put("accountCreated", "2022-01-01");
data.put("accountNumber", "000000");
data.put("accountType", "savings");
data.put("branchCode", "000");
data.put("name", "Arya Stark");
data.put("taxId", "012.345.678-90");
data.put("keyId", "+5511989898989");
PixClaim claim = new PixClaim(data);

PixClaim claim = PixClaim.create(claim);

System.out.println(claim);
```

### Query pix claims

You can query multiple Pix claims according to filters.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 10);
params.put("after", "2022-01-20");
params.put("before", "2022-01-24");
params.put("status", "registered");
params.put("keyId", "+5541998989898");
Generator<PixClaim> claims = PixClaim.query(params);

for (PixClaim claim : claims){
    System.out.println(claim);
}
```

### Get a pix claim

After its creation, information on a Pix claim may be retrieved by its id:

```java
import com.starkinfra.*;

PixClaim claim = PixClaim.get("5155165527080960");

System.out.println(claim);
```

### Update a pix claim

A Pix Claim can be patched for two distinct reasons. A received Pix Claim can be confirmed or canceled by patching
its status. A received Pix Claim must be confirmed by the donor to be completed. Ownership Pix Claims can only be
canceled by the donor if the reason is fraud. A sent Pix Claim can also be canceled by patching its status.

```java
import com.starkinfra.*;
import java.util.HashMap;

HashMap<String, Object> patchData = new HashMap<>();
patchData.put("status", "confirmed");
PixClaim claim = PixClaim.update("5155165527080960", patchData);

System.out.println(claim);
```

### Query pix claim logs

You can query Pix claim logs to better understand Pix claim life cycles.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 10);
params.put("after", "2020-04-01");
params.put("before", "2020-04-30");
Generator<PixClaim.Log> logs = PixClaim.Log.query(params);

for (PixClaim.Log log : logs){
    System.out.println(log);
}
```

### Get a pix claim log

You can also get a specific log by its id.

```java
import com.starkinfra.*;

PixClaim.Log log = PixClaim.Log.get("6532638269505536");

System.out.println(log);
```

### Create an infraction report

Infraction reports are used to report transactions that are suspected of fraud, to request a refund or to
reverse a refund. Infraction reports can be created by either participant of a transaction.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

HashMap<String, Object> data = new HashMap<>();
data.put("referenceId", "E20018183202201201450u34sDGd19lz");
data.put("type", "fraud");
InfractionReport report = new InfractionReport(data);

report = InfractionReport.create(report);

System.out.println(report);
```

### Query infraction reports

You can query multiple infraction reports according to filters.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 10);
params.put("after", "2022-01-20");
params.put("before", "2022-01-24");
params.put("status", "delivered");
params.put("ids", new String[] {"5155165527080960", "4023146587080960"});
Generator<InfractionReport> reports = InfractionReport.query(params);

for (InfractionReport report : reports){
    System.out.println(report);
}
```

### Get an infraction report

After its creation, information on an infraction report may be retrieved by its id.

```java
import com.starkinfra.*;

InfractionReport report = InfractionReport.get("5155165527080960");

System.out.println(report);
```

### Cancel an infraction report

To cancel an infraction report, run:

```java
import com.starkinfra.*;

InfractionReport report = InfractionReport.delete("5155165527080960");

System.out.println(report);
```

### Update an infraction report

A received Infraction Report can be confirmed or declined by patching its status. After an Infraction Report
is Patched, its status changes to closed.

```java
import com.starkinfra.*;
import java.util.HashMap;

HashMap<String, Object> patchData = new HashMap<>();
patchData.put("result", "agreed");
InfractionReport report = InfractionReport.update("5155165527080960", patchData);

System.out.println(report);
```

### Query infraction report logs

You can query infraction report logs to better understand infraction report's life cycles.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 10);
params.put("after", "2020-04-01");
params.put("before", "2020-04-30");
Generator<InfractionReport.Log> logs = InfractionReport.Log.query(params);

for (InfractionReport.Log log : logs){
    System.out.println(log);
}
```

### Get an infraction report log

You can also get a specific log by its id.

```java
import com.starkinfra.*;

InfractionReport.Log log = InfractionReport.Log.get("6532638269505536");

System.out.println(log);
```

### Create a reversal request

A reversal request can be created when fraud is detected on a transaction or a system malfunction
results in an erroneous transaction.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

HashMap<String, Object> data = new HashMap<>();
data.put("amount", 1000);
data.put("referenceId", "E20018183202201201450u34sDGd19lz");
data.put("reason", "fraud");
ReversalRequest request = new ReversalRequest(data);

request = ReversalRequest.create(request);

System.out.println(request);
```

### Query reversal requests

You can query multiple reversal requests according to filters.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 10);
params.put("after", "2022-01-20");
params.put("before", "2022-01-24");
params.put("status", "delivered");
params.put("ids", new String[] {"5155165527080960", "4023146587080960"});
Generator<ReversalRequest> requests = ReversalRequest.query(params);

for (ReversalRequest request : requests){
    System.out.println(request);
}
```

### Get a reversal request

After its creation, information on a reversal request may be retrieved by its id.

```java
import com.starkinfra.*;

ReversalRequest request = ReversalRequest.get("5155165527080960");

System.out.println(request);
```

### Cancel a reversal request

To cancel a reversal request, run:

```java
import com.starkinfra.*;

ReversalRequest request = ReversalRequest.delete("5155165527080960");

System.out.println(request);
```

### Update a reversal request

A received Reversal Request can be confirmed or declined by patching its status. After a Reversal Request
is Patched, its status changes to closed.

```java
import com.starkinfra.*;
import com.starkinfra.utils.*;
import java.util.HashMap;

HashMap<String, Object> patchData = new HashMap<>();
patchData.put("result", "accepted");
patchData.put("reversalReferenceId", ReturnId.create("20018183"));
ReversalRequest request = ReversalRequest.update("5155165527080960", patchData);

System.out.println(request);
```

### Query reversal request logs

You can query reversal request logs to better understand reversal request life cycles.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 10);
params.put("after", "2020-04-01");
params.put("before", "2020-04-30");
Generator<ReversalRequest.Log> logs = ReversalRequest.Log.query(params);

for (ReversalRequest.Log log : logs){
    System.out.println(log);
}
```

### Get a reversal request log

You can also get a specific log by its id.

```java
import com.starkinfra.*;

ReversalRequest.Log log = ReversalRequest.Log.get("6532638269505536");

System.out.println(log);
```

## Credit Note

### Create CreditNotes
You can create a Credit Note to generate a CCB contract:

```java
import com.starkinfra.CreditNote;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

List<CreditNote> creditNotes = new ArrayList<>();
HashMap<String, Object> data = new HashMap<>();
data.put("templateId", "01234567890");
data.put("name", "Jamie Lannister");
data.put("taxId", "20.018.183/0001-80");
data.put("nominalAmount", 9000);
data.put("scheduled", "2022-4-29");

data.put("invoices", Collections.singletonList(
    new HashMap<String, Object>() {{
        put("amount", 5500);
        put("name", "Jamie Lannister");
        put("taxId", "20.018.183/0001-80");
        put("fine", 2.0);
        put("interest", 1.0);

    new HashMap<String, Object>() {{
        put("amount", 4399);
        put("name", "Jamie Lannister");
        put("taxId", "20.018.183/0001-80");
        put("fine", 2.0);
        put("interest", 1.0);
    }};
    }}
));

data.put("transfer", new HashMap<String, Object>(){{
    put("amount", 8831);
    put("bankCode", "00000000");
    put("branchCode", "1234");
    put("accountNumber", "129340-1");
    put("taxId", "012.345.678-90");
    put("name", "Jamie Lannister");
}});

data.put("signers", Collections.singletonList(
    new HashMap<String, Object>() {{
        put("name", "Jamie Lannister");
        put("contact", "joe.limals.14@gmail.com");
        put("method","link");
        }}
    ));

data.put("externalId", "my-internal-id-8435356");
data.put("tags", new String[]{"War supply", "Invoice #1234"});
data.put("rebateAmount", 0);

creditNotes.add(new CreditNote(data));
creditNote = CreditNote.create(creditNotes);
 
for(CreditNote creditNote : creditNotes) {
    System.out.println(creditNote);
}
```

**Note**: Instead of using CreditNote objects, you can also pass each element in dictionary format

### Query CreditNotes

You can query multiple credit notes according to filters.

```java
import com.starkinfra.CreditNote;
import com.starkinfra.utils.Generator;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 3);
params.put("status", "success");
params.put("after", "2019-04-01");
params.put("before", "2030-04-30");
Generator<CreditNote> creditNotes = CreditNote.query(params);

for (CreditNote creditNote : creditNotes) {
    System.out.println(creditNote);
}
```

### Get a CreditNote

After its creation, information on a credit note may be retrieved by its id.

```java
import com.starkinfra.CreditNote;

CreditNote creditNote = CreditNote.get("5155165527080960");

System.out.println(creditNote);
```

## Cancel a CreditNote

You can cancel a credit note if it has not been signed yet.

```java
import com.starkinfra.CreditNote;

CreditNote creditNote = CreditNote.delete("5155165527080960");

System.out.println(creditNote);
```

### Query CreditNote logs

You can query credit note logs to better understand credit note life cycles.

```java
import com.starkinfra.CreditNote;
import com.starkinfra.utils.Generator;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 3);
params.put("after", "2019-04-01");
params.put("before", "2030-04-30");
Generator<CreditNote.Log> logs = CreditNote.Log.query(params);

for (CreditNote.Log log : logs) {
    System.out.println(log);
}
```

### Get a CreditNote log

You can also get a specific log by its id.

```java
import com.starkinfra.CreditNote;

CreditNote.Log log = CreditNote.Log.get("5155165527080960");

System.out.println(log);
```

## Webhook events

### Process webhook events

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
else if (event.subscription.contains("pix-key")) {
    PixKey.Log log = ((Event.PixKeyEvent) event).log;
    System.out.println(log.key);
}
else if (event.subscription.contains("pix-claim")) {
    PixClaim.Log log = ((Event.PixClaimEvent) event).log;
    System.out.println(log.claim);
}
else if (event.subscription.contains("infraction-report")) {
    InfractionReport.Log log = ((Event.InfractionReportEvent) event).log;
    System.out.println(log.report);
}
else if (event.subscription.contains("reversal-request")) {
    ReversalRequest.Log log = ((Event.ReversalRequestEvent) event).log;
    System.out.println(log.request);
}
```

### Query webhook events

To search for webhooks events, run:

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("isDelivered", false);
params.put("after", "2020-04-01");
params.put("before", "2020-04-30");
Generator<Event> events = Event.query(params);

for (Event event : events){
    System.out.println(event);
}
```

### Get a webhook event

You can get a specific webhook event by its id.

```java
import com.starkinfra.*;

Event event = Event.get("5730174175805440");

System.out.println(event);
```

### Delete a webhook event

You can also delete a specific webhook event by its id.

```java
import com.starkinfra.*;

Event event = Event.delete("6312789471657984");

System.out.println(event);
```

### Set webhook events as delivered

This can be used in case you've lost events.
With this function, you can manually set events retrieved from the API as
"delivered" to help future event queries with `isDelivered=false`.

```java
import com.starkinfra.*;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("isDelivered", true);
Event event = Event.update("5824181711142912", params);

System.out.println(event);
```

### Query failed webhook event delivery attempts information

You can also get information on failed webhook event delivery attempts.

```java
import com.starkinfra.*;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("after", "2020-03-20");
Generator<Event.Attempt> attempts = Event.Attempt.query(params);

for (Event.Attempt attempt: attempts) {
    System.out.println(attempt);
}
```

### Get a failed webhook event delivery attempt information

To retrieve information on a single attempt, use the following function:

```java
import com.starkinfra.*;

Event.Attempt attempt = Event.Attempt.get("1616161616161616");

System.out.println(attempt);
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
