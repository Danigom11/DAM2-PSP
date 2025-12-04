package Tema2_Hilos;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reloj extends JFrame implements Runnable {
    private Thread hilo = null;
    private Font fuente;
    private String horaActual = "";
    private JLabel label;

    public Reloj(){
        fuente = new Font("Verdana", Font.BOLD, 26);
        label = new JLabel("", SwingConstants.CENTER);
        label.setFont(fuente);
        getContentPane().setBackground(Color.yellow);
        add(label);
        setSize(300, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void start() {
        if (hilo == null){
            hilo = new Thread(this);
            hilo.start();
        }
    }

    public void run() {
        Thread hiloActual = Thread.currentThread();
        while (hilo == hiloActual){
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            horaActual = sdf.format(cal.getTime());
            label.setText(horaActual); // Actualizar el contenido
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){}
        }
    }

    public void stop() {
        hilo = null;
    }

    public static void main(String[] args) {
        Reloj reloj = new Reloj();
        reloj.setVisible(true);
        reloj.start();
    }
}