package com.dash.multilangandroid;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import com.dash.multilangandroid.utils.localstorage.LocalStorage;

import java.util.Locale;

public class BaseActivity extends AppCompatActivity {
   LocalStorage localStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        localStorage = new LocalStorage(getApplicationContext());
        Locale locale;
        String language = localStorage.getLanguage();

        if (language == null) {
            language = "en";
            localStorage.setLanguage("English");
        } else {
            language = getLanguange(language);
        }

        //Log.e("Lan",session.getLanguage());
        locale = new Locale(language);
        Configuration config = new Configuration(getResources().getConfiguration());
        Locale.setDefault(locale);
        config.setLocale(locale);

        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }

    private String getLanguange(String item) {
        String langString = null;
        switch (item) {
            case "English":
                langString = "en";
                break;
            case "Hindi":
                langString = "hi";
                break;
            default:
                langString = null;
                break;

        }
        return langString;
    }


}
