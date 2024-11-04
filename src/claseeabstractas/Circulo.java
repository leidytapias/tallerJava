package claseeabstractas;

public class Circulo extends Figuras{
	
	private double radio;
	
	public Circulo() {
		
	}
	
	public Circulo(double radio, double x, double y) {
		super(x, y);
		this.radio=radio;
	}
	
	@Override
	public double calculaAreas() {
		double pi=3.1416;
		double resultado=pi*radio*radio;
		return resultado;
	}

}
