
#import "PreferencesManager.h"

@implementation PreferencesManager

typedef enum
{
    STRING = 0
} Type;


-(void)saveByType:(int)type :(NSString *)key :(NSString *)value{

    self.preferences = [NSUserDefaults standardUserDefaults];

    switch (type) {
        case STRING:
            [self.preferences setObject:value forKey:key];
            break;

        default:
            break;
    }

    [self.preferences synchronize];

}

-(void) store:(CDVInvokedUrlCommand *)comand{

    int type = [[comand.arguments objectAtIndex:0] intValue];
    NSString *key = [comand.arguments objectAtIndex:1];
    NSString *value = [comand.arguments objectAtIndex:2];

    [self saveByType:type :key :value];
    [self sendResultSuccess:@"Saved with success" :comand];


}

-(void) restore:(CDVInvokedUrlCommand *)comand{

    self.preferences = [NSUserDefaults standardUserDefaults];

    int type = [[comand.arguments objectAtIndex:0] intValue];
    NSString *key = [comand.arguments objectAtIndex:1];
    NSString *data = @"";

    switch (type) {
        case STRING:
            data = [self.preferences valueForKey:key];
            break;

        default:
            break;
    }

    [self sendResultSuccess:data :comand];

}

-(void) remove:(CDVInvokedUrlCommand *)comand{

    self.preferences = [NSUserDefaults standardUserDefaults];

    NSString *key = [comand.arguments objectAtIndex:0];

    [self.preferences removeObjectForKey:key];
    [self.preferences synchronize];

    [self sendResultSuccess:@"Removed with success" :comand];

}

-(void) sendResultSuccess:(NSString *) data :(CDVInvokedUrlCommand *)command{

    CDVPluginResult* result;

    result = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK
                               messageAsString:data];

    [self.commandDelegate sendPluginResult:result
                                callbackId:command.callbackId];
}

@end
