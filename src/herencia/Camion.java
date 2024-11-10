package herencia;

public class Camion extends Vehiculo {
	private double capacidadDeCarga;

	public Camion(String marca, String modelo, int año, double capacidadDeCarga) {
		super(marca, modelo, año);
		this.capacidadDeCarga = capacidadDeCarga;
	}

	@Override
	public String toString() {
		return "Marca: " + marca + " | Modelo: " + modelo + " | Año: " + año + " | Capacidad: " + capacidadDeCarga;
	}
}
