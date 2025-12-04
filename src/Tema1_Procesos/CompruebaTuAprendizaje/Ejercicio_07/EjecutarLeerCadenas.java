package Tema1_Procesos.CompruebaTuAprendizaje.Ejercicio_07;

import java.io.*;

public class EjecutarLeerCadenas {
    public static void main(String[] args) {
        // Indicar donde está el fichero compilado
        File fichero = new File(".\\out\\production\\PSP");
        // Crear el plano de los procesos
        ProcessBuilder ps = new ProcessBuilder("java", "PSP.Tema1.CompruebaTuAprendizaje.Ejercicio_07.LeerCadenas");
        // Indicarle al plano donde está el fichero
        ps.directory(fichero);
        try {
            // Iniciar el proceso (la ejecución del Java) con los planos indicados
            Process p = ps.start();

            // Crear un stream (flujo) de salida para enviar las cadenas que el otro programa usará
            OutputStream os = p.getOutputStream();
            os.write("Daniel\n".getBytes());
            os.write("Casa\n".getBytes());
            os.write("Avión\n".getBytes());
            os.write("*\n".getBytes());
            os.flush(); // Enviar los datos, vaciar el buffer

            // Leer el stream (flujo) que se recibe, de entrada, del otro programa.
            BufferedReader brin = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String lineain = null;
            while ((lineain = brin.readLine())!= null) System.out.println(lineain);

            // Leer el stream de los posibles fallos del otro programa
            BufferedReader brer = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String lineaer = null;
            while ((lineaer = brer.readLine()) != null) System.out.println(lineaer);

            // Cerrar todo antes de terminar
            os.close();
            brin.close();
            brer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}