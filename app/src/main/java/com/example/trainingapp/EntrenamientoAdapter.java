package com.example.trainingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class EntrenamientoAdapter extends ArrayAdapter<Entrenamiento> {

    public EntrenamientoAdapter(@NonNull Context context, @NonNull List<Entrenamiento> entrenamientos) {
        super(context, 0, entrenamientos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_entrenamiento, parent, false);
        }

        Entrenamiento entrenamiento = getItem(position);

        if (entrenamiento != null) {
            ImageView imageViewLogo = convertView.findViewById(R.id.imageViewLogo);
            TextView textViewNombre = convertView.findViewById(R.id.textViewNombre);

            imageViewLogo.setImageResource(entrenamiento.getLogoResId());
            textViewNombre.setText(entrenamiento.getNombre());
        }

        return convertView;
    }
}
