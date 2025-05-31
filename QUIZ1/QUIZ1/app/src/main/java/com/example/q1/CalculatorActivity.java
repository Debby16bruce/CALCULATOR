package com.example.q1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.q1.R;

public class CalculatorActivity extends AppCompatActivity {

    private EditText editTextNumber1, editTextNumber2;
    private TextView textViewResult;
    private Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonReturnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        textViewResult = findViewById(R.id.textViewResult);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonReturnHome = findViewById(R.id.buttonReturnHome);

        buttonAdd.setOnClickListener(view -> performOperation("add"));
        buttonSubtract.setOnClickListener(view -> performOperation("subtract"));
        buttonMultiply.setOnClickListener(view -> performOperation("multiply"));
        buttonDivide.setOnClickListener(view -> performOperation("divide"));

        buttonReturnHome.setOnClickListener(view -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", textViewResult.getText().toString().replace("Result: ", ""));
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }

    private void performOperation(String operation) {
        String number1Str = editTextNumber1.getText().toString();
        String number2Str = editTextNumber2.getText().toString();

        if (number1Str.isEmpty() || number2Str.isEmpty()) {
            textViewResult.setText("Result: Please enter both numbers");
            return;
        }

        double number1 = Double.parseDouble(number1Str);
        double number2 = Double.parseDouble(number2Str);
        double result = 0;

        switch (operation) {
            case "add":
                result = number1 + number2;
                break;
            case "subtract":
                result = number1 - number2;
                break;
            case "multiply":
                result = number1 * number2;
                break;
            case "divide":
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    textViewResult.setText("Result: Cannot divide by zero");
                    return;
                }
                break;
        }

        textViewResult.setText("Result: " + result);
    }
}
