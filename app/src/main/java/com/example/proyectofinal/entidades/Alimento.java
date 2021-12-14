package com.example.proyectofinal.entidades;

import java.io.Serializable;

/**
 * Created by CHENAO on 17/06/2017.
 */

public class Alimento implements Serializable {

    private String idDuenio;
    private String idMascota;
    private String nombreMascota;
    private String raza;

    public Alimento(){

    }

    public Alimento(String idDuenio, String idMascota, String nombreMascota, String raza) {
        this.idDuenio = idDuenio;
        this.idMascota = idMascota;
        this.nombreMascota = nombreMascota;
        this.raza = raza;
    }

    public String getIdDuenio() {
        return idDuenio;
    }

    public void setIdDuenio(String idDuenio) {
        this.idDuenio = idDuenio;
    }

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}
