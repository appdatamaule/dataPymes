package com.example.myapplication.clases;

public class verificadorRUT {
    int r1=3,r2=2,r3=7,r4=6,r5=5,r6=4,r7=3,r8=2;
    public verificadorRUT(){

    }
    public String calcularrut(String rut){
        int largo=rut.length();
        if(largo!=8){
            rut="0"+rut;
        }
        String[] partes=rut.split("");
        int p1=Integer.parseInt(partes[1]);
        int p2=Integer.parseInt(partes[2]);
        int p3=Integer.parseInt(partes[3]);
        int p4=Integer.parseInt(partes[4]);
        int p5=Integer.parseInt(partes[5]);
        int p6=Integer.parseInt(partes[6]);
        int p7=Integer.parseInt(partes[7]);
        int p8=Integer.parseInt(partes[8]);
        int suma=(p1*r1)+(p2*r2)+(p3*r3)+(p4*r4)+(p5*r5)+(p6*r6)+(p7*r7)+(p8*r8);
        int resto = suma % 11;
        String Digitocomprobado = String.valueOf(11 - resto);
        if (Digitocomprobado.equals("11")) {
            Digitocomprobado = "0";
        }
        if (Digitocomprobado.equals("10")) {
            Digitocomprobado = "K";
        }
        return Digitocomprobado;
    }
}
