package com.example.myapplication.clases;

import android.os.Parcel;
import android.os.Parcelable;

public class datoslistasucursales implements Parcelable {
    private int imagenid;
    private int id_sucursal;
    private String nombre_cliente;
    private String comuna;
    private String referencia;
    private String direccion;
    private String idcomuna;

    public datoslistasucursales(int imagenid, int id_sucursal, String nombre_cliente, String comuna, String referencia, String direccion,String idcomuna) {
        this.imagenid = imagenid;
        this.id_sucursal=id_sucursal;
        this.nombre_cliente = nombre_cliente;
        this.comuna=comuna;
        this.referencia=referencia;
        this.direccion = direccion;
        this.idcomuna=idcomuna;
    }

    protected datoslistasucursales(Parcel in) {
        imagenid = in.readInt();
        id_sucursal=in.readInt();
        nombre_cliente = in.readString();
        comuna=in.readString();
        referencia=in.readString();
        direccion = in.readString();
        idcomuna= in.readString();
    }

    public static final Creator<datoslistasucursales> CREATOR = new Creator<datoslistasucursales>() {
        @Override
        public datoslistasucursales createFromParcel(Parcel in) {
            return new datoslistasucursales(in);
        }

        @Override
        public datoslistasucursales[] newArray(int size) {
            return new datoslistasucursales[size];
        }
    };

    public int getImagenid() {
        return imagenid;
    }
    public void setImagenid(int imagenid) {
        this.imagenid = imagenid;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }
    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }
    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getComuna() {
        return comuna;
    }
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getReferencia() {
        return referencia;
    }
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdcomuna() {
        return idcomuna;
    }
    public void setIdcomuna(String idcomuna) {
        this.idcomuna = idcomuna;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagenid);
        dest.writeInt(id_sucursal);
        dest.writeString(nombre_cliente);
        dest.writeString(comuna);
        dest.writeString(referencia);
        dest.writeString(direccion);
        dest.writeString(idcomuna);
    }
}
