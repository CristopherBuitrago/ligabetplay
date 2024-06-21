package com.ligabetplay;

import com.ligabetplay.model.entity.Player;
import com.ligabetplay.model.entity.Team;

public class Main {
    public static void main(String[] args) {
        Controller ctrlTeams = new Controller();
        Team equipo = new Team();
        Player jugador = new Player(1, "Cristopher", "Palomino", 17, 2, "Portero");
        
        equipo.setLstJugadores(jugador);
        equipo.setCiudad("Bucaramanga");
        equipo.setNombre("Bucaros");
        ctrlTeams.equipos.put("001", equipo);

        equipo = ctrlTeams.equipos.get("001");

        System.out.println("Mi equipo: "+equipo.getNombre());
        System.out.println("Jugador: "+equipo.getLstJugadores().get(0).getNombre());
    }
}