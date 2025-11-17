package Tema2.actividad_02_02_TicTac_Runnable;

import static java.lang.Thread.sleep;

public class Tic implements Runnable{
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