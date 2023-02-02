package com.example.actividaduf3_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.actividaduf3_5.dialogos.DialogoSalir;
import com.example.actividaduf3_5.dialogos.DialogoTam;

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
            DialogoSalir dialogoSalir = new DialogoSalir();
            dialogoSalir.setCancelable(false);
            dialogoSalir.show(getSupportFragmentManager(), "Dialogo salida");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCambiarTam) {
            DialogoTam dialogo = new DialogoTam();
            dialogo.setCancelable(false);
            dialogo.show(getSupportFragmentManager(), "Dialogo");
        }
    }


}