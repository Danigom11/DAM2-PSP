package Tema2.CompruebaTuAprendizaje.Ejercicio01;

public class VerHolaMundo {
    public static void main(String[] args) {
        // Grupo
        ThreadGroup grupo = new ThreadGroup("Grupo de Hola Mundo");
        HolaMundo holaMundo = null;
        for (int i = 0; i < 5; i++){
            holaMundo = new HolaMundo();
            holaMundo.setName("Hilo" + (i+1));
            holaMundo.start();
        }
    }
}