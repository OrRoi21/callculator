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
    int result = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.calcView);
        textView.setText("");
    }

    public void writeNumber(View view) {
        b = (Button) view;
        String value = String.valueOf(result);
        if(op == ' ' ||
                textView.getText().toString().equals("Error") ||
                    textView.getText().toString().equals(value)) {
            if(textView.getText().toString().equals("Error") ||
                    textView.getText().toString().equals(value))
                textView.setText("");
            textView.append(b.getText());
            num1 = Integer.parseInt(textView.getText().toString());
        }
        else {
            textView.append(b.getText());
            num2 = Integer.parseInt(textView.getText().toString());
        }
    }

    public void getOperator(View view) {
        b = (Button) view;
        op = b.getText().charAt(0);
        textView.setText("");
    }

    public void clearTextfield(View view) {
        textView.setText("");
        op = ' ';
    }

    public void calculate(View view) {

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
                if(num2 == 0){
                    textView.setText((String)"Error");
                    num1 = 0;
                }else
                    result = num1 / num2;
                break;
            default:
                break;

        }
        if(!textView.getText().toString().equals("Error")) {
            textView.setText(Integer.toString(result));
            num1 = result;
        }
    }
}