package Tema1_Procesos.CompruebaTuAprendizaje.Ejercicio_04;

public class GestorArgumentos {
    public static void main(String[] args) {
        // Si el número de argumentos es menor a 1 que devuelva 1
        if (args.length < 1) System.exit(1);

        // Si el argumento es una cadena que devuelva 2
        try {
            Integer.parseInt(args[0]); // Se intenta convertir a número, si no salta la excepción ya que es una cadena
        } catch (NumberFormatException e) {
            System.exit(2);
        }

        // Si el argumento es un número entero menor que 0 devuelve 3
        if (Integer.parseInt(args[0]) < 0) {
            System.exit(3);
        }

        // En cualquier otra situación devuelve 0
        System.exit(0);

    }

}