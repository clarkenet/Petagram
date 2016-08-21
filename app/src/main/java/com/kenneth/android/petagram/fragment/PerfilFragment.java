package com.kenneth.android.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kenneth.android.petagram.R;
import com.kenneth.android.petagram.adapter.PerfilMascotaAdapter;
import com.kenneth.android.petagram.model.Mascota;
import com.kenneth.android.petagram.utils.ListSpacingDecoration;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    RecyclerView rvPerfil;
    CircularImageView civPerfil;
    TextView tvPerfil;
//    CardView cvPerfil;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvPerfil = (RecyclerView) view.findViewById(R.id.rvPerfil);
        GridLayoutManager glm = new GridLayoutManager(getContext(), 3);
        rvPerfil.setLayoutManager(glm);
        rvPerfil.addItemDecoration(new ListSpacingDecoration(getContext(), R.dimen.rv_grid_spacing));

        inicializarMascotas();
        inicializarAdapter();

        civPerfil = (CircularImageView) view.findViewById(R.id.civPerfil);
        tvPerfil = (TextView) view.findViewById(R.id.tvPerfil);

        civPerfil.setImageResource(mascotas.get(0).getFoto());
        tvPerfil.setText(mascotas.get(0).getName());

        return view;
    }

    private void inicializarMascotas() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.puppy_husky, "Aslan", 1));
        mascotas.add(new Mascota(R.drawable.puppy_husky, "Aslan", 2));
        mascotas.add(new Mascota(R.drawable.puppy_husky, "Aslan", 4));
        mascotas.add(new Mascota(R.drawable.puppy_husky, "Aslan", 10));
        mascotas.add(new Mascota(R.drawable.puppy_husky, "Aslan", 5));
        mascotas.add(new Mascota(R.drawable.puppy_husky, "Aslan", 7));
        mascotas.add(new Mascota(R.drawable.puppy_husky, "Aslan", 9));
        mascotas.add(new Mascota(R.drawable.puppy_husky, "Aslan", 2));
        mascotas.add(new Mascota(R.drawable.puppy_husky, "Aslan", 1));
        mascotas.add(new Mascota(R.drawable.puppy_husky, "Aslan", 8));
        mascotas.add(new Mascota(R.drawable.puppy_husky, "Aslan", 4));
        mascotas.add(new Mascota(R.drawable.puppy_husky, "Aslan", 3));
    }

    private void inicializarAdapter() {
        PerfilMascotaAdapter adapter = new PerfilMascotaAdapter(mascotas);
        rvPerfil.setAdapter(adapter);
    }

}
