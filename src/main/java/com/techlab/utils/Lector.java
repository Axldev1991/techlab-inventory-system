package com.techlab.utils;

import java.util.Scanner;

public class Lector {

    public static String leerString(Scanner leer, String mensaje) {
        String entrada;
        do {
            System.out.println(mensaje + ": ");
            entrada = leer.nextLine();

            if (!Validador.esTextoValido(entrada)) {
                System.out.println("ERROR: No puede estar el campo vacío");
            }
        } while (!Validador.esTextoValido(entrada));

        return entrada;
    }

    public static double leerDoublePositivo(Scanner leer, String mensaje) {
        double valor = -1;
        do {
            try {
                System.out.print(mensaje + ": ");
                String entrada = leer.nextLine();
                if (entrada.trim().isEmpty()) {
                    System.out.println("ERROR: No podés dejar el campo vacío.");
                    continue;
                }
                valor = Double.parseDouble(entrada);
                if (!Validador.esPositivo(valor)) {
                    System.out.println("Error: El valor no puede ser negativo.");
                    valor = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("¡ERROR! Debes ingresar un número válido (ej: 1200.50).");
                valor = -1;
            }
        } while (valor < 0);
        return valor;
    }
    
    public static int leerIntPositivo(Scanner leer, String mensaje) {
        int valor = -1;
        do {
            try {
                System.out.print(mensaje + ": ");
                String entrada = leer.nextLine();
                if (entrada.trim().isEmpty()) {
                    System.out.println("ERROR: No podés dejar el campo vacío.");
                    continue;
                }
                valor = Integer.parseInt(entrada);
                if (!Validador.esPositivo(valor)) {
                    System.out.println("Error: El valor no puede ser negativo.");
                    valor = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("¡ERROR! Debes ingresar un número entero válido.");
                valor = -1;
            }
        } while (valor < 0);
        return valor;
    }

    public static String leerFecha(Scanner leer, String mensaje) {
        String fecha;
        do {
            System.out.println(mensaje + " (Formato AAAA-MM-DD): ");
            fecha = leer.nextLine();
            if (!Validador.esFechaValida(fecha)) {
                System.out.println("ERROR: Formato de fecha inválido. Debe ser AAAA-MM-DD (ej: 2024-12-31)");
            }
        } while (!Validador.esFechaValida(fecha));
        return fecha;
    }
}
