#import <Cordova/CDVPlugin.h>

@interface PreferencesManager : CDVPlugin

@property NSUserDefaults *preferences;

-(void)saveByType:(int)type :(NSString *)key :(NSString *)value;
-(void) store:(CDVInvokedUrlCommand *)comand;
-(void) restore:(CDVInvokedUrlCommand *)comand;
-(void) remove:(CDVInvokedUrlCommand *)comand;
-(void) sendResultSuccess:(NSString *) data :(CDVInvokedUrlCommand *)command;

@end
