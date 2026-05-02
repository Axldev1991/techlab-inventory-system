package com.techlab.productos;

/**
 * Representa un producto que no pertenece a una categoría especial
 * (como Alimento o Electrónica). Hereda de la clase abstracta Producto.
 */
public class ProductoGenerico extends Producto {
    
    public ProductoGenerico(String nombre, double precio, int stock) {
        super(nombre, precio, stock);
    }

    @Override
    public String toString() {
        return super.toString() + " | Categoría: General";
    }
}
