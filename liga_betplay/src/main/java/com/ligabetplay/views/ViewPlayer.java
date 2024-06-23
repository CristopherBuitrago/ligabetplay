package com.ligabetplay.views;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.model.entity.Player;

public class ViewPlayer {
    public static Controller controlador;
    private Scanner scanner;

    public ViewPlayer(Scanner scanner) {
        this.scanner = scanner;
    }

    private void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void retardo(String mensaje, int segundos) {
        System.out.println(mensaje);
        try {
            Thread.sleep(segundos * 1000); // Convertir segundos a milisegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        limpiarPantalla();
    }

    public void start() {
        while (true) {
            limpiarPantalla();
            System.out.println("\r\n" + //
                                "          ___                               _                             \r\n" + //
                                "         |_  |                             | |                            \r\n" + //
                                "           | |  _   _    __ _    __ _    __| |   ___    _ __    ___   ___ \r\n" + //
                                "           | | | | | |  / _` |  / _` |  / _` |  / _ \\  | '__|  / _ \\ / __|\r\n" + //
                                "       /\\__/ / | |_| | | (_| | | (_| | | (_| | | (_) | | |    |  __/ \\__ \\\r\n" + //
                                "       \\____/   \\__,_|  \\__, |  \\__,_|  \\__,_|  \\___/  |_|     \\___| |___/\r\n" + //
                                "                         __/ |                                            \r\n" + //
                                "                        |___/                                             \r\n" + //
                                "");
            System.out.println("---------------------------------[Seleccione una opcion]----------------------------------");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("[1] ->                               Crear jugador                                      <-");
            System.out.println("[2] ->                             Actualizar jugador                                   <-");
            System.out.println("[3] ->                               Buscar jugador                                     <-");
            System.out.println("[4] ->                              Eliminar jugador                                    <-");
            System.out.println("[5] ->                          Listar todos los jugadores                              <-");
            System.out.println("[6] ->                                    Salir                                         <-");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.print("[Tu eleccion] -> ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    limpiarPantalla();
                    Player jugador = new Player();
                    int idJugador;

                    System.out.print("Ingrese el id del jugador :");
                    idJugador = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println();

                    System.out.print("Ingrese Nombre del jugador :");
                    jugador.setNombre(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese el apellido del jugador: ");
                    jugador.setApellido(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la edad del jugador: ");
                    jugador.setEdad(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.println();

                    System.out.print("Ingrese posicion del jugador :");
                    jugador.setPosicion(scanner.nextLine());
                    System.out.println();

                    controlador.jugadores.put(idJugador, jugador);
                    retardo("¡Jugador agregado exitosamente!", 2);
                    break;

                case 2:
                    limpiarPantalla();
                    Player jugadorAct = new Player();
                    int idJugador2;

                    System.out.print("Ingrese el id del jugador: ");
                    idJugador2 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println();

                    System.out.print("Ingrese nuevo nombre del jugador: ");
                    jugadorAct.setNombre(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese el nuevo apellido del jugador: ");
                    jugadorAct.setApellido(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la nueva edad del jugador: ");
                    jugadorAct.setEdad(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.println();

                    System.out.print("Ingrese nueva posicion del jugador: ");
                    jugadorAct.setPosicion(scanner.nextLine());
                    System.out.println();

                    controlador.jugadores.replace(idJugador2, jugadorAct);
                    retardo("¡Jugador actualizado exitosamente!", 2);
                    break;

                case 3:
                    limpiarPantalla();
                    int idJugador3;
                    System.out.print("Ingrese el id del jugador: ");
                    idJugador3 = scanner.nextInt();
                    if (controlador.jugadores.containsKey(idJugador3)) {
                        limpiarPantalla();
                        Player jugadorEncontrado = controlador.jugadores.get(idJugador3);
                        System.out.println("+------------|---------------[JUGADOR ENCONTRADO]-------------------------");
                        System.out.println("| Jugador + " + jugadorEncontrado.getNombre() + " " + jugadorEncontrado.getApellido());
                        System.out.println("+------------|-------------------------------------------------------------");
                        retardo("(Este mensaje se limpiara en 5 segundos)", 5);
                    } else {
                        limpiarPantalla();
                        retardo("Jugador no encontrado", 2);
                    }
                    break;
                case 4:
                    limpiarPantalla();
                    int idJugador4;
                    System.out.print("Ingrese el id del jugador que quiere eliminar: ");
                    idJugador4 = scanner.nextInt();
                    if (controlador.jugadores.containsKey(idJugador4)) {
                        controlador.jugadores.remove(idJugador4);
                        retardo("¡Jugador eliminado exitosamente!", 2);
                    } else {
                        retardo("Jugador no encontrado", 2);
                    }
                    break;
                case 5:
                    limpiarPantalla();
                    System.out.println("---------------------------------[JUGADORES]--------------------------------- ");
                    int i = 0;
                    for (Map.Entry<Integer, Player> entry : controlador.jugadores.entrySet()) {
                        int idsJugadores = entry.getKey();
                        Player jugadores = entry.getValue();
                        System.out.println(MessageFormat.format("| Jugador {0} | Id: {1} | Nombre: {2} | Apellido: {3} | Posicion: {4} |", i, idsJugadores, jugadores.getNombre(), jugadores.getApellido(), jugadores.getPosicion()));
                        i++;
                    }
                    retardo("Ya no hay más jugadores (Espere 10 segundos)", 10);
                    break;
                case 6:
                    return;

                default:
                    retardo("Opción incorrecta, intente de nuevo en 3 segundos", 3);
            }
        }
    }
}
