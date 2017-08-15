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

Run the following:

```shell
react-native link react-native-ux-cam
```

If you receive an error with RxJava similar to:

```shell
com.android.build.api.transform.TransformException: com.android.builder.packaging.DuplicateFileException: Duplicate files copied in APK META-INF/rxjava.properties
  File1: /home/adi/.gradle/caches/modules-2/files-2.1/io.reactivex/rxjava/1.1.8/f9dbae366a6a3d6b5041c5e8db0dcdfdc35c27b5/rxjava-1.1.8.jar
  File2: /home/adi/.gradle/caches/modules-2/files-2.1/io.reactivex.rxjava2/rxjava/2.0.0-RC1/3ee37bb825446a3bafac68a46f2397a8affd9b68/rxjava-2.0.0-RC1.jar
```

Then update your `app/build.gradle` file to include:

```gradle
android {
  ...

  packagingOptions {
    exclude 'META-INF/rxjava.properties'
  }
}
```

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
