package com.kenneth.android.petagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kenneth.android.petagram.R;
import com.kenneth.android.petagram.model.Mascota;

import java.util.ArrayList;

/**
 * Created by kenneth on 2/08/16.
 */
public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imFoto.setImageResource(mascota.getFoto());
        holder.tvName.setText(mascota.getName());
        holder.tvRating.setText("" + mascota.getRating());

        holder.btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mascota.setRating(mascota.getRating()+1);
                holder.tvRating.setText("" + mascota.getRating());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imFoto;
        private TextView tvName;
        private TextView tvRating;
        private ImageView btnRating;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imFoto = (ImageView) itemView.findViewById(R.id.imFoto);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvRating = (TextView) itemView.findViewById(R.id.tvRating);
            btnRating = (ImageView) itemView.findViewById(R.id.btnRating);
        }

    }
}
