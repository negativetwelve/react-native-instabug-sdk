package com.rninstabugsdk.rninstabugsdk;

import com.instabug.library.Instabug;
import com.instabug.library.invocation.InstabugInvocationEvent;
import com.instabug.library.invocation.InstabugInvocationMode;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.Promise;

import java.util.HashMap;

public class InstabugSDKModule extends ReactContextBaseJavaModule {

  // Invocation Events
  private final String INVOCATION_EVENT_NONE = "none";
  private final String INVOCATION_EVENT_SHAKE = "shake";
  private final String INVOCATION_EVENT_SCREENSHOT = "screenshot";
  private final String INVOCATION_EVENT_TWO_FINGERS_SWIPE = "swipe";
  private final String INVOCATION_EVENT_FLOATING_BUTTON = "button";

  // Invocation Modes
  // NOTE(mark): In this version of the SDK, feature -> feedback.
  private final String INVOCATION_MODE_NEW_BUG = "bug";
  private final String INVOCATION_MODE_NEW_FEATURE = "feedback";

  // Instance of the Instabug SDK object.
  private Instabug mInstabug;

  public InstabugSDKModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "RNInstabugSDK";
  }

  @ReactMethod
  public void startWithToken(String token, String invocationEvent) {
    mInstabug = new Instabug.Builder(this.androidApplication, androidToken);
    mInstabug.setIntroMessageEnabled(false)
    mInstabug.setInvocationEvent(getInvocationEventById(invocationEvent))
    mInstabug.build();
  }

  @ReactMethod
  public void invoke() {
    // TODO
  }

  @ReactMethod
  public void invokeWithInvocationMode(String invocationMode) {
    // TODO
  }

  @ReactMethod
  public void dismiss() {
    // TODO
  }

  @ReactMethod
  public void setIntroMessageEnabled(boolean isEnabled) {
    // TODO
  }

  @ReactMethod
  public void setUserData(String userData) {
    // TODO
  }

  @ReactMethod
  public void setUserEmail(String userName) {
    // TODO
  }

  @ReactMethod
  public void setEmailFieldRequired(boolean isRequired) {
    // TODO
  }

  @ReactMethod
  public void setCommentFieldRequired(boolean isRequired) {
    // TODO
  }

  @ReactMethod
  public void resetTags() {
    // TODO
  }

  @Override
  public Map<String, Object> getConstants() {
    final Map<String, Object> constants = new HashMap<>();

    // Invocation Events
    // TODO(mark): iOS has invocationEventRightEdgePan which Android doesn't
    // have.
    constants.put("invocationEventNone", INVOCATION_EVENT_NONE);
    constants.put("invocationEventShake", INVOCATION_EVENT_SHAKE);
    constants.put("invocationEventScreenshot", INVOCATION_EVENT_SCREENSHOT);
    constants.put("invocationEventTwoFingersSwipe", INVOCATION_EVENT_TWO_FINGERS_SWIPE);
    constants.put("invocationEventFloatingButton", INVOCATION_EVENT_FLOATING_BUTTON);

    // Invocation Modes
    // TODO(mark): iOS has invocationModeNA which Android doesn't have.
    constants.put("invocationModeNewBug", INVOCATION_MODE_NEW_BUG);
    constants.put("invocationModeNewFeature", INVOCATION_MODE_NEW_FEATURE);

    return constants;
  }

  // --------------------------------------------------
  // Private
  // --------------------------------------------------
  private InstabugInvocationEvent getInvocationEventById(String invocationEventValue) {
    InstabugInvocationEvent invocationEvent = InstabugInvocationEvent.SHAKE;
    try {
      if (invocationEventValue.equals(INVOCATION_EVENT_FLOATING_BUTTON)) {
        invocationEvent = InstabugInvocationEvent.FLOATING_BUTTON;
      } else if (invocationEventValue.equals(INVOCATION_EVENT_TWO_FINGERS_SWIPE)) {
        invocationEvent = InstabugInvocationEvent.TWO_FINGER_SWIPE_LEFT;
      } else if (invocationEventValue.equals(INVOCATION_EVENT_SHAKE)) {
        invocationEvent = InstabugInvocationEvent.SHAKE;
      } else if (invocationEventValue.equals(INVOCATION_EVENT_SCREENSHOT)) {
        invocationEvent = InstabugInvocationEvent.SCREENSHOT_GESTURE;
      } else if (invocationEventValue.equals(INVOCATION_EVENT_NONE)) {
        invocationEvent = InstabugInvocationEvent.NONE;
      }

      return invocationEvent;
    } catch (Exception e) {
      e.printStackTrace();
      return invocationEvent;
    }
  }

}
