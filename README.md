# DAM2 - Programación de Servicios y Procesos (PSP)

Este repositorio contiene los ejercicios, prácticas y proyectos desarrollados durante el módulo de **Programación de Servicios y Procesos** del ciclo formativo de **Desarrollo de Aplicaciones Multiplataforma (DAM)** de segundo curso.

## 📚 Estructura del Proyecto

El proyecto está organizado en dos temas principales:

### 📁 Tema 1: Programación Multiproceso
Ejemplos y actividades sobre creación y gestión de procesos en Java:

- **Creación de procesos**: Uso de `ProcessBuilder` para crear y ejecutar procesos
- **Comunicación entre procesos**: Lectura y escritura de streams
- **Redirección de entrada/salida**: Manejo de flujos de datos
- **Variables de entorno**: Configuración y uso

**Actividades incluidas:**
- Actividad 01.04: Ejecutar y leer nombre
- Actividad 01.05: Mostrar errores
- Actividad 01.06: Sumar dos números
- Actividad 01.07 y 01.08: Lectura modificada y redirección
- Ejercicios de Comprueba tu Aprendizaje (04-09)

### 📁 Tema 2: Programación Multihilo
Ejemplos y actividades sobre programación concurrente con hilos en Java:

- **Creación de hilos**: Extensión de `Thread` e implementación de `Runnable`
- **Sincronización**: Uso de `synchronized` para evitar condiciones de carrera
- **Control de hilos**: Join, prioridades, interrupciones
- **Comunicación entre hilos**: Wait/notify, productor-consumidor
- **Interfaces gráficas**: Integración de hilos con Swing

**Actividades incluidas:**
- Actividades 02.01-02.07: TicTac, Runnable, Frames, Suspender, Synchronized
- Ejercicios de Comprueba tu Aprendizaje (01, 02, 06, 08-11)
- **Proyecto Final**: Simulador de carrera de corredores con interfaz gráfica

## 🎯 Proyecto Final: Carrera de Corredores

Aplicación gráfica desarrollada con Java Swing que simula una carrera de corredores utilizando hilos.

**Características:**
- Simulación visual de corredores en una pista
- Panel de control para gestionar la carrera
- Uso de multithreading para animar cada corredor de forma independiente
- Interfaz gráfica intuitiva

**Archivos principales:**
- `Main.java`: Punto de entrada de la aplicación
- `Corredor.java`: Clase que representa cada corredor (hilo)
- `PanelCarrera.java`: Panel que dibuja la carrera
- `ControlPanel.java`: Panel de control de la aplicación

## 🛠️ Requisitos

- **Java JDK**: 8 o superior
- **IDE recomendado**: IntelliJ IDEA (aunque puede usarse cualquier IDE compatible con Java)

## ▶️ Cómo Ejecutar

### Ejecutar el Proyecto Final
```bash
# Compilar
javac src/Tema2_Hilos/proyecto_final/*.java

# Ejecutar
java -cp src Tema2_Hilos.proyecto_final.Main
```

### Ejecutar otros ejemplos
Cada archivo Java puede ejecutarse de forma independiente desde su respectivo directorio.

## 📖 Aprendizajes

Este proyecto demuestra competencias en:
- ✅ Gestión de procesos del sistema operativo
- ✅ Programación concurrente con hilos
- ✅ Sincronización y comunicación entre hilos
- ✅ Desarrollo de interfaces gráficas con Swing
- ✅ Manejo de streams y comunicación entre procesos
- ✅ Buenas prácticas en programación Java

## 👨‍💻 Autor

Desarrollado como parte del ciclo formativo DAM2 - Programación de Servicios y Procesos

## 📝 Licencia

Este proyecto es de uso educativo.

---

**Curso**: 2024-2025  
**Módulo**: Programación de Servicios y Procesos (PSP)  
**Ciclo**: Desarrollo de Aplicaciones Multiplataforma (DAM2)

