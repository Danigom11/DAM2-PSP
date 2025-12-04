package Tema2_Hilos.actividad_02_01_TicTac;

public class Tac extends Thread{
    public void run(){
        while (true) {
            System.out.println("TAC");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}