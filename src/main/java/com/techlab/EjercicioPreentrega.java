package com.techlab;

import com.techlab.productos.*;
import com.techlab.pedidos.*;
import com.techlab.excepciones.*;
import com.techlab.utils.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioPreentrega {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        GestorProducto gestor = new GestorProducto();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();

        inicializarInventario(gestor);

        int opcion;
        do {
            mostrarMenu();
            opcion = Lector.leerIntPositivo(leer, "\nElija una opción: ");

            switch (opcion) {
                case 1 -> menuAgregar(leer, gestor);
                case 2 -> gestor.mostrarListaProductos();
                case 3 -> menuBuscarActualizar(leer, gestor);
                case 4 -> menuEliminar(leer, gestor);
                case 5 -> menuCrearPedido(leer, gestor, listaPedidos);
                case 6 -> menuMostrarHistorial(listaPedidos);
                case 7 -> System.out.println("Saliendo del sistema... ¡Hasta luego!");
                default -> System.out.println("Error: Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 7);

        leer.close();
    }

    private static void inicializarInventario(GestorProducto gestor) {
        // Alimentos
        gestor.agregarProductoAlimento("Leche", 1200.0, 50, "2024-12-30");
        gestor.agregarProductoAlimento("Pan", 2000.0, 30, "2024-05-15");
        // Electrónica
        gestor.agregarProductoElectronico("Auriculares", 15000.0, 10, 12);
        gestor.agregarProductoElectronico("Cargador", 8000.0, 20, 6);
        // Genéricos
        gestor.agregarProductoInventario(ListaProductos.Manzana, 1500.0, 100);
        gestor.agregarProductoInventario(ListaProductos.Banana, 1200.0, 150);
    }

    private static void mostrarMenu() {
        System.out.println("\n=================================== SISTEMA DE GESTIÓN - TECHLAB ==================================");
        for (MenuPrincipal m : MenuPrincipal.values()) {
            System.out.println(m.getDescripcion());
        }
    }

    private static void menuAgregar(Scanner leer, GestorProducto gestor) {
        System.out.println("TIPO: 1. Genérico | 2. Alimento | 3. Electrónica");
        int tipo = Lector.leerIntPositivo(leer, "Opción");
        String nombre = Lector.leerString(leer, "Ingrese el NOMBRE");
        double precio = Lector.leerDoublePositivo(leer, "Ingrese el PRECIO");
        int stock = Lector.leerIntPositivo(leer, "Ingrese el STOCK");

        if (tipo == 2) {
            String venc = Lector.leerFecha(leer, "Fecha vencimiento");
            gestor.agregarProductoAlimento(nombre, precio, stock, venc);
        } else if (tipo == 3) {
            int gar = Lector.leerIntPositivo(leer, "Meses de garantía");
            gestor.agregarProductoElectronico(nombre, precio, stock, gar);
        } else {
            gestor.agregarProductoManual(nombre, precio, stock);
        }
        System.out.println("¡Producto Agregado!");
    }

    private static void menuBuscarActualizar(Scanner leer, GestorProducto gestor) {
        System.out.println("1. Por NOMBRE | 2. Por ID");
        int subOp = Lector.leerIntPositivo(leer, "Opción");
        Producto p = (subOp == 1) 
            ? gestor.encontrarProducto(Lector.leerString(leer, "Nombre"))
            : gestor.encontrarProductoPorId(Lector.leerIntPositivo(leer, "ID"));

        if (p != null) {
            System.out.println("Encontrado: " + p);
            System.out.println("1. Editar Precio/Stock | 2. Cancelar");
            if (Lector.leerIntPositivo(leer, "Opción") == 1) {
                double nPrecio = Lector.leerDoublePositivo(leer, "Nuevo Precio");
                int nStock = Lector.leerIntPositivo(leer, "Nuevo Stock");
                gestor.actualizarProducto(p.getId(), nPrecio, nStock);
            }
        } else {
            System.out.println("No se encontró el producto.");
        }
    }

    private static void menuEliminar(Scanner leer, GestorProducto gestor) {
        System.out.println("1. Por NOMBRE | 2. Por ID | 3. Por POSICIÓN");
        int subOp = Lector.leerIntPositivo(leer, "Opción");
        if (subOp == 1) gestor.eliminarProducto(Lector.leerString(leer, "Nombre"));
        else if (subOp == 2) gestor.eliminarProductoPorId(Lector.leerIntPositivo(leer, "ID"));
        else gestor.eliminarProductoPorPosicion(Lector.leerIntPositivo(leer, "Posición"));
    }

    private static void menuCrearPedido(Scanner leer, GestorProducto gestor, ArrayList<Pedido> listaPedidos) {
        int cantItems = Lector.leerIntPositivo(leer, "¿Cuántos productos diferentes?");
        if (cantItems <= 0) return;

        Pedido pedido = new Pedido();
        boolean pedidoValido = false;

        for (int i = 0; i < cantItems; i++) {
            System.out.println("\nÍtem " + (i + 1) + " de " + cantItems + ":");
            Producto p = gestor.encontrarProductoPorId(Lector.leerIntPositivo(leer, "ID del producto"));

            if (p != null) {
                int cant = Lector.leerIntPositivo(leer, "Cantidad para " + p.getNombre());
                try {
                    if (cant > p.getStock()) throw new StockInsuficienteException("Stock insuficiente (Max: " + p.getStock() + ")");
                    p.setStock(p.getStock() - cant);
                    pedido.agregarLinea(new LineaPedido(p, cant));
                    pedidoValido = true;
                } catch (StockInsuficienteException e) {
                    System.out.println("ERROR: " + e.getMessage());
                    i--; 
                }
            } else {
                System.out.println("No encontrado. Reintente.");
                i--;
            }
        }

        if (pedidoValido) {
            listaPedidos.add(pedido);
            System.out.println("\n¡Pedido #" + pedido.getId() + " creado!\n" + pedido);
        }
    }

    private static void menuMostrarHistorial(ArrayList<Pedido> listaPedidos) {
        System.out.println("\n--- HISTORIAL DE PEDIDOS ---");
        if (listaPedidos.isEmpty()) System.out.println("No hay pedidos.");
        else listaPedidos.forEach(p -> System.out.println(p.toString()));
    }
}
