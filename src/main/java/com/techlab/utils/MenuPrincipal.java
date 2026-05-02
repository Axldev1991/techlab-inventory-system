package com.techlab.utils;

public enum MenuPrincipal {
    AGREGAR("1) Agregar producto"),
    LISTAR("2) Listar productos"),
    BUSCAR_ACTUALIZAR("3) Buscar/Actualizar producto"),
    ELIMINAR("4) Eliminar producto"),
    CREAR_PEDIDO("5) Crear un pedido"),
    LISTAR_PEDIDOS("6) Listar pedidos"),
    SALIR("7) Salir");

    private final String descripcion;

    MenuPrincipal(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
