public class TrianguloEquilatero extends Figura {

    private double lado;

    public TrianguloEquilatero(double lado) {
        super("Triangulo Equilatero");
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return (Math.sqrt(3) / 4) * lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return 3 * lado;
    }
}