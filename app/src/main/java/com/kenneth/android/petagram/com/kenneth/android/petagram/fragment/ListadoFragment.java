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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListadoFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    RecyclerView rvMascotas;


    public ListadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_listado, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(linearLayoutManager);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
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

}
