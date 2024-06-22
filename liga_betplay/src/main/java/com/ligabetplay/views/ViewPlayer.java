    package com.ligabetplay.views;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Scanner;
import com.ligabetplay.Controller;
import com.ligabetplay.model.entity.Player;

public class ViewPlayer {
    public static Controller controlador;
    private Scanner scanner;

    public ViewPlayer (Scanner scanner){
        this.scanner = scanner;
    }

    public void start() {

        while (true) {
            System.out.println("1. Crear jugador");
            System.out.println("2. Actualizar jugador");
            System.out.println("3. Buscar jugador");
            System.out.println("4. Eliminar jugador");
            System.out.println("5. Listar todos los jugadores");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Player jugador = new Player();
                    int idJugador;

                    System.out.println("Ingrese el id del jugador :");
                    idJugador = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.println("Ingrese Nombre del jugador :");
                    jugador.setNombre(scanner.nextLine());

                    System.out.println("Ingrese el apellido del jugador: ");
                    jugador.setApellido(scanner.nextLine());

                    System.out.println("Ingrese la edad del jugador: ");
                    jugador.setEdad(scanner.nextInt());
                    scanner.nextLine(); // Consume newline

                    System.out.println("Ingrese la dorsal (Nro Camiseta) del jugador :");
                    jugador.setDorsal(scanner.nextInt());
                    scanner.nextLine(); // Consume newline

                    System.out.println("Ingrese la posicion del jugador :");
                    jugador.setPosicion(scanner.nextLine());

                    controlador.jugadores.put(idJugador, jugador);
                    System.out.println("Jugador agregado exitosamente!");
                    break;

                case 2:
                    Player jugadorAct = new Player();
                    int idJugador2;

                    System.out.print("Ingrese el id del jugador: ");
                    idJugador2 = scanner.nextInt();
                    scanner.nextLine(); // Consume new Line

                    System.out.println("Ingrese el nuevo nombre del jugador :");
                    jugadorAct.setNombre(scanner.nextLine());

                    System.out.println("Ingrese el nuevo apellido del jugador :");
                    jugadorAct.setApellido(scanner.nextLine());

                    System.out.println("Ingrese la nueva edad del jugador :");
                    jugadorAct.setEdad(scanner.nextInt());
                    scanner.nextLine(); // Consume new Line

                    System.out.println("Ingrese la nueva dorsal (Nro Camiseta) del jugador :");
                    jugadorAct.setDorsal(scanner.nextInt());
                    scanner.nextLine(); // Consume new Line
                    
                    System.out.println("Ingrese la nueva posicion del jugador :");
                    jugadorAct.setPosicion(scanner.nextLine());

                    controlador.jugadores.replace(idJugador2, jugadorAct);
                    break;

                case 3:
                    int idJugador3;
                    System.out.print("Ingrese el id del jugador: ");
                    idJugador3 = scanner.nextInt();
                    if (controlador.jugadores.containsKey(idJugador3)) {
                        Player jugadorEncontrado = controlador.jugadores.get(idJugador3);
                        System.out.println("Jugador: " + jugadorEncontrado.getNombre());
                    } else {
                        System.out.println("El id del jugador no existe");
                    }
                    break;
                case 4:
                    int idJugador4;
                    System.out.print("Ingrese el id del jugador que quiere eliminar: ");
                    idJugador4 = scanner.nextInt();
                    if (controlador.jugadores.containsKey(idJugador4)) {
                        controlador.jugadores.remove(idJugador4);
                        System.out.println("Jugador eliminado");
                    } else {
                        System.out.println("El id del jugador no existe");
                    }
                    break;
                case 5:
                    System.out.println("Todos los jugadores: ");
                    int i = 0;
                    for (Map.Entry<Integer, Player> entry : controlador.jugadores.entrySet()) {
                        int idsJugadores = entry.getKey();
                        Player jugadores = entry.getValue();
                        System.out.println(MessageFormat.format("Jugador {0} - Id: {1}, Nombre: {2}, Apellido: {3}, Posicion: {4}", i, idsJugadores, jugadores.getNombre(), jugadores.getApellido(), jugadores.getPosicion()));
                        i++;
                    }
                    break;
                case 6:
                    return;

                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }
        }
    }
}
