package Tema2_Hilos.CompruebaTuAprendizaje.Ejercicio09;

public class Hilo extends Thread {
    private int CONTADOR = 0;
    private boolean hiloParado = false;

    // Un constructor para crear objetos del hilo con un nombre
    public Hilo(String name) {
        super(name);
    }

    // Método que detiene el hilo
    public void pararHilo() {
        hiloParado = true;
    }

    // Método que reanuda el hilo
    public void reaundarHilo() {
        hiloParado = false;
    }

    // Lo que hace el hilo
    public void run() {
        // Mientras no esté interrumpido
        while (!isInterrupted()) {
            // Siempre que no esté parado
            while (!hiloParado) {
                // Suma 1 al contador
                CONTADOR++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public void interrumpirHilo() {
        interrupt();
    }

    // Obtener el valor del contador que tenga
    public int getCONTADOR() {
        return CONTADOR;
    }

    // Obtener si está detenido el hilo
    public boolean getHiloParado() {
        return hiloParado;
    }
}