package Tema1_Procesos.Actividad_01_05;

import java.io.*;

public class Actividad_01_05_mostrar_errores {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Mostrar los errores que se producen al ejecutar un programa Java que no exista

        // Indicar donde está el fichero COMPILADO
        File fichero = new File("C:\\Users\\danig\\Downloads\\DAM2\\PSP\\Tema1\\out\\production\\PSP");
        // Hacer un process builder de que se ejecute un archivo Java y cuál es
        ProcessBuilder pb = new ProcessBuilder("java", "PSP.Tema1.Actividad_01_04.LeerNombr", "Daniel"); // NO EXISTE
        // Se le pasa al process builder donde está el Java compilado
        pb.directory(fichero);
        // Se inicia el proceso con Process para después leerlo
        Process p = pb.start();
        // A leer el contenido del proceso iniciado
        int resultado = p.waitFor();
        System.out.println(resultado);

        InputStream er = p.getErrorStream();
        BufferedReader brer = new BufferedReader(new InputStreamReader(er));
        String liner = null;
        while ((liner = brer.readLine()) != null) System.out.println("ERROR >" + liner);

    }

}