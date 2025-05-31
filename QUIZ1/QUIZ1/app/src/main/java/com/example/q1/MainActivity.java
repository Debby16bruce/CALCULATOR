package com.example.q1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.q1.R;
import com.example.q1.ProfileActivity;
import com.example.q1.SettingsActivity;
import com.example.q1.CalculatorActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PROFILE = 1;
    private static final int REQUEST_SETTINGS = 2;
    private static final int REQUEST_CALCULATOR = 3;

    private TextView textProfileName, textSelectedTheme, textLastResult;
    private String profileName = "";
    private String selectedTheme = "Light";
    private String lastResult = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonProfile = findViewById(R.id.button_profile);
        Button buttonSettings = findViewById(R.id.button_settings);
        Button buttonCalculator = findViewById(R.id.button_calculator);
        textProfileName = findViewById(R.id.text_profile_name);
        textSelectedTheme = findViewById(R.id.text_selected_theme);
        textLastResult = findViewById(R.id.text_last_result);

        buttonProfile.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivityForResult(intent, REQUEST_PROFILE);
        });

        buttonSettings.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivityForResult(intent, REQUEST_SETTINGS);
        });

        buttonCalculator.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
            startActivityForResult(intent, REQUEST_CALCULATOR);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            switch (requestCode) {
                case REQUEST_PROFILE:
                    profileName = data.getStringExtra("name");
                    textProfileName.setText("Profile Name: " + profileName);
                    break;
                case REQUEST_SETTINGS:
                    selectedTheme = data.getStringExtra("theme");
                    textSelectedTheme.setText("Selected Theme: " + selectedTheme);
                    if ("Dark".equals(selectedTheme)) {
                        findViewById(android.R.id.content).setBackgroundColor(Color.DKGRAY);
                    } else {
                        findViewById(android.R.id.content).setBackgroundColor(Color.WHITE);
                    }
                    break;
                case REQUEST_CALCULATOR:
                    lastResult = data.getStringExtra("result");
                    textLastResult.setText("Last Result: " + lastResult);
                    break;
            }
        }
    }
}
