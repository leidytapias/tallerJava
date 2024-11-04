package claseabstractas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;

import herencia.Camion;
import herencia.Carro;
import herencia.Concesionario;
import herencia.Motocicleta;
import herencia.Vehiculo;

//import Figura;

public class TiendaGeometricaAbstracta extends JFrame {

	private JComboBox<String> tipoFigura;
	private JPanel formularioTienda;
	private JTextField radioField, anchoField, largoField;

	private ArrayList<Figura> figuras;

	public TiendaGeometricaAbstracta() {

		// Inicializar la lista de figuras
		figuras = new ArrayList<>();

		// Configuración de la ventana principal
		setTitle("Gestión de Figuras");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Panel de selección de tipo de figura
		JPanel tipoPanel = new JPanel();
		tipoFigura = new JComboBox<>(new String[] { "Circulo", "Rectangulo" });
		tipoFigura.addActionListener(e -> actualizarFormulario());
		tipoPanel.add(new JLabel("Tipo figura:"));
		tipoPanel.add(tipoFigura);
		add(tipoPanel, BorderLayout.NORTH);

		// Panel para el formulario
		formularioTienda = new JPanel();
		formularioTienda.setLayout(new BoxLayout(formularioTienda, BoxLayout.Y_AXIS));
		add(formularioTienda, BorderLayout.CENTER);

		radioField = new JTextField(10);
		anchoField = new JTextField(10);
		largoField = new JTextField(10);

		actualizarFormulario(); // Cargar formulario inicial

		// Botón para guardar el vehículo
		JButton guardarButton = new JButton("Guardar figura");
		guardarButton.addActionListener(e -> guardarFigura());
		add(guardarButton, BorderLayout.SOUTH);

		// Botón para mostrar los vehículos guardados
		JButton mostrarButton = new JButton("Mostrar figuras");
		mostrarButton.addActionListener(e -> mostrarFiguras());
		add(mostrarButton, BorderLayout.EAST);
	}

	private void actualizarFormulario() {
		formularioTienda.removeAll();

		String tipo = (String) tipoFigura.getSelectedItem();
		if ("Circulo".equals(tipo)) {
			formularioTienda.add(new JLabel("Radio:"));
			formularioTienda.add(radioField);
		} else if ("Rectangulo".equals(tipo)) {
			formularioTienda.add(new JLabel("Ancho:"));
			formularioTienda.add(anchoField);
			formularioTienda.add(new JLabel("Largo:"));
			formularioTienda.add(largoField);
		}

		formularioTienda.revalidate();
		formularioTienda.repaint();
	}

	private void guardarFigura() {

		String tipo = (String) tipoFigura.getSelectedItem();

		Figura figura = null;
		if ("Circulo".equals(tipo)) {
			int radio = Integer.parseInt(radioField.getText());
			figura = new Circulo(radio);

			// Se calcula manualmente el área
			figura.area = Math.PI * radio * radio;
		} else if ("Rectangulo".equals(tipo)) {
			double ancho = Double.parseDouble(anchoField.getText());
			double largo = Double.parseDouble(largoField.getText());
			figura = new Rectangulo(ancho, largo);

			// Se calcula manualmente el área
			figura.area = ancho * largo;
		}

		if (figura != null) {
			figuras.add(figura);
			JOptionPane.showMessageDialog(this, "Figura guardada exitosamente.");
		}
	}

	private void mostrarFiguras() {
		StringBuilder sb = new StringBuilder("Figuras guardadas:\n");
		for (Figura f : figuras) {
			sb.append(f).append("\n");
		}
		JOptionPane.showMessageDialog(this, sb.toString());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			TiendaGeometricaAbstracta app = new TiendaGeometricaAbstracta();
			app.setVisible(true);
		});
	}
}
