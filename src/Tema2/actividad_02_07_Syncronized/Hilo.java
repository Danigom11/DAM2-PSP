package Tema2.actividad_02_07_Syncronized;

public class Hilo extends Thread{
    int contador = 0;
    public Hilo(String nombre, int contador){
        setName(nombre);
        this.contador = contador;
    }

    // Incrementa el contador compartido 5000 veces
    public void incrementarContadorCompartido(Contador contador) {
        for (int i = 0; i < 5000; i++) {
            contador.incrementar();
        }
    }
}