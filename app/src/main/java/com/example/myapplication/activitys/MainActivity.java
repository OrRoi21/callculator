package com.example.myapplication.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.fragments.ScienceFragment;
import com.example.myapplication.fragments.SimpleFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    static TextView textView;
    static int num1, num2;
    static char op = ' ';
    static Button b;
    static int result = 0;
    boolean isOn = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.calcView);
        textView.setText("");

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        SimpleFragment simpleFragment = new SimpleFragment();
        fragmentTransaction.add(R.id.simpleCon, simpleFragment).commit();

    }

    public static void writeNumber(View view) {
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

    public static void getOperator(View view) {
        b = (Button) view;
        op = b.getText().charAt(0);
        textView.setText("");
    }

    public static void clearTextfield(View view) {
        textView.setText("");
        op = ' ';
    }

    public static void calculate(View view) {

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

    public void loadSetFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        ScienceFragment  scienceFragment = new ScienceFragment();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.scienceCon);
        fragmentTransaction.add(R.id.scienceCon, scienceFragment);
        if(isOn == false) {
            fragmentTransaction.show(scienceFragment);
            frameLayout.setVisibility(View.VISIBLE);
        }
        else {
            fragmentTransaction.hide(scienceFragment);
            frameLayout.setVisibility(View.GONE);
        }
        fragmentTransaction.addToBackStack(null).commit();
        isOn = !isOn;
    }
}