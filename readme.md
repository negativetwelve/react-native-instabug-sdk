# react-native-instabug-sdk

[![npm](https://img.shields.io/npm/v/react-native-instabug-sdk.svg)](https://www.npmjs.com/package/react-native-instabug-sdk)
[![npm](https://img.shields.io/npm/dt/react-native-instabug-sdk.svg)](https://www.npmjs.com/package/react-native-instabug-sdk)
[![npm](https://img.shields.io/npm/l/react-native-instabug-sdk.svg)](https://github.com/negativetwelve/react-native-instabug-sdk/blob/master/LICENSE)
[![CircleCI branch](https://img.shields.io/circleci/project/github/negativetwelve/react-native-instabug-sdk/master.svg)](https://circleci.com/gh/negativetwelve/react-native-instabug-sdk)

React Native wrapper for [Instabug](https://instabug.com/).

## Setup

```
yarn add react-native-instabug-sdk
```

### iOS

#### react-native link

```
react-native link react-native-instabug-sdk
```

Unfortunately, you currently need to follow the Cocoapods instructions as well. Need to find a way to link the official Instabug pod via `react-native link`. PRs appreciated!

#### Cocoapods

Add the following to your Podfile:

```
pod "Instabug"
pod "react-native-instabug-sdk", path: "../node_modules/react-native-instabug-sdk"
```

Run `pod install` to update your Pods.

#### Manual

Inside your xcode project file, right click on your "Libraries" folder and select "Add files to MyApp". Navigate to `node_modules/react-native-instabug-sdk/ios/RNInstabug.xcodeproj` and add that to your project. Then select your app's project file on the sidebar, scroll down to "Linked Frameworks and Libraries" and add `libRNInstabug.a` to this list.

### Android

TODO(mark): Add android support.

## Usage

```js
// Import the module.
import Instabug from 'react-native-instabug-sdk';

// Start the reporter with your token.
// This means you can trigger it via taking a screenshot.
Instabug.startWithToken(token, Instabug.events.screenshot);

// Invoke the reporter manually.
Instabug.invoke();

// Hide the reporter.
Instabug.dismiss();

// Set the user's name.
Instabug.setUserName("Mark Miyashita");

// Set the user's email.
Instabug.setUserEmail("negativetwelve@gmail.com");
```

Feature parity with the official iOS SDK coming soon. PRs welcome!
