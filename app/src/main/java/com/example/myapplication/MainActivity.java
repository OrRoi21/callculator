package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int num1, num2;
    char op = ' ';
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.calcView);
        textView.setText("");
    }

    public void writeNumber(View view) {
        b = (Button) view;
        if(op == ' ') {
            textView.append(b.getText());
            num1 = Integer.parseInt(textView.getText().toString());
        }
        else {
            textView.setText("");
            textView.append(b.getText());
            num2 = Integer.parseInt(textView.getText().toString());
        }
    }

    public void getOperator(View view) {
        b = (Button) view;
        op = b.getText().charAt(0);
    }

    public void clearTextfield(View view) {
        textView.setText("");
        op = ' ';
    }

    public void calculate(View view) {
        int result = 0;

        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                break;

        }
        String str = Integer.toString(result);
        textView.setText(str);
        num1 = result;
    }
}