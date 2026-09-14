// INTEGRANTES:
// -Carlos Tadeo Ferreira Alderete 5539544
// -Alex Giovanni Llamosas Maidana 5631704

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinario<Integer> arbol = null;
        int opcion;

        do {
            System.out.println("==========================");
            System.out.println(" arbol binario de busqueda");
            System.out.println("==========================");
            System.out.println("0- crear arbol");
            System.out.println("1- insertar dato");
            System.out.println("2- eliminar dato");
            System.out.println("3- buscar dato");
            System.out.println("4- imprimir por niveles (bfs)");
            System.out.println("5- imprimir en orden (inorder)");
            System.out.println("6- imprimir preorden");
            System.out.println("7- imprimir postorden");
            System.out.println("8- mostrar altura del arbol");
            System.out.println("9- mostrar cantidad de nodos");
            System.out.println("10- salir");
            System.out.print("ingrese una opcion: ");
            opcion = pedirEntero(sc);

            if (opcion == 0) {
                arbol = new ArbolBinario<>();
                System.out.println("arbol creado");
            } else if (opcion == 1) {
                if (arbol == null) {
                    System.out.println("primero debe crear el arbol (opcion 0)");
                } else {
                    System.out.print("ingrese el dato a insertar: ");
                    int dato = pedirEntero(sc);
                    arbol.insertar(dato);
                    System.out.println("se inserto el dato " + dato);
                }
            } else if (opcion == 2) {
                if (arbol == null) {
                    System.out.println("primero debe crear el arbol (opcion 0)");
                } else if (arbol.estaVacio()) {
                    System.out.println("el arbol esta vacio");
                } else {
                    System.out.print("ingrese el dato a eliminar: ");
                    int dato = pedirEntero(sc);
                    arbol.eliminar(dato);
                    System.out.println("se elimino el dato " + dato);
                }
            } else if (opcion == 3) {
                if (arbol == null) {
                    System.out.println("primero debe crear el arbol (opcion 0)");
                } else if (arbol.estaVacio()) {
                    System.out.println("el arbol esta vacio");
                } else {
                    System.out.print("ingrese el dato a buscar: ");
                    int dato = pedirEntero(sc);
                    if (arbol.buscar(dato)) {
                        System.out.println("el dato " + dato + " existe en el arbol");
                    } else {
                        System.out.println("el dato " + dato + " no existe en el arbol");
                    }
                }
            } else if (opcion == 4) {
                if (arbol == null) {
                    System.out.println("primero debe crear el arbol (opcion 0)");
                } else if (arbol.estaVacio()) {
                    System.out.println("el arbol esta vacio");
                } else {
                    System.out.println("arbol por niveles:");
                    arbol.imprimirPorNiveles();
                }
            } else if (opcion == 5) {
                if (arbol == null) {
                    System.out.println("primero debe crear el arbol (opcion 0)");
                } else if (arbol.estaVacio()) {
                    System.out.println("el arbol esta vacio");
                } else {
                    System.out.print("recorrido en orden: ");
                    arbol.imprimirEnOrden();
                }
            } else if (opcion == 6) {
                if (arbol == null) {
                    System.out.println("primero debe crear el arbol (opcion 0)");
                } else if (arbol.estaVacio()) {
                    System.out.println("el arbol esta vacio");
                } else {
                    System.out.print("recorrido preorden: ");
                    arbol.imprimirPreOrden();
                }
            } else if (opcion == 7) {
                if (arbol == null) {
                    System.out.println("primero debe crear el arbol (opcion 0)");
                } else if (arbol.estaVacio()) {
                    System.out.println("el arbol esta vacio");
                } else {
                    System.out.print("recorrido postorden: ");
                    arbol.imprimirPostOrden();
                }
            } else if (opcion == 8) {
                if (arbol == null) {
                    System.out.println("primero debe crear el arbol (opcion 0)");
                } else if (arbol.estaVacio()) {
                    System.out.println("el arbol esta vacio");
                } else {
                    System.out.println("la altura del arbol es: " + arbol.altura());
                }
            } else if (opcion == 9) {
                if (arbol == null) {
                    System.out.println("primero debe crear el arbol (opcion 0)");
                } else if (arbol.estaVacio()) {
                    System.out.println("el arbol esta vacio");
                } else {
                    System.out.println("el arbol tiene " + arbol.contarNodos() + " nodo(s)");
                }
            } else if (opcion == 10) {
                System.out.println("chau    ");
            } else {
                System.out.println("opcion no valida");
            }

            System.out.println("");
        } while (opcion != 10);
    }

    // lee un numero entero, si el usuario escribe otra cosa le avisa
    // y le vuelve a pedir, asi el programa no se rompe
    public static int pedirEntero(Scanner sc) {
        while (true) {
            try {
                String linea = sc.nextLine();
                return Integer.parseInt(linea.trim());
            } catch (Exception e) {
                // si ya no hay mas entrada (por ejemplo un archivo) salgo
                if (!sc.hasNextLine()) {
                    System.out.println("se termino la entrada, chau");
                    return 10;
                }
                System.out.println("eso no es un numero valido, intente de nuevo");
            }
        }
    }
}