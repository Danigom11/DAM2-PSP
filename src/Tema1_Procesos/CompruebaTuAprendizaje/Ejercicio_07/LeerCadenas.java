package Tema1_Procesos.CompruebaTuAprendizaje.Ejercicio_07;

import java.util.Scanner;

public class LeerCadenas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena= "";
        while (true) {
            System.out.print("Introduce una cadena (* para salir): ");
            cadena += sc.nextLine();
            if (cadena.equals("*")) break;
            System.out.println("Has introducido la cadena: " + cadena);
        }
    }
}