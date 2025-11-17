package Tema1.Actividad_01_07;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejemplo_lectura_modificado {
    public static void main(String[] args) throws IOException {
        // Modificar EjemploLectura para que la salida del proceso y la salida del error se almacenen
        // en un fichero de texto, y la entrada la tome desde otro fichero de texto
        File fichero = new File(".\\out\\production\\PSP");
        ProcessBuilder pb = new ProcessBuilder("java", "PSP.Tema1.EjemploLectura");
        pb.directory(fichero);
        File fString = new File("ficheroTexto.txt");
        File fSalida = new File("salidaTexto.txt");
        File fError = new File("errorTexto.txt");

        pb.redirectInput(fString);
        pb.redirectOutput(fSalida);
        pb.redirectError(fError);

        pb.start();
    }
}