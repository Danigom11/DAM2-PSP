package Tema2_Hilos.CompruebaTuAprendizaje.Ejercicio10;

// Cola compartida entre productor y consumidores
public class Cola {
    private char caracter;
    private boolean disponible = false;
    private boolean finalizado = false;

    // Obtener un carácter de la cola
    public synchronized char get() {
        // Esperar mientras no haya dato disponible y no haya finalizado
        while (!disponible && !finalizado) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Si finalizó y no hay datos disponibles, devolver señal de fin
        if (finalizado && !disponible) {
            return '\0';
        }

        // Marcar que el dato ya fue consumido
        disponible = false;
        // Notificar al productor que puede poner otro carácter
        notifyAll();
        return caracter;
    }

    // Poner un carácter en la cola
    public synchronized void put(char c) {
        // Esperar mientras haya un dato disponible sin consumir
        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Poner el nuevo carácter
        caracter = c;
        disponible = true;
        // Notificar a los consumidores que hay un nuevo carácter
        notifyAll();
    }

    // Marcar que el productor finalizó
    public synchronized void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
        // Notificar a todos los consumidores en espera
        notifyAll();
    }

    // Comprobar si el productor finalizó
    public synchronized boolean isFinalizado() {
        return finalizado;
    }
}

