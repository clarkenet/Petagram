package com.kenneth.android.petagram.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.kenneth.android.petagram.model.Mascota;

import java.util.ArrayList;

/**
 * Created by kenneth on 20/08/16.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, Constantes.DB_NAME, null, Constantes.DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String qMascota = "CREATE TABLE " + Constantes.TB_MASCOTA + "(" +
                Constantes.TB_MASCOTA_ID_MASCOTA + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Constantes.TB_MASCOTA_NAME + " TEXT, " +
                Constantes.TB_MASCOTA_FOTO + " INTEGER" +
                ")";

        String qRates = "CREATE TABLE " + Constantes.TB_RATES_MASCOTA + "(" +
                Constantes.TB_RATES_MASCOTA_ID_RATES_MASCOTA + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Constantes.TB_RATES_MASCOTA_ID_MASCOTA + " INTEGER, " +
                Constantes.TB_RATES_MASCOTA_RATE + " INTEGER, " +
                "FOREIGN KEY (" + Constantes.TB_RATES_MASCOTA_ID_MASCOTA + ") " +
                "REFERENCES " + Constantes.TB_MASCOTA + "(" + Constantes.TB_MASCOTA_ID_MASCOTA + ")" +
                ")";

        sqLiteDatabase.execSQL(qMascota);
        sqLiteDatabase.execSQL(qRates);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Constantes.TB_MASCOTA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Constantes.TB_RATES_MASCOTA);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascota> obtenerMascotas() {

        ArrayList<Mascota> mascotas =new ArrayList<>();

        String query = "SELECT * FROM " + Constantes.TB_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor regs = db.rawQuery(query, null);

        while (regs.moveToNext()) {

            Mascota mascota = new Mascota();
            mascota.setId(regs.getInt(0));
            mascota.setName(regs.getString(1));
            mascota.setFoto(regs.getInt(2));

            String qRates = "SELECT COUNT(*) FROM " + Constantes.TB_RATES_MASCOTA + " WHERE " +
                    Constantes.TB_RATES_MASCOTA_ID_MASCOTA + " = " + mascota.getId();

            Cursor regRates = db.rawQuery(qRates, null);
            if (regRates.moveToNext()) {
                mascota.setRating(regRates.getInt(0));
            } else {
                mascota.setRating(0);
            }

            mascotas.add(mascota);

        }

        db.close();
        return mascotas;

    }

    public void insertarMascota(ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Constantes.TB_MASCOTA, null, values);
        db.close();
    }

    public void insertarRatesMascota(ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Constantes.TB_RATES_MASCOTA, null, values);
        db.close();
    }

    public int obtenerRateMascota(Mascota mascota) {

        int rate = 0;

        String query = "SELECT COUNT(*) FROM " + Constantes.TB_RATES_MASCOTA + " WHERE " +
                Constantes.TB_RATES_MASCOTA_ID_MASCOTA + " = " + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor reg = db.rawQuery(query, null);

        if (reg.moveToNext()) {
            rate = reg.getInt(0);
        }

        db.close();
        return rate;

    }

    public ArrayList<Mascota> obtenerMascotasFavoritas() {

        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT DISTINCT " +
                Constantes.TB_MASCOTA + "." + Constantes.TB_MASCOTA_ID_MASCOTA + ", " +
                Constantes.TB_MASCOTA + "." + Constantes.TB_MASCOTA_NAME + ", " +
                Constantes.TB_MASCOTA + "." + Constantes.TB_MASCOTA_FOTO + ", " +
                Constantes.TB_RATES_MASCOTA + "." + Constantes.TB_RATES_MASCOTA_RATE +
                " FROM " + Constantes.TB_MASCOTA +
                " JOIN " + Constantes.TB_RATES_MASCOTA + " ON " +
                Constantes.TB_MASCOTA + "." + Constantes.TB_MASCOTA_ID_MASCOTA + " = " +
                Constantes.TB_RATES_MASCOTA + "." + Constantes.TB_RATES_MASCOTA_ID_MASCOTA +
                " ORDER BY " + Constantes.TB_MASCOTA + "." + Constantes.TB_MASCOTA_ID_MASCOTA +
//                " GROUP BY " + Constantes.TB_MASCOTA + "." + Constantes.TB_MASCOTA_ID_MASCOTA +
                " LIMIT 5";

        Log.i("Mascotas Favoritas: ", query);

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor regs = db.rawQuery(query, null);

        while (regs.moveToNext()) {
            Mascota mascota = new Mascota();
            mascota.setId(regs.getInt(0));
            mascota.setName(regs.getString(1));
            mascota.setFoto(regs.getInt(2));

            String qRates = "SELECT COUNT(*) FROM " + Constantes.TB_RATES_MASCOTA + " WHERE " +
                    Constantes.TB_RATES_MASCOTA_ID_MASCOTA + " = " + mascota.getId();

            Cursor regRates = db.rawQuery(qRates, null);
            if (regRates.moveToNext()) {
                mascota.setRating(regRates.getInt(0));
            } else {
                mascota.setRating(0);
            }

            mascotas.add(mascota);
        }

        db.close();
        return mascotas;
    }

}
