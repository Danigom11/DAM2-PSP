package Tema2_Hilos.CompruebaTuAprendizaje.Ejercicio02;

import static java.lang.Thread.sleep;

/*
Crea un programa Java que visualice el mensaje anterior 5 veces creando para ello 5 hilos diferentes usando
 la clase creada anteriormente. Luego haz que antes de visualizar el mensaje el hilo espere un tiempo
  proporcional a su identificador; usa para ello el método sleep().
 */
public class VerHolaMundo {
    public static void main(String[] args) throws InterruptedException {
        Thread hilo = null;
        for (int i = 0; i < 5; i++) {
            hilo = new Thread(new HolaMundo("Mensaje " + (i+1)));
            hilo.start();
        }

    }

}