package herencia;

public class Carro extends Vehiculo {
    private int numeroDePuertas;

    public Carro(String marca, String modelo, int año, int numeroDePuertas) {
        super(marca, modelo, año);
        this.numeroDePuertas = numeroDePuertas;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + " | Modelo: " + modelo + " | Año: " + año + " | Puertas: " + numeroDePuertas ;
    }
}