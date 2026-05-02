# REQUERIMIENTOS TÉCNICOS - TECHLAB INVENTORY

## 1. POO Avanzada
- [x] **Herencia**: Implementada en `ProductoAlimento` y `ProductoElectronico`.
- [x] **Polimorfismo**: Sobrecarga de `toString()` y listado genérico en `GestorProducto`.
- [x] **Composición**: Un `Pedido` se compone de una lista de `LineaPedido`.

## 2. Gestión de Inventario (CRUD)
- [x] **Agregar**: Soporte para diferentes tipos de productos.
- [x] **Eliminar**: Por ID, Nombre o Posición.
- [x] **Actualizar**: Validación de precios y stock negativos.

## 3. Lógica de Pedidos
- [x] **Multi-producto**: Soporte para múltiples ítems en un solo pedido.
- [x] **Cálculo automático**: Total generado dinámicamente.
- [x] **ID Autogenerado**: Pedidos numerados secuencialmente.

## 4. Robustez y UX
- [x] **Excepciones**: Uso de `StockInsuficienteException`.
- [x] **Validación**: Fechas (AAAA-MM-DD) y números (no vacíos, no negativos).
- [x] **UX**: Menú interactivo blindado contra entradas inválidas.
