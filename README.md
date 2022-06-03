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
  - [Issuing](#issuing)
    - [BINs](#query-issuingbins): View available sub-issuer BINs (a.k.a. card number ranges)
    - [Holders](#create-issuingholders): Manage card holders
    - [Cards](#create-issuingcards): Create virtual and/or physical cards
    - [Purchases](#process-purchase-authorizations): Authorize and view your past purchases
    - [Invoices](#create-issuinginvoices): Add money to your issuing balance
    - [Withdrawals](#create-issuingwithdrawals): Send money back to your Workspace from your issuing balance
    - [Balance](#get-your-issuingbalance): View your issuing balance
    - [Transactions](#query-issuingtransactions): View the transactions that have affected your issuing balance
  - [Pix](#Pix)
    - [PixRequests](#create-pixrequests): Create Pix transactions
    - [PixReversals](#create-pixreversals): Reverse Pix transactions
    - [PixBalance](#get-your-pixbalance): View your account balance
    - [PixStatement](#create-a-pixstatement): Request your account statement
    - [PixKey](#create-a-pixkey): Create a Pix Key
    - [PixClaim](#create-a-pixclaim): Claim a Pix Key
    - [PixDirector](#create-a-pixdirector): Create a Pix Director
    - [PixInfraction](#create-pixinfractions): Create Pix Infraction reports
    - [PixChargeback](#create-pixchargebacks): Create Pix Chargeback requests
    - [PixDomain](#query-pixdomains): View registered SPI participants certificates
  - [Credit Note](#credit-note)
    - [CreditNote](#create-creditnotes): Create credit notes
  - [Webhook](#webhook):
    - [Webhook](#create-a-webhook-subscription): Configure your webhook endpoints and subscriptions
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
  implementation 'com.starkinfra:sdk:0.0.3'
}
```

1.2 If you are using Maven, add this dependency to your pom.xml:

```xml
<dependency>
  <groupId>com.starkinfra</groupId>
  <artifactId>sdk</artifactId>
  <version>0.0.3</version>
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
in your account, which can be added to your balance by creating a starkbank.Invoice.

In the Sandbox environment, most of the created starkbank.Invoices will be automatically paid,
so there's nothing else you need to do to add funds to your account. Just create
a few starkbank.Invoices and wait around a bit.

In Production, you (or one of your clients) will need to actually pay this starkbank.Invoice
for the value to be credited to your account.

# Usage

Here are a few examples on how to use the SDK. If you have any doubts, use the built-in
`help()` function to get more info on the desired functionality
(for example: `help(starkinfra.IssuingInvoice.create)`)

## Issuing

### Query IssuingBins

To take a look at the sub-issuer BINs available to you, just run the following:

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;

Generator<IssuingBin> bins = IssuingBin.query();

for (IssuingBin bin : bins) {
    System.out.println(bin);
}
```

This will tell which card products and card number prefixes you have at your disposal.

### Create IssuingHolders

You can create card holders to which your cards will be bound.
They support spending rules that will apply to all underlying cards.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

List<IssuingHolder> holders = new ArrayList<>();
HashMap<String, Object> data = new HashMap<>();
data.put("name", "Iron Bank S.A.");
data.put("externalId", "1325");
data.put("taxId", "012.345.678-90");
data.put("tags", new String[]{"lannister", "debts"});

HashMap<String, Object> rule = new HashMap<>();
rule.put("name", "General USD");
rule.put("interval", "day");
rule.put("amount", 100000);
rule.put("currencyCode", "USD");
data.put("rules", new IssuingRule[]{new IssuingRule(rule)});

holders.add(new IssuingHolder(data));

holders = IssuingHolder.create(holders);

for (IssuingHolder holder : holders) {
    System.out.println(holder);
}
```

### Query IssuingHolders

You can query multiple holders according to filters.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;

Generator<IssuingHolder> holders = IssuingHolder.query();

for (IssuingHolder holder : holders) {
    System.out.println(holder);
}
```

### Cancel an IssuingHolder

To cancel a single Issuing Holder by its id, run:

```java
import com.starkinfra.*;

IssuingHolder holder = IssuingHolder.cancel("6668150653321216");

System.out.println(holder);
```

### Get an IssuingHolder

To get a single Issuing Holder by its id, run:

```java
import com.starkinfra.*;

IssuingHolder holder = IssuingHolder.get("6668150653321216");

System.out.println(holder);
```

### Query IssuingHolder logs

You can query holder logs to better understand their life cycles.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 3);
Generator<IssuingHolder.Log> logs = IssuingHolder.Log.query(params);

for (IssuingHolder.Log log : logs) {
    System.out.println(log);
}
```

### Get an IssuingHolder log

You can also get a specific log by its id.

```java
import com.starkinfra.*;
        
IssuingHolder.Log log = IssuingHolder.Log.get("6381355445256192");

System.out.println(log);
```

### Create IssuingCards

You can issue cards with specific spending rules.

```java
import com.starkinfra.*;
import com.starkinfra.utils.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

List<IssuingCard> cards = new ArrayList<>();
HashMap<String, Object> data = new HashMap<>();
data.put("holderName", "Developers");
data.put("holderTaxId", "012.345.678-90");
data.put("holderExternalId", "12345");

HashMap<String, Object> rule = new HashMap<>();
rule.put("name", "general");
rule.put("interval", "week");
rule.put("amount", 50000);
rule.put("currencyCode", "USD");
data.put("rules", new IssuingRule[]{new IssuingRule(rule)});

cards.add(new IssuingHolder(data));

cards = IssuingCard.create(cards);

for (IssuingCard card : cards){
    System.out.println(card);
}
```

### Query IssuingCards

You can get a list of created cards given some filters.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import com.starkinfra.utils.Generator;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 3);
Generator<IssuingCard> cards = IssuingCard.query(params);

for (IssuingCard card : cards) {
    System.out.println(card);
}
```

### Get an IssuingCard

After its creation, information on a card may be retrieved by its id.

```java
import com.starkinfra.*;

IssuingCard card = IssuingCard.get("5186529903247360");

System.out.println(card);
```

### Update an IssuingCard

You can update a specific card by its id.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

Map<String, Object> patchData = new HashMap<>();;
patchData.put("status", "blocked");

IssuingCard card = IssuingCard.update("5760854205136896", patchData);

System.out.println(card);
```

### Cancel an IssuingCard

You can also cancel a card by its id.

```java
import com.starkinfra.*;

IssuingCard card = IssuingCard.cancel("5760854205136896");

System.out.println(card);
```

### Query IssuingCard logs

Logs are pretty important to understand the life cycle of a card.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import com.starkinfra.utils.Generator;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 3);
Generator<IssuingCard.Log> logs = IssuingCard.Log.query(params);

for (IssuingCard.Log log : logs) {
    System.out.println(log);
}
```

### Get an IssuingCard log

You can get a single log by its id.

```java
import com.starkinfra.*;

IssuingCard.Log log = IssuingCard.Log.get("5642114708799488");

System.out.println(log);
```

### Process Purchase authorizations

It's easy to process Authorizations delivered to your endpoint.
If you do not approve or decline the authorization within 2 seconds, the authorization will be denied.

```java
import com.starkinfra.*;

Request request = Listener.listen(); // this is the method you made to get the events posted to your webhook

String content = request.content.toString();
String signature = request.headers.get("Digital-Signature");

IssuingAuthorization event = IssuingAuthorization.parse(content, valid_signature);

sendResponse(  // you should also implement this method
    IssuingAuthorization.response(  // this optional method just helps you build the response JSON
        "accepted",
        authorization.amount,
        new String[]{"my-purchase-id/123"}
    );
);

// or 

sendResponse(
    IssuingAuthorization.response(
        "denied",
        "other",
        new String[]{"other-id/456"}
    );
);
```

### Query IssuingPurchases

You can get a list of created purchases given some filters.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 3);
Generator<IssuingPurchase> purchases = IssuingPurchase.query(params);

for (IssuingPurchase purchase : purchases) {
    System.out.println(purchase);
}
```

### Get an IssuingPurchase

After its creation, information on a purchase may be retrieved by its id.

```java
import com.starkinfra.*;

IssuingPurchase purchase = IssuingPurchase.get("5302186862968832");

System.out.println(purchase);
```

### Query IssuingPurchase logs

Logs are pretty important to understand the life cycle of a purchase.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import com.starkinfra.utils.Generator;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 3);
Generator<IssuingPurchase.Log> logs = IssuingPurchase.Log.query(params);

for (IssuingPurchase.Log log : logs) {
    System.out.println(log);
}
```

### Get an IssuingPurchase log

You can get a single log by its id.

```java
import com.starkinfra.*;

IssuingPurchase.Log log = IssuingPurchase.Log.get("5642114708799488");

System.out.println(log);
```

### Create IssuingInvoices

You can create Pix invoices to transfer money from accounts you have in any bank to your Issuing balance,
allowing you to run your issuing operation.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

HashMap<String, Object> data = new HashMap<>();
data.put("amount", 1000);
IssuingInvoice invoice = new IssuingInvoice(data);

invoice = IssuingInvoice.create(invoice);

System.out.println(invoice);
```

**Note**: Instead of using IssuingInvoice objects, you can also pass each element in dictionary format

### Get an IssuingInvoice

After its creation, information on an invoice may be retrieved by its id.
Its status indicates whether it's been paid.

```java
import com.starkinfra.*;

IssuingInvoice invoice = IssuingInvoice.get("5396424728510464");

System.out.println(invoice);
```

### Query IssuingInvoices

You can get a list of created invoices given some filters.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import com.starkinfra.utils.Generator;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 3);
Generator<IssuingInvoice> invoices = IssuingInvoice.query(params);

for (IssuingInvoice invoice : invoices) {
    System.out.println(invoice);
}
```

### Query IssuingInvoice logs

Logs are pretty important to understand the life cycle of an invoice.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import com.starkinfra.utils.Generator;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 3);
Generator<IssuingInvoice.Log> logs = Issuinginvoice.Log.query(params);

for (Issuinginvoice.Log log : logs) {
    System.out.println(log);
}
```

### Create IssuingWithdrawals

You can create withdrawals to send cash back from your Issuing balance to your Banking balance
by using the Withdrawal resource.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

HashMap<String, Object> data = new HashMap<>();
data.put("amount", 1000);
data.put("externalId", "1234");
data.put("description", "Sending back");
IssuingWithdrawal withdrawal = new IssuingWithdrawal(data);

withdrawal = IssuingWithdrawal.create(withdrawal);

System.out.println(withdrawal);
```

**Note**: Instead of using IssuingWithdrawal objects, you can also pass each element in dictionary format

### Get an IssuingWithdrawal

After its creation, information on a withdrawal may be retrieved by its id.

```java
import com.starkinfra.*;

IssuingWithdrawal withdrawal = IssuingWithdrawal.get("5646309415452672");

System.out.println(withdrawal);
```

### Query IssuingWithdrawals

You can get a list of created invoices given some filters.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import com.starkinfra.utils.Generator;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 3);
Generator<IssuingWithdrawal> withdrawals = IssuingWithdrawal.query(params);

for (IssuingWithdrawal withdrawal : withdrawals){
    System.out.println(withdrawal);
}
```

### Get your IssuingBalance

To know how much money you have available to run authorizations, run:

```java
import com.starkinfra.*;

IssuingBalance balance = IssuingBalance.get();

System.out.println(balance);
```

### Query IssuingTransactions

To understand your balance changes (issuing statement), you can query
transactions. Note that our system creates transactions for you when
you make purchases, withdrawals, receive issuing invoice payments, for example.

```java
import com.starkinfra.utils.Generator;
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 3);
params.put("after", "2020-01-01");
params.put("before", "2020-03-01")
Generator<IssuingWithdrawal> transactions = IssuingWithdrawal.query(params);

for (IssuingWithdrawal transaction : transactions) {
    System.out.println(transaction);
}
```

### Get an IssuingTransaction

You can get a specific transaction by its id:

```java
import com.starkbank.*;

IssuingTransaction transaction = IssuingTransaction.get("5396424728510464");

System.out.println(transaction);
```

## Pix

### Create PixRequests

You can create a Pix request to transfer money from one of your users to anyone else:

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

**Note**: Instead of using PixRequest objects, you can also pass each element in dictionary format

### Query PixRequests

You can query multiple Pix requests according to filters.

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

### Get a PixRequest

After its creation, information on a Pix request may be retrieved by its id. Its status indicates whether it has been paid.

```java
import com.starkinfra.*;

PixRequest request = PixRequest.get("5155966664310784");

System.out.println(request);
```

### Process inbound PixRequest authorizations

It's easy to process authorization requests that arrived at your endpoint.
Remember to pass the signature header so the SDK can make sure it's StarkInfra that sent you the event.
If you do not approve or decline the authorization within 1 second, the authorization will be denied.

```java
import com.starkinfra.*;

Request request = Listener.listen(); // this is your handler to listen for authorization requests

String content = request.content.toString();
String signature = request.headers.get("Digital-Signature");

PixRequest request = PixRequest.parse(content, signature);

System.out.println(request);
```

### Query PixRequest logs

You can query Pix request logs to better understand Pix request life cycles.

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

### Get a PixRequest log

You can also get a specific log by its id.

```java
import com.starkinfra.*;

PixRequest.Log log = PixRequest.Log.get("6532638269505536");

System.out.println(log);
```

### Create PixReversals

You can reverse a Pix request by whole or by a fraction of its amount using a Pix reversal.

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

### Query PixReversals

You can query multiple Pix reversals according to filters.

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

### Get a PixReversal

After its creation, information on a Pix reversal may be retrieved by its id. Its status indicates whether it has been paid.

```java
import com.starkinfra.*;

PixReversal reversal = PixReversal.get("5155966664310784");

System.out.println(reversal);
```

### Process inbound PixReversal authorizations

It's easy to process authorization requests that arrived at your endpoint.
Remember to pass the signature header so the SDK can make sure it's StarkInfra that sent you the event.
If you do not approve or decline the authorization within 1 second, the authorization will be denied.

```java
import com.starkinfra.*;

Request request = Listener.listen(); // this is your handler to listen for authorization requests

String content = request.content.toString();
String signature = request.headers.get("Digital-Signature");

PixReversal request = PixReversal.parse(content, signature);

System.out.println(request);
```

### Query PixReversal logs

You can query Pix reversal logs to better understand Pix reversal life cycles.

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

### Get a PixReversal log

You can also get a specific log by its id.

```java
import com.starkinfra.*;

PixReversal.Log log = PixReversal.Log.get("6532638269505536");

System.out.println(log);
```

### Get your PixBalance

To know how much money you have in your workspace, run:

```java
import com.starkinfra.*;

PixBalance balance = PixBalance.get();

System.out.println(balance);
```

### Create a PixStatement

Statements are only available for direct participants. To create a statement of all the transactions that happened on your workspace during a specific day, run:

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

HashMap<String, Object> data = new HashMap<>();
data.put("after", "2022-01-01");
data.put("before", "2022-01-01");
data.put("type", "transaction");

PixStatement statement = new PixStatement(data);

statement = PixStatement.create(statement);

System.out.println(statement);
```
### Query PixStatements

You can query multiple Pix statements according to filters.

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

### Get a PixStatement

Statements are only available for direct participants. To get a Pix statement by its id:

```java
import com.starkinfra.*;

PixStatement statement = PixStatement.get("5155966664310784");

System.out.println(statement);
```

### Get a PixStatement .csv file

To get a .csv file of a Pix statement using its id, run:

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

### Create a PixKey

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

### Query PixKeys

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

### Get a PixKey

Information on any Pix key may be retrieved by its id and the tax ID of the consulting agent.
If the request results in the creation of a Pix Request, the same end to end id should be used. 
If this parameter is not passed, one endToEndId will be automatically created.

```java
import com.starkinfra.*;

PixKey key = PixKey.get("+5541998989898", "012.345.678-90", EndToEndId.create("20018183"));

System.out.println(key);
```

### Cancel a PixKey

To cancel a Pix key, run:

```java
import com.starkinfra.*;

PixKey key = PixKey.cancel("+5541998989898");

System.out.println(key);
```

### Update a PixKey

Update the account information or the holder's name linked to a Pix key.

```java
import com.starkinfra.*;
import java.util.HashMap;

HashMap<String, Object> patchData = new HashMap<>();
patchData.put("name", "Jamie Lannister");
PixKey key = PixKey.update("+5541998989898", "branchTransfer", patchData);

System.out.println(key);
```

### Query PixKey logs

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

### Get a PixKey log

You can also get a specific log by its id.

```java
import com.starkinfra.*;

PixKey.Log log = PixKey.Log.get("6532638269505536");

System.out.println(log);
```

### Create a PixClaim

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

### Query PixClaims

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

### Get a PixClaim

After its creation, information on a Pix claim may be retrieved by its id:

```java
import com.starkinfra.*;

PixClaim claim = PixClaim.get("5155165527080960");

System.out.println(claim);
```

### Update a PixClaim

A Pix Claim can be patched for two distinct reasons. A received Pix Claim can be confirmed or canceled by patching
its status. A received Pix Claim must be confirmed by the donor to be completed. Ownership Pix Claims can only be
canceled by the donor if the reason is fraud. A sent Pix Claim can also be canceled by patching its status.

```java
import com.starkinfra.*;
import java.util.HashMap;

PixClaim claim = PixClaim.update("5155165527080960", "confirmed");

System.out.println(claim);
```

### Query PixClaim logs

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

### Get a PixClaim log

You can also get a specific log by its id.

```java
import com.starkinfra.*;

PixClaim.Log log = PixClaim.Log.get("6532638269505536");

System.out.println(log);
```

## Create a PixDirector

To register the Pix director contact information at the Central Bank, run the following:

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

HashMap<String, Object> data = new HashMap<>();
data.put("name", "Edward Stark");
data.put("taxId", "012.345.678-90");
data.put("phone", "+5511999999999");
data.put("email", "ned.stark@company.com");
data.put("password", "12345678");
data.put("teamEmail", "Pix.team@company.com");
data.put("teamPhones", new String[] {"+5511997979797", "+5511996969696"});
PixDirector director = new PixDirector(data);

PixDirector director = PixDirector.create(director);

System.out.println(director);
```

### Create PixInfractions

Pix infractions are used to report transactions that are suspected of fraud, to request a refund or to
reverse a refund. Pix infractions can be created by either participant of a transaction.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

List infractions = new ArrayList<>();
HashMap<String, Object> data = new HashMap<>();
data.put("referenceId", "E20018183202201201450u34sDGd19lz");
data.put("type", "fraud");
infractions.add(new PixInfraction(data));

infractions = PixInfraction.create(infractions);

for (PixRequest infraction : infractions){
    System.out.println(infraction);
}
```

### Query PixInfractions

You can query multiple Pix infractions according to filters.

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
Generator<PixInfraction> infractions = PixInfraction.query(params);

for (PixInfraction infraction : infractions){
    System.out.println(infraction);
}
```

### Get a PixInfraction

After its creation, information on a Pix infraction may be retrieved by its id.

```java
import com.starkinfra.*;

PixInfraction infraction = PixInfraction.get("5155165527080960");

System.out.println(infraction);
```

### Cancel a PixInfraction

To cancel a Pix infraction, run:

```java
import com.starkinfra.*;

PixInfraction infraction = PixInfraction.cancel("5155165527080960");

System.out.println(infraction);
```

### Update a PixInfraction

A received Pix Infraction can be confirmed or declined by patching its status. After a Pix Infraction
is Patched, its status changes to closed.

```java
import com.starkinfra.*;
import java.util.HashMap;

PixInfraction infraction = PixInfraction.update("5155165527080960", "agreed");

System.out.println(infraction);
```

### Query PixInfraction logs

You can query Pix infraction logs to better understand Pix infraction's life cycles.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 10);
params.put("after", "2020-04-01");
params.put("before", "2020-04-30");
Generator<PixInfraction.Log> logs = PixInfraction.Log.query(params);

for (PixInfraction.Log log : logs){
    System.out.println(log);
}
```

### Get a PixInfraction log

You can also get a specific log by its id.

```java
import com.starkinfra.*;

PixInfraction.Log log = PixInfraction.Log.get("6532638269505536");

System.out.println(log);
```

### Create PixChargebacks

Pix chargebacks can be created when fraud is detected on a transaction or a system malfunction
results in an erroneous transaction.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


List infractions = new ArrayList<>();
HashMap<String, Object> data = new HashMap<>();
data.put("referenceId", "E20018183202201201450u34sDGd19lz");
data.put("type", "fraud");
data.put("description", "Client payed for an item and never received it.");
infractions.add(new PixInfraction(data));

infractions = PixInfraction.create(infractions);

for (PixInfraction infraction : infractions){
    System.out.println(infraction);
}
```

### Query PixChargebacks

You can query multiple Pix chargebacks according to filters.

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
Generator<PixChargeback> chargebacks = PixChargeback.query(params);

for (PixChargeback chargeback : chargebacks){
    System.out.println(chargeback);
}
```

### Get a PixChargeback

After its creation, information on a Pix chargeback may be retrieved by its id.

```java
import com.starkinfra.*;

PixChargeback chargeback = PixChargeback.get("5155165527080960");

System.out.println(chargeback);
```

### Cancel a PixChargeback

To cancel a Pix chargeback, run:

```java
import com.starkinfra.*;

PixChargeback chargeback = PixChargeback.cancel("5155165527080960");

System.out.println(chargeback);
```

### Update a PixChargeback

A received Pix Chargeback can be confirmed or declined by patching its status. After a Pix Chargeback
is Patched, its status changes to closed.

```java
import com.starkinfra.*;
import com.starkinfra.utils.*;
import java.util.HashMap;

HashMap<String, Object> patchData = new HashMap<>();
patchData.put("reversalReferenceId", ReturnId.create("20018183"));
PixChargeback chargeback = PixChargeback.update("5155165527080960", "accepted", patchData);

System.out.println(chargeback);
```

### Query PixChargeback logs

You can query Pix chargeback logs to better understand Pix chargeback life cycles.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 10);
params.put("after", "2020-04-01");
params.put("before", "2020-04-30");
Generator<PixChargeback.Log> logs = PixChargeback.Log.query(params);

for (PixChargeback.Log log : logs){
    System.out.println(log);
}
```

### Get a PixChargeback log

You can also get a specific log by its id.

```java
import com.starkinfra.*;

PixChargeback.Log log = PixChargeback.Log.get("6532638269505536");

System.out.println(log);
```

### Query PixDomains

You can query for certificates of registered SPI participants able to issue dynamic QR Codes.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

Generator<PixDomain> domains = PixDomain.query();
for (PixDomain domain : domains) {
    System.out.println(domain);
}
```

## Credit Note

### Create CreditNotes

You can create a Credit Note to generate a CCB contract:

```java
import com.starkinfra.CreditNote;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

List<HashMap<String, Object>> invoices = new ArrayList<>();
HashMap<String, Object> invoice = new HashMap<String, Object>() {{
    put("amount", 50000);
    put("fine", 10);
    put("interest", 2);
    put("due", "2022-07-05");
    put("taxId", "20.018.183/0001-80");
}};
invoices.add(invoice);

invoice = new HashMap<String, Object>() {{
    put("amount", 51000);
    put("fine", 10);
    put("interest", 2);
    put("due", "2022-08-05");
    put("taxId", "20.018.183/0001-80");
}};
invoices.add(invoice);

HashMap<String, Object> transfer = new HashMap<String, Object>(){{
    put("bankCode", "00000000");
    put("branchCode", "1234");
    put("accountNumber", "129340-1");
    put("taxId", "012.345.678-90");
    put("name", "Jamie Lannister");
}}

List<HashMap<String, Object>> signers = new ArrayList<>();
HashMap<String, Object> signer = new HashMap<String, Object>() {{
    put("name", "Jamie Lannister");
    put("contact", "teste11@gmail.com");
    put("method","link");
}};
signers.add(signer);

List<CreditNote> creditNotes = new ArrayList<>();
HashMap<String, Object> data = new HashMap<>();
data.put("templateId", "5707012469948416");
data.put("name", "Jamie Lannister");
data.put("taxId", "20.018.183/0001-80");
data.put("nominalAmount", 100000);
data.put("scheduled", "2022-05-05");
data.put("invoices", invoices );
data.put("transfer", transfer );
data.put("signers", signers );
data.put("externalId", "my-internal-id-8435356");
data.put("tags", new String[]{"War supply", "Invoice #1234"});
data.put("rebateAmount", 0);
data.put("streetLine1", "Rua ABC");
data.put("streetLine2", "Ap 123");
data.put("district", "Jardim Paulista");
data.put("city", "São Paulo");
data.put("stateCode", "SP");
data.put("zipCode", "01234-567");

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

### Cancel a CreditNote

You can cancel a credit note if it has not been signed yet.

```java
import com.starkinfra.CreditNote;

CreditNote creditNote = CreditNote.cancel("5155165527080960");

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

## Webhook

### Create a webhook subscription

To create a webhook subscription and be notified whenever an event occurs, run:

```java
import com.starkinfra.*;
import java.util.HashMap;

HashMap<String, Object> data = new HashMap<>();
data.put("url", "https://webhook.site/dd784f26-1d6a-4ca6-81cb-fda0267761ec");
data.put("subscriptions", new String[]{
    "contract", "credit-note", "signer",
    "issuing-card", "issuing-invoice", "issuing-purchase",
    "pix-request.in", "pix-request.out", "pix-reversal.in", "pix-reversal.out", "pix-claim", "pix-key", "pix-chargeback", "pix-infraction"
});
Webhook webhook = Webhook.create(data);

System.out.println(webhook);
```

## Query webhooks

To search for registered webhooks, run:

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;

Generator<Webhook> webhooks = Webhook.query();

for (Webhook webhook : webhooks){
    System.out.println(webhook);
}
```

## Get a webhook

You can get a specific webhook by its id.

```java
import com.starkinfra.*;

Webhook webhook = Webhook.get("5730174175805440");

System.out.println(webhook);
```

## Delete a webhook

You can also delete a specific webhook by its id.

```java
import com.starkinfra.*;

Webhook webhook = Webhook.delete("6699417864241152");

System.out.println(webhook);
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
else if (event.subscription.contains("issuing-card")) {
    IssuingCard.Log log = ((Event.IssuingCardEvent) event).log;
    System.out.println(log.card);
}
else if (event.subscription.contains("issuing-invoice")) {
    IssuingInvoice.Log log = ((Event.IssuingInvoiceEvent) event).log;
    System.out.println(log.invoice);
}
else if (event.subscription.contains("issuing-purchase")) {
    IssuingPurchase.Log log = ((Event.IssuingPurchaseEvent) event).log;
    System.out.println(log.purchase);
}
else if (event.subscription.contains("credit-note")) {
    CreditNote.Log log = ((Event.CreditNoteEvent) event).log;
    System.out.println(log.note);
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

Email: help@starkbank.com
