package com.carloseduardo.preferences.manager;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Date;

public class PreferencesImpl implements Preferences {

    private final SharedPreferences preferences;

    public PreferencesImpl(Context context) {

        String sharedPreferencesName = "globalPrefs";
        preferences = context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);
    }

    @Override
    public String getString(String key) {
        return preferences.getString(key, "");
    }

    @Override
    public int getInt(String key) {
        return preferences.getInt(key, 0);
    }

    @Override
    public long getLong(String key) {
        return preferences.getLong(key, 0);
    }

    @Override
    public float getFloat(String key) {
        return preferences.getFloat(key, 0);
    }

    @Override
    public double getDouble(String key) {
        return Double.doubleToLongBits(getLong(key));
    }

    @Override
    public boolean getBoolean(String key) {
        return preferences.getBoolean(key, false);
    }

    @Override
    public Date getDate(String key) {
        long dateInMillis = preferences.getLong(key, 0);
        return dateInMillis == 0 ? null : new Date(dateInMillis);
    }

    @Override
    public void putString(String key, String value) {
        preferences.edit().putString(key, value).apply();
    }

    @Override
    public void putInt(String key, int value) {
        preferences.edit().putInt(key, value).apply();
    }

    @Override
    public void putLong(String key, long value) {
        preferences.edit().putLong(key, value).apply();
    }

    @Override
    public void putFloat(String key, float value) {
        preferences.edit().putFloat(key, value).apply();
    }

    @Override
    public void putBoolean(String key, boolean value) {
        preferences.edit().putBoolean(key, value).apply();
    }

    @Override
    public void putDate(String key, Date date) {
        preferences.edit().putLong(key, date == null ? 0 : date.getTime()).apply();
    }

    @Override
    public void remove(String key) {
        preferences.edit().remove(key).apply();
    }
}
