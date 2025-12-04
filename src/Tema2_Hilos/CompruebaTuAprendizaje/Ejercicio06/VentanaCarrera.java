package Tema2_Hilos.CompruebaTuAprendizaje.Ejercicio06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCarrera extends JFrame{
    // Primero los hilos
    Hilo hilo1 = new Hilo("Hilo 1");
    Hilo hilo2 = new Hilo("Hilo 2");
    Hilo hilo3 = new Hilo("Hilo 3");

    // Las tres regiones del layout
    JPanel panelNorte;
    JPanel panelCentro;

    // Boton
    JButton botonComenzarCarrera;

    // Label de los hilos
    JLabel labelHilo1;
    JLabel labelHilo2;
    JLabel labelHilo3;

    // Label prioridad
    JLabel labelPrioridad1;
    JLabel labelPrioridad2;
    JLabel labelPrioridad3;

    // Slider para elegir la prioridad
    JSlider sliderHilo1;
    JSlider sliderHilo2;
    JSlider sliderHilo3;

    // Barras de progreso
    JProgressBar progressBarHilo1;
    JProgressBar progressBarHilo2;
    JProgressBar progressBarHilo3;

    // Labels de resultados
    JLabel labelResultado1;
    JLabel labelResultado2;
    JLabel labelResultado3;

    // Label para mostrar el ganador
    JLabel labelGanador;

    // Fuente importante
    Font fuenteImportante = new Font("Arial", Font.BOLD, 30);

    // Fuente normal
    Font fuenteNormal = new Font("Arial", Font.PLAIN, 20);

    // Constructor de la ventana
    public VentanaCarrera(){
        // VENTANA PRINCIPAL
        // Título de la ventana
        setTitle("Carrera de hilos");
        // Controlar el cierre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Border layout para las regiones
        setLayout(new BorderLayout());
        // Tamaño de la ventana
        setSize(800, 600);

        // PANEL NORTE con el botón
        panelNorte = new JPanel();
        botonComenzarCarrera = new JButton("Comenzar Carrera");
        botonComenzarCarrera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comenzarCarrera();
            }
        });
        panelNorte.add(botonComenzarCarrera);
        add(panelNorte, BorderLayout.NORTH);

        // PANEL CENTRAL con BoxLayout vertical
        panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        // Crear los labels de los hilos
        labelHilo1 = new JLabel("HILO 1", SwingConstants.CENTER);
        labelHilo1.setFont(fuenteImportante);
        labelHilo2 = new JLabel("HILO 2", SwingConstants.CENTER);
        labelHilo2.setFont(fuenteImportante);
        labelHilo3 = new JLabel("HILO 3", SwingConstants.CENTER);
        labelHilo3.setFont(fuenteImportante);

        // Crear los sliders con etiquetas solo en 1, 5 y 10
        sliderHilo1 = new JSlider(1, 10, 5);
        sliderHilo1.setMajorTickSpacing(5);
        sliderHilo1.setMinorTickSpacing(1);
        sliderHilo1.setPaintTicks(true);
        sliderHilo1.setPaintLabels(true);
        java.util.Hashtable<Integer, JLabel> labelTable1 = new java.util.Hashtable<>();
        labelTable1.put(1, new JLabel("1"));
        labelTable1.put(5, new JLabel("5"));
        labelTable1.put(10, new JLabel("10"));
        sliderHilo1.setLabelTable(labelTable1);
        sliderHilo1.addChangeListener(e -> labelPrioridad1.setText("Prioridad: " + sliderHilo1.getValue()));

        sliderHilo2 = new JSlider(1, 10, 5);
        sliderHilo2.setMajorTickSpacing(5);
        sliderHilo2.setMinorTickSpacing(1);
        sliderHilo2.setPaintTicks(true);
        sliderHilo2.setPaintLabels(true);
        java.util.Hashtable<Integer, JLabel> labelTable2 = new java.util.Hashtable<>();
        labelTable2.put(1, new JLabel("1"));
        labelTable2.put(5, new JLabel("5"));
        labelTable2.put(10, new JLabel("10"));
        sliderHilo2.setLabelTable(labelTable2);
        sliderHilo2.addChangeListener(e -> labelPrioridad2.setText("Prioridad: " + sliderHilo2.getValue()));

        sliderHilo3 = new JSlider(1, 10, 5);
        sliderHilo3.setMajorTickSpacing(5);
        sliderHilo3.setMinorTickSpacing(1);
        sliderHilo3.setPaintTicks(true);
        sliderHilo3.setPaintLabels(true);
        java.util.Hashtable<Integer, JLabel> labelTable3 = new java.util.Hashtable<>();
        labelTable3.put(1, new JLabel("1"));
        labelTable3.put(5, new JLabel("5"));
        labelTable3.put(10, new JLabel("10"));
        sliderHilo3.setLabelTable(labelTable3);
        sliderHilo3.addChangeListener(e -> labelPrioridad3.setText("Prioridad: " + sliderHilo3.getValue()));

        // Crear los labels de prioridad
        labelPrioridad1 = new JLabel("Prioridad: 5", SwingConstants.CENTER);
        labelPrioridad1.setFont(fuenteNormal);
        labelPrioridad2 = new JLabel("Prioridad: 5", SwingConstants.CENTER);
        labelPrioridad2.setFont(fuenteNormal);
        labelPrioridad3 = new JLabel("Prioridad: 5", SwingConstants.CENTER);
        labelPrioridad3.setFont(fuenteNormal);

        // Crear las barras de progreso
        progressBarHilo1 = new JProgressBar();
        progressBarHilo1.setMinimum(0);
        progressBarHilo1.setMaximum(100);
        progressBarHilo1.setStringPainted(true);

        progressBarHilo2 = new JProgressBar();
        progressBarHilo2.setMinimum(0);
        progressBarHilo2.setMaximum(100);
        progressBarHilo2.setStringPainted(true);

        progressBarHilo3 = new JProgressBar();
        progressBarHilo3.setMinimum(0);
        progressBarHilo3.setMaximum(100);
        progressBarHilo3.setStringPainted(true);

        // Labels de resultados (inicialmente vacíos)
        labelResultado1 = new JLabel("", SwingConstants.CENTER);
        labelResultado1.setFont(fuenteNormal);
        labelResultado2 = new JLabel("", SwingConstants.CENTER);
        labelResultado2.setFont(fuenteNormal);
        labelResultado3 = new JLabel("", SwingConstants.CENTER);
        labelResultado3.setFont(fuenteNormal);

        // Label del ganador
        labelGanador = new JLabel("", SwingConstants.CENTER);
        labelGanador.setFont(fuenteImportante);

        // HILO 1
        // Fila con nombre, slider y prioridad
        JPanel filaHilo1 = new JPanel(new GridLayout(1, 3, 10, 0));
        filaHilo1.add(labelHilo1);
        filaHilo1.add(sliderHilo1);
        filaHilo1.add(labelPrioridad1);
        panelCentro.add(filaHilo1);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 5)));

        // Barra de progreso que ocupa todo el ancho
        JPanel filaProgreso1 = new JPanel(new BorderLayout());
        filaProgreso1.add(progressBarHilo1, BorderLayout.CENTER);
        panelCentro.add(filaProgreso1);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 15)));

        // HILO 2
        JPanel filaHilo2 = new JPanel(new GridLayout(1, 3, 10, 0));
        filaHilo2.add(labelHilo2);
        filaHilo2.add(sliderHilo2);
        filaHilo2.add(labelPrioridad2);
        panelCentro.add(filaHilo2);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 5)));

        JPanel filaProgreso2 = new JPanel(new BorderLayout());
        filaProgreso2.add(progressBarHilo2, BorderLayout.CENTER);
        panelCentro.add(filaProgreso2);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 15)));

        // HILO 3
        JPanel filaHilo3 = new JPanel(new GridLayout(1, 3, 10, 0));
        filaHilo3.add(labelHilo3);
        filaHilo3.add(sliderHilo3);
        filaHilo3.add(labelPrioridad3);
        panelCentro.add(filaHilo3);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 5)));

        JPanel filaProgreso3 = new JPanel(new BorderLayout());
        filaProgreso3.add(progressBarHilo3, BorderLayout.CENTER);
        panelCentro.add(filaProgreso3);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 20)));

        // FILA DE RESULTADOS (3 columnas)
        JPanel filaResultados = new JPanel(new GridLayout(1, 3, 10, 0));
        filaResultados.add(labelResultado1);
        filaResultados.add(labelResultado2);
        filaResultados.add(labelResultado3);
        panelCentro.add(filaResultados);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 10)));

        // FILA DEL GANADOR (centrado)
        JPanel filaGanador = new JPanel(new FlowLayout(FlowLayout.CENTER));
        filaGanador.add(labelGanador);
        panelCentro.add(filaGanador);

        add(panelCentro, BorderLayout.CENTER);



        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
    }

    private void comenzarCarrera() {
        // Limpiar resultados anteriores
        labelGanador.setText("");
        labelResultado1.setText("");
        labelResultado2.setText("");
        labelResultado3.setText("");
        progressBarHilo1.setValue(0);
        progressBarHilo2.setValue(0);
        progressBarHilo3.setValue(0);

        // Crear los 3 hilos
        hilo1 = new Hilo("Hilo 1");
        hilo2 = new Hilo("Hilo 2");
        hilo3 = new Hilo("Hilo 3");

        // Asignar la prioridad según los sliders
        hilo1.setPriority(sliderHilo1.getValue());
        hilo2.setPriority(sliderHilo2.getValue());
        hilo3.setPriority(sliderHilo3.getValue());

        // Comenzar la carrera
        hilo1.start();
        hilo2.start();
        hilo3.start();

        // Desactivar el botón de comenzar la carrera
        botonComenzarCarrera.setEnabled(false);

        // Hilo que va actualizando la ventana
        Thread actualizadorVentana = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean hayGanador = false;
                // Mientras no haya ganador
                while (!hayGanador && (hilo1.isAlive() || hilo2.isAlive() || hilo3.isAlive())){
                    // Pasar swing el control
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            // Poner la barra de progreso con el valor que corresponda
                            progressBarHilo1.setValue(hilo1.getContador());
                            progressBarHilo2.setValue(hilo2.getContador());
                            progressBarHilo3.setValue(hilo3.getContador());

                            // Mostrar resultados mientras corre
                            labelResultado1.setText(String.valueOf(hilo1.getContador()));
                            labelResultado2.setText(String.valueOf(hilo2.getContador()));
                            labelResultado3.setText(String.valueOf(hilo3.getContador()));
                        }
                    });

                    // Verificar si algún hilo ha ganado
                    if (hilo1.getContador() >= progressBarHilo1.getMaximum()){
                        hayGanador = true;
                        // Detener todos los hilos
                        hilo1.terminarHilo();
                        hilo2.terminarHilo();
                        hilo3.terminarHilo();
                        // Mostrar ganador
                        SwingUtilities.invokeLater(() -> labelGanador.setText("GANA HILO 1"));
                    } else if (hilo2.getContador() >= progressBarHilo2.getMaximum()){
                        hayGanador = true;
                        hilo1.terminarHilo();
                        hilo2.terminarHilo();
                        hilo3.terminarHilo();
                        SwingUtilities.invokeLater(() -> labelGanador.setText("GANA HILO 2"));
                    } else if (hilo3.getContador() >= progressBarHilo3.getMaximum()){
                        hayGanador = true;
                        hilo1.terminarHilo();
                        hilo2.terminarHilo();
                        hilo3.terminarHilo();
                        SwingUtilities.invokeLater(() -> labelGanador.setText("GANA HILO 3"));
                    }

                    // Descanso de actualizaciones de este hilo
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) { break; }
                }

                // Reactivar el botón para otra carrera
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        botonComenzarCarrera.setEnabled(true);
                    }
                });
            }
        });
        // Arrancar el hilo actualizador
        actualizadorVentana.setDaemon(true);
        actualizadorVentana.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaCarrera ventana = new VentanaCarrera();
                ventana.setVisible(true);
            }
        });
    }
}