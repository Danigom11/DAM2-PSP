package Tema1_Procesos.CompruebaTuAprendizaje.Ejercicio_05;

import java.io.*;
import java.util.Scanner;


public class EjecutarMostrarArgs {
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
            // Mostrar el stream de salida del proceso hijo con una entrada a mi programa
            InputStream is = p.getInputStream();
            BufferedReader bris = new BufferedReader(new InputStreamReader(is));
            String linis = null;
            while ((linis = bris.readLine()) != null) System.out.println(linis);
            bris.close();

            // Mostrar el stream de error
            InputStream er = p.getErrorStream();
            BufferedReader brer = new BufferedReader(new InputStreamReader(er));
            String liner = null;
            while ((liner = brer.readLine()) != null) System.out.println("ERROR >" + liner);
            brer.close();

        } catch (IOException e) {
            System.out.println("Error al iniciar el proceso. " + e.getMessage());
        }
    }
}