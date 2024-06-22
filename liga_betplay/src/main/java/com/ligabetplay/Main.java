package com.ligabetplay;

import java.util.Scanner;

import com.ligabetplay.views.ViewCoach;
import com.ligabetplay.views.ViewDoctor;
import com.ligabetplay.views.ViewPlayer;
import com.ligabetplay.views.ViewTeam;

public class Main {
    public static void main(String[] args) {
        Controller ctrlTeams = new Controller();
        ViewTeam.controlador = ctrlTeams;
        ViewPlayer.controlador = ctrlTeams;
        ViewDoctor.controlador = ctrlTeams;
        ViewCoach.controlador = ctrlTeams;
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Entrenadores");
            System.out.println("2. Masajistas");
            System.out.println("3. Jugadores");
            System.out.println("4. Equipos");
            System.out.println("5. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    
                    break;
                
                case 2:
                    ViewDoctor vd = new ViewDoctor(scanner);
                    vd.start();
                    break;
                
                case 3:
                    ViewPlayer vp = new ViewPlayer(scanner);
                    vp.start();
                    break;

                case 4:
                    ViewTeam vt = new ViewTeam(scanner);
                    vt.start();
                    break;

                case 5:
                    scanner.close();
                    System.exit(0);
                    break;

                default:

                    break;

            }
        }
        
        
    }
}