package Tema2_Hilos.actividad_02_02_TicTac_Runnable;

public class Main {
    public static void main(String[] args) {
        Thread.currentThread().setName("Principal");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().toString());

        Tac tac = new Tac();

        new Thread(new Tic()).start();
        new Thread(new Tac()).start();
    }

}