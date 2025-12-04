package Tema2_Hilos.CompruebaTuAprendizaje.Ejercicio02;

/*
2º) Crea una clase que implemente la interfaz Runnable cuya única funcionalidad sea visualizar el mensaje
"Hola mundo" seguido de una cadena que se recibirá en el constructor (es decir al crear un objeto de este
tipo se enviará una cadena) y seguido del identificador del hilo.
 */

import static java.lang.Thread.sleep;

public class HolaMundo implements Runnable {
    String cadena;

    public HolaMundo(String cadena) {
        this.cadena = cadena;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public void run() {
        try {
            sleep(Thread.currentThread().getId()*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hola mundo " + getCadena() + " ID del hilo: " + Thread.currentThread().getId());
    }
}