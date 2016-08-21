package com.kenneth.android.petagram.com.kenneth.android.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kenneth.android.petagram.R;
import com.kenneth.android.petagram.com.kenneth.android.petagram.adapter.MascotaAdapter;
import com.kenneth.android.petagram.com.kenneth.android.petagram.model.Mascota;
import com.kenneth.android.petagram.com.kenneth.android.petagram.presenter.IListadoFragmentPresenter;
import com.kenneth.android.petagram.com.kenneth.android.petagram.presenter.ListadoFragmentPresenter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListadoFragment extends Fragment implements IListadoFragmentView {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IListadoFragmentPresenter presenter;

    public ListadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_listado, container, false);
        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new ListadoFragmentPresenter(getContext(), this);
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(linearLayoutManager);
    }

    @Override
    public MascotaAdapter crearAdapter(ArrayList<Mascota> mascotas) {
        MascotaAdapter adapter = new MascotaAdapter(mascotas, getActivity());
        return adapter;
    }

    @Override
    public void inicializarAdapter(MascotaAdapter adapter) {
        rvMascotas.setAdapter(adapter);
    }

}
