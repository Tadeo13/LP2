public class ComponenteDiccionario<T> {

    private String id;
    private T elemento;

    public ComponenteDiccionario(String id, T elemento) {
        this.id = id;
        this.elemento = elemento;
    }

    public String getClave() {
        return id;
    }

    public void setClave(String id) {
        this.id = id;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    
    public String toString() {
        String s = "Clave: " + id + " - Elemento: " + elemento;
        return s;
    }
}