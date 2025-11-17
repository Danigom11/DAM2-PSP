package Tema1.Actividad_01_08;

import java.io.File;
import java.io.IOException;

public class EjemploLecturaModificadoRedirect {
    public static void main(String[] args) throws IOException {
        // Usando ProcessBuilder.Redirect modifica EjemploLectura para que la salida del proceso
        // Se muestre en la consola. La entrada la tome de un fichero de texto y la salida lleve
        // a otro fichero de texto

        // Indicar donde está el fichero compilado
        File fichero = new File(".\\out\\production\\PSP");
        // Crear el constructor del proceso
        ProcessBuilder pb = new ProcessBuilder("java", "PSP.Tema1.EjemploLectura");
        // Indicar donde está el fichero compilado
        pb.directory(fichero);

        // Redirigir el input a un archivo
        File fTexto = new File("ficheroTexto.txt");
        pb.redirectInput(ProcessBuilder.Redirect.from(fTexto));

        // Mostrar por consola del programa padre el resultado del hijo
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        // Redirigir los errores a un fichero
        File fErr = new File("ficheroErroresRedirect.txt");
        pb.redirectError(ProcessBuilder.Redirect.to(fErr));

        // Iniciar el proceso
        pb.start();

    }

}