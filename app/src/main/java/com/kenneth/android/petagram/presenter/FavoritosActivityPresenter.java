package com.kenneth.android.petagram.presenter;

import android.content.Context;

import com.kenneth.android.petagram.activity.IFavoritosActivityView;
import com.kenneth.android.petagram.model.ConstructorMascota;
import com.kenneth.android.petagram.model.Mascota;

import java.util.ArrayList;

/**
 * Created by kenneth on 21/08/16.
 */
public class FavoritosActivityPresenter implements IFavoritosActivityPresenter {

    private IFavoritosActivityView iFavoritosActivityView;
    private Context context;
    private ConstructorMascota constructor;
    private ArrayList<Mascota> mascotas;

    public FavoritosActivityPresenter(Context context, IFavoritosActivityView iFavoritosActivityView) {
        this.context = context;
        this.iFavoritosActivityView = iFavoritosActivityView;
        obtenerMascotasFavoritas();
    }

    @Override
    public void obtenerMascotasFavoritas() {
        constructor = new ConstructorMascota(context);
        mascotas = constructor.obtenerMascotasFavoritas();
        mostrarMascotas();
    }

    @Override
    public void mostrarMascotas() {
        iFavoritosActivityView.inicializarAdapter(iFavoritosActivityView.crearAdapter(mascotas));
        iFavoritosActivityView.generarLinearLayoutVertical();
    }
}
