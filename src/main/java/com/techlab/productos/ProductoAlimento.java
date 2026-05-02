package com.techlab.productos;

public class ProductoAlimento extends Producto {
    private final String fechaVencimiento;

    public ProductoAlimento(String nombre, double precio, int stock, String fechaVencimiento) {
        super(nombre, precio, stock);
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    @Override
    public String toString() {
        return super.toString() + " | Vence: " + fechaVencimiento;
    }
}
