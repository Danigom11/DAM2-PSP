package Tema2.CompruebaTuAprendizaje.Ejercicio11;

public class Jugador extends Thread {
    private int idJugador;
    private Arbitro arbitro;

    public Jugador(int idJugador, Arbitro arbitro) {
        this.idJugador = idJugador;
        this.arbitro = arbitro;
    }

    @Override
    public void run() {
        while (!arbitro.estadoJuego()) {
            if (arbitro.getTurno() == idJugador) {
                int numero = 1 + (int) (10 * Math.random());
                arbitro.comprobarJugada(idJugador, numero);
            }
        }
    }
}