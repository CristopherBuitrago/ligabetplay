package com.ligabetplay.views;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.model.entity.Coach;

public class ViewCoach {
    public static Controller controlador;
    private Scanner scanner;

    public ViewCoach (Scanner scanner){
        this.scanner = scanner;
    }

    private void limpiarPantalla(){
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
        System.out.println("Mensaje después del retraso");
    }

    public void start() {

        while (true) {
            limpiarPantalla();
            System.out.println("\r\n" + //
                                " _____           _                                       _                             \r\n" + //
                                "|  ___|         | |                                     | |                            \r\n" + //
                                "| |__    _ __   | |_   _ __    ___   _ __     __ _    __| |   ___    _ __    ___   ___ \r\n" + //
                                "|  __|  | '_ \\  | __| | '__|  / _ \\ | '_ \\   / _` |  / _` |  / _ \\  | '__|  / _ \\ / __|\r\n" + //
                                "| |___  | | | | | |_  | |    |  __/ | | | | | (_| | | (_| | | (_) | | |    |  __/ \\__ \\\r\n" + //
                                "\\____/  |_| |_|  \\__| |_|     \\___| |_| |_|  \\__,_|  \\__,_|  \\___/  |_|     \\___| |___/\r\n" + //
                                "                                                                                       \r\n" + //
                                "                                                                                       \r\n" + //
                                "");
            System.out.println("---------------------------------[Seleccione una opcion]----------------------------------");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("[1] ->                               Crear entrenador                                   <-");
            System.out.println("[2] ->                             Actualizar entrenador                                <-");
            System.out.println("[3] ->                               Buscar entrenador                                  <-");
            System.out.println("[4] ->                              Eliminar entrenador                                 <-");
            System.out.println("[5] ->                          Listar todos los entrenadores                           <-");
            System.out.println("[6] ->                                      Salir                                       <-");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.print(  "[Tu eleccion] -> ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    limpiarPantalla();
                    Coach entrenador = new Coach();
                    int idEntrenador;

                    System.out.print("Ingrese el id del entrenador :");
                    idEntrenador = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println();

                    System.out.print("Ingrese Nombre del entrenador :");
                    entrenador.setNombre(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese el apellido del entrenador: ");
                    entrenador.setApellido(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la edad del entrenador: ");
                    entrenador.setEdad(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.println();

                    System.out.print("Ingrese el id de la federacion del entrenador :");
                    entrenador.setIdFedaracion(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.println();


                    controlador.entrenadores.put(idEntrenador, entrenador);
                    retardo("¡Entrenador agregado exitosamente!", 2);
                    break;

                case 2:
                    limpiarPantalla();
                    Coach entrenadorAct = new Coach();
                    int idEntrenador2;

                    System.out.print("Ingrese el id del entrenador: ");
                    idEntrenador2 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println();

                    System.out.print("Ingrese nuevo nombre del entrenador: ");
                    entrenadorAct.setNombre(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese el nuevo apellido del entrenador: ");
                    entrenadorAct.setApellido(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la nueva edad del entrenador: ");
                    entrenadorAct.setEdad(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.println();

                    System.out.print("Ingrese el nuevo id de la federacion del entrenador: ");
                    entrenadorAct.setIdFedaracion(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.println();            

                    controlador.entrenadores.replace(idEntrenador2, entrenadorAct);
                    retardo("¡Entrenador actualizado exitosamente!", 2);

                    break;

                case 3:
                    limpiarPantalla();
                    int idEntrenador3;
                    System.out.print("Ingrese el id del entrenador: ");
                    idEntrenador3 = scanner.nextInt();
                    if (controlador.entrenadores.containsKey(idEntrenador3)) {
                        limpiarPantalla();
                        Coach entrenadorEncontrado = controlador.entrenadores.get(idEntrenador3);
                        System.out.println("+------------|---------------[ENTRENADOR ENCONTRADO]-------------------------");
                        System.out.println(  "| Entrenador + " + entrenadorEncontrado.getNombre() +" "+ entrenadorEncontrado.getApellido());
                        System.out.println("+------------|---------------------------------------------------------------");
                        retardo("(Este mensaje se limpiara en 5 segundos)", 5);
                    } else {
                        limpiarPantalla();
                        retardo("Entrenador no encontrado", 2);
                    }
                    break;
                case 4:
                    limpiarPantalla();
                    int idEntrenador4;
                    System.out.print("Ingrese el id del masajista que quiere eliminar: ");
                    idEntrenador4 = scanner.nextInt();
                    if (controlador.entrenadores.containsKey(idEntrenador4)) {
                        controlador.entrenadores.remove(idEntrenador4);
                        retardo("¡Entrenador eliminado exitosamente!", 2);
                    } else {
                        retardo("Entrenador no encontrado", 2);
                    }
                    break;
                case 5:
                    limpiarPantalla();
                    System.out.println("---------------------------------[ENTRENADORES]--------------------------------- ");
                    int i = 0;
                    for (Map.Entry<Integer, Coach> entry : controlador.entrenadores.entrySet()) {
                        int idsEntrenadores = entry.getKey();
                        Coach entrenadores = entry.getValue();
                        System.out.println(MessageFormat.format("| Entrenador {0} | Id: {1} | Nombre_ {2} | Apellido: {3} | Federacion: {4} |" , i, idsEntrenadores, entrenadores.getNombre(), entrenadores.getApellido(), entrenadores.getIdFedaracion()));
                        i++;
                    }
                    retardo("Ya no hay más entrenadores (Espere 10 segundos)", 10);
                    break;
                case 6:
                    return;

                default:
                    retardo("Opcion incorrecta, intente de nuevo en 3 segundos", 3);
            }
        }
    }
}
