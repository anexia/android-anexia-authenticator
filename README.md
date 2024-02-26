# About The Project

Anexia Authenticator is based on the project [2FAS Android](https://github.com/twofas/2fas-android) and provides you with an extra layer of security for all your online accounts. Protect your Anexia accounts with Anexia Authenticator. 

## Features

- Support for time-based one-time passwords (TOTP) and HMAC-based on-time passwords (HOTP)
- Compatible with any service that supports the TOTP and HOTP standard

## Installation

1. Download the app from the [play store](https://play.google.com/store/apps/details?id=at.anexia.authenticator).
2. Install the app on your device.
3. Follow the on-screen instructions to set up your online accounts.

## Getting started

The following steps will help if you want to work on the application.

### Prerequirements

- Android Studio Iguana
- Android Version >= 6.0
- Java 17

### Installation

1. Clone the repository
2. Create your own debug signing key in `config/debug_signing.jks`
3. Create `config/config.properties` file with your debug key alias and password:
```
debug.storePassword=
debug.keyAlias=
debug.keyPassword=
```
4. Start working and debugging
5. Run the app in Android Studio

## Contributing

Contributions are welcome! 
Because the project is a clone of the 2fas project, if you would like to contribute, please see [2FAS-Android](https://github.com/twofas/2fas-android) 

## List of developers

- Bettina Kelhar <BKelhar@anexia-it.com>, Technical Leader Mobile


## License

Copyright (c) Two Factor Authentication Service, Inc. All rights reserved.
This project is published with the [GNU General Public License v3.0](https://www.gnu.org/licenses/gpl-3.0.en.html).
