package Tema2_Hilos.CompruebaTuAprendizaje.Ejercicio09;

import javax.swing.*;

public class EjecutarHilos {
    public static void main(String[] args) {
        // Dejar que swing controle el hilo del main por seguridad
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // crear un objeto de la ventana
                VentanaHilos ventana = new VentanaHilos();
                // Hacerla visible
                ventana.setVisible(true);
            }
        });
    }
}