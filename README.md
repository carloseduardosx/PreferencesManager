## PreferencesManager

PreferencesManager is a cordova android plugin to store some data using SharedPreferences

### How to use

#### Store data

Storing data in SharedPreferences it's very simple.
Simply call the function **store** from PreferencesManager.

```javascript
PreferencesManager.store(type, key, value);
```

#### Restore data

Restoring data from SharedPreferences is similar to **store**.
Below has a example of how to **restore** that information.

```javascript
PreferencesManager.restore(type, key);
```

#### Remove data

Remove data is pretty simple too. To remove simply call the function **remove** and pass the key do you want to remove.

```javascript
PreferencesManager.remove(key);
```

#### Supported types

Currently is supported some set of data. Below has a table of data types with respective value to pass on `functions`

Type | Type code
------------ | -------------
String | 0
Int | 1
Long | 2
Float | 3
Double | 4
Date | 5
