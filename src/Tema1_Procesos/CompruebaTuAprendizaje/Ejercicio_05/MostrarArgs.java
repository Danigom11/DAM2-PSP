package Tema1_Procesos.CompruebaTuAprendizaje.Ejercicio_05;

public class MostrarArgs {
    public static void main(String[] args) {
        if (args.length > 0){
            int num = Integer.parseInt(args[0]);
            for (int i = 0; i < num; i++){
                System.out.println(args[0]);
            }
        } else {
            System.out.println("El programa no ha recibido parámetros");
            System.exit(1);
        }
    }
}