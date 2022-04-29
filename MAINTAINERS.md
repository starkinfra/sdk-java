# Deploying to Maven Central Repository
After you ticket has been approved, perform the following steps to deploy to Maven.


## Register gpg keys:

### Install gpg:
https://gnupg.org/download/

### Generate gpg keys:
```sh
gpg --gen-key
```

### Export key:
```sh
gpg -export-secret-keys YOUR-KEY-ID > secret-keys.gpg
```
note: the KEY-ID is the last 8 digits of the 40 digit string displayed when the key was created.

### Register key to online server:
```sh
gpg --keyserver hkp://keyserver.ubuntu.com --send-keys YOUR-KEY-ID
```


## Create a gradle.properties file:

Add the following to the gradle.properties
```sh
signing.keyId=YOUR-KEY-ID
signing.password=YOUR-GPG-PASSWORD
signing.secretKeyRingFile=${HOME}/.gnupg/secring.gpg

ossrhUsername=YOUR-OSSRH-USERNAME
ossrhPassword=YOUR-OSSRH-PASSWORD
```

## Publish to gradle:
```sh
gradle publish
```
