package com.example.myapplication.clases;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class datoslista3 implements Parcelable {
    private int imagenid;
    private String nombre_producto;
    private String base;
    private String cantidad;
    private String precio_unitario;
    private String total_producto;




    public datoslista3(ArrayList datos){

    }
    public datoslista3(int imagenid,String nombre_producto, String base, String cantidad, String precio_unitario, String total_producto) {
        this.imagenid=imagenid;
        this.nombre_producto = nombre_producto;
        this.base=base;
        this.precio_unitario = precio_unitario;
        this.total_producto = total_producto;
        this.cantidad=cantidad;
    }



    protected datoslista3(Parcel in) {
        imagenid = in.readInt();
        nombre_producto = in.readString();
        precio_unitario = in.readString();
        cantidad = in.readString();
        total_producto = in.readString();
        base = in.readString();

    }

    public static final Creator<datoslista3> CREATOR = new Creator<datoslista3>() {
        @Override
        public datoslista3 createFromParcel(Parcel in) {
            return new datoslista3(in);
        }

        @Override
        public datoslista3[] newArray(int size) {
            return new datoslista3[size];
        }
    };

    public int getImagenid() {
        return imagenid;
    }
    public void setImagenid(int imagenid) {
        this.imagenid = imagenid;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }
    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getBase() {
        return base;
    }
    public void setBase(String base) {
        this.base = base;
    }

    public String getCantidad() {
        return cantidad;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio_unitario() {
        return precio_unitario;
    }
    public void setPrecio_unitario(String precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getTotal_producto() {
        return total_producto;
    }
    public void setTotal_producto(String total_producto) {
        this.total_producto = total_producto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagenid);
        dest.writeString(nombre_producto);
        dest.writeString(precio_unitario);
        dest.writeString(cantidad);
        dest.writeString(base);
        dest.writeString(total_producto);
    }
}
