package Tema1_Procesos.Actividad_01_04;

public class LeerNombre {
    public static void main(String[] args) {
        if (args.length == 0) System.exit(-1);
        System.out.println(args[0]);
        System.exit(1);
    }
}