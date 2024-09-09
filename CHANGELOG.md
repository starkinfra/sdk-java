# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/)
and this project adheres to the following versioning pattern:

Given a version number MAJOR.MINOR.PATCH, increment:

- MAJOR version when the **API** version is incremented. This may include backwards incompatible changes;
- MINOR version when **breaking changes** are introduced OR **new functionalities** are added in a backwards compatible manner;
- PATCH version when backwards compatible bug **fixes** are implemented.


## [Unreleased]

## [0.13.1] - 2024-09-09
### Fixed
- event parse method

## [0.13.0] - 2024-07-18
### Changed
- use core as dependecy
### Fixed
- Request docString

## [0.12.0] - 2024-07-17
### Added
- Request methods
- PixReversal description

## [0.11.3] - 2024-06-19
### Fixed
- Event parse errors

## [0.11.2] - 2024-06-07
### Fixed
- PixClaim log error list

## [0.11.1] - 2024-05-21
### Fixed
- due parameter to BrcodePreview resource

## [0.11.0] - 2024-04-01
### Added
- update method to Issuing Purchase resource

## [0.10.0] - 2024-03-05
### Added
- IssuingToken resource
- IssuingTokenDesign resource
- IssuingTokenRequest resource
- IssuingTokenActivation resource

## [0.9.0] - 2023-11-14
### Fixed 
- merchantCategoryType, description and holderId parameters to IssuingPurchase resource
- IssuingPurchase docstring in readme
- double slash request on Rest.getSubResource
### Changed
- senderTaxId and receiverTaxId parameters to DynamicBrcode resource
- type parameter to PixInfraction resource
### Added 
- method, fraudType and fraudId parameters to PixInfraction resource
- PixFraud resource
- PixUser resource

## [0.8.0] - 2023-06-19
### Added
- metadata parameter to IssuingPurchase resource

## [0.7.0] - 2023-05-11
### Added
- payerId and endToEndId parameter to BrcodePreview resource
- description parameter to StaticBrcode resource
### Changed
- nominalAmount and amount parameter to conditionally required to CreditNote resource

## [0.6.0] - 2023-04-27
### Added
- IssuingEmbossingKit resource
- pin parameter to update method in IssuingCard resource
- cashierBankCode attribute to StaticBrcode resource
### Removed
- cardDesignId and envelopeDesignId attributes to IssuingEmbossingRequest resource

## [0.5.0] - 2023-02-14
### Added
- IndividualIdentity resource
- IndividualDocument resource

## [0.4.0] - 2022-12-28
### Added
- CreditHolmes resource

## [0.3.0] - 2022-12-02
### Added
- productId attribute to IssuingPurchase resource
- IssuingDesign resource
- IssuingStock resource
- IssuingRestock resource
- IssuingEmbossingRequest resource

## [0.2.0] - 2022-09-16
### Added
- StaticBrcode resource
- BrcodePreview resource
- DynamicBrcode resource
- CardMethod sub-resource
- CreditPreview sub-resource
- MerchantCountry sub-resource
- MerchantCategory sub-resource
- CreditNotePreview sub-resource
- flow parameter to query and page methods in PixClaim resource
- tags parameter to PixChargeback, PixClaim and PixInfraction resources
- tags parameter to query and page methods in PixChargeback, PixClaim and PixInfraction resources
- code attribute to IssuingProduct resource
- nominalInterest attribute to CreditNote resource
- zipCode, purpose, isPartialAllowed, cardTags and holderTags attributes to IssuingPurchase resource
- brcode, link and due attributes to IssuingInvoice resource
### Changed
- IssuingBin resource to IssuingProduct
- fine and interest attributes to return only in CreditNote.Invoice sub-resource
- expiration attribute returned-only to optional parameter in the CreditNote resource
- settlement parameter to fundingType and client parameter to holderType in Issuing Product resource
- bankCode parameter to claimerBankCode in PixClaim resource
- agent parameter to flow in PixClaim and PixInfraction resources
- agent parameter to flow on query and page methods in PixClaim resource
- Creditnote.Signer sub-resource to CreditSigner resource
### Removed
- IssuingAuthorization resource
- category parameter from IssuingProduct resource
- agent parameter from PixClaim.Log resource
- bacenId parameter from PixChargeback and PixInfraction resources

## [0.1.0] - 2022-06-03
### Added
- credit receiver's billing address on CreditNote

## [0.0.3] - 2022-05-23
### Added
- PixDomain resource for Indirect and Direct Participants
- code attribute to IssuingProduct resource
- PixDirector resource for Direct Participants
- CreditNote.Signer sub-resource
- CreditNote.Invoice sub-resource
- CreditNote.Transfer sub-resource
- get method to IssuingInvoice.Log resource
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
