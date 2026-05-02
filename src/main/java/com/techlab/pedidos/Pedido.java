package com.techlab.pedidos;

import java.util.ArrayList;

public class Pedido {
    private static int contadorId = 1;
    private final int id;
    private final ArrayList<LineaPedido> lineas;

    public Pedido() {
        this.id = contadorId++;
        this.lineas = new ArrayList<>();
    }

    public void agregarLinea(LineaPedido linea) {
        this.lineas.add(linea);
    }

    public int getId() {
        return id;
    }

    public double getTotal() {
        double total = 0;
        for (LineaPedido linea : lineas) {
            total += linea.getSubtotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------------------\n");
        sb.append("PEDIDO #").append(id).append("\n");
        sb.append("------------------------------------------\n");
        for (LineaPedido linea : lineas) {
            sb.append(linea.toString()).append("\n");
        }
        sb.append("------------------------------------------\n");
        sb.append("TOTAL A PAGAR: $").append(getTotal()).append("\n");
        sb.append("------------------------------------------\n");
        return sb.toString();
    }
}
