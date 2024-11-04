package claseeabstractas;

public abstract class Figuras {
	
	protected double x;
	protected double y;
	
	protected Figuras() {
		
	}
	
	protected Figuras(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public abstract double calculaAreas();

}
