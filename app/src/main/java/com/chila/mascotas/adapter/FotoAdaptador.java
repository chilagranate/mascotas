package com.chila.mascotas.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chila.mascotas.pojo.Mascota;
import com.chila.mascotas.R;

import java.util.ArrayList;

public class FotoAdaptador extends RecyclerView.Adapter<FotoAdaptador.MascotaViewHolder> {

    public FotoAdaptador (ArrayList<Mascota> fotos){
        this.fotos = fotos;
    }

    ArrayList<Mascota> fotos;
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_foto, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota foto = fotos.get(position);
        mascotaViewHolder.fotoImagen.setImageResource(foto.getFoto());
        mascotaViewHolder.fotoLike.setText(String.valueOf(foto.getRaiting()));

    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView fotoImagen;
        private TextView fotoLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            fotoImagen  = itemView.findViewById(R.id.fotoImagen);
            fotoLike           = itemView.findViewById(R.id.fotoLike);


        }
    }
}
