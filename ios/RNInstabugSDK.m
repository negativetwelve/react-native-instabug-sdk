//
//  RNInstabugSDK.m
//  RNInstabugSDK
//
//  Created by Mark Miyashita on 10/11/16.
//  Copyright © 2016 Mark Miyashita. All rights reserved.
//


#import "RNInstabugSDK.h"
#import <Instabug/Instabug.h>


@implementation RNInstabugSDK

RCT_EXPORT_MODULE();

- (dispatch_queue_t)methodQueue {
  return dispatch_get_main_queue();
}

RCT_EXPORT_METHOD(startWithToken:(NSString *)token invocationEvent:(IBGInvocationEvent)invocationEvent) {
  [Instabug startWithToken:token invocationEvent:invocationEvent];
}

RCT_EXPORT_METHOD(invoke) {
  [Instabug invoke];
}

RCT_EXPORT_METHOD(invokeWithInvocationMode:(IBGInvocationMode)invocationMode) {
  [Instabug invokeWithInvocationMode:invocationMode];
}

RCT_EXPORT_METHOD(dismiss) {
  [Instabug dismiss];
}

RCT_EXPORT_METHOD(setUserData:(NSString *)userData) {
  [Instabug setUserData:userData];
}

RCT_EXPORT_METHOD(setUserEmail:(NSString *)userEmail) {
  [Instabug setUserEmail:userEmail];
}

RCT_EXPORT_METHOD(setUserName:(NSString *)userName) {
  [Instabug setUserName:userName];
}

RCT_EXPORT_METHOD(setEmailFieldRequired:(BOOL)isEmailFieldRequired) {
  [Instabug setEmailFieldRequired:isEmailFieldRequired];
}

RCT_EXPORT_METHOD(setCommentFieldRequired:(BOOL)isCommentFieldRequired) {
  [Instabug setCommentFieldRequired:isCommentFieldRequired];
}

RCT_EXPORT_METHOD(resetTags) {
  [Instabug resetTags];
}

- (NSDictionary *)constantsToExport {
  return @{
    @"invocationEventNone" : @(IBGInvocationEventNone),
    @"invocationEventShake" : @(IBGInvocationEventShake),
    @"invocationEventScreenshot" : @(IBGInvocationEventScreenshot),
    @"invocationEventTwoFingersSwipeLeft": @(IBGInvocationEventTwoFingersSwipeLeft),
    @"invocationEventRightEdgePan": @(IBGInvocationEventRightEdgePan),
    @"invocationEventFloatingButton": @(IBGInvocationEventFloatingButton),

    @"invocationModeNA": @(IBGInvocationModeNA),
  };
}

@end
