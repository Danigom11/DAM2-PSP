package Tema2.CompruebaTuAprendizaje.Ejercicio06;

public class Hilo extends Thread {
    private int contador = 0;
    private boolean stopHilo = false;
    private long tiempoSleep;

    public Hilo(String name) {
        super(name);
        // Tiempo aleatorio de sleep según las instrucciones: (long) Math.random() * 1000 + 1
        this.tiempoSleep = (long) (Math.random() * 1000) + 1;
    }

    public void run() {
        while (!stopHilo && contador < 100) {
            contador++;
            try {
                Thread.sleep(tiempoSleep);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void terminarHilo() {
        stopHilo = true;
    }

    public int getContador(){
        return contador;
    }
}