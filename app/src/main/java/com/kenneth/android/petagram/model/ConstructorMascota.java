package com.kenneth.android.petagram.model;

import android.content.ContentValues;
import android.content.Context;

import com.kenneth.android.petagram.R;
import com.kenneth.android.petagram.database.BaseDatos;
import com.kenneth.android.petagram.database.Constantes;

import java.util.ArrayList;

/**
 * Created by kenneth on 20/08/16.
 */
public class ConstructorMascota {

    private Context context;

    public ConstructorMascota(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerMascotas() {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerMascotas();
    }

    public void insertarMascotasDummy(BaseDatos db) {
        ContentValues values = new ContentValues();
        values.put(Constantes.TB_MASCOTA_NAME, "Aslan");
        values.put(Constantes.TB_MASCOTA_FOTO, R.drawable.puppy_husky);

        db.insertarMascota(values);

        values = new ContentValues();
        values.put(Constantes.TB_MASCOTA_NAME, "Perry");
        values.put(Constantes.TB_MASCOTA_FOTO, R.drawable.puppy_brown);

        db.insertarMascota(values);

        values = new ContentValues();
        values.put(Constantes.TB_MASCOTA_NAME, "Oso");
        values.put(Constantes.TB_MASCOTA_FOTO, R.drawable.puppy_black_white);

        db.insertarMascota(values);

        values = new ContentValues();
        values.put(Constantes.TB_MASCOTA_NAME, "Balto");
        values.put(Constantes.TB_MASCOTA_FOTO, R.drawable.puppy_wolf);

        db.insertarMascota(values);

        values = new ContentValues();
        values.put(Constantes.TB_MASCOTA_NAME, "Lambda");
        values.put(Constantes.TB_MASCOTA_FOTO, R.drawable.puppy_labrador);

        db.insertarMascota(values);

        values = new ContentValues();
        values.put(Constantes.TB_MASCOTA_NAME, "Daddy");
        values.put(Constantes.TB_MASCOTA_FOTO, R.drawable.puppy_pitbull);

        db.insertarMascota(values);

        values = new ContentValues();
        values.put(Constantes.TB_MASCOTA_NAME, "Pet");
        values.put(Constantes.TB_MASCOTA_FOTO, R.drawable.puppy_black_brown);

        db.insertarMascota(values);

        values = new ContentValues();
        values.put(Constantes.TB_MASCOTA_NAME, "Kyara");
        values.put(Constantes.TB_MASCOTA_FOTO, R.drawable.puppy_white);

        db.insertarMascota(values);

        values = new ContentValues();
        values.put(Constantes.TB_MASCOTA_NAME, "Tufi");
        values.put(Constantes.TB_MASCOTA_FOTO, R.drawable.puppy_bulldog);

        db.insertarMascota(values);
    }

    public void rateMascota(Mascota mascota) {
        BaseDatos db = new BaseDatos(context);
        ContentValues values = new ContentValues();
        values.put(Constantes.TB_RATES_MASCOTA_ID_MASCOTA, mascota.getId());
        values.put(Constantes.TB_RATES_MASCOTA_RATE, 1);
        db.insertarRatesMascota(values);
    }

    public int obtenerRateMascota(Mascota mascota) {
        BaseDatos bd = new BaseDatos(context);
        return bd.obtenerRateMascota(mascota);
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas() {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerMascotasFavoritas();
    }

}
