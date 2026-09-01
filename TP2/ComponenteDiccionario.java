public class ComponenteDiccionario<T> {

    private String clave;
    private T elemento;

    public ComponenteDiccionario(String clave, T elemento) {
        this.clave = clave;
        this.elemento = elemento;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    @Override
    public String toString() {
        String s = "Clave: " + clave + " - Elemento: " + elemento;
        return s;
    }
}