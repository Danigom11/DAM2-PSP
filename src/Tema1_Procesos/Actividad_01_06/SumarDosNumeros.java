package Tema1_Procesos.Actividad_01_06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SumarDosNumeros {
    public static void main(String[] args) {
        // Escribe un programa que lea dos números desde la entrada estandar y visualice su suma.
        // Controla que lo introducido por teclado sean dos números.
        // Haz otro programa Java para ejecutar el anterior
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String numero1, numero2;
        int num1, num2;
        try {
            while (true) {
                System.out.print("Introduce el número 1: ");
                numero1 = br.readLine();
                try {
                    num1 = Integer.parseInt(numero1);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Introduce un número.");
                }
            }
            while (true){
                System.out.print("Introduce el número 2: ");
                numero2 = br.readLine();
                try {
                    num2 = Integer.parseInt(numero2);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Introduce un número.");
                }
            }
            System.out.printf("%d + %d = %d", num1, num2, (num1 + num2));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}