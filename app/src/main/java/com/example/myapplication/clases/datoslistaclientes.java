package com.example.myapplication.clases;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class datoslistaclientes implements Parcelable {
    private int imagenid;
    private int id_cliente;
    private String nombre_cliente;
    private String comuna;
    private String rut_cliente;
    private String rut_incompleto;
    private String vigente;
    private String direccion;

    public datoslistaclientes(int imagenid, int id_cliente, String nombre_cliente,String comuna, String rut_cliente,String rut_incompleto, String vigente, String direccion) {
        this.imagenid = imagenid;
        this.id_cliente=id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.rut_incompleto=rut_incompleto;
        this.rut_cliente = rut_cliente;
        this.comuna=comuna;
        this.vigente=vigente;
        this.direccion = direccion;
    }

    protected datoslistaclientes(Parcel in) {
        imagenid = in.readInt();
        id_cliente = in.readInt();
        nombre_cliente = in.readString();
        rut_incompleto=in.readString();
        comuna=in.readString();
        rut_cliente = in.readString();
        vigente = in.readString();
        direccion = in.readString();
    }

    public static final Creator<datoslistaclientes> CREATOR = new Creator<datoslistaclientes>() {
        @Override
        public datoslistaclientes createFromParcel(Parcel in) {
            return new datoslistaclientes(in);
        }

        @Override
        public datoslistaclientes[] newArray(int size) {
            return new datoslistaclientes[size];
        }
    };

    public int getImagenid() {
        return imagenid;
    }
    public void setImagenid(int imagenid) {
        this.imagenid = imagenid;
    }

    public int getid_cliente() {
        return id_cliente;
    }
    public void setid_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getComuna() {
        return comuna;
    }
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }
    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getrut_cliente() {
        return rut_cliente;
    }
    public void setrut_cliente(String rut_cliente) {
        this.rut_cliente = rut_cliente;
    }

    public String getRut_incompleto() {
        return rut_incompleto;
    }
    public void setRut_incompleto(String rut_incompleto) {
        this.rut_incompleto = rut_incompleto;
    }

    public String getVigente() {
        return vigente;
    }
    public void setvigente(String vigente) {
        this.vigente = vigente;
    }

    public String getdireccion() {
        return direccion;
    }
    public void setdireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagenid);
        dest.writeInt(id_cliente);
        dest.writeString(nombre_cliente);
        dest.writeString(comuna);
        dest.writeString(rut_cliente);
        dest.writeString(rut_incompleto);
        dest.writeString(vigente);
        dest.writeString(direccion);
    }
}
