// Libraries
import {NativeModules, Platform} from 'react-native';
import {check} from 'react-native-module-check';
import {guard} from 'react-native-module-guard';
import Package from '../package.json';


// Checks that the module was installed properly. More details at:
// https://github.com/negativetwelve/react-native-module-check
check({
  name: Package.name,
  repo: Package.homepage,
  nativeModule: NativeModules.RNInstabugSDK,
  enabled: Platform.select({
    ios: true,
  }),
});


// Guards the module because right now it only works on iOS. When more
// implementations are added, enabled the platforms below. More details at:
// https://github.com/negativetwelve/react-native-module-guard
export default guard({
  name: Package.name,
  repo: Package.homepage,
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
