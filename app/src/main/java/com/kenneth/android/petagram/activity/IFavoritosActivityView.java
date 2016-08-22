package com.kenneth.android.petagram.activity;

import com.kenneth.android.petagram.adapter.MascotaAdapter;
import com.kenneth.android.petagram.model.Mascota;

import java.util.ArrayList;

/**
 * Created by kenneth on 21/08/16.
 */
public interface IFavoritosActivityView {
    void generarLinearLayoutVertical();

    MascotaAdapter crearAdapter(ArrayList<Mascota> mascotas);

    void inicializarAdapter(MascotaAdapter adapter);
}
