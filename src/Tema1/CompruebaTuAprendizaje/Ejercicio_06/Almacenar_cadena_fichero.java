package Tema1.CompruebaTuAprendizaje.Ejercicio_06;

import java.io.*;
import java.util.Scanner;

public class Almacenar_cadena_fichero {
    // Partiendo del ejercicio anterior, realiza los cambios para que la cadena se almacene
    // en un fichero de texto, no mostrándola por pantalla
    public static void main(String[] args) {
        // Programa que introduzca por teclado una cadena y ejecute MostrarArgs par ver 5 veces esa cadena
        // Pedir la cadena
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una cadena y por medio de otro programa la trataremos: ");
        String cadena = sc.nextLine();
        sc.close();

        File fichero = new File("C:\\Users\\danig\\Downloads\\DAM2\\PSP\\Tema1\\out\\production\\PSP");
        ProcessBuilder pb = new ProcessBuilder("java", "PSP.Tema1.CompruebaTuAprendizaje.Ejercicio_05.MostrarArgs", cadena);
        pb.directory(fichero);
        try {
            Process p = pb.start();
            File ficheroTexto = new File("C:\\Users\\danig\\Downloads\\DAM2\\PSP\\src\\PSP\\Tema1\\CompruebaTuAprendizaje\\Ejercicio_06\\Cadena.txt");
            if (ficheroTexto.createNewFile()){
                System.out.println("El fichero de texto se ha creado correctamente");
            }
            BufferedWriter bwis = new BufferedWriter(new FileWriter(ficheroTexto));

            // Guardar en txt el stream de salida
            InputStream is = p.getInputStream();
            BufferedReader bris = new BufferedReader(new InputStreamReader(is));
            String linis = null;
            while ((linis = bris.readLine()) != null) {
                bwis.write(linis);
                bwis.newLine();
            }
            bris.close();

            // Guardar en txt el stream de error
            InputStream er = p.getErrorStream();
            BufferedReader brer = new BufferedReader(new InputStreamReader(er));
            String liner = null;
            while ((liner = brer.readLine()) != null) {
                bwis.write(liner);
                bwis.newLine();
            }
            brer.close();

            bwis.close();

        } catch (IOException e) {
            System.out.println("Error al iniciar el proceso. " + e.getMessage());
        }
    }

}