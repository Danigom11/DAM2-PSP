package Tema2;

public class HiloJoin extends Thread {
    private int repeticiones;

    public HiloJoin(String nombreHilo, int repeticiones) {
        super(nombreHilo);
        this.repeticiones = repeticiones;
    }

    public void run() {
        for (int i = 1; i <= repeticiones; i++) {
            System.out.println(getName() + ": " + i);
            try {
                sleep(1000);
            } catch (InterruptedException ignore) {
            }
        }
        System.out.println("Fin Bucle " + getName());
    }
}