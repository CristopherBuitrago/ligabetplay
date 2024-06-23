package com.ligabetplay.views;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.model.entity.Doctor;

public class ViewDoctor {
    public static Controller controlador;
    private Scanner scanner;

    public ViewDoctor(Scanner scanner) {
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
                                "           ___  ___                          _   _         _                 \r\n" + //
                                "           |  \\/  |                         (_) (_)       | |                \r\n" + //
                                "           | .  . |   __ _   ___    __ _     _   _   ___  | |_    __ _   ___ \r\n" + //
                                "           | |\\/| |  / _` | / __|  / _` |   | | | | / __| | __|  / _` | / __|\r\n" + //
                                "           | |  | | | (_| | \\__ \\ | (_| |   | | | | \\__ \\ | |_  | (_| | \\__ \\\r\n" + //
                                "           \\_|  |_/  \\__,_| |___/  \\__,_|   | | |_| |___/  \\__|  \\__,_| |___/\r\n" + //
                                "                                           _/ |                              \r\n" + //
                                "                                          |__/                               \r\n" + //
                                "");
            System.out.println("---------------------------------[Seleccione una opcion]----------------------------------");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("[1] ->                               Crear masajista                                    <-");
            System.out.println("[2] ->                             Actualizar masajista                                 <-");
            System.out.println("[3] ->                               Buscar masajista                                   <-");
            System.out.println("[4] ->                              Eliminar masajista                                  <-");
            System.out.println("[5] ->                          Listar todos los masajistas                             <-");
            System.out.println("[6] ->                                      Salir                                       <-");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.print("[Tu eleccion] -> ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    limpiarPantalla();
                    Doctor masajista = new Doctor();
                    int idMasajista;

                    System.out.print("Ingrese el id del masajista :");
                    idMasajista = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println();

                    System.out.print("Ingrese Nombre del masajista :");
                    masajista.setNombre(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese el apellido del masajista: ");
                    masajista.setApellido(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la edad del masajista: ");
                    masajista.setEdad(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.println();

                    System.out.print("Ingrese el titulo del masajista :");
                    masajista.setTitulo(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la experiencia del masajista :");
                    masajista.setExpYear(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.println();

                    controlador.masajistas.put(idMasajista, masajista);
                    retardo("¡Masajista agregado exitosamente!", 2);
                    break;

                case 2:
                    limpiarPantalla();
                    Doctor masajistaAct = new Doctor();
                    int idMasajista2;

                    System.out.print("Ingrese el id del masajista: ");
                    idMasajista2 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println();

                    System.out.print("Ingrese nuevo nombre del masajista :");
                    masajistaAct.setNombre(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese el nuevo apellido del masajista: ");
                    masajistaAct.setApellido(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la nueva edad del masajista: ");
                    masajistaAct.setEdad(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.println();

                    System.out.print("Ingrese el nuevo titulo del masajista :");
                    masajistaAct.setTitulo(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la nueva experiencia del masajista :");
                    masajistaAct.setExpYear(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.println();

                    controlador.masajistas.replace(idMasajista2, masajistaAct);
                    retardo("¡Masajista actualizado exitosamente!", 2);
                    break;

                case 3:
                    limpiarPantalla();
                    int idMasajista3;
                    System.out.print("Ingrese el id del masajista: ");
                    idMasajista3 = scanner.nextInt();
                    if (controlador.masajistas.containsKey(idMasajista3)) {
                        limpiarPantalla();
                        Doctor masajistaEncontrado = controlador.masajistas.get(idMasajista3);
                        System.out.println("+------------|---------------[MASAJISTA ENCONTRADO]-------------------------");
                        System.out.println("| Masajista + " + masajistaEncontrado.getNombre() + " " + masajistaEncontrado.getApellido());
                        System.out.println("+------------|---------------------------------------------------------------");
                        retardo("(Este mensaje se limpiara en 5 segundos)", 5);
                    } else {
                        limpiarPantalla();
                        retardo("Masajista no encontrado", 2);
                    }
                    break;

                case 4:
                    limpiarPantalla();
                    int idMasajista4;
                    System.out.print("Ingrese el id del masajista que quiere eliminar: ");
                    idMasajista4 = scanner.nextInt();
                    if (controlador.masajistas.containsKey(idMasajista4)) {
                        controlador.masajistas.remove(idMasajista4);
                        retardo("¡Masajista eliminado exitosamente!", 2);
                    } else {
                        retardo("Masajista no encontrado", 2);
                    }
                    break;

                case 5:
                    limpiarPantalla();
                    System.out.println("---------------------------------[MASAJISTAS]--------------------------------- ");
                    int i = 0;
                    for (Map.Entry<Integer, Doctor> entry : controlador.masajistas.entrySet()) {
                        int idsMasajistas = entry.getKey();
                        Doctor masajistas = entry.getValue();
                        System.out.println(MessageFormat.format("| Masajista {0} | Id: {1} | Nombre: {2} | Apellido: {3} | Titulo: {4} |", i, idsMasajistas, masajistas.getNombre(), masajistas.getApellido(), masajistas.getTitulo()));
                        i++;
                    }
                    retardo("Ya no hay más masajistas (Espere 10 segundos)", 10);
                    break;

                case 6:
                    return;

                default:
                    retardo("Opción inválida, inténtelo de nuevo en 3 segundos", 3);
            }
        }
    }
}
