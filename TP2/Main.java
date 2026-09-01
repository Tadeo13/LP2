import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Diccionario<String> dic = new Diccionario<>();
        int opcion;

        do {
            System.out.println("========== MENU ==========");
            System.out.println("1- Crear diccionario");
            System.out.println("2- Tamaño");
            System.out.println("3- Existe elemento");
            System.out.println("4- Obtener elemento");
            System.out.println("5- Eliminar elemento");
            System.out.println("6- Agregar elemento");
            System.out.println("7- Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                dic = new Diccionario<>();
                System.out.println("Diccionario creado (vacío)");
            } else if (opcion == 2) {
                int cantidad = dic.tamaño();
                System.out.println("El diccionario tiene " + cantidad + " elemento/s");
            } else if (opcion == 3) {
                System.out.print("Ingrese la clave: ");
                String key = sc.nextLine();
                boolean esta = dic.existeElemento(key);
                if (esta == true) {
                    System.out.println("La clave " + key + " existe");
                } else {
                    System.out.println("La clave " + key + " NO existe");
                }
            } else if (opcion == 4) {
                System.out.print("Ingrese la clave: ");
                String key = sc.nextLine();
                String valor = dic.obtenerElemento(key);
                if (valor != null) {
                    System.out.println("El valor de " + key + " es: " + valor);
                } else {
                    System.out.println("No hay ningun valor para la clave " + key);
                }
            } else if (opcion == 5) {
                System.out.print("Ingrese la clave: ");
                String key = sc.nextLine();
                dic.eliminarElemento(key);
                System.out.println("Se elimino la clave " + key + " (si existia)");
            } else if (opcion == 6) {
                System.out.print("Ingrese la clave: ");
                String key = sc.nextLine();
                System.out.print("Ingrese el valor: ");
                String valor = sc.nextLine();
                dic.agregarElemento(key, valor);
                System.out.println("Se agrego el valor para la clave " + key);
            } else if (opcion == 7) {
                System.out.println("Chau!");
            } else {
                System.out.println("Opcion invalida");
            }
            System.out.println("");
        } while (opcion != 7);
    }
}