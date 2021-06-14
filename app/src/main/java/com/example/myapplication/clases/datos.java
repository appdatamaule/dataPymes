package com.example.myapplication.clases;

public class datos {
    private String id,objeto;

    public datos(String id,String objeto){
        this.id=id;
        this.objeto=objeto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }
}
