package Tema1.CompruebaTuAprendizaje.Ejercicio_08;

import java.util.Scanner;

public class Palindromo {
    // Programa que lea una cadena desde la entrada estándar y visualice en pantalla si
    // la cadena es o no un palíndromo o si la cadena está vacía (longitud 0)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una cadena y te diré si es un palíndromo: ");
        String cadena = sc.nextLine();
        if (cadena.isEmpty()) {
            System.out.println("La cadena está vacía");
        } else {
            if (cadena.contentEquals(new StringBuilder(cadena).reverse()))
                System.out.println("Si que es un palíndromo.");
            else
                System.out.println("No es un palíndromo.");
        }
    }
}