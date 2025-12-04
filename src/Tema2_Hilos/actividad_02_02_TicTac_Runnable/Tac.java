package Tema2_Hilos.actividad_02_02_TicTac_Runnable;

import static java.lang.Thread.sleep;

public class Tac implements Runnable{
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