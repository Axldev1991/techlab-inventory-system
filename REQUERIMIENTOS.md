# Revisión de Progreso

Estamos acercándonos a un punto clave en el desarrollo del proyecto, donde tendrán la oportunidad de mostrar lo que han aprendido hasta ahora. Es un excelente momento para compartir su progreso y recibir comentarios que les ayudarán a pulir detalles y afinar sus ideas antes de la entrega final.

Aprovechen esta instancia para obtener una visión más clara de su trabajo y hacer los ajustes necesarios para llegar a un resultado óptimo.

## Entregable

Como parte de tu avance en el curso y para prepararte para el desarrollo del Trabajo Final Integrador (TFI), se te solicita que diseñes un sistema básico que permita gestionar información inicial sobre los productos de la empresa. Este proyecto servirá como la base sobre la cual construirás funcionalidades más complejas en las próximas semanas. Así, podrán recibir comentarios que les permitirán fortalecer su proyecto y enfocarse en los detalles clave para la etapa final.

## Revisión de Progreso (Continuación)

Esta instancia evaluativa es de carácter obligatorio y es un punto clave dentro de la cursada ya que nos permitirá evaluar tu progreso en el recorrido y asegurar que estás en el camino correcto en la construcción del Proyecto Final Integrador.

## Preentrega de Proyecto

Se evaluará la aplicación de los conocimientos adquiridos en la realización de un proyecto. La realización progresiva de los "Ejercicios prácticos" los guiará paso a paso hacia la realización de la "Preentrega" y el "Proyecto Integrador Final".

Vas a desarrollar un programa en Java que cumpla con las siguientes características:

### Objetivo General

Diseñar una aplicación en Java que permita registrar, mostrar y gestionar productos, así como crear pedidos que involucren varios productos. El sistema deberá hacer uso de variables, operadores, colecciones (listas), POO (clases, objetos, encapsulamiento, herencia, polimorfismo), excepciones y organización de código en paquetes/módulos.

---

### Requerimientos

#### Ingreso de productos
El sistema debe permitir agregar productos con la siguiente información mínima:
*   **Nombre del producto**: cadena de texto (ej. "Café Premium").
*   **Precio**: double (admite decimales).
*   **Cantidad en Stock**: int.
*   **Almacenamiento**: Estos productos deben almacenarse en una colección (ej. `ArrayList<Producto>`).

#### Visualización de productos
Debe haber una funcionalidad que liste en pantalla todos los productos registrados, mostrando su:
*   ID (o posición).
*   Nombre.
*   Precio.
*   Cantidad en Stock.
*   *Nota*: El ID puede ser autogenerado (ej. un contador estático) o la posición en la lista.

#### Búsqueda y actualización de productos
*   El sistema permitirá buscar un producto por su nombre o ID.
*   Si se encuentra el producto, se mostrará su información completa.
*   **Opcional**: Se podrá actualizar alguno de sus datos (precio o stock), validando que los valores sean coherentes (ej. que el stock no sea negativo).

#### Eliminación de productos
*   El sistema debe permitir eliminar un producto de la lista, identificándolo por su ID o posición en la colección.
*   **Opcional**: Antes de eliminar, el sistema podría pedir confirmación.

#### Creación de pedidos
Además de manejar productos, se sugiere agregar la clase **Pedido** (o Orden) que contenga:
*   Una lista de productos asociados.
*   Cantidad deseada de cada producto (por ejemplo, usando un objeto intermedio `LineaPedido` o similar).

**El sistema debe permitir crear un pedido nuevo:**
1.  Solicitar al usuario qué productos desea y en qué cantidad (validar que haya suficiente stock).
2.  Calcular el costo total (sumando precio * cantidad de cada producto).
3.  Disminuir el stock de cada producto si el pedido se confirma.
4.  **Funcionalidad**: Debe haber una forma de mostrar los pedidos realizados, su costo total y la lista de productos asociados.

---

### Menú Principal Interactivo

El programa presentará un menú con opciones (el menú se repetirá hasta elegir Salir):
1.  Agregar producto
2.  Listar productos
3.  Buscar/Actualizar producto
4.  Eliminar producto
5.  Crear un pedido
6.  Listar pedidos (opcionales)
7.  Salir

---

### Requerimientos Técnicos

#### Tipos de datos y variables
*   Emplear variables de tipo `int` (cantidades/IDs), `double` (precios), `String` (nombres) y `boolean` si fuera necesario.
*   Uso de operadores aritméticos, lógicos y relacionales en funciones de cálculo y validación.

#### Colecciones (Arrays, Listas)
*   `ArrayList<Producto>` para el inventario.
*   Para productos dentro de un pedido: `ArrayList<LineaPedido>` o un `Map<Integer, Integer>` (detalles a tu elección).

#### POO y Colaboración de Clases
*   **Clase Producto**: id, nombre, precio, stock, getters y setters.
*   **Clase Pedido**: id, lista de productos/líneas, métodos para calcular total, etc.
*   **Clase Principal (Main)**: orquesta el menú, invoca métodos de servicios (ej. un `ProductoService` que encapsule la lógica).

#### Herencia/Polimorfismo (Opcional para extender)
*   Podés crear subclases de Producto (ej. `Bebida`, `Comida`) con atributos específicos (vencimiento, volumen, etc.).
*   Mostrar cómo el polimorfismo ayuda a tratar distintos productos de forma genérica.

#### Excepciones
*   Manejar errores con `try/catch`. Ejemplo: `NumberFormatException` al convertir datos.
*   Excepción personalizada: `StockInsuficienteException` al intentar crear un pedido con cantidad mayor al stock.

#### Paquetes / Módulos (Organización)
*   `com.techlab.productos` (Producto, Bebida, etc.)
*   `com.techlab.pedidos` (Pedido, LineaPedido)
*   `com.techlab.excepciones` (Excepciones personalizadas)

---

### Ejemplo de flujo de uso (Escenario)

1.  **Menú**: Aparecen las opciones del 1 al 7.
2.  **Agregar**: Selecciona "1". El programa pregunta nombre, precio, stock. Se crea el objeto y se agrega a la lista.
3.  **Listar**: Selecciona "2". Muestra todos los productos con id, nombre, precio, stock.
4.  **Crear Pedido**: Selecciona "5". El sistema pregunta cuántos productos va a agregar, pide ID y cantidad. Verifica stock; si no hay suficiente, lanza `StockInsuficienteException` o un mensaje apropiado. Si se confirma, descuenta stock y crea el pedido.
5.  **Salir**: Selecciona "7". El programa finaliza.
