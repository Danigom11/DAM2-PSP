package Tema1;

import java.io.*;
import java.util.Scanner;

public class ResumenTema1 {
    public static void main(String[] args) {
        // Entrada (input, read): el programa recibe datos para trabajar. Ejemplo: Scanner, BufferedReader, InputStream.
        // Salida (output, write): el programa muestra o guarda datos. Ejemplo: System.out, BufferedWriter, OutputStream.
        // ProcessBuilder: permite crear y configurar procesos externos (otros programas o comandos).
        // Process: representa el proceso en ejecución, permite comunicarse con él (leer/escribir datos).
        // flush: fuerza el envío de los datos pendientes en el buffer, útil para que el proceso hijo reciba la información inmediatamente.
        // ProcessBuilder.Redirect.INHERIT: hace que la salida o errores del proceso hijo se muestren directamente en la consola del padre.

        try {
            // EJERCICIOS 5 y 6: Ejecutar otro Java, capturar salida/errores, guardar en archivo
            // Claves: ProcessBuilder, getInputStream/getErrorStream, BufferedWriter
            File fichero = new File(".\\out.production.PSP"); // Carpeta de los .class
            String cadena = "Texto"; // Argumento para el proceso hijo
            ProcessBuilder pb = new ProcessBuilder("java", "PSP.Tema1.CompruebaTuAprendizaje.Ejercicio_05.MostrarArgs", cadena);
            pb.directory(fichero);
            Process p = pb.start();
            // Mostrar la salida estándar del proceso hijo
            BufferedReader brOut = new BufferedReader(new InputStreamReader(p.getInputStream()));
            // Mostrar la salida de error del proceso hijo
            BufferedReader brErr = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            // Guardar todo en un archivo de texto
            BufferedWriter bw = new BufferedWriter(new FileWriter("Cadena.txt"));
            String linea;
            while ((linea = brOut.readLine()) != null) {
                System.out.println(linea); // Mostrar por consola
                bw.write(linea); bw.newLine(); // Guardar en archivo
            }
            while ((linea = brErr.readLine()) != null) {
                System.out.println("ERROR >" + linea);
                bw.write("ERROR >" + linea); bw.newLine();
            }
            brOut.close();
            brErr.close();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al iniciar el proceso. " + e.getMessage());
        }

        try {
            // EJERCICIO 7: Ejecutar otro Java, enviar datos por OutputStream, mostrar salida/errores
            // Claves: OutputStream, flush, getInputStream/getErrorStream
            File fichero = new File(".\\out\\production\\PSP");
            ProcessBuilder pb = new ProcessBuilder("java", "PSP.Tema1.CompruebaTuAprendizaje.Ejercicio_07.LeerCadenas");
            pb.directory(fichero);
            Process p = pb.start();
            OutputStream os = p.getOutputStream();
            // Enviar varias cadenas al proceso hijo
            for (String texto : new String[]{"Daniel", "Casa", "Avión", "*"}) {
                os.write((texto + "\n").getBytes());
            }
            os.flush(); os.close(); // Vacía el buffer y cierra el flujo
            // Mostrar la salida estándar y de error por consola
            BufferedReader brOut = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader brErr = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String linea;
            while ((linea = brOut.readLine()) != null) System.out.println(linea);
            while ((linea = brErr.readLine()) != null) System.out.println("ERROR >" + linea);
            brOut.close(); brErr.close();
        } catch (IOException e) {
            System.out.println("Error al iniciar el proceso. " + e.getMessage());
        }

        try {
            // EJERCICIO 8: Ejecutar otro Java, enviar datos por OutputStream, redirigir salida/errores a consola
            // Claves: redirectOutput(INHERIT), redirectError(INHERIT), OutputStream, flush
            Scanner sc = new Scanner(System.in);
            File fichero = new File(".\\out\\production\\PSP"); // Carpeta donde están los .class
            ProcessBuilder pb = new ProcessBuilder("java", "PSP.Tema1.CompruebaTuAprendizaje.Ejercicio_08.Palindromo");
            pb.directory(fichero);
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT); // Muestra la salida del hijo en la consola del padre
            pb.redirectError(ProcessBuilder.Redirect.INHERIT);  // Muestra los errores del hijo en la consola del padre
            Process p = pb.start();
            System.out.print("Introduce una cadena para comprobar si es palíndromo: ");
            String cadena = sc.nextLine();
            OutputStream os = p.getOutputStream(); // Flujo para enviar datos al hijo
            os.write(cadena.getBytes()); // Enviar la cadena
            os.flush(); // Vacía el buffer y envía los datos
            os.close(); // Cierra el flujo
            // El proceso hijo mostrará el resultado por consola
        } catch (IOException e) {
            System.out.println("Error al iniciar el proceso. " + e.getMessage());
        }

        try {
            // EJERCICIO 9: Ejecutar otro Java, redirigir entrada desde fichero, salida a consola
            // Claves: redirectInput(from), redirectOutput(INHERIT)
            File fichero = new File(".\\out\\production\\PSP"); // Carpeta donde están los .class
            ProcessBuilder pb = new ProcessBuilder("java", "PSP.Tema1.CompruebaTuAprendizaje.Ejercicio_07.LeerCadenas");
            pb.directory(fichero);
            File fTexto = new File("FicheroEjercicio7.txt"); // Fichero con las cadenas de entrada
            pb.redirectInput(ProcessBuilder.Redirect.from(fTexto)); // Redirige la entrada estándar al fichero
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT); // Muestra la salida del hijo en la consola del padre
            pb.start(); // Inicia el proceso
            // El proceso hijo leerá las cadenas del fichero y mostrará el resultado por consola
        } catch (IOException e) {
            System.out.println("Error al iniciar el proceso. " + e.getMessage());
        }
    }
}