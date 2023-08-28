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
    - [Products](#query-issuingproducts): View available sub-issuer Products (a.k.a. card number ranges)
    - [Holders](#create-issuingholders): Manage card holders
    - [Cards](#create-issuingcards): Create virtual and/or physical cards
    - [Design](#query-issuingdesigns): View your current card or package designs
    - [EmbossingKit](#query-issuingembossingkits): Create embossing kits
    - [Stock](#query-issuingstocks): View your current stock of a certain IssuingDesign linked to an Embosser on the workspace
    - [Restock](#create-issuingrestocks): Create restock orders of a specific IssuingStock object
    - [EmbossingRequest](#create-issuingembossingrequests): Create embossing requests
    - [Purchases](#process-purchase-authorizations): Authorize and view your past purchases
    - [Invoices](#create-issuinginvoices): Add money to your issuing balance
    - [Withdrawals](#create-issuingwithdrawals): Send money back to your Workspace from your issuing balance
    - [Balance](#get-your-issuingbalance): View your issuing balance
    - [Transactions](#query-issuingtransactions): View the transactions that have affected your issuing balance
    - [Enums](#issuing-enums): Query enums related to the issuing purchases, such as merchant categories, countries and card purchase methods
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
    - [StaticBrcode](#create-staticbrcodes): Create static Pix BR Codes
    - [DynamicBrcode](#create-dynamicbrcodes): Create dynamic Pix BR Codes
    - [BrcodePreview](#create-brcodepreviews): Read data from BR Codes before paying them
  - [Lending](#lending)
    - [CreditNote](#create-creditnotes): Create credit notes
    - [CreditPreview](#create-creditpreviews): Create credit previews
    - [CreditHolmes](#create-creditholmes): Create credit holmes debt verification
  - [Identity](#identity)
    - [IndividualIdentity](#create-individualidentities): Create individual identities
    - [IndividualDocument](#create-individualdocuments): Create individual documents
  - [Webhook](#webhook):
    - [Webhook](#create-a-webhook-subscription): Configure your webhook endpoints and subscriptions
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
  implementation 'com.starkinfra:sdk:0.8.0'
}
```

1.2 If you are using Maven, add this dependency to your pom.xml:

```xml
<dependency>
  <groupId>com.starkinfra</groupId>
  <artifactId>sdk</artifactId>
  <version>0.8.0</version>
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

### Query IssuingProducts

To take a look at the sub-issuer Products available to you, just run the following:

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;

Generator<IssuingProduct> products = IssuingProduct.query();

for (IssuingProduct product : products) {
    System.out.println(product);
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

Map<String, Object> data = new HashMap<>();;
data.put("status", "blocked");

IssuingCard card = IssuingCard.update("5760854205136896", data);

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

Logs are pretty important to understand the life cycles of a card.

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

### Query IssuingDesigns

You can get a list of available designs given some filters.

```java
import com.starkinfra.*;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 3);
Generator<IssuingDesign> designs = IssuingDesign.query(params);

for (IssuingDesign design : designs) {
    System.out.println(design);
}
```

### Get an IssuingDesign

Information on a design may be retrieved by its id.

```java
import com.starkinfra.*;

IssuingDesign design = IssuingDesign.get("5747368922185728");

System.out.println(design);
```

### Query IssuingEmbossingKits

You can get a list of created embossing kits given some filters.

```java
import com.starkinfra.*;

HashMap<String, Object> params = new HashMap<>();
params.put("after", "2022-11-01");
params.put("before", "2022-11-30");

Generator<IssuingEmbossingKit> kits = IssuingEmbossingKit.query(params);

for (IssuingEmbossingKit kit : kits) {
    System.out.println(kit);
}
```

### Get an IssuingEmbossingKit

After its creation, information on an embossing kit may be retrieved by its id.

```java
import com.starkinfra.*;

IssuingEmbossingKit kit = IssuingEmbossingKit.get("5792731695677440");

System.out.println(kit);
```

### Query IssuingStocks

You can get a list of available stocks given some filters.

```java
import com.starkinfra.*;

HashMap<String, Object> params = new HashMap<>();
params.put("after", "2022-11-01");
params.put("before", "2022-11-30");

Generator<IssuingStock> stocks = IssuingStock.query(params);

for (IssuingStock stock : stocks) {
    System.out.println(stock);
}
```

### Get an IssuingStock

Information on a stock may be retrieved by its id.

```java
import com.starkinfra.*;

IssuingStock stock = IssuingStock.get("5792731695677440");

System.out.println(stock);
```

### Query IssuingStock logs

Logs are pretty important to understand the life cycle of a stock.

```java
import com.starkinfra.*;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 150);

Generator<IssuingStock.Log> logs = IssuingStock.Log.query(params);

for (IssuingStock.Log log : logs) {
    System.out.println(log);
}
```

### Get an IssuingStock log

You can get a single log by its id.

```java
import com.starkinfra.*;

IssuingStock.Log log = IssuingStock.Log.get("5809977331548160");

System.out.println(log);
```

### Create IssuingRestocks

You can order restocks for a specific IssuingStock.

```java
import com.starkinfra.*;

List<IssuingRestock> restocks = new ArrayList<>();
HashMap<String, Object> data = new HashMap<>();
data.put("count", 200);
data.put("stockId", "5136459887542272");
restocks.add(new IssuingRestock(data));

restocks = IssuingRestock.create(restocks);

for (IssuingRestock restock : restocks) {
    System.out.println(restock);
}
```

### Query IssuingRestocks

You can get a list of created restocks given some filters.

```java
import com.starkinfra.*;

HashMap<String, Object> params = new HashMap<>();
params.put("after", "2022-11-01");
params.put("before", "2022-11-30");

Generator<IssuingRestock> restocks = IssuingRestock.query(params);

for (IssuingRestock restock : restocks) {
    System.out.println(restock);
}
```

### Get an IssuingRestock

After its creation, information on a restock may be retrieved by its id.

```java
import com.starkinfra.*;

IssuingRestock restock = IssuingRestock.get("5664445921492992");

System.out.println(restock);
```

### Query IssuingRestock logs

Logs are pretty important to understand the life cycle of a restock.

```java
import com.starkinfra.*;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 150);

Generator<IssuingRestock.Log> logs = IssuingRestock.Log.query(params);

for (IssuingRestock.Log log : logs) {
    System.out.println(log);
}
```

### Get an IssuingRestock log

You can get a single log by its id.

```java
import com.starkinfra.*;

IssuingStock.Log log = IssuingStock.Log.get("6310318875607040");

System.out.println(log);
```

### Create IssuingEmbossingRequests

You can create a request to emboss a physical card.

```java
import com.starkinfra.*;

List<IssuingEmbossingRequest> requests = new ArrayList<>();
HashMap<String, Object> data = new HashMap<>();
data.put("kitId", "5648359658356736");
data.put("cardId", "5714424132272128");
data.put("displayName1", "Antonio Stark");
data.put("shippingCity", "Sao Paulo");
data.put("shippingCountryCode", "BRA");
data.put("shippingDistrict", "Bela Vista");
data.put("shippingService", "loggi");
data.put("shippingStateCode", "SP");
data.put("shippingStreetLine1", "Av. Paulista, 200");
data.put("shippingStreetLine2", "10 andar");
data.put("shippingTrackingNumber", "My_custom_tracking_number");
data.put("shippingZipCode", "12345-678");
data.put("embosserId", "5746980898734080");
requests.add(new IssuingEmbossingRequest(data));

requests = IssuingEmbossingRequest.create(requests);

for (IssuingEmbossingRequest request : requests) {
    System.out.println(request);
}
```

### Query IssuingEmbossingRequests

You can get a list of created embossing requests given some filters.

```java
import com.starkinfra.*;

HashMap<String, Object> params = new HashMap<>();
params.put("after", "2022-11-01");
params.put("before", "2022-11-30");

Generator<IssuingEmbossingRequest> requests = IssuingEmbossingRequest.query(params);

for (IssuingEmbossingRequest request : requests) {
    System.out.println(request);
}
```

### Get an IssuingEmbossingRequest

After its creation, information on an embossing request may be retrieved by its id.

```java
import com.starkinfra.*;

IssuingEmbossingRequest request = IssuingEmbossingRequest.get("5191752558313472");

System.out.println(request);
```

### Query IssuingEmbossingRequest logs

Logs are pretty important to understand the life cycle of an embossing request.

```java
import com.starkinfra.*;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 150);

Generator<IssuingEmbossingRequest.Log> logs = IssuingEmbossingRequest.Log.query(params);

for (IssuingEmbossingRequest.Log log : logs) {
    System.out.println(log);
}
```

### Get an IssuingEmbossingRequest log

You can get a single log by its id.

```java
import com.starkinfra.*;

IssuingEmbossingRequest.Log log = IssuingEmbossingRequest.Log.get("6724771005857792");

System.out.println(log);
```

### Process Purchase authorizations

It's easy to process purchase authorizations delivered to your endpoint.
Remember to pass the signature header so the SDK can make sure it's StarkInfra that sent you the event.
If you do not approve or decline the authorization within 2 seconds, the authorization will be denied.

```java
import com.starkinfra.*;

Request request = Listener.listen(); // this is the method you made to get the events posted to your tokenActivationUrl endpoint

String content = request.content.toString();
String signature = request.headers.get("Digital-Signature");

IssuingAuthorization event = IssuingAuthorization.parse(content, validSignature);

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

Logs are pretty important to understand the life cycles of a purchase.

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

Logs are pretty important to understand the life cycles of an invoice.

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

### Get an IssuingInvoice log

You can also get a specific log by its id.

```java
import com.starkinfra.*;

IssuingInvoice.Log log = IssuingInvoice.Log.get("4899337284878336");

System.out.println(log);
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
### Issuing Enums

#### Query MerchantCategories

You can query any merchant categories using this resource.
You may also use MerchantCategories to define specific category filters in IssuingRules.
Either codes (which represents specific MCCs) or types (code groups) will be accepted as filters.

```java
import com.starkinfra.utils.Generator;
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("search", "food");

Generator<MerchantCategory> categories = MerchantCategory.query(params);

for (MerchantCategory category : categories) {
    System.out.println(category);
}
```

#### Query MerchantCountries

You can query any merchant countries using this resource.
You may also use MerchantCountries to define specific country filters in IssuingRules.

```java
import com.starkinfra.utils.Generator;
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("search", "brazil");

Generator<MerchantCountry> countries = MerchantCountry.query(params);

for (MerchantCountry country : countries) {
    System.out.println(country);
}
```

#### Query CardMethods

You can query available card methods using this resource.
You may also use CardMethods to define specific purchase method filters in IssuingRules.

```java
import com.starkinfra.utils.Generator;
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;

HashMap<String, Object> params = new HashMap<>();
params.put("search", "token");

Generator<CardMethod> methods = CardMethod.query(params);

for (CardMethod method : methods) {
    System.out.println(method);
}
```

## Pix

### Create PixRequests

You can create a Pix request to transfer money from one of your users to anyone else:

```java
import com.starkinfra.*;
import com.starkinfra.utils.EndToEndId;
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

After its creation, information on a Pix reversal may be retrieved by its id. 
Its status indicates whether it has been paid.

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

### Update a PixKey

Update the account information linked to a Pix Key.

```java
import com.starkinfra.*;
import java.util.HashMap;

HashMap<String, Object> patchData = new HashMap<>();
patchData.put("name", "Jamie Lannister");

PixKey key = PixKey.update("+5541998989898", "branchTransfer", patchData);

System.out.println(key);
```

### Cancel a PixKey

To cancel a Pix key, run:

```java
import com.starkinfra.*;

PixKey key = PixKey.cancel("+5541998989898");

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

You can create a Pix claim to request the transfer of a Pix key from an account on another bank to one of your accounts:

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

A Pix Claim can be confirmed or canceled by patching its status.
A received Pix Claim must be confirmed by the donor to be completed.
Ownership Pix Claims can only be canceled by the donor if the reason is "fraud".
A sent Pix Claim can also be canceled.

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

### Update a PixInfraction

A received Pix Infraction can be confirmed or declined by patching its status.
After a Pix Infraction is patched, its status changes to closed.

```java
import com.starkinfra.*;
import java.util.HashMap;

PixInfraction infraction = PixInfraction.update("5155165527080960", "agreed");

System.out.println(infraction);
```

### Cancel a PixInfraction

Cancel a specific Pix Infraction using its id.

```java
import com.starkinfra.*;

PixInfraction infraction = PixInfraction.cancel("5155165527080960");

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

### Update a PixChargeback

A received Pix Chargeback can be confirmed or declined by patching its status. After a Pix Chargeback
is Patched, its status changes to closed.

```java
import com.starkinfra.PixChargeback;
import com.starkinfra.utils.ReturnId;
import java.util.HashMap;

HashMap<String, Object> patchData = new HashMap<>();
patchData.put("reversalReferenceId", ReturnId.create("20018183"));

PixChargeback chargeback = PixChargeback.update("5155165527080960", "accepted", patchData);

System.out.println(chargeback);
```

### Cancel a PixChargeback

To cancel a Pix chargeback, run:

```java
import com.starkinfra.*;

PixChargeback chargeback = PixChargeback.cancel("5155165527080960");

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

Here you can list all Pix Domains registered at the Brazilian Central Bank. The Pix Domain object displays the domain
name and the QR Code domain certificates of registered Pix participants able to issue dynamic QR Codes.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;
import java.util.HashMap;

Generator<PixDomain> domains = PixDomain.query();

for (PixDomain domain : domains) {
    System.out.println(domain);
}
```

### Create StaticBrcodes

StaticBrcodes store account information via a BR Code or an image (QR code)
that represents a PixKey and a few extra fixed parameters, such as an amount
and a reconciliation ID. They can easily be used to receive Pix transactions.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

List<StaticBrcode> brcodes = new ArrayList<>();
HashMap<String, Object> data = new HashMap<>();
data.put("name", "Tony Stark");
data.put("keyId", "+5541999999999");
data.put("city", "Rio de Janeiro");
data.put("amount", 1000);
brcodes.add(new StaticBrcode(data));

brcodes = StaticBrcode.create(brcodes);

for (StaticBrcode brcode : brcodes){
    System.out.println(brcode);
}
```

### Query StaticBrcodes

You can query multiple StaticBrcodes according to filters.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 3);
params.put("after", "2019-04-01");
params.put("before", "2030-04-30");
params.put("uuid", "147642085d6a4142a3c6c248ce69f3e3");

Generator<StaticBrcode> brcodes = StaticBrcode.query(params);

for (StaticBrcode brcode : brcodes) {
    System.out.println(brcode);
}
```

### Get a StaticBrcodes

After its creation, information on a StaticBrcode may be retrieved by its UUID.

```java
import com.starkinfra.*;

StaticBrcode brcode = StaticBrcode.get("91a6b9f33291446e9750ef20a2457633");

System.out.println(brcode);
```

### Create DynamicBrcodes

BR Codes store information represented by Pix QR Codes, which are used to send
or receive Pix transactions in a convenient way.
DynamicBrcodes represent charges with information that can change at any time,
since all data needed for the payment is requested dynamically to an URL stored
in the BR Code. Stark Infra will receive the GET request and forward it to your
registered endpoint with a GET request containing the UUID of the BR Code for
identification.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

List<DynamicBrcode> brcodes = new ArrayList<>();
HashMap<String, Object> data = new HashMap<>();
data.put("name", "Tony Stark");
data.put("city", "Rio de Janeiro");
data.put("externalId", "my-internal-id-12333456");
data.put("type", "instant");
brcodes.add(new DynamicBrcode(data));

brcodes = DynamicBrcode.create(brcodes);

for (DynamicBrcode brcode : brcodes) {
    System.out.println(brcode);
}
```

### Query DynamicBrcodes

You can query multiple DynamicBrcodes according to filters.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 3);
params.put("uuid", "58397397ed0c4a158ecc37cde6e0fd2a");

Generator<DynamicBrcode> brcodes = DynamicBrcode.query(params);

for (DynamicBrcode brcode : brcodes) {
    System.out.println(brcode);
}
```

### Get a DynamicBrcode

After its creation, information on a DynamicBrcode may be retrieved by its UUID.

```java
import com.starkinfra.*;

DynamicBrcode brcode = DynamicBrcode.get("7cc0974604224a63a67764b921836e67");

System.out.println(brcode);
```

### Verify a DynamicBrcode read

When a DynamicBrcode is read by your user, a GET request will be made to the your regitered URL to
retrieve additional information needed to complete the transaction.
Use this method to verify the authenticity of a GET request received at your registered endpoint.
If the provided digital signature does not check out with the StarkInfra public key, a com.starkinfra.error.InvalidSignatureError will be raised.

```java
import com.starkinfra.*;

Request request = Listener.listen(); // this is the method you made to listen to BR Code reads made to your registered endpoint

String uuid = DynamicBrcode.verify(
    getUuid(request.url); // you should implement this method to extract the uuid from the request's URL
    request.headers.get("Digital-Signature")
);
```

### Answer to a Due DynamicBrcode read

When a Due DynamicBrcode is read by your user, a GET request containing
the BR Code UUID will be made to your registered URL to retrieve additional
information needed to complete the transaction.

The GET request must be answered in the following format within 5 seconds
and with an HTTP status code 200.

```java
import com.starkinfra.*;

Request request = Listener.listen(); // this is the method you made to get the events posted to your webhook

String uuid = DynamicBrcode.verify(
    getUuid(request.url); // you should implement this method to extract the uuid from the request's URL 
    request.headers.get("Digital-Signature")
);

Invoice invoice = getMyInvoice(uuid) # you should implement this method to get the information of the BR Code from its uuid

HashMap<String, Object> data = new HashMap<>();
data.put("version", invoice.version);
data.put("created", invoice.created);
data.put("due", invoice.due);
data.put("keyId", invoice.keyId);
data.put("status", invoice.status);
data.put("reconciliationId", invoice.reconciliationId);
data.put("amount", invoice.amount);
data.put("senderName", invoice.senderName);
data.put("receiverName", invoice.receiverName);
data.put("receiverStreetLine", invoice.receiverStreetLine);
data.put("receiverCity", invoice.receiverCity);
data.put("receiverStateCode", invoice.receiverStateCode);
data.put("receiverZipCode", invoice.receiverZipCode);
        
Response Sender.sendResponse(  # you should also implement this method to respond the read request
    String responseDues = DynamicBrcode.responseDue(data);
);
```

### Answer to an Instant DynamicBrcode read

When an Instant DynamicBrcode is read by your user, a GET request
containing the BR Code UUID will be made to your registered URL to retrieve
additional information needed to complete the transaction.

The get request must be answered in the following format
within 5 seconds and with an HTTP status code 200.

```java
import com.starkinfra.*;

Request request = Listener.listen(); // this is the method you made to listen to BR Code reads made to your registered endpoint

String uuid = DynamicBrcode.verify(
    getUuid(request.url); // you should implement this method to extract the uuid from the request's URL 
    request.headers.get("Digital-Signature")
);

Invoice invoice = getMyInvoice(uuid) // you should implement this method to get the information of the BR Code from its uuid

HashMap<String, Object> data = new HashMap<>();
data.put("version", invoice.version);
data.put("created", invoice.created);
data.put("keyId", invoice.keyId);
data.put("status", invoice.status);
data.put("reconciliationId", invoice.reconciliationId);
data.put("amount", invoice.amount);
data.put("cashierType", invoice.cashierType);
data.put("cashierBankCode", invoice.cashierBankCode);
data.put("cashAmount", invoice.cashAmount);        
        
Response Sender.sendResponse(  // you should also implement this method to respond the read request
    String responseInstant = DynamicBrcode.responseInstant(data);
);

```

## Create BrcodePreviews

You can create BrcodePreviews to preview BR Codes before paying them.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

List<BrcodePreview> previews = new ArrayList<>();
HashMap<String, Object> data = new HashMap<>();
data.put("id", "00020126360014br.gov.bcb.pix0114+5541999999999520400005303986540510.005802BR5910Tony Stark6014Rio de Janeiro62070503***630466B7");
data.put("payerId", "123.456.789-01");
previews.add(new BrcodePreview(data));

List<BrcodePreview> previews = (List<BrcodePreview>) BrcodePreview.create(previews);

System.out.println(previews);
```

## Lending

If you want to establish a lending operation, you can use Stark Infra to
create a CCB contract. This will enable your business to lend money without
requiring a banking license, as long as you use a Credit Fund 
or Securitization company.

The required steps to initiate the operation are:

 1. Have funds in your Credit Fund or Securitization account
 2. Request the creation of an [Identity Check](#create-individualidentities)
for the credit receiver (make sure you have their documents and express authorization)
 3. (Optional) Create a [Credit Simulation](#create-creditpreviews) 
with the desired installment plan to display information for the credit receiver
 4. Create a [Credit Note](#create-creditnotes)
with the desired installment plan

### Create CreditNotes

For lending operations, you can create a CreditNote to generate a CCB contract.

Note that you must have recently created an identity check for that same Tax ID before
being able to create a credit operation for them.

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

### Create CreditPreviews

You can preview a credit operation before creating them (Currently we only have CreditNote / CCB previews):

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

HashMap<String, Object> sac = new HashMap<>();
sac.put("type", "sac");
sac.put("nominalAmount", 100000);
sac.put("scheduled", getDateString(3));
sac.put("taxId", "20.018.183/0001-80");
sac.put("initialDue", getDateString(4));
sac.put("nominalInterest", 15);
sac.put("count", 1);
sac.put("interval", "year");
sac.put("rebateAmount", 0);

HashMap<String, Object> price = new HashMap<>();
price.put("type", "price");
price.put("nominalAmount", 10000null);
price.put("scheduled", getDateString(3));
price.put("taxId", "20.018.183/0001-80");
price.put("initialDue", getDateString(4));
price.put("nominalInterest", 15);
price.put("count", 15);
price.put("interval", "year");
price.put("rebateAmount", 900);

HashMap<String, Object> american = new HashMap<>();
american.put("type", "american");
american.put("nominalAmount", 100000);
american.put("scheduled", getDateString(3));
american.put("taxId", "20.018.183/0001-80");
american.put("initialDue", getDateString(4));
american.put("nominalInterest", 15);
american.put("count", 5);
american.put("interval", "month");
american.put("rebateAmount", 900);

HashMap<String, Object> bullet = new HashMap<>();
bullet.put("type", "bullet");
bullet.put("nominalAmount", 100000);
bullet.put("scheduled", getDateString(3));
bullet.put("taxId", "20.018.183/0001-80");
bullet.put("initialDue", getDateString(4));
bullet.put("nominalInterest", 15);
bullet.put("rebateAmount", 0);

List<CreditPreview> previews = new ArrayList<>();
previews.add(new CreditPreview(new CreditNotePreview(sac), "credit-note"));
previews.add(new CreditPreview(new CreditNotePreview(price), "credit-note"));
previews.add(new CreditPreview(new CreditNotePreview(american),"credit-note"));
previews.add(new CreditPreview(new CreditNotePreview(bullet), "credit-note"));

List<CreditPreview> previews = CreditPreview.create(previews);

for (CreditPreview preview : previews){
    System.out.println(preview);
}
```

### Create CreditHolmes

Before you request a credit operation, you may want to check previous credit operations
the credit receiver has taken.

For that, open up a CreditHolmes investigation to receive information on all debts and credit
operations registered for that individual or company inside the Central Bank's SCR.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

List<CreditHolmes> creditHolmes = new ArrayList<>();

HashMap<String, Object> data = new HashMap<>();
data.put("taxId", "012.345.678-90");
data.put("competence", "2022-09-01");
creditHolmes.add(new CreditHolmes(data));

data = new HashMap<>();
data.put("taxId", "012.345.678-90");
data.put("competence", "2022-08-01");
creditHolmes.add(new CreditHolmes(data));

data = new HashMap<>();
data.put("taxId", "012.345.678-90");
data.put("competence", "2022-07-01");
creditHolmes.add(new CreditHolmes(data));

List<CreditHolmes> holmes= CreditHolmes.create(creditHolmes);

for (CreditHolmes sherlock : holmes) {
    System.out.println(sherlock);
}
```

### Query CreditHolmes

You can query multiple credit holmes according to filters.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

HashMap<String, Object> params = new HashMap<>();
params.put("after", "2019-04-01");
params.put("before", "2030-04-30");
params.put("status", "success");

Generator<CreditHolmes> holmes = CreditHolmes.query(params);

for (CreditHolmes sherlock : holmes) {
    System.out.println(sherlock);
}
```

### Get a CreditHolmes

After its creation, information on a credit holmes may be retrieved by its id.

```java
import com.starkinfra.*;

CreditHolmes holmes = CreditHolmes.get("5657818854064128");

System.out.println(holmes);
```

### Query CreditHolmes logs

You can query credit holmes logs to better understand their life cycles.

```java
import com.starkinfra.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

List<String> types = new ArrayList<>();
types.add("created");

List<String> ids = new ArrayList<>();
ids.add("5433445668880384");

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 50);
params.put("after", "2019-04-01");
params.put("before", "2030-04-30");
params.put("types", types);
params.put("holmesIds", ids);

Generator<CreditHolmes.Log> logs = CreditHolmes.Log.query(params);

for (CreditHolmes.Log log : logs) {
    System.out.println(log);
}
```

### Get a CreditHolmes log

You can also get a specific log by its id.

```java
import com.starkinfra.*;

CreditHolmes.Log log = CreditHolmes.Log.get("5155165527080960");

System.out.println(log);
```

## Identity

Several operations, especially credit ones, require that the identity
of a person or business is validated beforehand.

Identities are validated according to the following sequence:

1. The Identity resource is created for a specific Tax ID
2. Documents are attached to the Identity resource
3. The Identity resource is updated to indicate that all documents have been attached
4. The Identity is sent for validation and returns a webhook notification to reflect
the success or failure of the operation

### Create IndividualIdentities

You can create an IndividualIdentity to validate a document of a natural person

```java
import com.starkinfra.*;

HashMap<String, Object> identity = new HashMap<>();
identity.put("name", "Walter White");
identity.put("taxId", "012.345.678-90");
identity.put("tags", new String[]{"breaking", "bad"});

List<IndividualIdentity> identities = new ArrayList<>();
identities.add(new IndividualIdentity(identity));

identities = IndividualIdentity.create(identities);

for (IndividualIdentity identity : identities){
    System.out.println(identity);
}
```

**Note**: Instead of using IndividualIdentity objects, you can also pass each element in dictionary format

### Query IndividualIdentities

You can query multiple IndividualIdentities according to filters.

```java
import com.starkinfra.*;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 3);
params.put("status", "success");
params.put("after", "2019-04-01");
params.put("before", "2030-04-30");

Generator<IndividualIdentity> identities = IndividualIdentity.query(params);

for (IndividualIdentity identity : identities) {
    System.out.println(identity);
}
```

### Get an IndividualIdentity

After its creation, information on a IndividualIdentity may be retrieved by its id.

```java
import com.starkinfra.*;

IndividualIdentity identity = IndividualIdentity.get("5155165527080960");

System.out.println(identity);
```

### Update an IndividualIdentity

You can update a specific identity status to send it to validation.

```java
import com.starkinfra.*;

IndividualIdentity identity = IndividualIdentity.update("5155165527080960", "processing")

System.out.println(identity);
```

**Note**: For apply it to processing status, you should send required IndividualDocuments

### Cancel an IndividualIdentity

You can cancel a IndividualIdentity before update status to processing.

```java
import com.starkinfra.*;

IndividualIdentity identity = IndividualIdentity.cancel("5155165527080960");

System.out.println(identity);
```
  
### Query IndividualIdentity logs

You can query IndividualIdentity logs to better understand IndividualIdentity life cycles.

```java
import com.starkinfra.IndividualIdentity;
import com.starkinfra.utils.Generator;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 3);
params.put("after", "2019-04-01");
params.put("before", "2030-04-30");

Generator<IndividualIdentity.Log> logs = IndividualIdentity.Log.query(params);

for (IndividualIdentity.Log log : logs) {
    System.out.println(log);
}
```

### Get an IndividualIdentity log

You can also get a specific log by its id.

```java
import com.starkinfra.*;

IndividualIdentity.Log log = IndividualIdentity.Log.get("5155165527080960");

System.out.println(log);
```

### Create IndividualDocuments

You can create a IndividualDocument for attach images of documents to IndividualIdentity

```java
import com.starkinfra.*;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.File;

File documentFrontFile = new File(path);
byte[] documentFrontBytes = Files.readAllBytes(documentFrontFile.toPath());

HashMap<String, Object> documentFront = new HashMap<>();
documentFront.put("type", "identity-front");
documentFront.put("content", documentFrontBytes);
documentFront.put("contentType", "image/png");
documentFront.put("identityId", "5155165527080960");
documentFront.put("tags", new String[]{"breaking", "bad"});

File documentBackFile = new File(path);
byte[] documentBackBytes = Files.readAllBytes(documentBackFile.toPath());

HashMap<String, Object> documentBack = new HashMap<>();
documentBack.put("type", "identity-back");
documentBack.put("content", documentBackBytes);
documentBack.put("contentType", "image/png");
documentBack.put("identityId", "5155165527080960");
documentBack.put("tags", new String[]{"breaking", "bad"});

File selfieFile = new File(path);
byte[] selfieBytes = Files.readAllBytes(selfieFile.toPath());

HashMap<String, Object> selfie = new HashMap<>();
selfie.put("type", "selfie");
selfie.put("content", selfieBytes);
selfie.put("contentType", "image/png");
selfie.put("identityId", "5155165527080960");
selfie.put("tags", new String[]{"breaking", "bad"});

List<IndividualDocument> documents = new ArrayList<>();
documents.add(new IndividualDocument(documentFront));
documents.add(new IndividualDocument(documentBack));
documents.add(new IndividualDocument(selfie));

documents = IndividualDocument.create(documents);

for (IndividualDocument document : documents){
    System.out.println(document);
}
```

**Note**: Instead of using IndividualDocument objects, you can also pass each element in dictionary format

### Query IndividualDocuments

You can query multiple IndividualDocuments according to filters.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 3);
params.put("status", "success");
params.put("after", "2019-04-01");
params.put("before", "2030-04-30");

Generator<IndividualDocument> documents = IndividualDocument.query(params);

for (IndividualDocument document : documents) {
    System.out.println(document);
}
```

### Get an IndividualDocument

After its creation, information on a IndividualDocument may be retrieved by its id.

```java
import com.starkinfra.*;

IndividualDocument document = IndividualDocument.get("5155165527080960");

System.out.println(document);
```
  
### Query IndividualDocument logs

You can query IndividualDocument logs to better understand IndividualDocument life cycles.

```java
import com.starkinfra.*;
import com.starkinfra.utils.Generator;

HashMap<String, Object> params = new HashMap<>();
params.put("limit", 3);
params.put("after", "2019-04-01");
params.put("before", "2030-04-30");

Generator<IndividualDocument.Log> logs = IndividualDocument.Log.query(params);

for (IndividualDocument.Log log : logs) {
    System.out.println(log);
}
```

### Get an IndividualDocument log

You can also get a specific log by its id.

```java
import com.starkinfra.*;

IndividualDocument.Log log = IndividualDocument.Log.get("5155165527080960");

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

### Process webhook events

It's easy to process events delivered to your Webhook endpoint.
Remember to pass the signature header so the SDK can make sure it was StarkInfra that sent you the event.

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

__InvalidSignatureError__ will be raised specifically by starkinfra.Event.parse()
when the provided content and signature do not check out with the Stark Infra public
key.

# Help and Feedback

If you have any questions about our SDK, just email us.
We will respond you quickly, pinky promise. We are here to help you integrate with us ASAP.
We also love feedback, so don't be shy about sharing your thoughts with us.

Email: help@starkbank.com
