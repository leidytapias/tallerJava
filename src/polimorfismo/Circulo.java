package polimorfismo;

public class Circulo extends Figura {

	private double radio;

	public Circulo() {

	}

	public Circulo(double radio) {
		super();
		this.radio = radio;
	}

	@Override
	public void calculaAreas() {
		this.area = Math.PI * this.radio * this.radio;
	}

	@Override
	public String toString() {
		return "Radio: " + radio + " | Area: " + area;
	}
}
