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
            System.out.print("\033[H\033[2J"); 
            System.out.flush();
            System.out.println("        ______          _    ______   _                 \n"+
                               "        | ___ \\        | |   | ___ \\ | |                \n"+
                               "        | |_/ /   ___  | |_  | |_/ / | |   __ _   _   _ \n"+
                               "        | ___ \\  / _ \\ | __| |  __/  | |  / _` | | | | |\n"+
                               "        | |_/ / |  __/ | |_  | |     | | | (_| | | |_| |\n"+
                               "        \\____/   \\___|  \\__| \\_|     |_|  \\__,_|  \\__, |\n"+
                               "                                                   __/ |\n"+
                               "                                                  |___/ \n");
            System.out.println("--------------------[Seleccione una opcion]---------------------");
            System.out.println("----------------------------------------------------------------");            
            System.out.println(" [1] ->                 Entrenadores                          <-");
            System.out.println(" [2] ->                  Masajistas                           <-");
            System.out.println(" [3] ->                   Jugadores                           <-");
            System.out.println(" [4] ->                    Equipos                            <-");
            System.out.println(" [5] ->                     Salir                             <-");
            System.out.println("----------------------------------------------------------------");
            System.out.print(  "[Tu eleccion] -> ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("\033[H\033[2J"); 
                    System.out.flush(); 
                    ViewCoach vc = new ViewCoach(scanner);
                    vc.start();
                    break;
                
                case 2:
                    System.out.print("\033[H\033[2J"); 
                    System.out.flush(); 
                    ViewDoctor vd = new ViewDoctor(scanner);
                    vd.start();
                    break;
                
                case 3:
                    System.out.print("\033[H\033[2J"); 
                    System.out.flush();
                    ViewPlayer vp = new ViewPlayer(scanner);
                    vp.start();
                    break;

                case 4:
                    System.out.print("\033[H\033[2J"); 
                    System.out.flush();
                    ViewTeam vt = new ViewTeam(scanner);
                    vt.start();
                    break;

                case 5:
                    System.out.print("\033[H\033[2J"); 
                    System.out.flush();
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.print("\033[H\033[2J"); 
                    System.out.flush();
                    System.out.println("Opcion incorrecta");
                    break;

            }
        }
        
        
    }
}