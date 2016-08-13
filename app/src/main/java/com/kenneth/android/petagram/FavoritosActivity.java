package com.kenneth.android.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.kenneth.android.petagram.com.kenneth.android.petagram.adapter.MascotaAdapter;
import com.kenneth.android.petagram.com.kenneth.android.petagram.model.Mascota;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    RecyclerView rvMascotasFav;
    Toolbar toolbarGral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        toolbarGral = (Toolbar) findViewById(R.id.toolbarGral);
        if (toolbarGral != null) {
            setSupportActionBar(toolbarGral);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        rvMascotasFav = (RecyclerView) findViewById(R.id.rvMascotasFav);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotasFav.setLayoutManager(linearLayoutManager);

        inicializarListaMascotas();
        inicializarAdaptador();

    }

    private void inicializarListaMascotas() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.puppy_black_brown, "Puppy"));
        mascotas.add(new Mascota(R.drawable.puppy_bulldog, "Pet"));
        mascotas.add(new Mascota(R.drawable.puppy_husky, "Balto"));
        mascotas.add(new Mascota(R.drawable.puppy_white, "Snow"));
        mascotas.add(new Mascota(R.drawable.puppy_wolf, "Lobo"));
    }

    private void inicializarAdaptador() {
        MascotaAdapter adapter = new MascotaAdapter(mascotas);
        rvMascotasFav.setAdapter(adapter);
    }

}
