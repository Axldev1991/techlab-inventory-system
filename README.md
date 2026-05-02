# TechLab Inventory System 🚀

Sistema Profesional de Gestión de Inventarios desarrollado en Java.

## Características
- **Programación Orientada a Objetos**: Implementación de Herencia, Polimorfismo y Composición.
- **Robustez**: Manejo de excepciones personalizadas (`StockInsuficienteException`) y validación de entradas.
- **Funcionalidad**: CRUD completo para inventario y gestión de pedidos multi-producto.
- **Arquitectura Limpia**: Código refactorizado para alta mantenibilidad y legibilidad.

## Cómo Ejecutar
```bash
mvn compile
mvn exec:java
```

## Pruebas (Testing)
El proyecto incluye una suite de pruebas de integración completa:
```bash
mvn exec:java -Dexec.mainClass="com.techlab.TestIntegral"
```
