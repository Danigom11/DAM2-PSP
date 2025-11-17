package Tema2.CompruebaTuAprendizaje.Ejercicio11;

public class Arbitro {
    private int numJugadores;
    private int turno;
    private int numAdivinar;
    private boolean juegoAcabado;

    public Arbitro(int numJugadores) {
        this.numJugadores = numJugadores;
        this.turno = 1;
        this.numAdivinar = 1 + (int) (10 * Math.random());
        this.juegoAcabado = false;
        System.out.println("NÚMERO A ADIVINAR: " + numAdivinar);
    }

    public int getTurno() {
        return turno;
    }

    public boolean estadoJuego() {
        return juegoAcabado;
    }

    public synchronized void comprobarJugada(int idJugador, int numero) {
        System.out.println("Jugador" + idJugador + " dice: " + numero);

        if (numero == numAdivinar) {
            System.out.println("    Jugador " + idJugador + " gana, adivinó el número!!!");
            juegoAcabado = true;
        } else {
            turno++;
            if (turno > numJugadores) {
                turno = 1;
            }
            System.out.println("    Le toca a Jug" + turno);
        }
    }
}