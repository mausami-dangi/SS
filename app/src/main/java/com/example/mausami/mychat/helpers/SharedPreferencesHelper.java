package com.example.mausami.mychat.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by mausami on 15/05/2018.
 */

public class SharedPreferencesHelper {
    public static String IMAGE_PATH = "IMAGE_PATH";

    private static SharedPreferences sharedPreferences = null;
    private static SharedPreferences.Editor editor = null;

    public static void initSharedPreference(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public static void putString(String key, String value, Context context){
        if (sharedPreferences == null){
            initSharedPreference(context);
        }
        editor.putString( key, value).commit();
    }

    public static String getString(String key, Context context){
        if (sharedPreferences == null){
            initSharedPreference(context);
        }
        return sharedPreferences.getString(key,"");
    }
}
