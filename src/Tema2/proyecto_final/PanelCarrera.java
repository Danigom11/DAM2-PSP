package Tema2.proyecto_final;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PanelCarrera extends JPanel {
    private List<Corredor> corredores;
    private boolean carreraIniciada = false;
    private boolean carreraTerminada = false;
    private Corredor ganador = null;
    private Timer timer;
    private static final int META = 100;

    public PanelCarrera() {
        corredores = new ArrayList<>();
        setPreferredSize(new Dimension(800, 400));
        setBackground(Color.WHITE);

        // Timer para actualizar la vista cada 50ms
        timer = new Timer(50, e -> repaint());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dimensiones del panel
        int ancho = getWidth();
        int alto = getHeight();
        int alturaPorCorredor = alto / (corredores.size() + 1);

        // Dibujar línea de meta
        g.setColor(Color.RED);
        int metaX = ancho - 50;
        g.drawLine(metaX, 0, metaX, alto);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString("META", metaX - 30, 20);

        // Dibujar cada corredor
        for (int i = 0; i < corredores.size(); i++) {
            Corredor corredor = corredores.get(i);
            int y = (i + 1) * alturaPorCorredor;

            // Calcular posición X según el progreso
            int maxRecorrido = metaX - 100;
            int posX = 50 + (maxRecorrido * corredor.getPosicion() / META);

            // Color según el estado
            if (corredor.getPosicion() >= META) {
                g.setColor(Color.GREEN);
            } else if (corredor.isPausado()) {
                g.setColor(Color.ORANGE);
            } else {
                g.setColor(Color.BLUE);
            }

            // Dibujar el corredor como un círculo
            g.fillOval(posX, y - 15, 30, 30);

            // Dibujar nombre y posición
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 12));
            g.drawString(corredor.getNombre(), 10, y);
            g.drawString(corredor.getPosicion() + "%", posX + 5, y + 5);
        }

        // Mostrar ganador si la carrera terminó
        if (carreraTerminada && ganador != null) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 24));
            String mensaje = "¡GANADOR: " + ganador.getNombre() + "!";
            int mensajeX = (ancho - g.getFontMetrics().stringWidth(mensaje)) / 2;
            g.drawString(mensaje, mensajeX, alto - 30);
        }
    }

    // Iniciar la carrera con los corredores
    public void iniciarCarrera(int numCorredores) {
        // Limpiar corredores anteriores
        corredores.clear();
        carreraIniciada = false;
        carreraTerminada = false;
        ganador = null;

        // Crear nuevos corredores
        for (int i = 1; i <= numCorredores; i++) {
            Corredor corredor = new Corredor("Corredor " + i, this);
            corredores.add(corredor);
        }

        // Iniciar todos los hilos
        for (Corredor corredor : corredores) {
            corredor.start();
        }

        carreraIniciada = true;
        timer.start();
    }

    // Método llamado cuando un corredor termina
    public synchronized void corredorTermino(Corredor corredor) {
        if (ganador == null && !carreraTerminada) {
            ganador = corredor;
            carreraTerminada = true;

            // Detener todos los demás corredores
            for (Corredor c : corredores) {
                if (c != ganador) {
                    c.terminar();
                }
            }

            // Parar el timer de repintado al finalizar
            if (timer.isRunning()) {
                timer.stop();
            }

            // Guardar resultados en archivo
            guardarResultados();

            repaint();
        }
    }

    // Guardar resultados en fichero
    private void guardarResultados() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("resultados_carrera.txt", true))) {
            writer.println("=== RESULTADO DE LA CARRERA ===");
            writer.println("Ganador: " + ganador.getNombre());
            writer.println("Tiempo: " + ganador.getTiempoTotal() + " ms");
            writer.println("Resultados de todos los corredores:");

            for (Corredor c : corredores) {
                writer.println("  - " + c.getNombre() + ": " + c.getPosicion() + "% completado");
            }

            writer.println("================================\n");

        } catch (IOException e) {
            System.err.println("Error al guardar resultados: " + e.getMessage());
        }
    }

    // Pausar un corredor específico
    public void pausarCorredor(int indice) {
        if (indice >= 0 && indice < corredores.size()) {
            corredores.get(indice).pausar();
        }
    }

    // Reanudar un corredor específico
    public void reanudarCorredor(int indice) {
        if (indice >= 0 && indice < corredores.size()) {
            corredores.get(indice).reanudar();
        }
    }

    // Reiniciar la carrera (mantengo por compatibilidad): resetea y vuelve a iniciar
    public void reiniciarCarrera(int numCorredores) {
        // Primero resetear
        resetCarrera();
        // Luego iniciar de nuevo (método legado)
        iniciarCarrera(numCorredores);
    }

    // Resetear la carrera: detener hilos, parar timer y limpiar estado sin iniciar nada
    public void resetCarrera() {
        // Terminar todos los hilos actuales
        for (Corredor c : corredores) {
            c.terminar();
        }

        // Parar timer si está corriendo
        if (timer.isRunning()) {
            timer.stop();
        }

        // Esperar a que terminen todos
        for (Corredor c : corredores) {
            try {
                c.join(1000);
            } catch (InterruptedException e) {
                // Interrupción al esperar: salir del bucle
                break;
            }
        }

        // Limpiar estado y vista
        corredores.clear();
        carreraIniciada = false;
        carreraTerminada = false;
        ganador = null;
        repaint();
    }

    // Getters
    public List<Corredor> getCorredores() {
        return corredores;
    }

    public boolean isCarreraIniciada() {
        return carreraIniciada;
    }

    public boolean isCarreraTerminada() {
        return carreraTerminada;
    }
}