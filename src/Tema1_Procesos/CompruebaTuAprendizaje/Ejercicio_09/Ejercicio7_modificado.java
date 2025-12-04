package Tema1_Procesos.CompruebaTuAprendizaje.Ejercicio_09;

import java.io.*;

public class Ejercicio7_modificado {
    public static void main(String[] args) {
        // Modifica este ejercicio para que al ejecutar el programa la entrada al proceso
        // se obtenga a partir de un fichero de texto

        // Indicar donde está el fichero compilado
        File fichero = new File(".\\out\\production\\PSP");
        // Crear el plano de los procesos
        ProcessBuilder ps = new ProcessBuilder("java", "PSP.Tema1.CompruebaTuAprendizaje.Ejercicio_07.LeerCadenas");
        // Indicarle al plano donde está el fichero
        ps.directory(fichero);
        try {
            // Entrada a partir de un archivo
            File fTexto = new File("FicheroEjercicio7.txt");
            ps.redirectInput(ProcessBuilder.Redirect.from(fTexto));
            ps.redirectOutput(ProcessBuilder.Redirect.INHERIT);

            ps.start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}