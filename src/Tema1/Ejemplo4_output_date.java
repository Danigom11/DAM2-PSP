package Tema1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejemplo4_output_date {
    public static void main(String[] args) throws IOException {
        Process p = new ProcessBuilder("CMD", "DATE").start();
        // Escritura = enviar entrada a DATE
        OutputStream os = p.getOutputStream();
        os.write("15-06-18\n".getBytes());
        os.flush(); // Vacía el buffer de salida
        os.close();

        // Lectura = obtiene la salida de DATE
        InputStream is = p.getInputStream();
        int c;
        while ((c = is.read()) != -1) System.out.print((char) c);
        is.close();

        // Comprobar los errores = 0 bien o -1 mal
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida: " + exitVal);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}