package Tema2.CompruebaTuAprendizaje.Ejercicio11;

public class Main {
    public static void main(String[] args) {
        Arbitro arbitro = new Arbitro(3);

        for (int i = 1; i <= 3; i++) {
            Jugador jugador = new Jugador(i, arbitro);
            jugador.start();
        }
    }

}