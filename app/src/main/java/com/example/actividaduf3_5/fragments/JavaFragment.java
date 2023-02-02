package com.example.actividaduf3_5.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.actividaduf3_5.MainActivity;
import com.example.actividaduf3_5.R;

public class JavaFragment extends Fragment {

    TextView tvJava;

    public JavaFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_java, container, false);
        tvJava = view.findViewById(R.id.tvJava);
        tvJava.setTextSize(TypedValue.COMPLEX_UNIT_SP, MainActivity.TAM);
        return view;
    }
}