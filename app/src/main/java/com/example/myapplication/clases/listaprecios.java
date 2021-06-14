package com.example.myapplication.clases;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class listaprecios implements Parcelable {
    private int foto;
    private String desde;
    private String hasta;
    private String precio;
    private String info;

    public listaprecios(ArrayList datos){

    }

    public listaprecios(int foto,String precio, String desde, String hasta, String info) {
        this.foto=foto;
        this.precio =precio;
        this.desde = desde;
        this.hasta = hasta;
        this.info=info;
    }

    protected listaprecios(Parcel in) {
        foto=in.readInt();
        desde = in.readString();
        hasta = in.readString();
        precio = in.readString();
        info = in.readString();
    }

    public static final Creator<listaprecios> CREATOR = new Creator<listaprecios>() {
        @Override
        public listaprecios createFromParcel(Parcel in) {
            return new listaprecios(in);
        }

        @Override
        public listaprecios[] newArray(int size) {
            return new listaprecios[size];
        }
    };

    public int getFoto() {
        return foto;
    }
    public void setfoto(int foto) {
        this.foto = foto;
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

    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(foto);
        dest.writeString(desde);
        dest.writeString(hasta);
        dest.writeString(precio);
        dest.writeString(info);
    }
}
