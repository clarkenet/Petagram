package com.kenneth.android.petagram.com.kenneth.android.petagram.model;

/**
 * Created by kenneth on 2/08/16.
 */
public class Mascota {

    private int id;
    private int foto;
    private String name;
    private int rating;

    public Mascota() {
    }

    public Mascota(int foto, String name) {
        this.foto = foto;
        this.name = name;
        this.rating = 0;
    }

    public Mascota(int foto, String name, int rating) {
        this.foto = foto;
        this.name = name;
        this.rating = rating;
    }

    public Mascota(int foto, int id, String name, int rating) {
        this.foto = foto;
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
