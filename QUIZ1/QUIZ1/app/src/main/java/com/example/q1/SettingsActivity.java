package com.example.q1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.q1.R;

public class SettingsActivity extends AppCompatActivity {

    private RadioGroup radioGroupTheme;
    private Button buttonSaveTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        radioGroupTheme = findViewById(R.id.radioGroupTheme);
        buttonSaveTheme = findViewById(R.id.buttonSaveTheme);

        buttonSaveTheme.setOnClickListener(view -> {
            int selectedId = radioGroupTheme.getCheckedRadioButtonId();
            String theme = selectedId == R.id.radioButtonLight ? "Light" : "Dark";
            Intent resultIntent = new Intent();
            resultIntent.putExtra("theme", theme);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
