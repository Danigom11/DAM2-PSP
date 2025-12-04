package Tema2_Hilos.actividad_02_01_TicTac;

public class Main {
    public static void main(String[] args) {
        Thread.currentThread().setName("Principal");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().toString());

        Tic tic = new Tic();
        Tac tac = new Tac();

        tic.start();
        tac.start();
    }

}