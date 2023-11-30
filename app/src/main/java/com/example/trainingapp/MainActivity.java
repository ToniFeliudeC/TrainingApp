package com.example.trainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListaEntrenamientosFragment.OnEntrenamientoClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            ListaEntrenamientosFragment listaFragment = new ListaEntrenamientosFragment();
            listaFragment.setOnEntrenamientoClickListener(this);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentListContainer, listaFragment)
                    .commit();
        }

    }

    @Override
    public void onEntrenamientoSelected(int position) {
        Entrenamiento entrenamientoSeleccionado = obtenerEntrenamientoDesdePosicion(position);

        DetalleEntrenamientoFragment detalleFragment = new DetalleEntrenamientoFragment();
        Bundle args = new Bundle();
        args.putString("nombre", entrenamientoSeleccionado.getNombre());
        args.putInt("logoResId", entrenamientoSeleccionado.getLogoResId());
        detalleFragment.setArguments(args);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentDetailContainer, detalleFragment)
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentListContainer, detalleFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

    private Entrenamiento obtenerEntrenamientoDesdePosicion(int position) {
        List<Entrenamiento> listaEntrenamientos = obtenerListaEntrenamientos();
        return listaEntrenamientos.get(position);
    }

    private List<Entrenamiento> obtenerListaEntrenamientos() {
        List<Entrenamiento> listaEntrenamientos = new ArrayList<>();

        listaEntrenamientos.add(new Entrenamiento("Entrenamiento 1", R.drawable.logo_entrenamiento));
        listaEntrenamientos.add(new Entrenamiento("Entrenamiento 2", R.drawable.logo_entrenamiento));
        listaEntrenamientos.add(new Entrenamiento("Entrenamiento 3", R.drawable.logo_entrenamiento));
        listaEntrenamientos.add(new Entrenamiento("Entrenamiento 4", R.drawable.logo_entrenamiento));

        return listaEntrenamientos;
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_horizontal);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentListContainer, new ListaEntrenamientosFragment())
                    .replace(R.id.fragmentDetailContainer, new DetalleEntrenamientoFragment())
                    .commit();
        } else {
            setContentView(R.layout.activity_main);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentListContainer, new ListaEntrenamientosFragment())
                    .commit();

            DetalleEntrenamientoFragment detalleFragment = (DetalleEntrenamientoFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDetailContainer);
            if (detalleFragment != null) {
                getSupportFragmentManager().beginTransaction().remove(detalleFragment).commit();
            }
        }
    }



}