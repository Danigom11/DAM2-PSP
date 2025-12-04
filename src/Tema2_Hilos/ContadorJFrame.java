package Tema2_Hilos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Ventana que muestra un contador que se incrementa automáticamente en un hilo separado
// Implementa Runnable para ejecutar el contador en un hilo
// Implementa ActionListener para responder a los clics en los botones
public class ContadorJFrame extends JFrame implements Runnable, ActionListener {
    // El hilo donde se ejecuta el contador
    private Thread h;
    // Variable que almacena el valor del contador
    long CONTADOR = 0;
    // Bandera para controlar cuándo parar el contador
    private boolean parar;
    // Fuente para mostrar el contador en pantalla
    private Font fuente;
    // Los dos botones: iniciar/continuar y parar
    private Button b1, b2;
    // Panel donde se colocan los botones
    private Panel panel;

    // Constructor: configura la ventana y sus componentes
    public ContadorJFrame() {
        // Color de fondo amarillo para la ventana
        setBackground(Color.yellow);

        // Crear el panel para los botones
        panel = new Panel();
        panel.setBackground(Color.yellow);

        // Crear y añadir el botón de iniciar
        panel.add(b1 = new Button("Iniciar contador"));
        b1.addActionListener(this); // Registrar este objeto para escuchar clicks en b1

        // Crear y añadir el botón de parar
        panel.add(b2 = new Button("Parar contador"));
        b2.addActionListener(this); // Registrar este objeto para escuchar clicks en b2

        // Configurar la fuente para mostrar el contador
        fuente = new Font("Verdana", Font.BOLD, 60);

        // Añadir el panel de botones en la parte inferior de la ventana
        add(panel, BorderLayout.SOUTH);

        // Tamaño de la ventana
        setSize(400, 200);
        // Cerrar la aplicación cuando se cierra la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
    }

    // Este método se ejecuta cuando se inicia el hilo (Thread.start())
    // Es el "corazón" del contador: incrementa el valor cada 300ms
    public void run() {
        // Reiniciar la bandera de parada
        parar = false;

        // Guardar referencia al hilo actual para poder compararlo después
        Thread hiloActual = Thread.currentThread();

        // Bucle que se ejecuta mientras:
        // 1) El hilo siga siendo el mismo (h == hiloActual)
        // 2) Y no se haya pulsado el botón de parar (!parar)
        while (h == hiloActual && !parar) {
            try {
                // Pausar el hilo durante 300 milisegundos (0.3 segundos)
                // Esto hace que el contador se incremente ~3 veces por segundo
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // Si el hilo es interrumpido, mostrar el mensaje de error
                System.out.println(e.getMessage());
            }

            // Solicitar que la ventana se repinte para mostrar el nuevo valor
            repaint();

            // Incrementar el contador en 1
            CONTADOR++;
        }
    }

    // Este método se ejecuta automáticamente cuando se llama a repaint()
    // Se encarga de dibujar el valor del contador en la ventana
    public void paint(Graphics g) {
        // Primero llamar al paint del padre (JFrame) para que dibuje el fondo y los componentes
        super.paint(g);

        // Establecer la fuente que configuramos (Verdana, negrita, tamaño 26)
        g.setFont(fuente);

        // Dibujar el valor del contador como texto en la posición (80, 100)
        // Long.toString() convierte el número a texto
        g.drawString(Long.toString((long) CONTADOR), 80, 100);
    }

    // Este método se ejecuta automáticamente cuando se pulsa algún botón
    // El parámetro 'e' contiene información sobre qué botón fue pulsado
    public void actionPerformed(ActionEvent e) {
        // Verificar si se pulsó el botón de iniciar/continuar (b1)
        if (e.getSource() == b1) {
            // Cambiar la etiqueta del botón a "Continuar" para la próxima vez
            b1.setLabel("Continuar");

            // Verificar si ya hay un hilo ejecutándose
            if (h != null && h.isAlive()) {
                // Si el hilo ya está corriendo, no hacer nada
                // Esto evita crear múltiples hilos que cuenten al mismo tiempo
            } else {
                // Si no hay hilo o ya terminó, crear uno nuevo
                h = new Thread(this); // 'this' indica que este objeto tiene el método run()
                h.start(); // Iniciar el hilo (esto llama automáticamente a run())
            }
        }
        // Verificar si se pulsó el botón de parar (b2)
        else if (e.getSource() == b2) {
            // Activar la bandera de parada
            // Esto hará que el bucle while en run() termine
            parar = true;
        }
    }

    // Método principal: punto de entrada del programa
    // Se ejecuta cuando lanzas la aplicación
    public static void main(String[] args) {
        // Crear una nueva ventana de contador
        ContadorJFrame contador = new ContadorJFrame();
        // Hacer visible la ventana (por defecto las ventanas están ocultas)
        contador.setVisible(true);
    }
}