package Tema2.actividad_02_04_Hilo_Suspender;

public class SolicitaSuspender {
    private boolean suspender;

    public synchronized void set(boolean b){
        suspender = b; // cambio de estado sobre el objeto
        notifyAll(); // notificar el cambio de estado
    }
    public synchronized void esperandoParaReanudar()
        throws InterruptedException {
        while (suspender) wait(); // Suspender el hilo hasta recibir el notify() o notifyAll()
    }
}