package Tema2.actividad_02_04_Hilo_Suspender;

import java.util.Scanner;

public class MyHilo extends Thread {
    private SolicitaSuspender suspender = new SolicitaSuspender();
    private int CONTADOR = 0;
    private boolean pararHilo = true;

    // Método para suspender el hilo
    public void suspender() { suspender.set(true); }

    // Método para reanudar el hilo
    public void reanudar() { suspender.set(false); }

    // Método para obtener el valor actual del contador
    public int getContador() { return CONTADOR; }

    // Método para finalizar el hilo
    public void finalizar() { pararHilo = false; }

    // Método principal del hilo
    public void run() {
        try {
            while (pararHilo) {
                CONTADOR++;
                System.out.println(CONTADOR);
                Thread.sleep(1000); // Pausa para ver el avance
                suspender.esperandoParaReanudar(); // Suspende si corresponde
            }
            // Mensaje al finalizar el bucle
            System.out.println("El hilo ha terminado. Valor final del contador: " + CONTADOR);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método main para probar la clase
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyHilo hilo = null;
        boolean hiloLanzado = false;
        String entrada;
        System.out.println("Introduce S para suspender, R para reanudar, * para terminar:");
        do {
            entrada = sc.nextLine().trim();
            if (!hiloLanzado) {
                hilo = new MyHilo();
                hilo.start();
                hiloLanzado = true;
            }
            if (entrada.equalsIgnoreCase("S")) {
                hilo.suspender();
                System.out.println("Hilo suspendido. R parar reanudar, * para terminar:");
            } else if (entrada.equalsIgnoreCase("R")) {
                hilo.reanudar();
                System.out.println("Hilo reanudado");
            }
        } while (!entrada.equals("*"));
        // Finalizar el hilo y mostrar el valor final
        hilo.finalizar();
        System.out.println("Proceso terminado. Valor final del contador: " + hilo.getContador());
    }
}