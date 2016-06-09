package com.carloseduardo.preferences.manager;

import android.support.annotation.NonNull;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.Date;

public class PreferencesManager extends CordovaPlugin {

    final int stringValue = 0;
    final int intValue = 1;
    final int longValue = 2;
    final int floatValue = 3;
    final int doubleValue = 4;
    final int booleanValue = 5;
    final int dateValue = 6;

    @Override
    public boolean execute(final String action, final JSONArray args,
                           final CallbackContext callbackContext) throws JSONException {

        final String store = "store";
        final String restore = "restore";
        final String remove = "remove";

        if (isEmpty(action) || args == null || args.length() == 0) {

            callbackContext.error(1);
            return false;
        }

        final Preferences preferences = new PreferencesImpl(cordova.getActivity());

        switch (action) {

            case store:

                return storePreference(args, preferences, callbackContext);

            case restore:

                return restorePreference(args, preferences, callbackContext);

            case remove:

                return removePreference(args, callbackContext, preferences);

            default:
                callbackContext.error(1);
                return false;
        }
    }

    private Boolean storePreference(@NonNull final JSONArray args,
                                    @NonNull final Preferences preferences,
                                    @NonNull final CallbackContext callbackContext) throws JSONException {

        int valueType = args.getInt(0);

        switch (valueType) {

            case stringValue:
                preferences.putString(args.getString(1), args.getString(2));
                break;

            case intValue:
                preferences.putInt(args.getString(1), args.getInt(2));
                break;

            case longValue:
                preferences.putLong(args.getString(1), args.getLong(2));
                break;

            case floatValue:
                preferences.putFloat(args.getString(1), (float) args.getDouble(2));
                break;

            case booleanValue:
                preferences.putBoolean(args.getString(1), args.getBoolean(2));
                break;

            case dateValue:
                preferences.putDate(args.getString(1), new Date(args.getLong(2)));
                break;

            default:
                callbackContext.error(1);
                return false;
        }
        callbackContext.success();
        return true;
    }

    private Boolean restorePreference(@NonNull final JSONArray args,
                                      @NonNull final Preferences preferences,
                                      @NonNull final CallbackContext callbackContext) throws JSONException {

        int valueType = args.getInt(0);

        switch (valueType) {

            case stringValue:

                String stringValue = preferences.getString(args.getString(1));
                callbackContext.success(stringValue);
                break;

            case intValue:

                int intValue = preferences.getInt(args.getString(1));
                callbackContext.success(String.valueOf(intValue));
                break;

            case longValue:

                long longValue = preferences.getLong(args.getString(1));
                callbackContext.success(String.valueOf(longValue));
                break;

            case floatValue:

                float floatValue = preferences.getFloat(args.getString(1));
                callbackContext.success(String.valueOf(floatValue));
                break;

            case doubleValue:

                float doubleValue = preferences.getFloat(args.getString(1));
                callbackContext.success(String.valueOf(doubleValue));
                break;

            case booleanValue:
                boolean booleanValue = preferences.getBoolean(args.getString(1));
                callbackContext.success(String.valueOf(booleanValue));
                break;

            case dateValue:

                Date date = preferences.getDate(args.getString(1));
                callbackContext.success(String.valueOf(date.getTime()));
                break;

            default:
                callbackContext.error(1);
                return false;
        }
        return true;
    }

    private boolean removePreference(@NonNull final JSONArray args,
                                     @NonNull final CallbackContext callbackContext,
                                     @NonNull final Preferences preferences) throws JSONException {

        preferences.remove(args.getString(0));
        callbackContext.success();
        return true;
    }

    private boolean isEmpty(final String value) {
        return value == null || value.trim().length() == 0;
    }
}
