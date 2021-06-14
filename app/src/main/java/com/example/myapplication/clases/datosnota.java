
package com.example.myapplication.clases;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class datosnota implements Parcelable {

    private String id;
    private String cantidad;
    private String descuento;
    private String porcentaje;
    private String neto;
    private String iva;
    private String ila;
    private String total;
    private String descproducto;



    private String precio_unitario;

    public datosnota(ArrayList datos){
    }
    public datosnota(String id,String cantidad, String porcentaje, String descuento, String neto, String iva, String ila, String total, String descproducto,String precio_unitario) {
        this.id=id;
        this.cantidad=cantidad;
        this.porcentaje = porcentaje;
        this.descuento = descuento;
        this.neto = neto;
        this.iva = iva;
        this.ila = ila;
        this.total = total;
        this.descproducto=descproducto;
        this.precio_unitario=precio_unitario;
    }

    protected datosnota(Parcel in) {
        id=in.readString();
        cantidad = in.readString();
        porcentaje = in.readString();
        descuento = in.readString();
        neto = in.readString();
        iva = in.readString();
        ila = in.readString();
        total = in.readString();
        descproducto= in.readString();
        precio_unitario=in.readString();
    }

    public static final Creator<datosnota> CREATOR = new Creator<datosnota>() {
        @Override
        public datosnota createFromParcel(Parcel in) {
            return new datosnota(in);
        }

        @Override
        public datosnota[] newArray(int size) {
            return new datosnota[size];
        }
    };

    public String getid() {
        return id;
    }
    public void setid(String id) {
        this.id = id;
    }

    public String getTextcantidad() {
        return cantidad;
    }
    public void setTextcantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getporcentaje() {
        return porcentaje;
    }
    public void setporcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getdescuento() {
        return descuento;
    }
    public void setdescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getneto() {
        return neto;
    }
    public void setneto(String neto) {
        this.neto = neto;
    }

    public String getiva() {
        return iva;
    }
    public void setiva(String iva) {
        this.iva = iva;
    }

    public String getila() {
        return ila;
    }
    public void setila(String ila) {
        this.ila= ila;
    }

    public String gettotal() {
        return total;
    }
    public void settotal(String total) {
        this.total = total;
    }

    public String getdescproducto() {
        return descproducto;
    }
    public void setdescproducto(String descproducto) {
        this.descproducto = descproducto;
    }

    public String getPrecio_unitario() {
        return precio_unitario;
    }
    public void setPrecio_unitario(String precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(cantidad);
        dest.writeString(porcentaje);
        dest.writeString(descuento);
        dest.writeString(neto);
        dest.writeString(iva);
        dest.writeString(ila);
        dest.writeString(total);
        dest.writeString(descproducto);
        dest.writeString(precio_unitario);
    }
}
