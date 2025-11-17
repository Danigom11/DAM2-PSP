package Tema2.actividad_02_05_Sin_Stop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class actividad_02_03 extends JFrame implements ActionListener {

    class HiloContador extends Thread {
        // Bandera para controlar cuándo parar el contador
        private boolean parar;
        // Identificador del hilo (1 o 2)
        private int numeroHilo;
        // Referencia al contador que debe modificar
        private long[] contadorRef;
        private int indiceContador;

        // Constructor de la clase HiloContador
        public HiloContador(int numeroHilo, long[] contadorRef, int indiceContador) {
            this.parar = false;
            this.numeroHilo = numeroHilo;
            this.contadorRef = contadorRef;
            this.indiceContador = indiceContador;
        }

        // Método run que ejecuta el contador
        public void run() {
            // Bucle que se ejecuta mientras no se active la bandera de parada
            while (!parar) {
                try {
                    // Pausar el hilo durante 300 milisegundos
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }

                // Incrementar el contador correspondiente
                contadorRef[indiceContador]++;

                // Solicitar que la ventana se repinte para mostrar el nuevo valor
                repaint();
            }
            System.out.println("Hilo " + numeroHilo + " terminado.");
        }

        // Método para parar el hilo
        public void parar() {
            this.parar = true;
        }

    } // Fin clase HiloContador

    // Atributos del JFrame
    private HiloContador hilo1, hilo2;
    // Variables que almacenan los valores de los contadores
    long[] CONTADORES = {0, 0}; // [contador1, contador2]
    // Fuente para mostrar los contadores en pantalla
    private Font fuente;
    // Botones para iniciar y parar cada hilo
    private Button bIniciar1, bParar1, bIniciar2, bParar2;
    // Panel donde se colocan los botones
    private Panel panel;

    // Constructor: configura la ventana y sus componentes
    public actividad_02_03() {
        // Color de fondo amarillo para la ventana
        setBackground(Color.yellow);

        // Crear el panel para los botones
        panel = new Panel();
        panel.setBackground(Color.yellow);
        panel.setLayout(new GridLayout(2, 2)); // 2 filas, 2 columnas

        // Crear y añadir los botones para el Hilo 1
        panel.add(bIniciar1 = new Button("Iniciar Hilo 1"));
        bIniciar1.addActionListener(this);

        panel.add(bParar1 = new Button("Parar Hilo 1"));
        bParar1.addActionListener(this);

        // Crear y añadir los botones para el Hilo 2
        panel.add(bIniciar2 = new Button("Iniciar Hilo 2"));
        bIniciar2.addActionListener(this);

        panel.add(bParar2 = new Button("Parar Hilo 2"));
        bParar2.addActionListener(this);

        // Configurar la fuente para mostrar los contadores
        fuente = new Font("Verdana", Font.BOLD, 26);

        // Añadir el panel de botones en la parte inferior de la ventana
        add(panel, BorderLayout.SOUTH);

        // Tamaño de la ventana (más grande para mostrar dos contadores)
        setSize(500, 250);
        // Cerrar la aplicación cuando se cierra la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
    }

    // Método paint para dibujar los contadores en la ventana
    public void paint(Graphics g) {
        // Primero llamar al paint del padre para dibujar el fondo y componentes
        super.paint(g);

        // Establecer la fuente configurada
        g.setFont(fuente);

        // Dibujar las etiquetas y valores de ambos contadores
        g.drawString("Hilo 1: " + Long.toString(CONTADORES[0]), 50, 100);
        g.drawString("Hilo 2: " + Long.toString(CONTADORES[1]), 50, 140);
    }

    // Método para manejar los eventos de los botones
    public void actionPerformed(ActionEvent e) {
        // Botones del Hilo 1
        if (e.getSource() == bIniciar1) {
            // Verificar si el hilo 1 ya está ejecutándose
            if (hilo1 != null && hilo1.isAlive()) {
                // Si ya está corriendo, no hacer nada
                System.out.println("Hilo 1 ya está ejecutándose");
            } else {
                // Crear y iniciar el hilo 1
                hilo1 = new HiloContador(1, CONTADORES, 0);
                hilo1.start();
                System.out.println("Hilo 1 iniciado");
            }
        }
        else if (e.getSource() == bParar1) {
            // Parar el hilo 1 si existe
            if (hilo1 != null) {
                hilo1.parar();
                System.out.println("Señal de parada enviada al Hilo 1");
            }
        }
        // Botones del Hilo 2
        else if (e.getSource() == bIniciar2) {
            // Verificar si el hilo 2 ya está ejecutándose
            if (hilo2 != null && hilo2.isAlive()) {
                // Si ya está corriendo, no hacer nada
                System.out.println("Hilo 2 ya está ejecutándose");
            } else {
                // Crear y iniciar el hilo 2
                hilo2 = new HiloContador(2, CONTADORES, 1);
                hilo2.start();
                System.out.println("Hilo 2 iniciado");
            }
        }
        else if (e.getSource() == bParar2) {
            // Parar el hilo 2 si existe
            if (hilo2 != null) {
                hilo2.parar();
                System.out.println("Señal de parada enviada al Hilo 2");
            }
        }
    }

    // Método principal
    public static void main(String[] args) {
        actividad_02_03 ventana = new actividad_02_03();
        ventana.setVisible(true);
    }

} // Fin actividad_02_03