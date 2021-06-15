package com.example.myapplication.clases;

import android.os.Parcel;
import android.os.Parcelable;

public class datosproductos implements Parcelable {
    private String id_producto;
    private String nombre_producto;
    private String desc;
    private double bruto;
    public datosproductos(String id_producto, String nombre_producto, String desc, double bruto) {
        this.id_producto = id_producto;
        this.nombre_producto=nombre_producto;
        this.desc = desc;
        this.bruto = bruto;
    }

    protected datosproductos(Parcel in) {
        id_producto = in.readString();
        nombre_producto=in.readString();
        desc=in.readString();
        bruto=in.readDouble();
    }

    public static final Creator<datosproductos> CREATOR = new Creator<datosproductos>() {
        @Override
        public datosproductos createFromParcel(Parcel in) {
            return new datosproductos(in);
        }

        @Override
        public datosproductos[] newArray(int size) {
            return new datosproductos[size];
        }
    };

    public String getId_producto() {
        return id_producto;
    }
    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }
    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getBruto() {
        return bruto;
    }
    public void setBruto(double bruto) {
        this.bruto = bruto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id_producto);
        dest.writeString(nombre_producto);
        dest.writeString(desc);
        dest.writeDouble(bruto);
    }
}
