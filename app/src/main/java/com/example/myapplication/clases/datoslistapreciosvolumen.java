package com.example.myapplication.clases;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class datoslistapreciosvolumen {
    private String valor_precio_volumen;
    private String desde;
    private String hasta;
    private String iva;
    private String ila;
    private String preciobruto;



    public datoslistapreciosvolumen(ArrayList datos){

    }

    public datoslistapreciosvolumen(String valor_precio_volumen, String desde, String hasta,String iva,String ila,String preciobruto) {
        this.valor_precio_volumen = valor_precio_volumen;
        this.desde = desde;
        this.hasta = hasta;
        this.iva=iva;
        this.ila=ila;
        this.preciobruto=preciobruto;
    }

    public String getValor_precio_volumen() {
        return valor_precio_volumen;
    }
    public void setValor_precio_volumen(String valor_precio_volumen) {
        this.valor_precio_volumen = valor_precio_volumen;
    }

    public String getDesde() {
        return desde;
    }
    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }
    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public String getIva() {
        return iva;
    }
    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getIla() {
        return ila;
    }
    public void setIla(String ila) {
        this.ila = ila;
    }

    public String getPreciobruto() {
        return preciobruto;
    }
    public void setPreciobruto(String preciobruto) {
        this.preciobruto = preciobruto;
    }
}
