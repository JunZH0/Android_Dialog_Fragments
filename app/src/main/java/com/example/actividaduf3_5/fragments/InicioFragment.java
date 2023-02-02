package com.example.actividaduf3_5.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.actividaduf3_5.MainActivity;
import com.example.actividaduf3_5.R;

public class InicioFragment extends Fragment {

    TextView tv1;

    public InicioFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);
        tv1 = view.findViewById(R.id.tv1);
        tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP, MainActivity.TAM);
        return view;
    }


}
