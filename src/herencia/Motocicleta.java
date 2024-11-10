package herencia;

public class Motocicleta extends Vehiculo {
	private boolean esAutomatica;

	public Motocicleta(String marca, String modelo, int año, boolean esAutomatica) {
		super(marca, modelo, año);
		this.esAutomatica = esAutomatica;
	}

	@Override
	public String toString() {
		String esAutomaticaLabel = "";
		if (this.esAutomatica) {
			esAutomaticaLabel = "Automatica";
		} else {
			esAutomaticaLabel = "Manual";
		}
		return "Marca: " + marca + " | Modelo: " + modelo + " | Año: " + año + " | Tipo de conducción: "
				+ esAutomaticaLabel;
	}
}
