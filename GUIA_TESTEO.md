# 🧪 Guía de Testeo Manual - TechLab Inventory

Seguí estos pasos para verificar que todo el sistema funciona a la perfección. Esta es la "prueba de fuego" antes de la entrega.

---

## 1. Agregar Productos (Herencia)
**Objetivo**: Verificar que se pueden cargar diferentes tipos de productos.
*   **Paso 1**: Elegí la Opción `1`.
*   **Paso 2**: Seleccioná `2` (Alimento). Cargá "Yogur", precio `500`, stock `20` y vencimiento `2024-12-01`.
*   **Paso 3**: Repetí la Opción `1`, elegí `3` (Electrónica). Cargá "Mouse", precio `5000`, stock `5` y garantía `12`.
*   **Paso 4**: Repetí la Opción `1`, elegí `1` (Genérico). Cargá "Caja", precio `100`, stock `100`.

## 2. Listado y Polimorfismo
**Objetivo**: Ver que el sistema "entiende" qué es cada cosa.
*   **Paso 1**: Elegí la Opción `2`.
*   **Paso 2**: Verificá que el Yogur diga "Vence: 2024-12-01" y el Mouse diga "Garantía: 12 meses".
*   **Paso 3**: Verificá que los IDs sean correlativos (1, 2, 3, etc.).

## 3. Búsqueda y Actualización (Robustez)
**Objetivo**: Validar que no se rompa nada.
*   **Paso 1**: Elegí la Opción `3`.
*   **Paso 2**: Buscá por NOMBRE: "yogur" (probá en minúsculas, debería encontrarlo igual).
*   **Paso 3**: Elegí Editar. Intentá poner un STOCK de `-10`.
    *   *Resultado esperado*: El sistema debe decirte "Error: El stock no puede ser negativo" y no actualizar.
*   **Paso 4**: Actualizá el stock a `50` y verificá con la Opción `2`.

## 4. Crear Pedido Multi-producto (Composición)
**Objetivo**: Crear un pedido con varios ítems y ver descuentos.
*   **Paso 1**: Elegí la Opción `5`.
*   **Paso 2**: "¿Cuántos productos diferentes?": Poné `2`.
*   **Paso 3** (Item 1): Poné el ID de la Leche (fijate en la lista) y cantidad `2`.
*   **Paso 4** (Item 2): Poné el ID de los Auriculares y cantidad `1`.
*   **Paso 5**: Verificá que al finalizar se imprima un ticket con el total correcto y el detalle de ambos productos.

## 5. Control de Excepciones
**Objetivo**: Forzar el error de stock.
*   **Paso 1**: Elegí la Opción `5`.
*   **Paso 2**: "¿Cuántos productos?": Poné `1`.
*   **Paso 3**: Elegí el ID del Mouse (que tenía stock 5) y poné cantidad `100`.
    *   *Resultado esperado*: Debe aparecer un mensaje: `ERROR: Stock insuficiente...`. El sistema te debería pedir que intentes de nuevo con ese ítem o cancelar.

## 6. Historial de Pedidos
**Objetivo**: Ver que los pedidos se guardan.
*   **Paso 1**: Elegí la Opción `6`.
*   **Paso 2**: Deberías ver el ticket del pedido que hiciste en el punto 4, con su ID propio.

## 7. Eliminar (Precisión)
**Objetivo**: Limpiar el inventario.
*   **Paso 1**: Elegí la Opción `4`.
*   **Paso 2**: Elegí "Eliminar por ID" y poné el ID de la "Caja" (el producto genérico).
*   **Paso 3**: Listá todo (Opción 2) y verificá que la caja ya no esté.

---
**¡Listo!** Si pasaste todas estas pruebas, tu proyecto está para un 10 felicitado. 🚀
