// Libraries
import {NativeModules, Platform} from 'react-native';

// Native Modules
const {RNInstabugSDK} = NativeModules;


// Wraps native functions so they are no-ops on android.
const noop = () => {};
const safe = (callback) => Platform.OS === 'android' ? noop : callback;
const guard = (object) => {
  const safeObject = {};

  // Copies all key/values and wraps each value inside a safe callback.
  Object.keys(object).forEach(key => safeObject[key] = safe(object[key]));

  // Returns the new cloned object.
  return safeObject;
};


const Instabug = {
  // Constants
  ...RNInstabugSDK,

  // Initialize
  startWithToken: (token, event) => RNInstabugSDK.startWithToken(token, event),
  invoke: () => RNInstabugSDK.invoke(),
  invokeWithInvocationMode: (mode) => {
    return RNInstabugSDK.invokeWithInvocationMode(mode);
  },
  dismiss: () => RNInstabugSDK.dismiss(),
  resetTags: () => RNInstabugSDK.resetTags(),

  // Settings
  setIntroMessageEnabled: (isEnabled) => {
    return RNInstabugSDK.setIntroMessageEnabled(isEnabled);
  },
  setUserData: (data) => RNInstabugSDK.setUserData(data),
  setUserEmail: (email) => RNInstabugSDK.setUserEmail(email),
  setUserName: (name) => RNInstabugSDK.setUserName(name),
  setEmailFieldRequired: (isRequired) => {
    return RNInstabugSDK.setEmailFieldRequired(isRequired);
  },
  setCommentFieldRequired: (isRequired) => {
    return RNInstabugSDK.setCommentFieldRequired(isRequired);
  },
};


export default guard(Instabug);
