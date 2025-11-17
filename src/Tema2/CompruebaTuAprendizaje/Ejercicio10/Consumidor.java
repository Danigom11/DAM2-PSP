package Tema2.CompruebaTuAprendizaje.Ejercicio10;

// Consumidor que obtiene caracteres de la cola y los muestra
public class Consumidor extends Thread {
    private Cola cola;
    private int id;

    public Consumidor(Cola cola, int id) {
        this.cola = cola;
        this.id = id;
    }

    @Override
    public void run() {
        char caracter;
        // Consumir caracteres hasta que la cola indique que finalizó
        while (true) {
            caracter = cola.get();
            if (caracter == '\0') {
                // El productor finalizó y no hay más caracteres
                break;
            }
            System.out.print(caracter);
        }
        System.out.println("\nConsumidor " + id + " ha finalizado");
    }
}