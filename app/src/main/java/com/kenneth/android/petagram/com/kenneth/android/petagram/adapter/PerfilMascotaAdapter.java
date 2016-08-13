package com.kenneth.android.petagram.com.kenneth.android.petagram.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kenneth.android.petagram.R;
import com.kenneth.android.petagram.com.kenneth.android.petagram.model.Mascota;

import java.util.ArrayList;

/**
 * Created by kenneth on 12/08/16.
 */
public class PerfilMascotaAdapter extends RecyclerView.Adapter<PerfilMascotaAdapter.PerfilMascotaHolder> {

    ArrayList<Mascota> mascotas;

    public PerfilMascotaAdapter(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public PerfilMascotaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil_grid, parent, false);
        return new PerfilMascotaHolder(view);
    }

    @Override
    public void onBindViewHolder(PerfilMascotaHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.ivPerfilGrid.setImageResource(mascota.getFoto());
        holder.tvRaitingGrid.setText(mascota.getRating() + "");
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class PerfilMascotaHolder extends RecyclerView.ViewHolder {

        private ImageView ivPerfilGrid;
        private TextView tvRaitingGrid;

        public PerfilMascotaHolder(View itemView) {
            super(itemView);
            ivPerfilGrid = (ImageView) itemView.findViewById(R.id.ivPerfilGrid);
            tvRaitingGrid = (TextView) itemView.findViewById(R.id.tvRatingGrid);
        }

    }

}
