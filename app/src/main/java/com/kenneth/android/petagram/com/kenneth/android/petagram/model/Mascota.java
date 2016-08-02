package com.kenneth.android.petagram.com.kenneth.android.petagram.model;

/**
 * Created by kenneth on 2/08/16.
 */
public class Mascota {

    private int foto;
    private String name;
    private int rating;

    public Mascota(int foto, String name) {
        this.foto = foto;
        this.name = name;
        this.rating = 0;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
