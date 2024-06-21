package com.ligabetplay.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String nombre;
    private String ciudad;
    private List<Player> lstJugadores;
    private List<Doctor> lstMasajistas;
    private List<Coach> lstEntrenadores;
    
    public Team() {
        lstEntrenadores = new ArrayList<Coach>();
        lstJugadores = new ArrayList<Player>();
        lstMasajistas = new ArrayList<Doctor>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Player> getLstJugadores() {
        return lstJugadores;
    }

    public void setLstJugadores(Player jugador ) {
        this.lstJugadores.add(jugador);
    }

    public List<Doctor> getLstMasajistas() {
        return lstMasajistas;
    }

    public void setLstMasajistas(List<Doctor> lstMasajistas) {
        this.lstMasajistas = lstMasajistas;
    }

    public List<Coach> getLstEntrenadores() {
        return lstEntrenadores;
    }

    public void setLstEntrenadores(List<Coach> lstEntrenadores) {
        this.lstEntrenadores = lstEntrenadores;
    }

    

}
