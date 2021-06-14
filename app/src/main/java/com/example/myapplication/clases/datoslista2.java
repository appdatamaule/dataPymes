package com.example.myapplication.clases;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class datoslista2 implements Parcelable {
    private int imagenid;
    private int id_venta;
    private String nombre_cliente;
    private String nombre_vendedor;
    private String fecha;
    private String total;

    public datoslista2(ArrayList datos){

    }
    public datoslista2(int imagenid,int id_venta, String nombre_cliente, String nombre_vendedor, String fecha, String total) {
        this.imagenid = imagenid;
        this.id_venta=id_venta;
        this.nombre_cliente = nombre_cliente;
        this.nombre_vendedor = nombre_vendedor;
        this.fecha=fecha;
        this.total = total;
    }

    protected datoslista2(Parcel in) {
        imagenid = in.readInt();
        id_venta = in.readInt();
        nombre_cliente = in.readString();
        nombre_vendedor = in.readString();
        fecha = in.readString();
        total = in.readString();
    }

    public static final Creator<datoslista2> CREATOR = new Creator<datoslista2>() {
        @Override
        public datoslista2 createFromParcel(Parcel in) {
            return new datoslista2(in);
        }

        @Override
        public datoslista2[] newArray(int size) {
            return new datoslista2[size];
        }
    };

    public int getImagenid() {
        return imagenid;
    }
    public void setImagenid(int imagenid) {
        this.imagenid = imagenid;
    }

    public int getId_venta() {
        return id_venta;
    }
    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }
    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getNombre_vendedor() {
        return nombre_vendedor;
    }
    public void setNombre_vendedor(String nombre_vendedor) {
        this.nombre_vendedor = nombre_vendedor;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTotal() {
        return total;
    }
    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagenid);
        dest.writeString(nombre_cliente);
        dest.writeString(nombre_vendedor);
        dest.writeString(fecha);
        dest.writeString(total);
    }
}
