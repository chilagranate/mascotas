package com.chila.mascotas.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chila.mascotas.adapter.FotoAdaptador;
import com.chila.mascotas.pojo.Mascota;
import com.chila.mascotas.R;
import com.chila.mascotas.adapter.MascotaAdaptador;

import java.util.ArrayList;

public class PerfilFragment extends android.support.v4.app.Fragment{
    private RecyclerView listaFotos;
    ArrayList<Mascota> fotos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_perfil,container,false);


        listaFotos = v.findViewById(R.id.rvFotosSubidas);
        GridLayoutManager llm = new GridLayoutManager(getActivity(),3);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaFotos.setLayoutManager(llm);


        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador() {

        FotoAdaptador adaptador = new FotoAdaptador(fotos);
        listaFotos.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {
        fotos = new ArrayList<Mascota>();

        fotos.add(new Mascota(R.drawable.perrito, "Bobby", 5));
        fotos.add(new Mascota(R.drawable.tortuga, "Manuelita", 7));
        fotos.add(new Mascota(R.drawable.pajaro, "Birdy", 5));
        fotos.add(new Mascota(R.drawable.red_nemo, "Nemo", 2));
        fotos.add(new Mascota(R.drawable.gato, "Firulais", 3));


    }
}
