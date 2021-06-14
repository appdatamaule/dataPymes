package com.example.myapplication.clases;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class datoslista4 {
    private int neto,iva,ilabebidasinazucar,ilabebidaconazucar,ilavino,ilalicor,ilaharina,ilacarne,ilacerveza,ila,total;




    public datoslista4(ArrayList datos){

    }

    public int getNeto() {
        return neto;
    }
    public void setNeto(int neto) {
        this.neto = neto;
    }

    public int getIva() {
        return iva;
    }
    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getIlabebidasinazucar() {
        return ilabebidasinazucar;
    }
    public void setIlabebidasinazucar(int ilabebidasinazucar) {
        this.ilabebidasinazucar = ilabebidasinazucar;
    }

    public int getIlabebidaconazucar() {
        return ilabebidaconazucar;
    }
    public void setIlabebidaconazucar(int ilabebidaconazucar) {
        this.ilabebidaconazucar = ilabebidaconazucar;
    }

    public int getIlavino() {
        return ilavino;
    }
    public void setIlavino(int ilavino) {
        this.ilavino = ilavino;
    }

    public int getIlalicor() {
        return ilalicor;
    }
    public void setIlalicor(int ilalicor) {
        this.ilalicor = ilalicor;
    }

    public int getIlaharina() {
        return ilaharina;
    }
    public void setIlaharina(int ilaharina) {
        this.ilaharina = ilaharina;
    }

    public int getIlacarne() {
        return ilacarne;
    }
    public void setIlacarne(int ilacarne) {
        this.ilacarne = ilacarne;
    }

    public int getIlacerveza() {
        return ilacerveza;
    }
    public void setIlacerveza(int ilacerveza) {
        this.ilacerveza = ilacerveza;
    }

    public int getIla() {
        return ila;
    }
    public void setIla(int ila) {
        this.ila = ila;
    }

    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }

    public datoslista4(int neto, int iva, int ilabebidasinazucar, int ilabebidaconazucar, int ilavino, int ilalicor, int ilaharina, int ilacarne, int ilacerveza, int ila, int total) {
        this.neto = neto;
        this.iva = iva;
        this.ilabebidasinazucar = ilabebidasinazucar;
        this.ilabebidaconazucar = ilabebidaconazucar;
        this.ilavino = ilavino;
        this.ilalicor = ilalicor;
        this.ilaharina = ilaharina;
        this.ilacarne = ilacarne;
        this.ilacerveza = ilacerveza;
        this.ila = ila;
        this.total = total;
    }
}
