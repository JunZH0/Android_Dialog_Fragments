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
import com.example.actividaduf3_5.fragments.InicioFragment;
import com.example.actividaduf3_5.fragments.JavaFragment;
import com.example.actividaduf3_5.fragments.PythonFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnDatosListener {

    public static int TAM = 24;
    InicioFragment frInicio;
    JavaFragment frJava;
    PythonFragment frPython;

    Button btnCambiarTam;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCambiarTam = findViewById(R.id.btnCambiarTam);
        btnCambiarTam.setOnClickListener(this);

        initContainer();

    }


    // Crea el menú con el layout proporcionado
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    // Inicializa el fragmento
    public void initContainer() {
        cargarFragment(new InicioFragment());
    }

    // Carga el fragmento
    private void cargarFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
    }


    // Implementa el método de la interfaz que recibe el tamaño
    @Override
    public void onAceptarDatosListener(int tam) {
        MainActivity.TAM = tam;

    }


    // elige el fragmento a cargar según la opción del menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_python  ) {
            cargarFragment(new PythonFragment());
        } else if (item.getItemId() == R.id.item_java) {
            cargarFragment(new JavaFragment());
        } else if (item.getItemId() == R.id.item_salir) {
            // Muestra el diálogo para salir
            DialogoSalir dialogoSalir = new DialogoSalir();
            dialogoSalir.setCancelable(false);
            dialogoSalir.show(getSupportFragmentManager(), "Dialogo salida");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCambiarTam) {
            // Mustra el diálogo para cambiar el tamaño
            DialogoTam dialogo = new DialogoTam();
            dialogo.setCancelable(false);
            dialogo.show(getSupportFragmentManager(), "Dialogo");
        }
    }


}