package com.ligabetplay.model.entity;

public class Coach extends Person{
    private int idFedaracion;

    public Coach(){
        super();
    }

    public Coach(int idFedaracion) {
        this.idFedaracion = idFedaracion;
    }

    public Coach(int id, String nombre, String apellido, int edad, int idFedaracion) {
        super(id, nombre, apellido, edad);
        this.idFedaracion = idFedaracion;
    }

    public int getIdFedaracion() {
        return idFedaracion;
    }

    public void setIdFedaracion(int idFedaracion) {
        this.idFedaracion = idFedaracion;
    }

    
}
