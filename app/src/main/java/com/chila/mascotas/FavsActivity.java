package com.chila.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.chila.mascotas.adapter.MascotaAdaptador;
import com.chila.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class FavsActivity extends AppCompatActivity {
    ArrayList <Mascota> mascotasFavs;
    private RecyclerView listaMascotasFavs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_favs);
        Toolbar actionBar = findViewById(R.id.MiActionBar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.drawable.pata);
        getSupportActionBar().setTitle(R.string.Favs_tittle);




        listaMascotasFavs = findViewById(R.id.rvMascotasFavs);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFavs.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();


    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotasFavs);
        listaMascotasFavs.setAdapter(adaptador);
    }

    public void inicializarListaMascotas (){
        mascotasFavs = new ArrayList<Mascota>();
        mascotasFavs.add(new Mascota(R.drawable.pajaro, "Birdy", 5));
        mascotasFavs.add(new Mascota(R.drawable.perrito, "Bobby", 5));
        mascotasFavs.add(new Mascota(R.drawable.tortuga, "Manuelita", 7));
        mascotasFavs.add(new Mascota(R.drawable.gato, "Firulais", 3));
        mascotasFavs.add(new Mascota(R.drawable.red_nemo, "Nemo", 2));


    }
}
