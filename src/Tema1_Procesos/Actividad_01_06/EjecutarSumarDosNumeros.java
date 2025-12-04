package Tema1_Procesos.Actividad_01_06;

import java.io.*;

public class EjecutarSumarDosNumeros {
    public static void main(String[] args) {
        File fichero = new File(".\\out\\production\\PSP");
        ProcessBuilder pb = new ProcessBuilder("java", "PSP.Tema1.Actividad_01_06.SumarDosNumeros");
        pb.directory(fichero);


        try {
            // Ejecutamos el proceso
            Process p = pb.start();

            // Enviar el texto al otro programa
            OutputStream os = p.getOutputStream();
            os.write("2\n".getBytes());
            os.write("4\n".getBytes());
            os.flush(); // Vaciar el buffer de salida
            os.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea = null;
            while ((linea = br.readLine()) != null){
                System.out.print(linea);
            }
            br.close();




        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}