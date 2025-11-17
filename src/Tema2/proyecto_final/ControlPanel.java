package Tema2.proyecto_final;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    private PanelCarrera panelCarrera;

    // Botones de control
    private JButton btnIniciar;
    private JButton btnPausar;
    private JButton btnReanudar;
    private JButton btnReiniciar;

    // Campos para configuración
    private JTextField txtNumCorredores;
    private JComboBox<String> comboCorredores;

    public ControlPanel(PanelCarrera panelCarrera) {
        this.panelCarrera = panelCarrera;
        setLayout(new GridLayout(6, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Configuración de número de corredores
        add(new JLabel("Número de corredores:"));
        txtNumCorredores = new JTextField("3");
        add(txtNumCorredores);

        // Botón Iniciar Carrera
        add(new JLabel("Control general:"));
        btnIniciar = new JButton("Iniciar Carrera");
        btnIniciar.addActionListener(e -> iniciarCarrera());
        add(btnIniciar);

        // Botón Reiniciar Carrera
        add(new JLabel(""));
        btnReiniciar = new JButton("Reiniciar Carrera");
        btnReiniciar.setEnabled(false);
        btnReiniciar.addActionListener(e -> reiniciarCarrera());
        add(btnReiniciar);

        // Selector de corredor
        add(new JLabel("Seleccionar corredor:"));
        comboCorredores = new JComboBox<>();
        comboCorredores.setEnabled(false);
        add(comboCorredores);

        // Botón Pausar Corredor
        add(new JLabel("Control individual:"));
        btnPausar = new JButton("Pausar Corredor");
        btnPausar.setEnabled(false);
        btnPausar.addActionListener(e -> pausarCorredor());
        add(btnPausar);

        // Botón Reanudar Corredor
        add(new JLabel(""));
        btnReanudar = new JButton("Reanudar Corredor");
        btnReanudar.setEnabled(false);
        btnReanudar.addActionListener(e -> reanudarCorredor());
        add(btnReanudar);
    }

    // Iniciar la carrera
    private void iniciarCarrera() {
        try {
            int numCorredores = Integer.parseInt(txtNumCorredores.getText());

            // Validar valores
            if (numCorredores < 2 || numCorredores > 10) {
                JOptionPane.showMessageDialog(this,
                    "El número de corredores debe estar entre 2 y 10",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Iniciar carrera
            panelCarrera.iniciarCarrera(numCorredores);

            // Actualizar combo de corredores
            comboCorredores.removeAllItems();
            for (int i = 1; i <= numCorredores; i++) {
                comboCorredores.addItem("Corredor " + i);
            }

            // Actualizar estado de botones
            btnIniciar.setEnabled(false);
            btnReiniciar.setEnabled(true);
            btnPausar.setEnabled(true);
            btnReanudar.setEnabled(true);
            comboCorredores.setEnabled(true);
            txtNumCorredores.setEnabled(false);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Por favor, introduce valores numéricos válidos",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Pausar el corredor seleccionado
    private void pausarCorredor() {
        int indice = comboCorredores.getSelectedIndex();
        if (indice >= 0) {
            panelCarrera.pausarCorredor(indice);
        }
    }

    // Reanudar el corredor seleccionado
    private void reanudarCorredor() {
        int indice = comboCorredores.getSelectedIndex();
        if (indice >= 0) {
            panelCarrera.reanudarCorredor(indice);
        }
    }

    // Reiniciar la carrera: solo resetea el estado y habilita la configuración
    private void reiniciarCarrera() {
        // Detener hilos y limpiar panel sin iniciar de nuevo
        panelCarrera.resetCarrera();

        // Habilitar de nuevo la configuración
        txtNumCorredores.setEnabled(true);

        // Limpiar selección de corredores y deshabilitar controles individuales
        comboCorredores.removeAllItems();
        comboCorredores.setEnabled(false);
        btnPausar.setEnabled(false);
        btnReanudar.setEnabled(false);

        // Preparar para una nueva carrera (no iniciar)
        btnIniciar.setEnabled(true);
        btnReiniciar.setEnabled(false);
    }
}
