package Tema2.CompruebaTuAprendizaje.Ejercicio10;

public class Produc_Consum {
    public static void main(String[] args) {
        String rutaFichero = "src/main/java/org/example/CompruebaTuAprendizaje/Ejercicio10/fichero.txt";

        // Crear la cola compartida
        Cola cola = new Cola();

        // Crear el productor
        Productor productor = new Productor(cola, rutaFichero);

        // Crear varios consumidores
        int numConsumidores = 3;
        Consumidor[] consumidores = new Consumidor[numConsumidores];
        for (int i = 0; i < numConsumidores; i++) {
            consumidores[i] = new Consumidor(cola, i + 1);
        }

        // Iniciar el productor
        productor.start();

        // Iniciar los consumidores
        for (Consumidor consumidor : consumidores) {
            consumidor.start();
        }

        // Esperar a que el productor termine
        try {
            productor.join();
            System.out.println("\nEstado del productor: " + productor.getState());

            // Esperar un poco para que los consumidores procesen
            Thread.sleep(1000);

            // Comprobar el estado de los consumidores
            System.out.println("\nEstado de los consumidores");
            for (int i = 0; i < numConsumidores; i++) {
                System.out.println("Consumidor " + (i + 1) + ": " + consumidores[i].getState());
            }

        } catch (InterruptedException e) { }
    }
}

