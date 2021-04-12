package com.dash.multilangandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.dash.multilangandroid.utils.localstorage.LocalStorage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    Spinner spinner;
    LocalStorage localStorage;
    String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        localStorage = new LocalStorage(getApplicationContext());
        language = localStorage.getLanguage();
        List<String> languageList = new ArrayList<String>();
        languageList.add("English");
        languageList.add("Hindi");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, languageList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        if (language != null) {
            int spinnerPosition = dataAdapter.getPosition(localStorage.getLanguage());
            spinner.setSelection(spinnerPosition);
        }
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();
                // Showing selected spinner item
                //   Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

                if (language != null) {
                    language = localStorage.getLanguage();
                } else {
                    language = "en";
                }

                if (language != null && !language.equalsIgnoreCase(item)) {
                    localStorage.setLanguage(item);
                    recreate();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}