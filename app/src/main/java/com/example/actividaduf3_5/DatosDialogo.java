package com.example.actividaduf3_5;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;


public class DatosDialogo extends DialogFragment {

    OnDatosListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Construir el dialogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Obtenemos el inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        // le asignamos el layout que hemos definido
        builder.setView(inflater.inflate(R.layout.dialogo_datos, null));

        builder.setMessage("Indicar tamaño");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getActivity(), "Tamaño: ", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                listener.onAceptarDatosListener(24);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return builder.create();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnDatosListener) {
            listener = (OnDatosListener) activity;
        } else {
            throw new RuntimeException(activity.toString()
                    + " must implement OnDatosListener ");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}