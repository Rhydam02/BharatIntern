package com.example.simplecalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String operand1 = "";
    private String operand2 = "";
    private String operator = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
    }

    public void numberClick(View view) {
        Button button = (Button) view;
        String number = button.getText().toString();
        resultTextView.append(number);
    }

    public void operatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        operand1 = resultTextView.getText().toString();
        resultTextView.setText("");
    }

    public void equalsClick(View view) {
        operand2 = resultTextView.getText().toString();
        double result = 0.0;

        if (!operand1.equals("") && !operand2.equals("")) {
            double num1 = Double.parseDouble(operand1);
            double num2 = Double.parseDouble(operand2);

            if (operator.equals("+")) {
                result = num1 + num2;
            } else if (operator.equals("-")) {
                result = num1 - num2;
            } else if (operator.equals("*")) {
                result = num1 * num2;
            } else if (operator.equals("/")) {
                result = num1 / num2;
            }

            resultTextView.setText(String.valueOf(result));
            operand1 = String.valueOf(result);
            operand2 = "";
            operator = "";
        }
    }

    public void clearClick(View view) {
        resultTextView.setText("");
        operand1 = "";
        operand2 = "";
        operator = "";
    }
}

