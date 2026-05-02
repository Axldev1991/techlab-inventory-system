package com.techlab.productos;

import com.techlab.utils.Formateador;

public class Producto {
    private static int contadorID = 1;
    private final int id;
    private final String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.id = contadorID++;
        this.nombre = Formateador.formatearNombre(nombre);
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Producto: " + nombre + " | Precio: $" + precio + " | Stock: " + stock;
    }
}
