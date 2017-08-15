package com.rninstabugsdk.rninstabugsdk;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

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
import java.util.Map;

public class InstabugSDKModule extends ReactContextBaseJavaModule {

  // Invocation Events
  private final String INVOCATION_EVENT_NONE = "none";
  private final String INVOCATION_EVENT_SHAKE = "shake";
  private final String INVOCATION_EVENT_SCREENSHOT = "screenshot";
  private final String INVOCATION_EVENT_TWO_FINGERS_SWIPE = "swipe";
  private final String INVOCATION_EVENT_FLOATING_BUTTON = "button";

  // Invocation Modes
  private final String INVOCATION_MODE_NEW_BUG = "bug";
  private final String INVOCATION_MODE_NEW_FEATURE = "feature";

  private Context mContext;
  private Instabug mInstabug;

  public InstabugSDKModule(ReactApplicationContext reactContext, Context context) {
    super(reactContext);
    mContext = context;
  }

  @Override
  public String getName() {
    return "RNInstabugSDK";
  }

  @ReactMethod
  public void startWithToken(String token, String invocationEvent) {
    mInstabug = new Instabug.Builder((Application) mContext.getApplicationContext(), token)
      .setInvocationEvent(getInvocationEventById(invocationEvent))
      .build();
  }

  @ReactMethod
  public void invoke() {
    Handler handler = new Handler(Looper.getMainLooper());
    handler.post(new Runnable() {
      @Override
      public void run() {
        mInstabug.invoke();
      }
    });
  }

  @ReactMethod
  public void invokeWithInvocationMode(String invocationMode) {
    mInstabug.invoke(getInvocationModeById(invocationMode));
  }

  @ReactMethod
  public void dismiss() {
    mInstabug.dismiss();
  }

  @ReactMethod
  public void setIntroMessageEnabled(boolean isEnabled) {
    mInstabug.setIntroMessageEnabled(isEnabled);
  }

  @ReactMethod
  public void setUserData(String userData) {
    mInstabug.setUserData(userData);
  }

  @ReactMethod
  public void setUserEmail(String userEmail) {
    mInstabug.setUserEmail(userEmail);
  }

  @ReactMethod
  public void setUserName(String userName) {
    mInstabug.setUsername(userName);
  }

  @ReactMethod
  public void setEmailFieldRequired(boolean isRequired) {
    mInstabug.setEmailFieldRequired(isRequired);
  }

  @ReactMethod
  public void setCommentFieldRequired(boolean isRequired) {
    mInstabug.setCommentFieldRequired(isRequired);
  }

  @ReactMethod
  public void resetTags() {
    mInstabug.resetTags();
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
  }

  private InstabugInvocationMode getInvocationModeById(String invocationModeValue) {
    InstabugInvocationMode invocationMode = InstabugInvocationMode.PROMPT_OPTION;

    if (invocationModeValue.equals(INVOCATION_MODE_NEW_BUG)) {
      invocationMode = InstabugInvocationMode.NEW_BUG;
    } else if (invocationModeValue.equals(INVOCATION_MODE_NEW_FEATURE)) {
      // NOTE(mark): In this version of the SDK, feature -> feedback.
      invocationMode = InstabugInvocationMode.NEW_FEEDBACK;
    }

    return invocationMode;
  }

}
