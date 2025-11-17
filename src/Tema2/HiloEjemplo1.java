package Tema2;

// Importante que extienda de Thread (hilo)
public class HiloEjemplo1 extends Thread{
    // Constructor
    public HiloEjemplo1(String nombre){
        super(nombre);
        System.out.println("--- CONSTRUCTOR DEL HILO ---");
        System.out.println("Creando hilo: " + getName());
    }

    // Método run que define la lógica de lo que hará cada hilo cuando se inicie son start()
    public void run(){
        for (int i = 0; i<5; i++)
            System.out.println("Hilo: " + getName() + " C = " + i);
    }

    public static void main (String[] args){
        // Al crearlos se ejecuta los constructores de cada 1
        HiloEjemplo1 h1 = new HiloEjemplo1("Hilo 1");
        HiloEjemplo1 h2 = new HiloEjemplo1("Hilo 2");
        HiloEjemplo1 h3 = new HiloEjemplo1("Hilo 3");

        // Se inician
        h1.start();
        h2.start();
        h3.start();

        System.out.println("3 Hilos iniciados...");
     }

}