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

RCT_EXPORT_METHOD(invoke) {
  [Instabug invoke];
}

@end
