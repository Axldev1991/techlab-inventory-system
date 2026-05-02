package com.techlab.utils;

public class Validador {

    public static boolean esPositivo(double valor) {
        return valor >= 0;
    }

    public static boolean esTextoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public static boolean esFechaValida(String fecha) {
        // Formato AAAA-MM-DD usando Regex
        return fecha.matches("\\d{4}-\\d{2}-\\d{2}");
    }
}
