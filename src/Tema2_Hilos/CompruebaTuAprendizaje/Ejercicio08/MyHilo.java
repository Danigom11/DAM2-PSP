package Tema2_Hilos.CompruebaTuAprendizaje.Ejercicio08;

public class MyHilo extends Thread {
    private SolicitaSuspender suspender = new SolicitaSuspender();
    private int CONTADOR = 0;
    private boolean pararHilo = true;

    // Constructor que recibe el nombre del hilo
    public MyHilo(String nombre) {
        super(nombre);
    }

    // Método para suspender el hilo
    public void suspender() { suspender.set(true); }

    // Método para reanudar el hilo
    public void reanudar() { suspender.set(false); }

    // Método para obtener el valor actual del contador
    public int getContador() { return CONTADOR; }

    // Método para finalizar el hilo
    public void finalizar() { pararHilo = false; }

    // Método para saber si el hilo está suspendido
    public boolean estaSuspendido() { return suspender.estaSuspendido(); }

    // Método principal del hilo
    public void run() {
        try {
            while (pararHilo) {
                CONTADOR++;
                Thread.sleep(300); // Pausa para ver el avance
                suspender.esperandoParaReanudar(); // Suspende si corresponde
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método main para lanzar la ventana gráfica
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaHilos ventana = new VentanaHilos();
                ventana.setVisible(true);
            }
        });
    }
}