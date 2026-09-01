import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Diccionario<String> dic = new Diccionario<>();
        int opt;

        do {
            System.out.println(" menu diccionario ");
            System.out.println("1- crear diccionario");
            System.out.println("2- tamaño");
            System.out.println("3- existe elemento");
            System.out.println("4- obtener elemento");
            System.out.println("5- eliminar elemento");
            System.out.println("6- agregar elemento");
            System.out.println("7- salir");
            System.out.print("ingrese una opcion: ");
            opt = sc.nextInt();
            sc.nextLine();

            if (opt == 1) {
                dic = new Diccionario<>();
                System.out.println("diccionario creado ");
            } else if (opt == 2) {
                int cantidad = dic.tamaño();
                System.out.println("el diccionario tiene " + cantidad + " elemento(s)");
            } else if (opt == 3) {
                System.out.print("ingrese la clave: ");
                String id = sc.nextLine();
                boolean esta = dic.existeElemento(id);
                if (esta == true) {
                    System.out.println("la clave " + id + " existe");
                } else {
                    System.out.println("la clave " + id + " no existe");
                }
            } else if (opt == 4) {
                System.out.print("ingrese la clave: ");
                String id = sc.nextLine();
                String valor = dic.obtenerElemento(id);
                if (valor != null) {
                    System.out.println("el valor de " + id + " es " + valor);
                } else {
                    System.out.println("no hay ningun valor para la clave " + id);
                }
            } else if (opt == 5) {
                System.out.print("ingrese la clave: ");
                String id = sc.nextLine();
                dic.eliminarElemento(id);
                System.out.println("se elimino la clave " + id );
            } else if (opt == 6) {
                System.out.print("ingrese la clave: ");
                String id = sc.nextLine();
                System.out.print("ingrese el valor: ");
                String valor = sc.nextLine();
                dic.agregarElemento(id, valor);
                System.out.println("se agrego el valor para la clave " + id);
            } else if (opt == 7) {
                System.out.println("chau profe");
            } else {
                System.out.println("opcion no valida");
            }
            System.out.println("");
        } while (opt != 7);
    }
}