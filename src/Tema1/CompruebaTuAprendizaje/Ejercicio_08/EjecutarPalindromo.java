package Tema1.CompruebaTuAprendizaje.Ejercicio_08;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EjecutarPalindromo {
    // Programa que ejecute palíndromo. Debe leer la cadena desde teclado y mostrar la salida
    // por pantalla. Transforma este ejercicio para que la cadena se obtenga de un fichero
    // de texto y se envíe la salida de error a un fichero
    public static void main(String[] args) throws IOException {
        int opcion;
        Scanner sc = new Scanner(System.in);
        File fichero = new File(".\\out\\production\\PSP");
        ProcessBuilder pb = new ProcessBuilder("java", "PSP.Tema1.CompruebaTuAprendizaje.Ejercicio_08.Palindromo");
        pb.directory(fichero);

        File fTexto = new File("FicheroTextoPalindromo.txt");
        File fError = new File("FicheroErrorPalindromo.txt");

        System.out.println("Como quieres ver el programa palindromo.java:");
        System.out.println("1. Por pantalla poniendo tu los datos");
        System.out.println("2. Obteniendo los datos de un fichero y enviando el error a un fichero.");

        while (true){
            try {
                System.out.print("Opción: ");
                opcion = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e){
                System.out.println("Introduce un número válido, 1 o 2");
            }
        }
        if (opcion == 1){
            // Cambiamos las reglas del process builder, las instrucciones, para decirle
            // que la salida normal y la de errores se muestren en la consola del padre
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            pb.redirectError(ProcessBuilder.Redirect.INHERIT);
            Process p = pb.start();
            System.out.println("Introduce una cadena de texto: ");
            String cadena = sc.nextLine().toLowerCase();
            OutputStream os = p.getOutputStream();
            os.write((cadena + "\n").getBytes());
            os.flush();
            os.close();
        } else if(opcion == 2){
            // Obtener la cadena desde un fichero
            pb.redirectInput(ProcessBuilder.Redirect.from(fTexto));
            // Mostrar aquí los resultados del hijo
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            // Guardar los errores en un archivo
            pb.redirectError(ProcessBuilder.Redirect.to(fError));
            // Iniciar
            pb.start();

        } else {
            System.out.println("Opción elegida no válida.");
        }
    }
}