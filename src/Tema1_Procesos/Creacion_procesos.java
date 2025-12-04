package Tema1_Procesos;

import java.io.IOException;
import java.io.InputStream;

public class Creacion_procesos {
    public static void main(String[] args) throws IOException {
        // Abrir el notepad
        // Process pb = new ProcessBuilder("NOTEPAD").start();
        // ProcessBuilder p = new ProcessBuilder("CMD");
        // Process proceso = p.start();

        // Hacer un DIR con el CMD
        Process p = new ProcessBuilder("CMD", "/C", "DIR").start();

        // Mostrar carácter a carácter
        try {
            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1 )
                System.out.print((char) c);
            is.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        // Comprobar errores: 0 bien o -1 mal
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de salida: " + exitVal);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}