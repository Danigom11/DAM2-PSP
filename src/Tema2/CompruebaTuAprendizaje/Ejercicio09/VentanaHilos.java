package Tema2.CompruebaTuAprendizaje.Ejercicio09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaHilos extends JFrame {
    // Instancias de los dos hilos
    private Hilo hilo1;
    private Hilo hilo2;

    // Las tres regiones
    JPanel regionNorte;
    JPanel regionCentro;
    JPanel regionSur;

    // Regiónes para cada hilo
    JPanel panelHilo1;
    JPanel panelHilo2;

    // Botones
    JButton botonComenzarProceso;
    JButton botonReanudarHilo1;
    JButton botonInterrumpirHilo1;
    JButton botonReanudarHilo2;
    JButton botonInterrumpirHilo2;
    JButton botonFinalizarProceso;

    // Resultados contadores y estados de los hilos
    JLabel labelContador1;
    JLabel labelContador2;
    JLabel labelEstado1;
    JLabel labelEstado2;

    // Constructor de la ventana
    public VentanaHilos(){
        // Título de la ventana
        setTitle("Ejecutar dos hilos deteniéndolos sin Stop");
        // Para que se cierre cuando le damos a la x
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Que el layout sea de tipo BorderLayout con regiones para ubicar el contenido
        setLayout(new BorderLayout());
        // Tamaño de la ventana
        setSize(600, 300);

        // NORTE DE LA VENTANA
        // Región norte comenzar proceso
        regionNorte = new JPanel();
        // Botón con su texto
        botonComenzarProceso = new JButton("Comenzar proceso");
        // Controlar si se pulsa
        botonComenzarProceso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // si se pulsa llamar al método correspondiente
                comenzarProceso();
            }
        });
        // Añadir el botón
        regionNorte.add(botonComenzarProceso);
        // Poner todo el panel región norte con lo que tenga al norte de la ventana principal
        add(regionNorte, BorderLayout.NORTH);

        // CENTRO DE LA VENTANA
        // Crear región central de tipo grid para poner las zonas
        // (2 con los botones interrumpir y debajo los resultados)
        regionCentro = new JPanel(new GridLayout(1, 2, 10, 10));

        // Hilo 1
        // Su propio panel
        panelHilo1 = new JPanel();
        // Colocar los componentes que tenga el panel de arriba a abajo con un BoxLayout y Y_AXIS
        panelHilo1.setLayout(new BoxLayout(panelHilo1, BoxLayout.Y_AXIS));
        // Poner un borde al panel
        panelHilo1.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        // Botón reanudar hilo 1
        botonReanudarHilo1 = new JButton("Reanudar");
        // Solo se ve si se ha detenido la cuenta
        botonReanudarHilo1.setEnabled(false);
        // Centrarlo
        botonReanudarHilo1.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Escuchar si se pulsa
        botonReanudarHilo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reanudarHilo1();
            }
        });

        // Botón interrumpir hilo 1
        botonInterrumpirHilo1 = new JButton("Parar");
        // Ocultarlo
        botonInterrumpirHilo1.setEnabled(false);
        // Centrarlo
        botonInterrumpirHilo1.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Escuchar si se pulsa
        botonInterrumpirHilo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interrumpirHilo1();
            }
        });

        // Mostrar los resultados del hilo 1 centrados en su línea
        labelContador1 = new JLabel("", SwingConstants.CENTER);
        // Alinear al centro del panel
        labelContador1.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Cambios en la fuente
        labelContador1.setFont(new Font("Arial", Font.BOLD, 40));
        // Lo mismo para los estados del hilo 1
        labelEstado1 = new JLabel("Hilo 1", SwingConstants.CENTER);
        labelEstado1.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelEstado1.setFont(new Font("Arial", Font.ITALIC, 20));
        // Añadirlos al panel del hilo 1 con un espacio entre medias
        panelHilo1.add(botonReanudarHilo1);
        panelHilo1.add(Box.createRigidArea(new Dimension(0, 10)));
        panelHilo1.add(botonInterrumpirHilo1);
        panelHilo1.add(Box.createRigidArea(new Dimension(0, 10)));
        panelHilo1.add(labelContador1);
        panelHilo1.add(Box.createRigidArea(new Dimension(0, 10)));
        panelHilo1.add(labelEstado1);

        // Hilo 2
        // Su propio panel
        panelHilo2 = new JPanel();
        // Colocar los componentes que tenga el panel de arriba a abajo con un BoxLayout y Y_AXIS
        panelHilo2.setLayout(new BoxLayout(panelHilo2, BoxLayout.Y_AXIS));
        // Poner un borde al panel
        panelHilo2.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        // Botón reanudar hilo 1
        botonReanudarHilo2 = new JButton("Reanudar");
        // Solo se ve si se ha detenido la cuenta
        botonReanudarHilo2.setEnabled(false);
        // Centrarlo
        botonReanudarHilo2.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Escuchar si se pulsa
        botonReanudarHilo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reanudarHilo2();
            }
        });

        // Botón interrumpir hilo 1
        botonInterrumpirHilo2 = new JButton("Parar");
        // Ocultarlo
        botonInterrumpirHilo2.setEnabled(false);
        // Centrarlo
        botonInterrumpirHilo2.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Escuchar si se pulsa
        botonInterrumpirHilo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interrumpirHilo2();
            }
        });

        // Mostrar los resultados del hilo 1 centrados en su línea
        labelContador2 = new JLabel("", SwingConstants.CENTER);
        // Alinear al centro del panel
        labelContador2.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Cambios en la fuente
        labelContador2.setFont(new Font("Arial", Font.BOLD, 40));
        // Lo mismo para los estados del hilo 1
        labelEstado2 = new JLabel("Hilo 2", SwingConstants.CENTER);
        labelEstado2.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelEstado2.setFont(new Font("Arial", Font.ITALIC, 20));
        // Añadirlos al panel del hilo 1 con un espacio entre medias
        panelHilo2.add(botonReanudarHilo2);
        panelHilo2.add(Box.createRigidArea(new Dimension(0, 10)));
        panelHilo2.add(botonInterrumpirHilo2);
        panelHilo2.add(Box.createRigidArea(new Dimension(0, 10)));
        panelHilo2.add(labelContador2);
        panelHilo2.add(Box.createRigidArea(new Dimension(0, 10)));
        panelHilo2.add(labelEstado2);

        // Añadir los dos paneles con los hilos al panel central en la zona central
        regionCentro.add(panelHilo1);
        regionCentro.add(panelHilo2);
        add(regionCentro, BorderLayout.CENTER);

        // REGIÓN SUR
        regionSur = new JPanel();
        // Iniciar el botón finalizar proceso
        botonFinalizarProceso = new JButton("Finalizar proceso");
        // Desactivarlo
        botonFinalizarProceso.setEnabled(false);
        // Escuchar si se pulsa
        botonFinalizarProceso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarProceso();
            }
        });
        // Añadirlo a la región sur
        regionSur.add(botonFinalizarProceso);
        add(regionSur, BorderLayout.SOUTH);

        // Cambios estéticos
        Color colorFondo = new Color(52, 152, 219); // Azul claro
        Color colorCentro = new Color(176, 225, 238); // Gris muy claro
        regionNorte.setBackground(colorFondo);
        regionCentro.setBackground(colorFondo);
        regionSur.setBackground(colorFondo);
        regionCentro.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        panelHilo1.setBackground(colorCentro);
        panelHilo2.setBackground(colorCentro);

        // Centrar en el centro del monitor cuando se reproduzca
        setLocationRelativeTo(null);
    }

    private void actualizarColorBoton(JButton boton) {
        boton.setContentAreaFilled(true);
        Color verdeNormal = new Color(157, 220, 159); // Verde más normal
        Color rojoNormal = new Color(229, 152, 146); // Rojo más normal
        if (boton.isEnabled()) {
            boton.setBackground(verdeNormal);
        } else {
            boton.setBackground(rojoNormal);
        }
    }

    private void finalizarProceso() {
        // Detener los dos hilos y mostrar por consola el valor final de cada contador.
        if (hilo1 != null){
            hilo1.interrumpirHilo();
        }
        if (hilo2 != null){
            hilo2.interrumpirHilo();
        }
        // Deshabilitar los botones
        botonFinalizarProceso.setEnabled(false);
        actualizarColorBoton(botonFinalizarProceso);
        botonReanudarHilo1.setEnabled(false);
        actualizarColorBoton(botonReanudarHilo1);
        botonInterrumpirHilo1.setEnabled(false);
        actualizarColorBoton(botonInterrumpirHilo1);
        botonReanudarHilo2.setEnabled(false);
        actualizarColorBoton(botonReanudarHilo2);
        botonInterrumpirHilo2.setEnabled(false);
        actualizarColorBoton(botonInterrumpirHilo2);

        // Mostrar valores finales en la consola
        System.out.println("VALORES FINALES");
        System.out.println("Hilo 1 finalizado con: " + hilo1.getCONTADOR());
        System.out.println("Hilo 2 finalizado con: " + hilo2.getCONTADOR());

        // Activar el botón de comenzar
        botonComenzarProceso.setEnabled(true);
        actualizarColorBoton(botonComenzarProceso);
    }

    private void interrumpirHilo2() {
        // Llamar al método que para el hilo
        hilo2.pararHilo();
        // Mostrar el botón de reanudar
        botonReanudarHilo2.setEnabled(true);
        actualizarColorBoton(botonReanudarHilo2);
        // Ocultar el de interrumpir
        botonInterrumpirHilo2.setEnabled(false);
        actualizarColorBoton(botonInterrumpirHilo2);
    }

    private void reanudarHilo2() {
        // Hacer que el hilo vuelva a arrancar
        hilo2.reaundarHilo();
        // Ocultar el botón de reanudar el hilo 1
        botonReanudarHilo2.setEnabled(false);
        actualizarColorBoton(botonReanudarHilo2);
        // Mostrar el botón de interrumpir
        botonInterrumpirHilo2.setEnabled(true);
        actualizarColorBoton(botonInterrumpirHilo2);
    }

    private void interrumpirHilo1() {
        // Llamar al método que para el hilo
        hilo1.pararHilo();
        // Mostrar el botón de reanudar
        botonReanudarHilo1.setEnabled(true);
        actualizarColorBoton(botonReanudarHilo1);
        // Ocultar el de interrumpir
        botonInterrumpirHilo1.setEnabled(false);
        actualizarColorBoton(botonInterrumpirHilo1);
    }

    private void reanudarHilo1() {
        // Hacer que el hilo vuelva a arrancar
        hilo1.reaundarHilo();
        // Ocultar el botón de reanudar el hilo 1
        botonReanudarHilo1.setEnabled(false);
        actualizarColorBoton(botonReanudarHilo1);
        // Mostrar el botón de interrumpir
        botonInterrumpirHilo1.setEnabled(true);
        actualizarColorBoton(botonInterrumpirHilo1);
    }

    private void comenzarProceso() {
        // Crear los dos hilos
        hilo1 = new Hilo("Hilo 1");
        hilo2 = new Hilo("Hilo 2");

        hilo1.start();
        hilo2.start();

        // Desactivar el botón de comenzar proceso
        botonComenzarProceso.setEnabled(false);
        actualizarColorBoton(botonComenzarProceso);
        // Activar los de de detener los hilos y finalizar
        botonInterrumpirHilo1.setEnabled(true);
        actualizarColorBoton(botonInterrumpirHilo1);
        botonInterrumpirHilo2.setEnabled(true);
        actualizarColorBoton(botonInterrumpirHilo2);
        botonFinalizarProceso.setEnabled(true);
        actualizarColorBoton(botonFinalizarProceso);

        // Hilo para ir actualizando la propia interfaz
        Thread actualizadorInterfaz = new Thread(new Runnable() {
            @Override
            public void run() {
                // Mientras un hilo esté vivo y no muerto de muerte natural
                while (hilo1.isAlive() || hilo2.isAlive()){
                    // Cambia los textos y estados de los hilos de forma segura
                    // Controlado por Swing
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            // Actualizamos el valor del texto del contador al que diga cada hilo
                            labelContador1.setText(String.valueOf(hilo1.getCONTADOR()));
                            labelContador2.setText(String.valueOf(hilo2.getCONTADOR()));
                            // Actualizar el valor del label de estado al que tenga
                            if (hilo1.getHiloParado()){
                                labelEstado1.setText("Hilo 1 interrumpido");
                            } else {
                                labelEstado1.setText("Hilo 1 corriendo");
                            }
                            if (hilo2.getHiloParado()){
                                labelEstado2.setText("Hilo 2 interrumpido");
                            } else {
                                labelEstado2.setText("Hilo 2 corriendo");
                            }
                        }
                    });
                    // Poner un descanso al actualizador. Si no haría millones de cálculos
                    // innecesarios, así solo calcula cada 100 milisegundos
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        break;
                    }
                }

            }
        });
        // Le damos prioridad a este hilo principal de la ventana
        actualizadorInterfaz.setDaemon(true);
        // Lo arrancamos
        actualizadorInterfaz.start();
    }
}