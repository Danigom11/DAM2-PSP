package Tema2_Hilos.proyecto_final;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Ejecutar en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> crearYMostrarVentana());
    }

    private static void crearYMostrarVentana() {
        // Crear la ventana principal
        JFrame ventana = new JFrame("Carrera de Corredores");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());

        // Crear el panel de carrera
        PanelCarrera panelCarrera = new PanelCarrera();

        // Crear el panel de control
        ControlPanel controlPanel = new ControlPanel(panelCarrera);

        // Añadir paneles a la ventana
        ventana.add(panelCarrera, BorderLayout.CENTER);
        ventana.add(controlPanel, BorderLayout.EAST);

        // Configurar ventana
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}