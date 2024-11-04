package claseabstractas;

public class Circulo extends Figura {

	private double radio;

	public Circulo() {

	}

	public Circulo(double radio) {
		super();
		this.radio = radio;
	}

	@Override
	public String toString() {
		return "Radio: " + radio + " | Área: " + area;
	}
}
