// Libraries
import {NativeModules, Platform} from 'react-native';
import Package from 'react-native-package';


/**
 * Package.create handles two things:
 *
 *   1. Checks that for each platform that's `enabled`, the module is installed
 *      properly. If it's not, it logs a warning.
 *   2. Guards the module on every platform that is not `enabled`. This allows
 *      the module to exist in cross-platform code without hacks to disable it.
 *
 * You can read more about `react-native-package` here:
 * https://github.com/negativetwelve/react-native-package
 */
export default Package.create({
  json: require('../package.json'),
  nativeModule: NativeModules.RNInstabugSDK,
  enabled: Platform.select({
    ios: true,
  }),
  export: (Instabug) => ({
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
  }),
});
