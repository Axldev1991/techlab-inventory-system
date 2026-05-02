package com.techlab.utils;

public class Formateador {
    public static String formatearNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) return "";
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
    }
}
