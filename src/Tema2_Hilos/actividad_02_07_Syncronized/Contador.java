package Tema2_Hilos.actividad_02_07_Syncronized;

// Clase que representa el contador compartido
public class Contador {
    private int contador = 0;

    // Incrementa el contador de forma sincronizada
    public synchronized void incrementar() {
        contador++;
    }

    // Devuelve el valor actual del contador
    public int getContador() {
        return contador;
    }
}
