package com.ligabetplay.views;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.model.entity.Coach;
import com.ligabetplay.model.entity.Doctor;

public class ViewCoach {
    public static Controller controlador;
    private Scanner scanner;

    public ViewCoach (Scanner scanner){
        this.scanner = scanner;
    }

    public void start() {

        while (true) {
            System.out.println("1. Crear entrenador");
            System.out.println("2. Actualizar entrenador");
            System.out.println("3. Buscar entrenador");
            System.out.println("4. Eliminar entrenador");
            System.out.println("5. Listar todos los entrenadores");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Coach entrenador = new Coach();
                    int idEntrenador;

                    System.out.println("Ingrese el id del entrenador :");
                    idEntrenador = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.println("Ingrese Nombre del entrenador :");
                    entrenador.setNombre(scanner.nextLine());

                    System.out.println("Ingrese el apellido del entrenador: ");
                    entrenador.setApellido(scanner.nextLine());

                    System.out.println("Ingrese la edad del entrenador: ");
                    entrenador.setEdad(scanner.nextInt());
                    scanner.nextLine(); // Consume newline

                    System.out.println("Ingrese el id de la federacion del entrenador :");
                    entrenador.setIdFedaracion(scanner.nextInt());
                    scanner.nextLine(); // Consume newline


                    controlador.entrenadores.put(idEntrenador, entrenador);
                    System.out.println("Entrenador agregado exitosamente!");
                    break;

                case 2:
                    Coach entrenadorAct = new Coach();
                    int idEntrenador2;

                    System.out.println("Ingrese el id del entrenador :");
                    idEntrenador2 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.println("Ingrese nuevo nombre del entrenador :");
                    entrenadorAct.setNombre(scanner.nextLine());

                    System.out.println("Ingrese el nuevo apellido del entrenador: ");
                    entrenadorAct.setApellido(scanner.nextLine());

                    System.out.println("Ingrese la nueva edad del entrenador: ");
                    entrenadorAct.setEdad(scanner.nextInt());
                    scanner.nextLine(); // Consume newline

                    System.out.println("Ingrese el nuevo id de la federacion del entrenador :");
                    entrenadorAct.setIdFedaracion(scanner.nextInt());
                    scanner.nextLine(); // Consume newline                                     

                    controlador.entrenadores.replace(idEntrenador2, entrenadorAct);
                    break;

                case 3:
                    int idEntrenador3;
                    System.out.print("Ingrese el id del entrenador: ");
                    idEntrenador3 = scanner.nextInt();
                    if (controlador.entrenadores.containsKey(idEntrenador3)) {
                        Coach entrenadorEncontrado = controlador.entrenadores.get(idEntrenador3);
                        System.out.println("Entrenador: " + entrenadorEncontrado.getNombre());
                    } else {
                        System.out.println("El id del entrenador no existe");
                    }
                    break;
                case 4:
                    int idEntrenador4;
                    System.out.print("Ingrese el id del masajista que quiere eliminar: ");
                    idEntrenador4 = scanner.nextInt();
                    if (controlador.entrenadores.containsKey(idEntrenador4)) {
                        controlador.entrenadores.remove(idEntrenador4);
                        System.out.println("entrenador eliminado");
                    } else {
                        System.out.println("El id del entrenador no existe");
                    }
                    break;
                case 5:
                    System.out.println("Todos los entrenadores: ");
                    int i = 0;
                    for (Map.Entry<Integer, Coach> entry : controlador.entrenadores.entrySet()) {
                        int idsEntrenadores = entry.getKey();
                        Coach entrenadores = entry.getValue();
                        System.out.println(MessageFormat.format("Entrenador {0} - Id: {1}, Nombre: {2}, Apellido: {3}, Federacion: {4}", i, idsEntrenadores, entrenadores.getNombre(), entrenadores.getApellido(), entrenadores.getIdFedaracion()));
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
