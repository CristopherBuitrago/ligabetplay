package com.ligabetplay.views;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.model.entity.Doctor;

public class ViewDoctor {
    public static Controller controlador;
    private Scanner scanner;

    public ViewDoctor (Scanner scanner){
        this.scanner = scanner;
    }

    public void start() {

        while (true) {
            System.out.println("1. Crear masajista");
            System.out.println("2. Actualizar masajista");
            System.out.println("3. Buscar masajista");
            System.out.println("4. Eliminar masajista");
            System.out.println("5. Listar todos los masajistas");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Doctor masajista = new Doctor();
                    int idMasajista;

                    System.out.println("Ingrese el id del masajista :");
                    idMasajista = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.println("Ingrese Nombre del masajista :");
                    masajista.setNombre(scanner.nextLine());

                    System.out.println("Ingrese el apellido del masajista: ");
                    masajista.setApellido(scanner.nextLine());

                    System.out.println("Ingrese la edad del masajista: ");
                    masajista.setEdad(scanner.nextInt());
                    scanner.nextLine(); // Consume newline

                    System.out.println("Ingrese el titulo del masajista :");
                    masajista.setTitulo(scanner.nextLine());

                    System.out.println("Ingrese la experiencia del masajista :");
                    masajista.setExpYear(scanner.nextInt());
                    scanner.nextLine(); // Consume newline

                    controlador.masajistas.put(idMasajista, masajista);
                    System.out.println("Masajista agregado exitosamente!");
                    break;

                case 2:
                    Doctor masajistaAct = new Doctor();
                    int idMasajista2;

                    System.out.print("Ingrese el id del masajista: ");
                    idMasajista2 = scanner.nextInt();
                    scanner.nextLine(); // Consume new Line

                    System.out.println("Ingrese nuevo nombre del masajista :");
                    masajistaAct.setNombre(scanner.nextLine());

                    System.out.println("Ingrese el nuevo apellido del masajista: ");
                    masajistaAct.setApellido(scanner.nextLine());

                    System.out.println("Ingrese la nueva edad del masajista: ");
                    masajistaAct.setEdad(scanner.nextInt());
                    scanner.nextLine(); // Consume newline

                    System.out.println("Ingrese el nuevo titulo del masajista :");
                    masajistaAct.setTitulo(scanner.nextLine());

                    System.out.println("Ingrese la nueva experiencia del masajista :");
                    masajistaAct.setExpYear(scanner.nextInt());
                    scanner.nextLine(); // Consume newline  z                                     

                    controlador.masajistas.replace(idMasajista2, masajistaAct);
                    break;

                case 3:
                    int idMasajista3;
                    System.out.print("Ingrese el id del masajista: ");
                    idMasajista3 = scanner.nextInt();
                    if (controlador.masajistas.containsKey(idMasajista3)) {
                        Doctor masajistaEncontrado = controlador.masajistas.get(idMasajista3);
                        System.out.println("Masajista: " + masajistaEncontrado.getNombre());
                    } else {
                        System.out.println("El id del masajista no existe");
                    }
                    break;
                case 4:
                    int idMasajista4;
                    System.out.print("Ingrese el id del masajista que quiere eliminar: ");
                    idMasajista4 = scanner.nextInt();
                    if (controlador.masajistas.containsKey(idMasajista4)) {
                        controlador.masajistas.remove(idMasajista4);
                        System.out.println("masajista eliminado");
                    } else {
                        System.out.println("El id del masajista no existe");
                    }
                    break;
                case 5:
                    System.out.println("Todos los masajistas: ");
                    int i = 0;
                    for (Map.Entry<Integer, Doctor> entry : controlador.masajistas.entrySet()) {
                        int idsMasajistas = entry.getKey();
                        Doctor masajistas = entry.getValue();
                        System.out.println(MessageFormat.format("Masajista {0} - Id: {1}, Nombre: {2}, Apellido: {3}, Titulo: {4}", i, idsMasajistas, masajistas.getNombre(), masajistas.getApellido(), masajistas.getTitulo()));
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
