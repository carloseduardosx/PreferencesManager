var PreferencesManager = function() {
};

PreferencesManager.exec = function() {

    var logRestoredValue = function(value) {
      console.log(value)
    }
    var successfully = function () {
        console.log("Success");
        cordova.exec(logRestoredValue, failed, "PreferencesManager", "restore", [2, "test"]);
    };

    var failed = function ()  {
        console.log("Failed");
    };
    cordova.exec(successfully, failed, "PreferencesManager", "store", [2, "test", 1080982423420]);
};

module.exports = PreferencesManager;
