package com.example.myapplication.clases;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class datoslista implements Parcelable {
    private int imagenid;
    private int id_producto;
    private String nombre;
    private String precio;
    private String cantidad;
    private String porcentaje;
    private String descuento;
    private String neto;
    private String iva;
    private String ila;
    private String total;
    private String impuesto1;
    private String impuesto2;
    private String codigobarra;
    private String stock;
    private String descproducto;



    public datoslista(ArrayList datos){

    }
    public datoslista(int id_producto, int imagenid, String nombre, String precio, String cantidad, String porcentaje, String descuento, String neto, String iva, String ila, String total, String impuesto1, String impuesto2, String codigobarra, String stock, String descproducto) {
        this.imagenid = imagenid;
        this.id_producto=id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad=cantidad;
        this.porcentaje = porcentaje;
        this.descuento = descuento;
        this.neto = neto;
        this.iva = iva;
        this.ila = ila;
        this.total = total;
        this.impuesto1=impuesto1;
        this.impuesto2=impuesto2;
        this.codigobarra=codigobarra;
        this.stock=stock;
        this.descproducto=descproducto;
    }

    protected datoslista(Parcel in) {
        imagenid = in.readInt();
        nombre = in.readString();
        precio = in.readString();
        cantidad = in.readString();
        porcentaje = in.readString();
        descuento = in.readString();
        neto = in.readString();
        iva = in.readString();
        ila = in.readString();
        total = in.readString();
        impuesto1 = in.readString();
        impuesto2 = in.readString();
        descproducto= in.readString();
    }

    public static final Creator<datoslista> CREATOR = new Creator<datoslista>() {
        @Override
        public datoslista createFromParcel(Parcel in) {
            return new datoslista(in);
        }

        @Override
        public datoslista[] newArray(int size) {
            return new datoslista[size];
        }
    };

    public int getImagenid() {
        return imagenid;
    }
    public void setImagenid(int imagenid) {
        this.imagenid = imagenid;
    }

    public int getId_producto() {
        return id_producto;
    }
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getText1() {
        return nombre;
    }
    public void setText1(String nombre) {
        this.nombre = nombre;
    }

    public String getText2() {
        return precio;
    }
    public void setText2(String precio) {
        this.precio = precio;
    }

    public String getTextcantidad() {
        return cantidad;
    }
    public void setTextcantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getText3() {
        return porcentaje;
    }
    public void setText3(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getText4() {
        return descuento;
    }
    public void setText4(String descuento) {
        this.descuento = descuento;
    }

    public String getText5() {
        return neto;
    }
    public void setText5(String neto) {
        this.neto = neto;
    }

    public String getText6() {
        return iva;
    }
    public void setText6(String iva) {
        this.iva = iva;
    }

    public String getText7() {
        return ila;
    }
    public void setText7(String ila) {
        this.ila= ila;
    }

    public String getText8() {
        return total;
    }
    public void setText8(String total) {
        this.total = total;
    }

    public String getText9() {
        return impuesto1;
    }
    public void setText9(String impuesto1) {
        this.impuesto1 = impuesto1;
    }

    public String getText10() {
        return impuesto2;
    }
    public void setText10(String impuesto2) {
        this.impuesto2 = impuesto2;
    }

    public String getText11() {
        return codigobarra;
    }
    public void setText11(String codigobarra) {
        this.codigobarra = codigobarra;
    }

    public String getiddetallecreado() {
        return stock;
    }
    public void setText12(String stock) {
        this.stock = stock;
    }

    public String getText13() {
        return descproducto;
    }
    public void setText13(String descproducto) {
        this.descproducto = descproducto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagenid);
        dest.writeString(nombre);
        dest.writeString(precio);
        dest.writeString(cantidad);
        dest.writeString(porcentaje);
        dest.writeString(descuento);
        dest.writeString(neto);
        dest.writeString(iva);
        dest.writeString(ila);
        dest.writeString(total);
        dest.writeString(impuesto1);
        dest.writeString(impuesto2);
        dest.writeString(descproducto);
    }
}
