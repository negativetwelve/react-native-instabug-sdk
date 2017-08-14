package com.rninstabugsdk.rninstabugsdk;

import com.instabug.library.Instabug;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.Promise;

import java.util.HashMap;

public class InstabugSDKModule extends ReactContextBaseJavaModule {

  public InstabugSDKModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "RNInstabugSDK";
  }

  @ReactMethod
  public void startWithToken(String token, String invocationEvent) {
    // TODO
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

    // TODO(marK): Implement.
    return constants;
  }

}
