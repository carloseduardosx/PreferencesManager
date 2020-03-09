package com.carloseduardo.preferences.manager;

import java.util.Date;
import java.util.Set;

public interface Preferences {

    String getString(String key);

    Set<String> getStringSet(String key);

    int getInt(String key);

    long getLong(String key);

    float getFloat(String key);

    double getDouble(String key);

    boolean getBoolean(String key);

    Date getDate(String key);

    void putString(String key, String value);

    void putStringSet(String set, Set<String> value);

    void putInt(String key, int value);

    void putLong(String key, long value);

    void putFloat(String key, float value);

    void putBoolean(String key, boolean value);

    void putDate(String key, Date date);

    void remove(String key);
}
