package Tema1.CompruebaTuAprendizaje.Ejercicio_04;

import java.io.File;
import java.io.IOException;

public class EjecutarGestorArgumentos {
    public static void main(String[] args) throws IOException, InterruptedException {
        File fichero = new File("C:\\Users\\danig\\Downloads\\DAM2\\PSP\\Tema1\\out\\production\\PSP");
        ProcessBuilder pb = new ProcessBuilder("java", "PSP.Tema1.CompruebaTuAprendizaje.Ejercicio_04.GestorArgumentos", "-2");
        pb.directory(fichero);

        Process p = pb.start();
        int resultado = p.waitFor();
        System.out.println(resultado);
    }
}