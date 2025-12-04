package Tema2_Hilos.actividad_02_07_Syncronized;

// Programa principal que lanza los hilos y muestra el resultado
public class Main {
    public static void main(String[] args) {
        Contador contador = new Contador();
        Thread[] hilos = new Thread[5];

        // Crear y arrancar los 5 hilos directamente con Runnable
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < 5000; j++) {
                    contador.incrementar();
                }
            }, "Hilo-" + (i+1));
            hilos[i].start();
        }

        // Mostrar el resultado final
        System.out.println("Valor esperado: 25000");
        System.out.println("Valor real: " + contador.getContador());
    }
}
