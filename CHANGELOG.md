# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/)
and this project adheres to the following versioning pattern:

Given a version number MAJOR.MINOR.PATCH, increment:

- MAJOR version when the **API** version is incremented. This may include backwards incompatible changes;
- MINOR version when **breaking changes** are introduced OR **new functionalities** are added in a backwards compatible manner;
- PATCH version when backwards compatible bug **fixes** are implemented.


## [Unreleased]

## [0.1.0] - 2022-06-03
### Added
- credit receiver's billing address on CreditNote

## [0.0.3] - 2022-05-23
### Added
- PixDomain resource for Indirect and Direct Participants
- PixDirector resource for Direct Participants
- CreditNote.Signer sub-resource
- CreditNote.Invoice sub-resource
- CreditNote.Transfer sub-resource
- issuinginvoice.Log.get() function
- Webhook resource to receive Events
- merchantFee atribute to IssuingPurchase
### Changed
- CreditNote.transfer parameter to payment and paymentType
- InfractionReport resource name to PixInfraction
- ReversalRequest resource name to PixChargeback
- PixInfraction and PixChargeback to post in batches
- delete methods name to cancel

## [0.0.2] - 2022-05-02
### Added
- PixKey resource for Indirect and Direct Participants
- PixClaim resource for Indirect and Direct Participants
- InfractionReport resource for Indirect and Direct Participants
- ReversalRequest resource for Indirect and Direct Participants
- get(), query(), page(), delete() and update() functions to Event resource.
- Event.Attempt sub-resource to allow retrieval of information on failed webhook event delivery attempts
- CreditNote resource for money lending with Stark's Infra endorsement.
- IssuingAuthorization resource for Sub Issuers
- IssuingBalance resource for Sub Issuers
- IssuingBin resource for Sub Issuers
- IssuingCard resource for Sub Issuers
- IssuingHolder resource for Sub Issuers
- IssuingInvoice resource for Sub Issuers
- IssuingPurchase resource for Sub Issuers
- IssuingTransaction resource for Sub Issuers

## [0.0.1] - 2022-03-16
### Added
- PixRequest resource for Indirect and Direct Participants
- PixReversal resource for Indirect and Direct Participants
- PixBalance resource for Indirect and Direct Participants
- PixStatement resource for Direct Participants
- Event resource for webhook receptions
