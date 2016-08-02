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
 * Created by kenneth on 2/08/16.
 */
public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;

    public MascotaAdapter(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.imFoto.setImageResource(mascota.getFoto());
        holder.tvName.setText(mascota.getName());
        holder.tvRating.setText("" + mascota.getRating());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imFoto;
        private TextView tvName;
        private TextView tvRating;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imFoto = (ImageView) itemView.findViewById(R.id.imFoto);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvRating = (TextView) itemView.findViewById(R.id.tvRating);
        }

    }
}
