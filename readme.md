# react-native-instabug-sdk

React Native wrapper for [Instabug](https://instabug.com/).

## Setup

```
# Yarn
yarn add react-native-instabug-sdk

OR

# NPM
npm install --save react-native-instabug-sdk
```

### iOS

#### react-native link

```
react-native link react-native-instabug-sdk
```

Unfortunately, you currently need to follow the Cocoapods instructions as well. Need to find a way to link the official Instabug pod via `react-native link`. PRs appreciated!

#### Cocoapods

TODO(mark): When adding `react-native-instabug-sdk` to Cocoapods and referencing `node_modules`, the package can't find the header files for Instabug itself :( If anyone knows how to fix this, I would gladly accept your PR!

Add the following to your Podfile:

```
pod "Instabug"
```

#### Manual

Inside your xcode project file, right click on your "Libraries" folder and select "Add files to MyApp". Navigate to `node_modules/react-native-instabug-sdk/ios/RNInstabug.xcodeproj` and add that to your project. Then select your app's project file on the sidebar, scroll down to "Linked Frameworks and Libraries" and add `libRNInstabug.a` to this list.

### Android

TODO(mark): Add android support.

## Usage

```js
// Import the module.
import Instabug from 'react-native-instabug-sdk';

// Start the reporter with your token.
Instabug.startWithToken(
  token,

  // This means you can trigger it via taking a screenshot.
  Instabug.invocationEventScreenshot,
);

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
