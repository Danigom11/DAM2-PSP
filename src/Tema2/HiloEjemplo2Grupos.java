package Tema2;

public class HiloEjemplo2Grupos extends Thread{
    public void run(){
        System.out.println("Información del hilo: " +
                Thread.currentThread().toString());
        for (int i = 0; i < 1000; i++);
        System.out.println(Thread.currentThread().getName() +
                " Finalizando la ejecución.");
    }

    public static void main(String[] args) {
        Thread.currentThread().setName("Principal");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().toString());

        ThreadGroup grupo = new ThreadGroup("Grupo de hilos");
        HiloEjemplo2Grupos h = new HiloEjemplo2Grupos();
        Thread h1 = new Thread(grupo, h, "hilo 1");
        Thread h2 = new Thread(grupo, h, "hilo 2");
        Thread h3 = new Thread(grupo, h, "hilo 3");

        h1.start();
        h2.start();
        h3.start();

        System.out.println("3 Hilos creados...");
        System.out.println("Hilos activos: " + Thread.activeCount());
    }
}