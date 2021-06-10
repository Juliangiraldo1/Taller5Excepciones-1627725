package com.capacitacion.excepciones.personalizadas;

public class ManejoPersonalizado extends Exception{
    Throwable causa;
    String tipoFalla;

    public ManejoPersonalizado(String message, Throwable causa) {
        super(message, causa);
        this.causa = causa;
        this.tipoFalla= message;
        System.out.println("Mensaje: "+this.tipoFalla+"\n Causa: " +this.causa);
    }


}
