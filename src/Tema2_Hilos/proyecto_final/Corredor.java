package Tema2_Hilos.proyecto_final;

public class Corredor extends Thread {
    private String nombre;
    private int posicion = 0;
    private boolean pausado = false;
    private boolean terminado = false;
    private PanelCarrera panelCarrera;
    private long tiempoInicio;
    private long tiempoFinal;

    public Corredor(String nombre, PanelCarrera panelCarrera) {
        super(nombre);
        this.nombre = nombre;
        this.panelCarrera = panelCarrera;
    }

    @Override
    public void run() {
        tiempoInicio = System.currentTimeMillis();

        // Mientras no haya terminado y no llegue a la meta
        while (!terminado && posicion < 100) {
            // Esperar si está pausado
            synchronized (this) {
                while (pausado && !terminado) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }

            // Si ya terminó, salir del bucle
            if (terminado) break;

            // Avanzar posición
            posicion++;

            // Dormir el hilo con tiempo aleatorio
            try {
                long tiempoSleep = (long) (Math.random() * 100) + 1;
                Thread.sleep(tiempoSleep);
            } catch (InterruptedException e) {
                break;
            }
        }

        // Registrar tiempo final
        tiempoFinal = System.currentTimeMillis();

        // Notificar al panel que este corredor ha terminado
        if (posicion >= 100 && !terminado) {
            panelCarrera.corredorTermino(this);
        }
    }

    // Pausar el corredor
    public synchronized void pausar() {
        pausado = true;
    }

    // Reanudar el corredor
    public synchronized void reanudar() {
        pausado = false;
        notify();
    }

    // Reiniciar el corredor
    public synchronized void reiniciar() {
        posicion = 0;
        pausado = false;
        terminado = false;
    }

    // Terminar el corredor
    public synchronized void terminar() {
        terminado = true;
        pausado = false;
        notify();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public boolean isPausado() {
        return pausado;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public long getTiempoTotal() {
        return tiempoFinal - tiempoInicio;
    }
}