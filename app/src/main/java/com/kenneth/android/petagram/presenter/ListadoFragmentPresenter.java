package com.kenneth.android.petagram.presenter;

import android.content.Context;

import com.kenneth.android.petagram.fragment.IListadoFragmentView;
import com.kenneth.android.petagram.model.ConstructorMascota;
import com.kenneth.android.petagram.model.Mascota;

import java.util.ArrayList;

/**
 * Created by kenneth on 21/08/16.
 */
public class ListadoFragmentPresenter implements IListadoFragmentPresenter {

    private IListadoFragmentView view;
    private Context context;
    private ConstructorMascota constructor;
    private ArrayList<Mascota> mascotas;

    public ListadoFragmentPresenter(Context context, IListadoFragmentView view) {
        this.context = context;
        this.view = view;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        constructor = new ConstructorMascota(context);
        mascotas = constructor.obtenerMascotas();
        mostrarMascotas();
    }

    @Override
    public void mostrarMascotas() {
        view.inicializarAdapter(view.crearAdapter(mascotas));
        view.generarLinearLayoutVertical();
    }
}
