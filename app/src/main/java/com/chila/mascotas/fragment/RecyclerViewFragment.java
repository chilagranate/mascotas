package com.chila.mascotas.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chila.mascotas.pojo.Mascota;
import com.chila.mascotas.R;
import com.chila.mascotas.adapter.MascotaAdaptador;

import java.util.ArrayList;

public class RecyclerViewFragment extends android.support.v4.app.Fragment{
    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);
        listaMascotas = v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);


        inicializarListaMascotas();
        inicializarAdaptador();
        return v;
    }

    public void inicializarAdaptador() {

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.perrito, "Bobby", 5));

        mascotas.add(new Mascota(R.drawable.tortuga, "Manuelita", 7));
        mascotas.add(new Mascota(R.drawable.pajaro, "Birdy", 5));
        mascotas.add(new Mascota(R.drawable.red_nemo, "Nemo", 2));
        mascotas.add(new Mascota(R.drawable.gato, "Firulais", 3));


    }
}
