package com.kenneth.android.petagram.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.kenneth.android.petagram.R;
import com.kenneth.android.petagram.adapter.MascotaAdapter;
import com.kenneth.android.petagram.model.Mascota;
import com.kenneth.android.petagram.presenter.FavoritosActivityPresenter;
import com.kenneth.android.petagram.presenter.IFavoritosActivityPresenter;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity implements IFavoritosActivityView {

    private IFavoritosActivityPresenter presenter;
    private RecyclerView rvMascotasFav;
    private Toolbar toolbarGral;

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
        presenter = new FavoritosActivityPresenter(getBaseContext(), this);
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotasFav.setLayoutManager(linearLayoutManager);
    }

    @Override
    public MascotaAdapter crearAdapter(ArrayList<Mascota> mascotas) {
        MascotaAdapter adapter = new MascotaAdapter(mascotas, this);
        return adapter;
    }

    @Override
    public void inicializarAdapter(MascotaAdapter adapter) {
        rvMascotasFav.setAdapter(adapter);
    }

}
