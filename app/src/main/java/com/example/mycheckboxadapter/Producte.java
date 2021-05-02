package com.example.mycheckboxadapter;

public class Producte {

    private String nomProducte;
    private String descripcioProducte;
    private int quantitat = 1;
    private int foto;

    private boolean checked;

    public Producte(String nom, String descripcio, int foto) {
        this.nomProducte  = nom;
        this.descripcioProducte = descripcio;
        this.foto = foto;
    }

    public String getNomProducte() {
        return nomProducte;
    }

    public void setNomProducte(String nomProducte) {
        this.nomProducte = nomProducte;
    }

    public String getDescripcioProducte() {
        return descripcioProducte;
    }

    public void setDescripcioProducte(String descripcioProducte) {
        this.descripcioProducte = descripcioProducte;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked)     {
        this.checked = checked;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}