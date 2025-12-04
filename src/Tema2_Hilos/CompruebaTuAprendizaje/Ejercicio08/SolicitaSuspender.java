package Tema2_Hilos.CompruebaTuAprendizaje.Ejercicio08;

public class SolicitaSuspender {
    private boolean suspender;

    public synchronized void set(boolean b){
        suspender = b; // cambio de estado sobre el objeto
        notifyAll(); // notificar el cambio de estado
    }

    public synchronized boolean estaSuspendido() {
        return suspender;
    }

    public synchronized void esperandoParaReanudar()
        throws InterruptedException {
        while (suspender) wait(); // Suspender el hilo hasta recibir el notify() o notifyAll()
    }
}