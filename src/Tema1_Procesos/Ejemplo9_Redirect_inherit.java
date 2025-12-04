package Tema1_Procesos;

import java.io.IOException;

public class Ejemplo9_Redirect_inherit {
    public static void main(String[] args) throws IOException {
        // Iniciamos los planos de un proceso que abrirá CMD y ejecutará DIR
        ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIR");
        // Redireccionamos la salida de ese proceso al proceso padre, aquí mismo
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        // Lanzamos
        Process p = pb.start();
    }
}