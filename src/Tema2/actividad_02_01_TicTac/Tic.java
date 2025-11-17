package Tema2.actividad_02_01_TicTac;

public class Tic extends Thread{
    public void run(){
        while (true) {
            System.out.println("TIC");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}