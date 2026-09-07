// INTEGRANTES:
// - Carlos Tadeo Ferreira Alderete
// - Giovanni Luis Roche Arguello



import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Figura> figuras = new ArrayList<>();
        int opcion;

        do {
            System.out.println("============================");
            System.out.println(" menu figuras geometricas");
            System.out.println("============================");
            System.out.println("0- crear circulo");
            System.out.println("1- crear rectangulo");
            System.out.println("2- crear triangulo equilatero");
            System.out.println("3- listar todas las figuras");
            System.out.println("4- calcular area total de todas las figuras");
            System.out.println("5- mostrar la figura de mayor area");
            System.out.println("6- salir");
            System.out.print("elija una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 0) {
                double radio = pedirPositivo(sc, "ingrese el radio: ");
                figuras.add(new Circulo(radio));
                System.out.println("se creo el circulo");
            } else if (opcion == 1) {
                double base = pedirPositivo(sc, "ingrese la base: ");
                double altura = pedirPositivo(sc, "ingrese la altura: ");
                figuras.add(new Rectangulo(base, altura));
                System.out.println("se creo el rectangulo");
            } else if (opcion == 2) {
                double lado = pedirPositivo(sc, "ingrese el lado: ");
                figuras.add(new TrianguloEquilatero(lado));
                System.out.println("se creo el triangulo equilatero");
            } else if (opcion == 3) {
                if (figuras.size() == 0) {
                    System.out.println("no hay figuras aun");
                } else {
                    for (int i = 0; i < figuras.size(); i++) {
                        System.out.println("figura " + (i + 1));
                        figuras.get(i).describir();
                        System.out.println("");
                    }
                }
            } else if (opcion == 4) {
                if (figuras.size() == 0) {
                    System.out.println("no hay figuras aun");
                } else {
                    double total = 0;
                    for (int i = 0; i < figuras.size(); i++) {
                        total += figuras.get(i).calcularArea();
                    }
                    System.out.println("el area total es: " + total);
                }
            } else if (opcion == 5) {
                if (figuras.size() == 0) {
                    System.out.println("no hay figuras aun");
                } else {
                    Figura mayor = figuras.get(0);
                    for (int i = 1; i < figuras.size(); i++) {
                        if (figuras.get(i).calcularArea() > mayor.calcularArea()) {
                            mayor = figuras.get(i);
                        }
                    }
                    System.out.println("la figura de mayor area es:");
                    mayor.describir();
                }
            } else if (opcion == 6) {
                System.out.println("chau profe");
            } else {
                System.out.println("opcion no valida");
            }

            if (opcion != 6) {
                presionarEnter(sc);
                limpiar();
            }
        } while (opcion != 6);
    }

    public static double pedirPositivo(Scanner sc, String mensaje) {
        double valor;
        do {
            System.out.print(mensaje);
            valor = sc.nextDouble();
            sc.nextLine();
            if (valor <= 0) {
                System.out.println("el valor debe ser un numero positivo");
            }
        } while (valor <= 0);
        return valor;
    }

    public static void presionarEnter(Scanner sc) {
        System.out.println("presione enter para volver al menu...");
        sc.nextLine();
    }

    public static void limpiar() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
        }
    }
}