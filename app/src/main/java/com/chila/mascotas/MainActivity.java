package com.chila.mascotas;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.chila.mascotas.adapter.MascotaAdaptador;
import com.chila.mascotas.adapter.PageAdapter;
import com.chila.mascotas.fragment.PerfilFragment;
import com.chila.mascotas.fragment.RecyclerViewFragment;
import com.chila.mascotas.pojo.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setLogo(R.drawable.pata);
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        setUpViewPager();
        if(toolbar!=null){
            setSupportActionBar(toolbar);
        }




    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.mContacto:
                Intent intent1 = new Intent(this, Contacto.class);
                startActivity(intent1);

                finish();
                break;

            case R.id.mAcercaDe:

                break;

            case R.id.mFav:
                Intent intent = new Intent(this, FavsActivity.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<android.support.v4.app.Fragment> agregarFragments(){
        ArrayList<android.support.v4.app.Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;


    }

    public void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_tab_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_tab_profile);


    }
}
