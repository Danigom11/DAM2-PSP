package Tema2_Hilos;

public class PrimerHilo extends Thread{
    private int x;
    // Constructor
    PrimerHilo(int x){
        this.x = x;
    }

    public void run() {
        for (int i = 0; i< x; i++)
            System.out.println("En el hilo... " + i);
    }

}