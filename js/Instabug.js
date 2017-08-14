// Libraries
import {NativeModules, Platform} from 'react-native';
import {check, defaultMessage} from 'react-native-module-check';
import Package from '../package.json';

// Native Modules
const {RNInstabugSDK} = NativeModules;

check({
  nativeModule: RNInstabugSDK,
  message: Platform.select({
    default: defaultMessage({name: Package.name, repo: Package.homepage}),
    android: (
      `${Package.name} does not currently have an Android implementation. If ` +
      `you would like to contribute, please submit a PR to ${Package.homepage}.`
    ),
  }),
});

// Wraps native functions so they are no-ops on android.
const noop = () => {};
const safe = (callback) => Platform.OS === 'android' ? noop : callback;
const guard = (object) => {
  const safeObject = {};

  // Copies all key/values and wraps each value inside a safe callback.
  Object.keys(object).forEach(key => {
    const value = object[key];

    if (typeof value === 'object') {
      safeObject[key] = guard(value);
    } else {
      safeObject[key] = safe(value);
    }
  });

  // Returns the new cloned object.
  return safeObject;
};


const Instabug = {
  // Constants
  events: {
    none: RNInstabugSDK.invocationEventNone,
    shake: RNInstabugSDK.invocationEventShake,
    screenshot: RNInstabugSDK.invocationEventScreenshot,
    twoFingersSwipeLeft: RNInstabugSDK.invocationEventTwoFingersSwipeLeft,
    rightEdgePan: RNInstabugSDK.invocationEventRightEdgePan,
    floatingButton: RNInstabugSDK.invocationEventFloatingButton,
  },

  modes: {
    NA: RNInstabugSDK.invocationModeNA,
    newBug: RNInstabugSDK.invocationModeNewBug,
    newFeature: RNInstabugSDK.invocationModeNewFeature,
  },

  // Initialize
  startWithToken: (token, event) => RNInstabugSDK.startWithToken(token, event),
  invoke: () => RNInstabugSDK.invoke(),
  invokeWithInvocationMode: (mode) => RNInstabugSDK.invokeWithInvocationMode(mode),
  dismiss: () => RNInstabugSDK.dismiss(),
  resetTags: () => RNInstabugSDK.resetTags(),

  // Settings
  setIntroMessageEnabled: (isEnabled) => RNInstabugSDK.setIntroMessageEnabled(isEnabled),
  setUserData: (data) => RNInstabugSDK.setUserData(data),
  setUserEmail: (email) => RNInstabugSDK.setUserEmail(email),
  setUserName: (name) => RNInstabugSDK.setUserName(name),
  setEmailFieldRequired: (isRequired) => RNInstabugSDK.setEmailFieldRequired(isRequired),
  setCommentFieldRequired: (isRequired) => RNInstabugSDK.setCommentFieldRequired(isRequired),
};


export default guard(Instabug);
