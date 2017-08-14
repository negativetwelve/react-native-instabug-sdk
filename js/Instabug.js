// Libraries
import {NativeModules, Platform} from 'react-native';
import {check, defaultMessage} from 'react-native-module-check';
import Package from '../package.json';

check({
  nativeModule: NativeModules.RNInstabugSDK,
  message: Platform.select({
    default: defaultMessage({name: Package.name, repo: Package.homepage}),
    android: (
      `${Package.name} does not currently have an Android implementation. If ` +
      `you would like to contribute, please submit a PR to ${Package.homepage}.`
    ),
  }),
});

// Protects constants.
const Instabug = NativeModules.RNInstabugSDK || {};

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


export default guard({
  // Constants
  events: {
    none: Instabug.invocationEventNone,
    shake: Instabug.invocationEventShake,
    screenshot: Instabug.invocationEventScreenshot,
    twoFingersSwipeLeft: Instabug.invocationEventTwoFingersSwipeLeft,
    rightEdgePan: Instabug.invocationEventRightEdgePan,
    floatingButton: Instabug.invocationEventFloatingButton,
  },

  modes: {
    NA: Instabug.invocationModeNA,
    newBug: Instabug.invocationModeNewBug,
    newFeature: Instabug.invocationModeNewFeature,
  },

  // Initialize
  startWithToken: (token, event) => Instabug.startWithToken(token, event),
  invoke: () => Instabug.invoke(),
  invokeWithInvocationMode: (mode) => Instabug.invokeWithInvocationMode(mode),
  dismiss: () => Instabug.dismiss(),
  resetTags: () => Instabug.resetTags(),

  // Settings
  setIntroMessageEnabled: (isEnabled) => Instabug.setIntroMessageEnabled(isEnabled),
  setUserData: (data) => Instabug.setUserData(data),
  setUserEmail: (email) => Instabug.setUserEmail(email),
  setUserName: (name) => Instabug.setUserName(name),
  setEmailFieldRequired: (isRequired) => Instabug.setEmailFieldRequired(isRequired),
  setCommentFieldRequired: (isRequired) => Instabug.setCommentFieldRequired(isRequired),
});
