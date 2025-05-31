package com.example.q1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.q1.R;

public class ProfileActivity extends AppCompatActivity {

    private EditText editTextName;
    private Button buttonSaveName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editTextName = findViewById(R.id.editTextName);
        buttonSaveName = findViewById(R.id.buttonSaveName);

        buttonSaveName.setOnClickListener(view -> {
            String name = editTextName.getText().toString();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("name", name);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
