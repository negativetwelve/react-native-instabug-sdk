//
//  RNInstabugSDK.h
//  RNInstabugSDK
//
//  Created by Mark Miyashita on 10/11/16.
//  Copyright © 2016 Mark Miyashita. All rights reserved.
//


#if __has_include("RCTBridgeModule.h")
  #import "RCTBridgeModule.h"
  #import "RCTConvert.h"
  #import "RCTUtils.h"
#else
  #import "React/RCTBridgeModule.h"
  #import "React/RCTConvert.h"
  #import "React/RCTUtils.h"
#endif


@interface RNInstabugSDK : NSObject <RCTBridgeModule>
@end
