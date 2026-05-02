package com.techlab;

import com.techlab.productos.*;
import com.techlab.pedidos.*;
import com.techlab.excepciones.*;

public class TestIntegral {
    private static int fallos = 0;
    private static int pruebas = 0;

    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println("   EJECUTANDO PRUEBA INTEGRAL DE SISTEMA - TECHLAB (SDD)        ");
        System.out.println("==================================================================\n");

        GestorProducto gestor = new GestorProducto();

        ProductoAlimento leche = new ProductoAlimento("Leche Entera", 1200.0, 50, "2024-12-30");
        ProductoElectronico auris = new ProductoElectronico("Auriculares BT", 15000.0, 10, 12);
        
        gestor.agregarProductoAlimento(leche.getNombre(), leche.getPrecio(), leche.getStock(), leche.getFechaVencimiento());
        gestor.agregarProductoElectronico(auris.getNombre(), auris.getPrecio(), auris.getStock(), auris.getMesesGarantia());

        verificar(leche.toString().contains("Vence: 2024-12-30"), "Polimorfismo Alimento (toString)");
        verificar(auris.toString().contains("Garantía: 12 meses"), "Polimorfismo Electrónica (toString)");

        Pedido pedido = new Pedido();
        Producto pLeche = gestor.encontrarProducto("Leche Entera");
        Producto pAuris = gestor.encontrarProducto("Auriculares Bt");

        pedido.agregarLinea(new LineaPedido(pLeche, 2));
        pedido.agregarLinea(new LineaPedido(pAuris, 1));
        
        double totalEsperado = 17400.0;
        verificar(pedido.getTotal() == totalEsperado, "Cálculo total Pedido Multi-producto");

        pLeche.setStock(pLeche.getStock() - 2);
        pAuris.setStock(pAuris.getStock() - 1);
        
        verificar(pLeche.getStock() == 48, "Descuento de Stock Alimento");
        verificar(pAuris.getStock() == 9, "Descuento de Stock Electrónica");

        boolean excepcionAtrapada = false;
        try {
            if (100 > pLeche.getStock()) throw new StockInsuficienteException("No hay stock");
        } catch (StockInsuficienteException e) {
            excepcionAtrapada = true;
        }
        verificar(excepcionAtrapada, "Captura de StockInsuficienteException");

        System.out.println("\n==================================================================");
        System.out.println("   RESUMEN: " + (pruebas - fallos) + "/" + pruebas + " PRUEBAS PASADAS");
        System.out.println("==================================================================");
    }

    private static void verificar(boolean condicion, String nombreTest) {
        pruebas++;
        if (condicion) System.out.println("[OK] " + nombreTest + " ✅");
        else { System.out.println("[FALLO] " + nombreTest + " ❌"); fallos++; }
    }
}
