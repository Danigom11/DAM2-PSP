package Tema1_Procesos;

import java.io.File;
import java.io.IOException;

public class Ejemplo8_redirect_input {
    public static void main(String[] args) throws IOException {
        // Solo decimos que usaremos el CMD
        ProcessBuilder pb = new ProcessBuilder("CMD");
        File fBat = new File("fichero.bat");
        File fOut = new File("salida.txt");
        File fErr = new File("error.txt");

        // Con esto le decimos al ProcessBuilder que en el archivo fBat están los comandos a ejecutar
        pb.redirectInput(fBat);
        // Guardamos el resultado
        pb.redirectOutput(fOut);
        // Guardamos los errores
        pb.redirectError(fErr);
        pb.start();
    }
}