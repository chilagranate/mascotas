package com.chila.mascotas;


import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    public MascotaAdaptador (ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    ArrayList<Mascota> mascotas;
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFotoMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvName.setText(mascota.getNombre());
        mascotaViewHolder.tvRate.setText(String.valueOf(mascota.getRaiting()));

        mascotaViewHolder.imgCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.like();
                mascotaViewHolder.tvRate.setText(String.valueOf(mascota.getRaiting()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoMascota;
        private ImageView imgCV;
        private TextView tvName;
        private TextView tvRate;
        private ImageView imgCVRate;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoMascota  = itemView.findViewById(R.id.imgFotoMascota);
            imgCV           = itemView.findViewById(R.id.imgCV);
            tvName          = itemView.findViewById(R.id.tvName);
            tvRate          = itemView.findViewById(R.id.tvRate);
            imgCVRate       = itemView.findViewById(R.id.imgCVRate);

        }
    }
}
