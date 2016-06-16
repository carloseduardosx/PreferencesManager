var PreferencesManager = function () {
};

PreferencesManager.store = function (type, key, value) {

    var logStoredValue = function (value) {
        console.log(value)
    };

    var successfully = function () {
        cordova.exec(logStoredValue, failed, "PreferencesManager", "restore", [type, key]);
    };

    var failed = function () {
        console.log("Failed");
    };
    cordova.exec(successfully, failed, "PreferencesManager", "store", [type, key, value]);
};

PreferencesManager.restore = function (type, key) {

    var successfully = function (value) {
        console.log(value)
    };

    var failed = function () {
        console.log("Failed");
    };
    cordova.exec(successfully, failed, "PreferencesManager", "restore", [type, key]);
};

PreferencesManager.remove = function (key) {

    var successfully = function () {
        console.log("Removed");
    };

    var failed = function () {
        console.log("Fail to remove preference");
    };
    cordova.exec(successfully, failed, "PreferencesManager", "remove", [key]);
};

module.exports = PreferencesManager;
