package com.example.myapplication.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.VolumeShaper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.lang.Math;
import com.example.myapplication.R;
import com.example.myapplication.fragments.ScienceFragment;
import com.example.myapplication.fragments.SimpleFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private static TextView textView;
    private static int num1, num2;
    private static char op = ' ';
    private static Button b;
    private static int result = 0;
    private boolean isOn = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.switch1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOn = !isOn;
                loadSetFragment();
            }
        });

        textView = findViewById(R.id.calcView);
        textView.setText("");
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        SimpleFragment simpleFragment = new SimpleFragment();
        fragmentTransaction.add(R.id.simpleCon, simpleFragment);
        if(getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            ScienceFragment  scienceFragment = new ScienceFragment();
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.scienceCon);
            fragmentTransaction.add(R.id.scienceCon, scienceFragment);
            fragmentTransaction.show(scienceFragment);
            frameLayout.setVisibility(View.VISIBLE);
            isOn = !isOn;
        }
        fragmentTransaction.commit();

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
            case '^':
                result = num1 * num1;
                break;
            case 'r':
                result = (int) Math.sqrt(num1);
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
        if(isOn) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            fragmentTransaction.hide(scienceFragment);
            frameLayout.setVisibility(View.GONE);
        }
        fragmentTransaction.addToBackStack(null).commit();
    }


}