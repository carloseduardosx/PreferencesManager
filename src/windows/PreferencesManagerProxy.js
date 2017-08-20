var PreferenceKey   = require('./PreferenceKey');

module.exports = {
    restore: function (success, fail, args) {
        var type = args[0];
        var key = args[1];
        var value = args[2];

        try{

            if (key) {

                var applicationData = Windows.Storage.ApplicationData.current;
                var localSettings = applicationData.localSettings;
                success(localSettings.values[key]);

            } else {
                fail("Not is a valid key");
            }

        } catch (e) {
            fail(e.message);
        }

    },
    store: function (success, fail, args) {
        var type = args[0];
        var key = args[1];
        var value = args[2];

        try{

            if (key) {

                var applicationData = Windows.Storage.ApplicationData.current;
                var localSettings = applicationData.localSettings;
                localSettings.values[key] = value;
                success(value);

            } else {
                fail("Not is a valid key");
            }

        } catch (e) {
            fail(e.message);
        }

    },
    remove: function (success, fail, args) {
        var type = args[0];
        var key = args[1];
        var value = args[2];

        try{

            if (key) {

                var applicationData = Windows.Storage.ApplicationData.current;
                var localSettings = applicationData.localSettings;
                localSettings.values.remove(key);
                success(value);

            } else {
                fail("Not is a valid key");
            }

        } catch (e) {
            fail(e.message);
        }
    }
}

require("cordova/exec/proxy").add("PreferencesManager", module.exports);
