package com.example.trainingapp;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetalleEntrenamientoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetalleEntrenamientoFragment extends Fragment {

    public DetalleEntrenamientoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_entrenamiento, container, false);

        Bundle args = getArguments();
        if (args != null) {
            String nombre = args.getString("nombre");
            int logoResId = args.getInt("logoResId");

            actualizarInterfazUsuario(nombre, logoResId, view);
        }

        return view;
    }

    private void actualizarInterfazUsuario(String nombre, int logoResId, View view) {
        TextView textViewNombre = view.findViewById(R.id.textNombre);
        ImageView imageViewLogo = view.findViewById(R.id.imageLogo);



        textViewNombre.setText(nombre);
        imageViewLogo.setImageResource(logoResId);
    }
}
