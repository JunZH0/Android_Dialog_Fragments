package com.example.actividaduf3_5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnDatosListener {

    public static int TAM = 24;

    Button btnCambiarTam;
    InicioFragment mTextFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCambiarTam = findViewById(R.id.btnCambiarTam);
        btnCambiarTam.setOnClickListener(this);

        initContainer();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void initContainer() {
        mTextFragment = new InicioFragment();
        cargarFragment(new InicioFragment());
    }

    private void cargarFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
    }

    @Override
    public void onAceptarDatosListener(int tam) {
        MainActivity.TAM = tam;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_python  ) {
            cargarFragment(new PythonFragment());
        } else if (item.getItemId() == R.id.item_java) {
            cargarFragment(new JavaFragment());
        } else if (item.getItemId() == R.id.item_salir) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCambiarTam) {
            DatosDialogo dialogo = new DatosDialogo();
            dialogo.setCancelable(false);
            dialogo.show(getSupportFragmentManager(), "Dialogo");
        }
    }


}