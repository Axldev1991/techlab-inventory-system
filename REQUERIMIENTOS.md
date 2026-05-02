# REQUERIMIENTOS TÉCNICOS - TECHLAB INVENTORY

Este documento detalla los requerimientos del proyecto y el estado de su implementación.

## 1. POO Avanzada
- [x] **Clase Abstracta**: La clase `Producto` es ahora `abstract`, sirviendo como base pero impidiendo instancias incompletas.
- [x] **Herencia**: Implementada en `ProductoAlimento`, `ProductoElectronico` y la nueva `ProductoGenerico`.
- [x] **Polimorfismo**: Sobrecarga de `toString()` y manejo uniforme de productos en el `GestorProducto`.
- [x] **Composición**: Un `Pedido` se compone de una lista de `LineaPedido`.

## 2. Gestión de Inventario (CRUD)
- [x] **Agregar**: Soporte para productos Genéricos, Alimentos y Electrónica.
- [x] **Eliminar**: Por ID, Nombre o Posición.
- [x] **Actualizar**: Validación de precios y stock (no negativos).

## 3. Lógica de Pedidos
- [x] **Multi-producto**: Un solo pedido puede tener múltiples ítems de diferentes tipos.
- [x] **Cálculo automático**: Total generado dinámicamente sumando subtotales.
- [x] **ID Autogenerado**: Pedidos y productos numerados secuencialmente.

## 4. Robustez y UX
- [x] **Excepciones**: Implementación de `StockInsuficienteException` para control de errores de negocio.
- [x] **Validación**: Fechas (Regex AAAA-MM-DD) y entradas numéricas blindadas contra errores de Scanner.
- [x] **UX**: Menú interactivo profesional con limpieza de buffer de entrada.

---

## Estructura de Paquetes
- `com.techlab.productos`: Jerarquía de productos.
- `com.techlab.pedidos`: Lógica de órdenes y composición.
- `com.techlab.excepciones`: Manejo de errores personalizados.
- `com.techlab.utils`: Herramientas de lectura, validación y formateo.
