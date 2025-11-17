package Tema1;

import java.util.*;
import java.io.*;

public class Ejemplo6_environment_command {
    public static void main(String[] args) {
        ProcessBuilder test = new ProcessBuilder();
        Map entorno = test.environment();
        System.out.println("Variables de entorno:");
        System.out.println(entorno);

        test = new ProcessBuilder("java", "LeerNombre", "Daniel");

        // devuelve el nombre del proceso y sus argumentos
        List l = test.command();
        Iterator iter = l.iterator();
        System.out.println("\nArgumentos del comando:");
        while (iter.hasNext()) System.out.println(iter.next());

        test = test.command("CMD", "/C", "DIR");
        try {
            Process p = test.start(); // se ejecuta DIR
            InputStream is = p.getInputStream();
            System.out.println();
            int c;
            while ((c = is.read()) != -1) System.out.print((char) c);
            is.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}