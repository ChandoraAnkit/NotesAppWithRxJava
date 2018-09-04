package com.chandora.androidy.notesappwithrxjava.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Defines to store and retrieve api key that needs to be sent to every http call.
 */
public class PrefUtils {

    public PrefUtils() {
    }

    private static SharedPreferences getSharedPreference(Context context) {
        return context.getSharedPreferences("APP_PREF", Context.MODE_PRIVATE);
    }

    /**
     * Defines to store api key to SharedPreference.
     * @param context
     * @param apiKey
     */
    public static void storeApiKey(Context context, String apiKey) {

        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString("API_KEY", apiKey);
        editor.commit();
    }

    /**
     * Defines to return api key from Shared Preference.
     * @param context
     * @return apiKey.
     */
    public static String getApiKey(Context context) {
        return getSharedPreference(context).getString("API_KEY", null);
    }
}
