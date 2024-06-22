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
    public void start() {

        while (true) {
            System.out.println("1. Crear Equipo");
            System.out.println("2. Actualizar Equipo");
            System.out.println("3. Buscar Equipo");
            System.out.println("4. Eliminar Equipo");
            System.out.println("5. Listar todos Equipos");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Team equipo = new Team();
                    String codigoEquipo = null;
                    System.out.println("Ingrese el codigo del equipo :");
                    codigoEquipo = scanner.nextLine();
                    System.out.println("Ingrese Nombre del equipo :");
                    equipo.setNombre(scanner.nextLine());
                    System.out.println("Ingrese la ciudad :");
                    equipo.setCiudad(scanner.nextLine());
                    controlador.equipos.put(codigoEquipo, equipo);
                    break;

                case 2:
                    Team eq = new Team();
                    String codEquipo2;
                    System.out.print("Ingrese el codigo del equipo: ");
                    codEquipo2 = scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre del equipo: ");
                    eq.setNombre(scanner.nextLine());
                    System.out.print("ingrese la nueva ciudad del equipo: ");
                    eq.setCiudad(scanner.nextLine());
                    controlador.equipos.replace(codEquipo2, eq);
                    break;

                case 3:
                    String codEquipo3;
                    System.out.print("Ingrese el codigo del equipo: ");
                    codEquipo3 = scanner.nextLine();
                    if (controlador.equipos.containsKey(codEquipo3)) {
                        Team eq2 = controlador.equipos.get(codEquipo3);
                        System.out.println("Equipo: " + eq2.getNombre());
                    } else {
                        System.out.println("El codigo del equipo no existe.");
                    }
                    break;
                case 4:
                    String codEquipo4;
                    System.out.print("Ingrese el codigo del equipo que quiere eliminar: ");
                    codEquipo4 = scanner.nextLine();
                    controlador.equipos.remove(codEquipo4);
                    break;
                case 5:
                    System.out.println("Todos los equipos: ");
                    int i = 0;
                    for (Map.Entry<String, Team> entry : controlador.equipos.entrySet()) {
                        String codEquipo5 = entry.getKey();
                        Team eq3 = entry.getValue();
                        System.out.println(MessageFormat.format("Equipo {0} - Codigo: {1}, Nombre: {2}, Ciudad: {3}", i, codEquipo5, eq3.getNombre(), eq3.getCiudad()));
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