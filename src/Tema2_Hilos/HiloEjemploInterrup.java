package Tema2_Hilos;

public class HiloEjemploInterrup extends Thread{
    public void run(){
        try {
            while (!isInterrupted()){
                System.out.println("En el hilo");
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println("HA OCURRIDO UNA EXCEPCIÓN");
        }
        System.out.println("Fin hilo");
    }

    public void interrumpir() {
        interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        HiloEjemploInterrup h = new HiloEjemploInterrup();
        h.start();
        Thread.sleep(100);
        h.interrumpir();
    }

}