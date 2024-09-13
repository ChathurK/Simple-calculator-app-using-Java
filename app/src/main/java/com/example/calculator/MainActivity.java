package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button addButton, subtractButton, multiplyButton, divideButton, clearButton;
    EditText number1, number2;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.add_btn);
        subtractButton = findViewById(R.id.subtract_btn);
        multiplyButton = findViewById(R.id.multiply_btn);
        divideButton = findViewById(R.id.divide_btn);
        clearButton = findViewById(R.id.clear_btn);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);

        answer = findViewById(R.id.answer);

        addButton.setOnClickListener(this);
        subtractButton.setOnClickListener(this);
        multiplyButton.setOnClickListener(this);
        divideButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }

    // Get number from Text-fields and convert to int-fields
    public int getNumFromEditText(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
        Toast.makeText(this, getHint(editText), Toast.LENGTH_SHORT).show();
            return 0;
        }
        return Integer.parseInt(editText.getText().toString());
    }

    // Get hint from Text-fields
    private String getHint(EditText editText) {
        return editText.getHint().toString();
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.add_btn) {
            answer.setText(String.valueOf(getNumFromEditText(number1) + getNumFromEditText(number2)));
        }
        if (view.getId() == R.id.subtract_btn) {
            answer.setText(String.valueOf(getNumFromEditText(number1) - getNumFromEditText(number2)));
        }
        if (view.getId() == R.id.multiply_btn) {
            answer.setText(String.valueOf(getNumFromEditText(number1) * getNumFromEditText(number2)));
        }
        if (view.getId() == R.id.divide_btn) {
            if (getNumFromEditText(number2) == 0) {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                return;
            }
            answer.setText(String.valueOf((double) getNumFromEditText(number1) / getNumFromEditText(number2)));
        }
        if (view.getId() == R.id.clear_btn) {
            number1.setText("");
            number2.setText("");
            answer.setText("Answer");
        }
    }
}