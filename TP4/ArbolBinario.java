// INTEGRANTES:
// -Carlos Tadeo Ferreira Alderete 5539544
// -Alex Giovanni Llamosas Maidana 5631704

import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinario<T extends Comparable<T>> {

    private NodoArbol<T> raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public void insertar(T dato) {
        raiz = insertarRec(raiz, dato);
    }

    private NodoArbol<T> insertarRec(NodoArbol<T> actual, T dato) {
        if (actual == null) {
            return new NodoArbol<>(dato);
        }

        int resultado = dato.compareTo(actual.getDato());

        if (resultado < 0) {
            // los menores van a la izquierda
            actual.setIzquierdo(insertarRec(actual.getIzquierdo(), dato));
        } else if (resultado > 0) {
            // y los mayores a la derecha
            actual.setDerecho(insertarRec(actual.getDerecho(), dato));
        }
        // si es igual no inserto nada, para no repetir datos
        return actual;
    }

    public boolean buscar(T dato) {
        return buscarRec(raiz, dato);
    }

    private boolean buscarRec(NodoArbol<T> actual, T dato) {
        if (actual == null) {
            return false;
        }

        int resultado = dato.compareTo(actual.getDato());

        if (resultado == 0) {
            return true;
        } else if (resultado < 0) {
            return buscarRec(actual.getIzquierdo(), dato);
        } else {
            return buscarRec(actual.getDerecho(), dato);
        }
    }

    public void eliminar(T dato) {
        raiz = eliminarRec(raiz, dato);
    }

    private NodoArbol<T> eliminarRec(NodoArbol<T> actual, T dato) {
        if (actual == null) {
            return null;
        }

        int resultado = dato.compareTo(actual.getDato());

        if (resultado < 0) {
            actual.setIzquierdo(eliminarRec(actual.getIzquierdo(), dato));
        } else if (resultado > 0) {
            actual.setDerecho(eliminarRec(actual.getDerecho(), dato));
        } else {
            // encontre el nodo, ahora hay que ver cuantos hijos tiene

            // caso 1 y 2: sin hijos o con un solo hijo
            if (actual.getIzquierdo() == null) {
                return actual.getDerecho();
            } else if (actual.getDerecho() == null) {
                return actual.getIzquierdo();
            }

            // caso 3: tiene dos hijos, uso el sucesor en inorden
            // (el mas chico del subarbol derecho) para reemplazarlo
            actual.setDato(minimo(actual.getDerecho()));
            actual.setDerecho(eliminarRec(actual.getDerecho(), actual.getDato()));
        }
        return actual;
    }

    private T minimo(NodoArbol<T> actual) {
        while (actual.getIzquierdo() != null) {
            actual = actual.getIzquierdo();
        }
        return actual.getDato();
    }

    public void imprimirPorNiveles() {
        if (raiz == null) {
            return;
        }

        Queue<NodoArbol<T>> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            // cantidad de nodos que hay en este nivel
            int cantidad = cola.size();

            for (int i = 0; i < cantidad; i++) {
                NodoArbol<T> actual = cola.remove();
                System.out.print(actual.getDato() + " ");

                if (actual.getIzquierdo() != null) {
                    cola.add(actual.getIzquierdo());
                }
                if (actual.getDerecho() != null) {
                    cola.add(actual.getDerecho());
                }
            }
            System.out.println("");
        }
    }

    public void imprimirEnOrden() {
        enOrdenRec(raiz);
        System.out.println("");
    }

    private void enOrdenRec(NodoArbol<T> actual) {
        if (actual == null) {
            return;
        }
        enOrdenRec(actual.getIzquierdo());
        System.out.print(actual.getDato() + " ");
        enOrdenRec(actual.getDerecho());
    }

    public void imprimirPreOrden() {
        preOrdenRec(raiz);
        System.out.println("");
    }

    private void preOrdenRec(NodoArbol<T> actual) {
        if (actual == null) {
            return;
        }
        System.out.print(actual.getDato() + " ");
        preOrdenRec(actual.getIzquierdo());
        preOrdenRec(actual.getDerecho());
    }

    public void imprimirPostOrden() {
        postOrdenRec(raiz);
        System.out.println("");
    }

    private void postOrdenRec(NodoArbol<T> actual) {
        if (actual == null) {
            return;
        }
        postOrdenRec(actual.getIzquierdo());
        postOrdenRec(actual.getDerecho());
        System.out.print(actual.getDato() + " ");
    }

    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(NodoArbol<T> actual) {
        if (actual == null) {
            return -1;
        }

        int alturaIzq = alturaRec(actual.getIzquierdo());
        int alturaDer = alturaRec(actual.getDerecho());

        // la altura es la rama mas larga mas uno
        if (alturaIzq > alturaDer) {
            return alturaIzq + 1;
        } else {
            return alturaDer + 1;
        }
    }

    public int contarNodos() {
        return contarRec(raiz);
    }

    private int contarRec(NodoArbol<T> actual) {
        if (actual == null) {
            return 0;
        }
        // el nodo actual mas los que hay en cada lado
        return 1 + contarRec(actual.getIzquierdo()) + contarRec(actual.getDerecho());
    }
}