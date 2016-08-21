package com.kenneth.android.petagram.com.kenneth.android.petagram.fragment;

import com.kenneth.android.petagram.com.kenneth.android.petagram.adapter.MascotaAdapter;
import com.kenneth.android.petagram.com.kenneth.android.petagram.model.Mascota;

import java.util.ArrayList;

/**
 * Created by kenneth on 20/08/16.
 */
public interface IListadoFragmentView {

    void generarLinearLayoutVertical();

    MascotaAdapter crearAdapter(ArrayList<Mascota> mascotas);

    void inicializarAdapter(MascotaAdapter adapter);
}
