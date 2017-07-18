//
//  RCTConvert+IBGEnums.m
//  RNInstabug
//
//  Created by Mark Miyashita on 10/12/16.
//  Copyright © 2016 Mark Miyashita. All rights reserved.
//


#import "RCTConvert+IBGEnums.h"
#import "IBGEnums.h"


@implementation RCTConvert (IBGEnums)

RCT_ENUM_CONVERTER(IBGInvocationEvent, (@{
  @"invocationEventNone": @(IBGInvocationEventNone),
  @"invocationEventShake": @(IBGInvocationEventShake),
  @"invocationEventScreenshot": @(IBGInvocationEventScreenshot),
  @"invocationEventTwoFingersSwipeLeft": @(IBGInvocationEventTwoFingersSwipeLeft),
  @"invocationEventRightEdgePan": @(IBGInvocationEventRightEdgePan),
  @"invocationEventFloatingButton": @(IBGInvocationEventFloatingButton)
}), IBGInvocationEventNone, integerValue);

RCT_ENUM_CONVERTER(IBGInvocationMode, (@{
  @"invocationModeNA": @(IBGInvocationModeNA),
  @"invocationModeNewBug": @(IBGInvocationModeBugReporter),
  @"invocationModeNewFeedback": @(IBGInvocationModeFeedbackSender),
}), IBGInvocationModeNA, integerValue);

RCT_ENUM_CONVERTER(IBGIssueState, (@{
  @"dismissTypeSubmit": @(IBGIssueSubmitted),
  @"dismissTypeCancel": @(IBGIssueCancelled),
  @"dismissTypeAddAtttachment": @(IBGIssueInProgress)
}), IBGIssueSubmitted, integerValue)

RCT_ENUM_CONVERTER(IBGFeedbackType, (@{
  @"reportTypeBug": @(IBGFeedbackTypeBug),
  @"reportTypeFeedback": @(IBGFeedbackTypeFeedback)
}), IBGFeedbackTypeBug, integerValue);

RCT_ENUM_CONVERTER(CGRectEdge, (@{
  @"rectMinXEdge": @(CGRectMinXEdge),
  @"rectMinYEdge": @(CGRectMinYEdge),
  @"rectMaxXEdge": @(CGRectMaxXEdge),
  @"rectMaxYEdge": @(CGRectMaxYEdge)
}), CGRectMinXEdge, unsignedIntegerValue);

RCT_ENUM_CONVERTER(IBGLocale, (@{
  @"localeArabic": @(IBGLocaleArabic),
  @"localeChineseSimplified": @(IBGLocaleChineseSimplified),
  @"localeChineseTraditional": @(IBGLocaleChineseTraditional),
  @"localeCzech": @(IBGLocaleCzech),
  @"localeDanish": @(IBGLocaleDanish),
  @"localeEnglish": @(IBGLocaleEnglish),
  @"localeFrench": @(IBGLocaleFrench),
  @"localeGerman": @(IBGLocaleGerman),
  @"localeItalian": @(IBGLocaleItalian),
  @"localeJapanese": @(IBGLocaleJapanese),
  @"localeKorean": @(IBGLocaleKorean),
  @"localePolish": @(IBGLocalePolish),
  @"localePortugueseBrazil": @(IBGLocalePortugueseBrazil),
  @"localeRussian": @(IBGLocaleRussian),
  @"localeSpanish": @(IBGLocaleSpanish),
  @"localeSwedish": @(IBGLocaleSwedish),
  @"localeTurkish": @(IBGLocaleTurkish)
}), IBGLocaleEnglish, integerValue);

RCT_ENUM_CONVERTER(IBGColorTheme, (@{
  @"colorThemeLight": @(IBGColorThemeLight),
  @"colorThemeDark": @(IBGColorThemeDark)
}), IBGColorThemeLight, integerValue);

@end
