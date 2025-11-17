package Tema1;

import java.io.*;
import java.util.Scanner;

public class ResumenTema1Concentrado {
    public static void main(String[] args) {
        // Conceptos clave:
        // Entrada (input/read): recibe datos (Scanner, BufferedReader, InputStream)
        // Salida (output/write): muestra/guarda datos (System.out, BufferedWriter, OutputStream)
        // ProcessBuilder: crea/configura procesos externos
        // Process: representa el proceso en ejecución
        // flush: envía datos pendientes al proceso hijo
        // Redirect.INHERIT: salida/errores del hijo en la consola del padre

        // Ejecutar otro Java y mostrar su salida/errores
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "PSP.Tema1.CompruebaTuAprendizaje.Ejercicio_05.MostrarArgs", "Texto");
            pb.directory(new File(".\\out.production.PSP"));
            Process p = pb.start();
            BufferedReader out = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader err = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String linea;
            while ((linea = out.readLine()) != null) System.out.println(linea);
            while ((linea = err.readLine()) != null) System.out.println("ERROR >" + linea);
            out.close(); err.close();
        } catch (IOException e) { System.out.println("Error: " + e.getMessage()); }

        // Enviar datos al proceso hijo por OutputStream
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "PSP.Tema1.CompruebaTuAprendizaje.Ejercicio_07.LeerCadenas");
            pb.directory(new File(".\\out\\production\\PSP"));
            Process p = pb.start();
            OutputStream os = p.getOutputStream();
            for (String txt : new String[]{"Daniel", "Casa", "Avión", "*"}) os.write((txt + "\n").getBytes());
            os.flush(); os.close();
            BufferedReader out = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea; while ((linea = out.readLine()) != null) System.out.println(linea);
            out.close();
        } catch (IOException e) { System.out.println("Error: " + e.getMessage()); }

        // Redirigir entrada desde fichero y salida a consola
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "PSP.Tema1.CompruebaTuAprendizaje.Ejercicio_07.LeerCadenas");
            pb.directory(new File(".\\out\\production\\PSP"));
            pb.redirectInput(ProcessBuilder.Redirect.from(new File("FicheroEjercicio7.txt")));
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            pb.start();
        } catch (IOException e) { System.out.println("Error: " + e.getMessage()); }

        // Enviar datos por OutputStream y mostrar salida/errores con INHERIT
        try {
            Scanner sc = new Scanner(System.in);
            ProcessBuilder pb = new ProcessBuilder("java", "PSP.Tema1.CompruebaTuAprendizaje.Ejercicio_08.Palindromo");
            pb.directory(new File(".\\out\\production\\PSP"));
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            pb.redirectError(ProcessBuilder.Redirect.INHERIT);
            Process p = pb.start();
            System.out.print("Introduce una cadena: ");
            String cadena = sc.nextLine();
            OutputStream os = p.getOutputStream();
            os.write(cadena.getBytes());
            os.flush(); os.close();
        } catch (IOException e) { System.out.println("Error: " + e.getMessage()); }
    }
}

