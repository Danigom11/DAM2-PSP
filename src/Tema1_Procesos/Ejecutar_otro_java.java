package Tema1_Procesos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Ejecutar_otro_java {
    public static void main(String[] args) throws IOException {
        File directorio = new File("C:\\Users\\danig\\Downloads\\DAM2\\PSP\\Tema1\\out\\production\\PSP");
        ProcessBuilder pb = new ProcessBuilder("java", "PSP.Tema1.Creacion_procesos");
        pb.directory(directorio);
        System.out.println("Directorio de trabajo: " + pb.directory());
        Process p = pb.start();
        // Obtener la salida del proceso
        try {
            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1) System.out.print((char) c);
            is.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}