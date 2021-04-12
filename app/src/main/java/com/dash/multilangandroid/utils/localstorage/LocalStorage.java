package com.dash.multilangandroid.utils.localstorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class LocalStorage {

    private static final String KEY_LANGUAGE = "language";
    private static com.dash.multilangandroid.utils.localstorage.LocalStorage instance = null;
    SharedPreferences sharedPreferences;
    Editor editor;
    int PRIVATE_MODE = 0;
    Context _context;

    public LocalStorage(Context context) {
        sharedPreferences = context.getSharedPreferences("Preferences", 0);
    }

    public static  com.dash.multilangandroid.utils.localstorage.LocalStorage getInstance(Context context) {
        if (instance == null) {
            synchronized ( com.dash.multilangandroid.utils.localstorage.LocalStorage.class) {
                if (instance == null) {
                    instance = new  com.dash.multilangandroid.utils.localstorage.LocalStorage(context);
                }
            }
        }
        return instance;
    }


    public String getLanguage() {
        return sharedPreferences.getString(KEY_LANGUAGE, null);
    }

    public void setLanguage(String language) {
        editor = sharedPreferences.edit();
        editor.putString(KEY_LANGUAGE, language);
        editor.commit();
    }


}
