package Tema2_Hilos.CompruebaTuAprendizaje.Ejercicio08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaHilos extends JFrame {
    private MyHilo hilo1;
    private MyHilo hilo2;

    private JLabel labelContador1;
    private JLabel labelContador2;
    private JLabel labelEstado1;
    private JLabel labelEstado2;

    private JButton btnReanudar1;
    private JButton btnSuspender1;
    private JButton btnReanudar2;
    private JButton btnSuspender2;
    private JButton btnComenzar;
    private JButton btnFinalizar;

    public VentanaHilos() {
        setTitle("EJECUTAR, SUSPENDER Y REANUDAR HILOS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(600, 300);

        // Panel superior con botón "Comenzar Proceso"
        JPanel panelSuperior = new JPanel();
        btnComenzar = new JButton("Comenzar Proceso");
        btnComenzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comenzarProceso();
            }
        });
        panelSuperior.add(btnComenzar);
        add(panelSuperior, BorderLayout.NORTH);

        // Panel central con los dos hilos
        JPanel panelCentral = new JPanel(new GridLayout(1, 2, 10, 0));

        // Panel para HILO 1
        JPanel panelHilo1 = new JPanel();
        panelHilo1.setLayout(new BoxLayout(panelHilo1, BoxLayout.Y_AXIS));
        panelHilo1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        btnReanudar1 = new JButton("Reanudar");
        btnReanudar1.setEnabled(false);
        btnReanudar1.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnReanudar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hilo1.reanudar();
                btnReanudar1.setEnabled(false);
                btnSuspender1.setEnabled(true);
            }
        });

        btnSuspender1 = new JButton("Suspender");
        btnSuspender1.setEnabled(false);
        btnSuspender1.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSuspender1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hilo1.suspender();
                btnReanudar1.setEnabled(true);
                btnSuspender1.setEnabled(false);
            }
        });

        labelContador1 = new JLabel("", SwingConstants.CENTER);
        labelContador1.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelContador1.setFont(new Font("Arial", Font.BOLD, 20));

        labelEstado1 = new JLabel("HILO 1", SwingConstants.CENTER);
        labelEstado1.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelEstado1.setFont(new Font("Arial", Font.PLAIN, 14));

        panelHilo1.add(btnReanudar1);
        panelHilo1.add(Box.createRigidArea(new Dimension(0, 10)));
        panelHilo1.add(btnSuspender1);
        panelHilo1.add(Box.createRigidArea(new Dimension(0, 20)));
        panelHilo1.add(labelContador1);
        panelHilo1.add(Box.createRigidArea(new Dimension(0, 10)));
        panelHilo1.add(labelEstado1);

        // Panel para HILO 2
        JPanel panelHilo2 = new JPanel();
        panelHilo2.setLayout(new BoxLayout(panelHilo2, BoxLayout.Y_AXIS));
        panelHilo2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        btnReanudar2 = new JButton("Reanudar");
        btnReanudar2.setEnabled(false);
        btnReanudar2.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnReanudar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hilo2.reanudar();
                btnReanudar2.setEnabled(false);
                btnSuspender2.setEnabled(true);
            }
        });

        btnSuspender2 = new JButton("Suspender");
        btnSuspender2.setEnabled(false);
        btnSuspender2.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSuspender2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hilo2.suspender();
                btnReanudar2.setEnabled(true);
                btnSuspender2.setEnabled(false);
            }
        });

        labelContador2 = new JLabel("", SwingConstants.CENTER);
        labelContador2.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelContador2.setFont(new Font("Arial", Font.BOLD, 20));

        labelEstado2 = new JLabel("HILO 2", SwingConstants.CENTER);
        labelEstado2.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelEstado2.setFont(new Font("Arial", Font.PLAIN, 14));

        panelHilo2.add(btnReanudar2);
        panelHilo2.add(Box.createRigidArea(new Dimension(0, 10)));
        panelHilo2.add(btnSuspender2);
        panelHilo2.add(Box.createRigidArea(new Dimension(0, 20)));
        panelHilo2.add(labelContador2);
        panelHilo2.add(Box.createRigidArea(new Dimension(0, 10)));
        panelHilo2.add(labelEstado2);

        panelCentral.add(panelHilo1);
        panelCentral.add(panelHilo2);
        add(panelCentral, BorderLayout.CENTER);

        // Panel inferior con botón "Finalizar Proceso"
        JPanel panelInferior = new JPanel();
        btnFinalizar = new JButton("Finalizar Proceso");
        btnFinalizar.setEnabled(false);
        btnFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarProceso();
            }
        });
        panelInferior.add(btnFinalizar);
        add(panelInferior, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    // Método para comenzar el proceso
    private void comenzarProceso() {
        hilo1 = new MyHilo("Hilo 1");
        hilo2 = new MyHilo("Hilo 2");

        hilo1.start();
        hilo2.start();

        btnComenzar.setEnabled(false);
        btnSuspender1.setEnabled(true);
        btnSuspender2.setEnabled(true);
        btnFinalizar.setEnabled(true);

        // Hilo para actualizar la interfaz
        Thread actualizador = new Thread(new Runnable() {
            @Override
            public void run() {
                while (hilo1.isAlive() || hilo2.isAlive()) {
                    // Cambia los textos y estados de los hilos en la ventana de forma segura
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            labelContador1.setText(String.valueOf(hilo1.getContador()));
                            labelContador2.setText(String.valueOf(hilo2.getContador()));

                            // Actualizar estado
                            if (hilo1.estaSuspendido()) {
                                labelEstado1.setText("Hilo1 suspendido");
                            } else {
                                labelEstado1.setText("Hilo1 Corriendo");
                            }

                            if (hilo2.estaSuspendido()) {
                                labelEstado2.setText("Hilo2 suspendido");
                            } else {
                                labelEstado2.setText("Hilo2 Corriendo");
                            }
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        });
        actualizador.setDaemon(true);
        actualizador.start();
    }

    // Método para finalizar el proceso
    private void finalizarProceso() {
        if (hilo1 != null) {
            hilo1.finalizar();
        }
        if (hilo2 != null) {
            hilo2.finalizar();
        }

        btnFinalizar.setEnabled(false);
        btnReanudar1.setEnabled(false);
        btnSuspender1.setEnabled(false);
        btnReanudar2.setEnabled(false);
        btnSuspender2.setEnabled(false);

        // Mostrar valores finales en consola
        System.out.println("Hilo 1: " + hilo1.getContador());
        System.out.println("Hilo 2: " + hilo2.getContador());

        btnComenzar.setEnabled(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaHilos ventana = new VentanaHilos();
                ventana.setVisible(true);
            }
        });
    }
}
