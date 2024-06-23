package com.ligabetplay.views;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.model.entity.Team;

public class ViewTeam {
    public static Controller controlador;
    private Scanner scanner;

    public ViewTeam(Scanner scanner) {
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
                                "                    _____                   _                       \r\n" + //
                                "                   |  ___|                 (_)                      \r\n" + //
                                "                   | |__     __ _   _   _   _   _ __     ___    ___ \r\n" + //
                                "                   |  __|   / _` | | | | | | | | '_ \\   / _ \\  / __|\r\n" + //
                                "                   | |___  | (_| | | |_| | | | | |_) | | (_) | \\__ \\\r\n" + //
                                "                   \\____/   \\__, |  \\__,_| |_| | .__/   \\___/  |___/\r\n" + //
                                "                               | |             | |                  \r\n" + //
                                "                               |_|             |_|                  \r\n" + //
                                "");
            System.out.println("---------------------------------[Seleccione una opcion]----------------------------------");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("[1] ->                               Crear Equipo                                       <-");
            System.out.println("[2] ->                             Actualizar Equipo                                    <-");
            System.out.println("[3] ->                               Buscar Equipo                                      <-");
            System.out.println("[4] ->                              Eliminar Equipo                                     <-");
            System.out.println("[5] ->                          Listar todos los Equipos                                <-");
            System.out.println("[6] ->                                   Salir                                          <-");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.print("[Tu eleccion] -> ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    limpiarPantalla();
                    Team equipo = new Team();
                    String codigoEquipo;

                    System.out.print("Ingrese el codigo del equipo: ");
                    codigoEquipo = scanner.nextLine();
                    System.out.println();

                    System.out.print("Ingrese Nombre del equipo: ");
                    equipo.setNombre(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la ciudad: ");
                    equipo.setCiudad(scanner.nextLine());
                    System.out.println();

                    controlador.equipos.put(codigoEquipo, equipo);
                    retardo("¡Equipo agregado exitosamente!", 2);
                    break;

                case 2:
                    limpiarPantalla();
                    Team equipoAct = new Team();
                    String codEquipo2;

                    System.out.print("Ingrese el codigo del equipo: ");
                    codEquipo2 = scanner.nextLine();
                    System.out.println();

                    System.out.print("Ingrese el nuevo nombre del equipo: ");
                    equipoAct.setNombre(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la nueva ciudad del equipo: ");
                    equipoAct.setCiudad(scanner.nextLine());
                    System.out.println();

                    controlador.equipos.replace(codEquipo2, equipoAct);
                    retardo("¡Equipo actualizado exitosamente!", 2);
                    break;

                case 3:
                    limpiarPantalla();
                    String codEquipo3;
                    System.out.print("Ingrese el codigo del equipo: ");
                    codEquipo3 = scanner.nextLine();
                    if (controlador.equipos.containsKey(codEquipo3)) {
                        limpiarPantalla();
                        Team equipoEncontrado = controlador.equipos.get(codEquipo3);
                        System.out.println("+------------+---------------[EQUIPO ENCONTRADO]-------------------------");
                        System.out.println("| Equipo       | " + equipoEncontrado.getNombre() + " | Ciudad: " + equipoEncontrado.getCiudad());
                        System.out.println("+------------+---------------------------------------------------------------");
                        retardo("(Este mensaje se limpiara en 5 segundos)", 5);
                    } else {
                        limpiarPantalla();
                        retardo("Equipo no encontrado", 2);
                    }
                    break;

                case 4:
                    limpiarPantalla();
                    String codEquipo4;
                    System.out.print("Ingrese el codigo del equipo que quiere eliminar: ");
                    codEquipo4 = scanner.nextLine();
                    if (controlador.equipos.containsKey(codEquipo4)) {
                        controlador.equipos.remove(codEquipo4);
                        retardo("¡Equipo eliminado exitosamente!", 2);
                    } else {
                        retardo("Equipo no encontrado", 2);
                    }
                    break;

                case 5:
                    limpiarPantalla();
                    System.out.println("---------------------------------[EQUIPOS]--------------------------------- ");
                    int i = 0;
                    for (Map.Entry<String, Team> entry : controlador.equipos.entrySet()) {
                        String codEquipo5 = entry.getKey();
                        Team eq = entry.getValue();
                        System.out.println(MessageFormat.format("| Equipo {0} | Codigo: {1} | Nombre: {2} | Ciudad: {3} |", i, codEquipo5, eq.getNombre(), eq.getCiudad()));
                        i++;
                    }
                    retardo("Ya no hay más equipos (Espere 10 segundos)", 10);
                    break;

                case 6:
                    return;

                default:
                    retardo("Opción inválida, inténtelo de nuevo en 3 segundos", 3);
            }
        }
    }
}
