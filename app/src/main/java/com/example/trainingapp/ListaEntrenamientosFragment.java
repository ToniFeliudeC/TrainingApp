package com.example.trainingapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaEntrenamientosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class ListaEntrenamientosFragment extends Fragment {

    public interface OnEntrenamientoClickListener {
        void onEntrenamientoSelected(int position);
    }

    private OnEntrenamientoClickListener listener;

    public ListaEntrenamientosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_entrenamientos, container, false);

        List<Entrenamiento> listaEntrenamientos = new ArrayList<>();
        listaEntrenamientos.add(new Entrenamiento("Entrenamiento 1", R.drawable.logo_entrenamiento));
        listaEntrenamientos.add(new Entrenamiento("Entrenamiento 2", R.drawable.logo_entrenamiento));
        listaEntrenamientos.add(new Entrenamiento("Entrenamiento 3", R.drawable.logo_entrenamiento));
        listaEntrenamientos.add(new Entrenamiento("Entrenamiento 4", R.drawable.logo_entrenamiento));

        EntrenamientoAdapter adapter = new EntrenamientoAdapter(requireContext(), listaEntrenamientos);

        ListView listViewEntrenamientos = view.findViewById(R.id.listViewEntrenamientos);
        listViewEntrenamientos.setAdapter(adapter);

        listViewEntrenamientos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listener != null) {
                    listener.onEntrenamientoSelected(position);
                }
            }
        });

        return view;
    }

    public void setOnEntrenamientoClickListener(OnEntrenamientoClickListener listener) {
        this.listener = listener;
    }
}


