import java.util.ArrayList;

public class Diccionario<T> {

    private ArrayList<ComponenteDiccionario<T>> lista;

    public Diccionario() {
        lista = new ArrayList<>();
    }

    public static <T> Diccionario<T> crear() {
        Diccionario<T> nuevo = new Diccionario<>();
        return nuevo;
    }

    public int tamaño() {
        int cant = lista.size();
        return cant;
    }

    public boolean existeElemento(String id) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getClave().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public T obtenerElemento(String id) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getClave().equals(id)) {
                T elem = lista.get(i).getElemento();
                return elem;
            }
        }
        return null;
    }

    public void eliminarElemento(String id) {
        if (existeElemento(id)) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getClave().equals(id)) {
                    lista.remove(i);
                }
            }
        }
    }

    public void agregarElemento(String clave, T elemento) {
        if (existeElemento(clave)) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getClave().equals(clave)) {
                    lista.get(i).setElemento(elemento);
                }
            }
        } else {
            ComponenteDiccionario<T> comp = new ComponenteDiccionario<>(clave, elemento);
            lista.add(comp);
        }
    }
}