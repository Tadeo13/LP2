public abstract class Figura {

    private String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double calcularArea();

    public abstract double calcularPerimetro();

    public void describir() {
        System.out.println("figura: " + nombre);
        System.out.println("area: " + calcularArea());
        System.out.println("perimetro: " + calcularPerimetro());
    }
}