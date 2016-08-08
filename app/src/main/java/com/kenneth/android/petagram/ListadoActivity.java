package com.kenneth.android.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.kenneth.android.petagram.com.kenneth.android.petagram.adapter.MascotaAdapter;
import com.kenneth.android.petagram.com.kenneth.android.petagram.model.Mascota;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
//        getActionBar().setDisplayHomeAsUpEnabled(true);

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(linearLayoutManager);

        inicializarListaMascotas();
        inicializarAdaptador();

    }

    private void inicializarListaMascotas() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.puppy_black_brown, "Puppy"));
        mascotas.add(new Mascota(R.drawable.puppy_black_white, "Perry"));
        mascotas.add(new Mascota(R.drawable.puppy_brown, "Aslan"));
        mascotas.add(new Mascota(R.drawable.puppy_bulldog, "Pet"));
        mascotas.add(new Mascota(R.drawable.puppy_husky, "Balto"));
        mascotas.add(new Mascota(R.drawable.puppy_labrador, "Lambda"));
        mascotas.add(new Mascota(R.drawable.puppy_pitbull, "Daddy"));
        mascotas.add(new Mascota(R.drawable.puppy_white, "Snow"));
        mascotas.add(new Mascota(R.drawable.puppy_wolf, "Lobo"));
    }

    private void inicializarAdaptador() {
        MascotaAdapter adapter = new MascotaAdapter(mascotas);
        rvMascotas.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones_listado, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;

        switch (item.getItemId()) {

            case R.id.action_favoritos:
                intent = new Intent(this, FavoritosActivity.class);
                startActivity(intent);
                break;

            case R.id.action_contacto:
                intent = new Intent(this, ContactoActivity.class);
                startActivity(intent);
                break;

            case R.id.action_about:
                intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
