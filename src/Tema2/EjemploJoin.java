package Tema2;

public class EjemploJoin {
    public static void main(String[] args) {
        HiloJoin hilo1 = new HiloJoin("Hilo1", 2);
        HiloJoin hilo2 = new HiloJoin("Hilo2", 5);
        HiloJoin hilo3 = new HiloJoin("Hilo3", 7);
        hilo1.start();
        hilo2.start();
        hilo3.start();
        try {
            hilo1.join(); hilo2.join(); hilo3.join();
        } catch (InterruptedException e) { }
        System.out.println("Final del programa");
    }
}