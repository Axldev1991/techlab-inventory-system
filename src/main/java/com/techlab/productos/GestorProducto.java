package com.techlab.productos;

import com.techlab.utils.Formateador;
import com.techlab.utils.Validador;
import java.util.ArrayList;

public class GestorProducto {

    private ArrayList<Producto> lista;

    public GestorProducto() {
        this.lista = new ArrayList<>();
    }

    // Método para agregar desde la lista del Enum
    public void agregarProductoInventario(ListaProductos item, double precio, int stock) {
        if (!Validador.esPositivo(stock)) {
            System.out.println("Error: El stock no puede ser negativo.");
            return;
        }
        Producto nuevo = new Producto(item.toString(), precio, stock);
        this.lista.add(nuevo);
    }

    // Método para agregar entrada manual
    public void agregarProductoManual(String nombre, double precio, int stock) {
        if (!Validador.esPositivo(stock)) {
            System.out.println("Error: El stock no puede ser negativo.");
            return;
        }
        this.lista.add(new Producto(nombre, precio, stock));
    }

    public void agregarProductoAlimento(String nombre, double precio, int stock, String vencimiento) {
        if (!Validador.esPositivo(stock)) {
            System.out.println("Error: El stock no puede ser negativo.");
            return;
        }
        this.lista.add(new ProductoAlimento(nombre, precio, stock, vencimiento));
    }

    public void agregarProductoElectronico(String nombre, double precio, int stock, int garantia) {
        if (!Validador.esPositivo(stock)) {
            System.out.println("Error: El stock no puede ser negativo.");
            return;
        }
        this.lista.add(new ProductoElectronico(nombre, precio, stock, garantia));
    }

    public void mostrarListaProductos() {
        if (lista.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }
        for (Producto p : lista) {
            System.out.println(p.toString());
        }
    }

    public Producto encontrarProductoPorId(int id) {
        for (Producto p : lista) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public Producto encontrarProducto(String nombre) {
        String nombreProducto = Formateador.formatearNombre(nombre);
        for (Producto p : lista) {
            if (p.getNombre().equals(nombreProducto)) {
                return p;
            }
        }
        return null;
    }

    public void eliminarProducto(String nombre) {
        Producto p = encontrarProducto(nombre);
        if (p != null) {
            lista.remove(p);
            System.out.println("Producto '" + nombre + "' eliminado con éxito.");
        } else {
            System.out.println("No se encontró o no existe el producto: " + nombre);
        }
    }

    public void eliminarProductoPorId(int id) {
        Producto p = encontrarProductoPorId(id);
        if (p != null) {
            lista.remove(p);
            System.out.println("Producto con ID " + id + " eliminado con éxito.");
        } else {
            System.out.println("No se encontró el producto con ID: " + id);
        }
    }

    public void eliminarProductoPorPosicion(int posicion) {
        if (posicion >= 0 && posicion < lista.size()) {
            Producto p = lista.remove(posicion);
            System.out.println("Producto '" + p.getNombre() + "' en la posición " + posicion + " eliminado.");
        } else {
            System.out.println("Error: Posición fuera de rango.");
        }
    }

    public void actualizarProducto(int id, double nuevoPrecio, int nuevoStock) {
        Producto p = encontrarProductoPorId(id);
        if (p != null) {
            if (!Validador.esPositivo(nuevoStock)) {
                System.out.println("Error: El stock no puede ser negativo.");
                return;
            }
            if (!Validador.esPositivo(nuevoPrecio)) {
                System.out.println("Error: El precio no puede ser negativo.");
                return;
            }
            p.setPrecio(nuevoPrecio);
            p.setStock(nuevoStock);
            System.out.println("Producto con ID " + id + " actualizado correctamente.");
        } else {
            System.out.println("Error: No se encontró el producto con ID " + id);
        }
    }
}
