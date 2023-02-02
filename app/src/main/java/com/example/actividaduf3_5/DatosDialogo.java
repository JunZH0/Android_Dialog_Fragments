package com.example.actividaduf3_5;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;


public class DatosDialogo extends DialogFragment {

    OnDatosListener listener;
    EditText etNum;

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
                etNum = getDialog().findViewById(R.id.etTam);
                int tam = Integer.parseInt(etNum.getText().toString());
                try {
                    if (tam > 0) {
                        Toast.makeText(getActivity(), "Tamaño cambiado a : " + tam, Toast.LENGTH_SHORT).show();
                        listener.onAceptarDatosListener(tam);
                        dialog.dismiss();
                    } else {
                        Toast.makeText(getActivity(), "El tamaño debe ser mayor que 0", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), " Introduce un número valido", Toast.LENGTH_SHORT).show();
                }
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
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDatosListener) {
            listener = (OnDatosListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnDatosListener ");
        }
    }


    @Override
    public void onDetach() {
        if (listener != null) {
            listener = null;
        }
        super.onDetach();
    }
}