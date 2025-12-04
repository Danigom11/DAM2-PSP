package Tema1_Procesos;

import java.io.*;

public class Ejemplo4_output_lectura {
    public static void main(String[] args) throws IOException {
        File directorio = new File(".\\out\\production\\PSP");
        ProcessBuilder pb = new ProcessBuilder("java", "PSP.Tema1.EjemploLectura");
        pb.directory(directorio);

        Process p = pb.start();

        OutputStream os = p.getOutputStream();
        os.write("Hola Daniel\n".getBytes());
        os.flush();
        os.close();

        // Leer la salida del proceso hijo
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
        br.close();
    }
}