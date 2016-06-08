var PreferencesManager = function() {
};

PreferencesManager.store = function(type, key, value) {

    var logStoredValue = function(value) {
      console.log(value)
    }

    var successfully = function () {
        cordova.exec(logStoredValue, failed, "PreferencesManager", "restore", [type, key]);
    };

    var failed = function ()  {
        console.log("Failed");
    };
    cordova.exec(successfully, failed, "PreferencesManager", "store", [type, key, value]);
};

PreferencesManager.restore = function(type, key) {

    var successfully = function (value) {
        console.log(value)
    };

    var failed = function ()  {
        console.log("Failed");
    };
    cordova.exec(successfully, failed, "PreferencesManager", "restore", [type, key]);
};

module.exports = PreferencesManager;
