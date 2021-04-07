package com.example.myapplication.fragments;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.activitys.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SimpleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SimpleFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    boolean isClicked = false;

    public SimpleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SimpleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SimpleFragment newInstance(String param1, String param2) {
        SimpleFragment fragment = new SimpleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_simple, container, false);

        view.findViewById(R.id.button0).setOnClickListener(MainActivity::writeNumber);
        view.findViewById(R.id.button1).setOnClickListener(MainActivity::writeNumber);
        view.findViewById(R.id.squareButton).setOnClickListener(MainActivity::writeNumber);
        view.findViewById(R.id.eButton).setOnClickListener(MainActivity::writeNumber);
        view.findViewById(R.id.paiButton).setOnClickListener(MainActivity::writeNumber);
        view.findViewById(R.id.button5).setOnClickListener(MainActivity::writeNumber);
        view.findViewById(R.id.button6).setOnClickListener(MainActivity::writeNumber);
        view.findViewById(R.id.button7).setOnClickListener(MainActivity::writeNumber);
        view.findViewById(R.id.button8).setOnClickListener(MainActivity::writeNumber);
        view.findViewById(R.id.button9).setOnClickListener(MainActivity::writeNumber);
        view.findViewById(R.id.plusButton).setOnClickListener(MainActivity::getOperator);
        view.findViewById(R.id.minusButton).setOnClickListener(MainActivity::getOperator);
        view.findViewById(R.id.multipleButton).setOnClickListener(MainActivity::getOperator);
        view.findViewById(R.id.divButton).setOnClickListener(MainActivity::getOperator);
        view.findViewById(R.id.equalButton).setOnClickListener(MainActivity::calculate);
        view.findViewById(R.id.clearButton).setOnClickListener(MainActivity::clearTextfield);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("result", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("result", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("result", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("result", "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("result", "onDestroy");
    }
}