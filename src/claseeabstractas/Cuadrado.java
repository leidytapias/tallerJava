package claseeabstractas;

public class Cuadrado extends Figuras{
	
	private double lado;
	
	public Cuadrado(double lado, double x, double y) {
		super(x, y);
		this.lado = lado;
	}
	
	
	@Override
	public double calculaAreas() {
		double resultado = lado*lado;
		return resultado;
	}

}
