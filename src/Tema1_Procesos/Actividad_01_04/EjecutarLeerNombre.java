package Tema1_Procesos.Actividad_01_04;

import java.io.File;
import java.io.IOException;

public class EjecutarLeerNombre {
    public static void main(String[] args) throws IOException, InterruptedException {

        /*
        Crea un programa Java llamado LeerNombre.java que reciba desde los argumentos de main()
        un nombre y lo visualice en pantalla. Utiliza System.exit(1) para una finalización
        correcta del programa y System.exit(-1) para el caso que no se hayan introducido los
        argumentos correctos en main().

        A continuación, haz un programa parecido a Ejemplo3.java para ejecutar LeerNombre.java.
        Utiliza el método waitFor() para comprobar el valor de salida del proceso que se ejecuta.
        Prueba la ejecución del programa dando valor a los argumentos de main() y sin darle valor.
        ¿Qué valor devuelve waitFor() en un caso y en otro?.
         */
        // Indicar donde está el fichero COMPILADO
        File fichero = new File("C:\\Users\\danig\\Downloads\\DAM2\\PSP\\Tema1\\out\\production\\PSP");
        // Hacer un process builder de que se ejecute un archivo Java y cuál es
        ProcessBuilder pb = new ProcessBuilder("java", "PSP.Tema1.Actividad_01_04.LeerNombre", "Daniel");
        // Se le pasa al process builder donde está el Java compilado
        pb.directory(fichero);
        // Se inicia el proceso con Process para después leerlo
        Process p = pb.start();
        // A leer el contenido del proceso iniciado
        int resultado = p.waitFor();
        System.out.println(resultado);
    }

}