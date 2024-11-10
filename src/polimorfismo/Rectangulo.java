package polimorfismo;

public class Rectangulo extends Figura {

	private double ancho;
	private double largo;

	public Rectangulo(double ancho, double largo) {
		super();
		this.ancho = ancho;
		this.largo = largo;
	}

	@Override
	public void calculaAreas() {
		this.area = ancho * largo;
	}

	@Override
	public String toString() {
		return "Ancho: " + ancho + " | Largo: " + largo + " | Area: " + area;
	}

}
