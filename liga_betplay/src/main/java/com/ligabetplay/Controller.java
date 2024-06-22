package com.ligabetplay;

import java.util.Hashtable;

import com.ligabetplay.model.entity.Coach;
import com.ligabetplay.model.entity.Doctor;
import com.ligabetplay.model.entity.Player;
import com.ligabetplay.model.entity.Team;

public class Controller {
    public Hashtable <String,Team> equipos = new Hashtable<>();
    public Hashtable <Integer,Player> jugadores = new Hashtable<>();
    public Hashtable <Integer,Doctor> masajistas = new Hashtable<>();
    public Hashtable <Integer,Coach> entrenadores = new Hashtable<>();
}
