package com.example.myapplication.clases;

import android.os.Parcel;
import android.os.Parcelable;

public class datoslistaventas implements Parcelable {
    private int imagenid;
    private int id_venta;
    private String nombre_cliente;
    private String nombre_vendedor;
    private String nombre_tipo_documento;
    private String total;
    private String fecha;

    public datoslistaventas(int imagenid, int id_venta, String nombre_cliente, String nombre_vendedor, String nombre_tipo_documento, String total,String fecha) {
        this.imagenid = imagenid;
        this.id_venta=id_venta;
        this.nombre_cliente = nombre_cliente;
        this.nombre_tipo_documento=nombre_tipo_documento;
        this.nombre_vendedor=nombre_vendedor;
        this.total = total;
        this.fecha=fecha;
    }

    protected datoslistaventas(Parcel in) {
        imagenid = in.readInt();
        id_venta=in.readInt();
        nombre_cliente = in.readString();
        nombre_vendedor=in.readString();
        nombre_tipo_documento=in.readString();
        total = in.readString();
        fecha=in.readString();
    }

    public static final Creator<datoslistaventas> CREATOR = new Creator<datoslistaventas>() {
        @Override
        public datoslistaventas createFromParcel(Parcel in) {
            return new datoslistaventas(in);
        }

        @Override
        public datoslistaventas[] newArray(int size) {
            return new datoslistaventas[size];
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

    public String getNombre_tipo_documento() {
        return nombre_tipo_documento;
    }
    public void setNombre_tipo_documento(String nombre_tipo_documento) {
        this.nombre_tipo_documento = nombre_tipo_documento;
    }

    public String getTotal() {
        return total;
    }
    public void setTotal(String total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagenid);
        dest.writeInt(id_venta);
        dest.writeString(nombre_cliente);
        dest.writeString(nombre_vendedor);
        dest.writeString(nombre_tipo_documento);
        dest.writeString(total);
        dest.writeString(fecha);
    }
}
