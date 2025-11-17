package Tema2;

public class HiloEjemplo1_V2 extends Thread{
    public HiloEjemplo1_V2(String nombre) {
        super(nombre);
        System.out.println("--- CONSTRUCTOR DEL HILO ---");
        System.out.println("Creando hilo: " + getName());
    }
    // Método run
    public void run() {
        for (int i = 0; i<5; i++){
            System.out.println("Hilo: " + getName() + " C = " + i);
        }
    }
}