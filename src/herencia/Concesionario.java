package herencia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Concesionario extends JFrame {
    private JComboBox<String> tipoVehiculoCombo;
    private JPanel formularioPanel;
    private JTextField marcaField, modeloField, añoField;
    private JTextField puertasField, cargaField;
    private JCheckBox esAutomaticaCheckBox;
    private ArrayList<Vehiculo> vehiculos;

    public Concesionario() {
    	
        
        vehiculos = new ArrayList<>();

       
        setTitle("Gestión de Vehículos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        
        JPanel tipoPanel = new JPanel();
        tipoVehiculoCombo = new JComboBox<>(new String[]{"Carro", "Camión", "Motocicleta"});
        tipoVehiculoCombo.addActionListener(e -> actualizarFormulario());
        tipoPanel.add(new JLabel("Tipo de Vehículo:"));
        tipoPanel.add(tipoVehiculoCombo);
        add(tipoPanel, BorderLayout.NORTH);

        formularioPanel = new JPanel();
        formularioPanel.setLayout(new BoxLayout(formularioPanel, BoxLayout.Y_AXIS));
        add(formularioPanel, BorderLayout.CENTER);

        marcaField = new JTextField(10);
        modeloField = new JTextField(10);
        añoField = new JTextField(10);

        puertasField = new JTextField(10);
        cargaField = new JTextField(10); 
        esAutomaticaCheckBox = new JCheckBox("¿Es automatica?");

        actualizarFormulario(); 

      
        JButton guardarButton = new JButton("Guardar Vehículo");
        guardarButton.addActionListener(e -> guardarVehiculo());
        add(guardarButton, BorderLayout.SOUTH);

        
        JButton mostrarButton = new JButton("Mostrar Vehículos");
        mostrarButton.addActionListener(e -> mostrarVehiculos());
        add(mostrarButton, BorderLayout.EAST);
    }

    private void actualizarFormulario() {
        formularioPanel.removeAll();
        formularioPanel.add(new JLabel("Marca:"));
        formularioPanel.add(marcaField);
        formularioPanel.add(new JLabel("Modelo:"));
        formularioPanel.add(modeloField);
        formularioPanel.add(new JLabel("Año:"));
        formularioPanel.add(añoField);

        String tipo = (String) tipoVehiculoCombo.getSelectedItem();
        if ("Carro".equals(tipo)) {
            formularioPanel.add(new JLabel("Número de Puertas:"));
            formularioPanel.add(puertasField);
        } else if ("Camión".equals(tipo)) {
            formularioPanel.add(new JLabel("Capacidad de Carga:"));
            formularioPanel.add(cargaField);
        } else if ("Motocicleta".equals(tipo)) {
            formularioPanel.add(esAutomaticaCheckBox);
        }

        formularioPanel.revalidate();
        formularioPanel.repaint();
    }

    private void guardarVehiculo() {
        String marca = marcaField.getText();
        String modelo = modeloField.getText();
        int año = Integer.parseInt(añoField.getText());
        String tipo = (String) tipoVehiculoCombo.getSelectedItem();

        Vehiculo vehiculo = null;
        if ("Carro".equals(tipo)) {
            int puertas = Integer.parseInt(puertasField.getText());
            vehiculo = new Carro(marca, modelo, año, puertas);
        } else if ("Camión".equals(tipo)) {
            double carga = Double.parseDouble(cargaField.getText());
            vehiculo = new Camion(marca, modelo, año, carga);
        } else if ("Motocicleta".equals(tipo)) {
            boolean esAutomatica = esAutomaticaCheckBox.isSelected();
            vehiculo = new Motocicleta(marca, modelo, año, esAutomatica);
        }

        if (vehiculo != null) {
            vehiculos.add(vehiculo);
            JOptionPane.showMessageDialog(this, "Vehículo guardado exitosamente.");
        }
    }

    private void mostrarVehiculos() {
        StringBuilder sb = new StringBuilder("Vehículos guardados:\n");
        for (Vehiculo v : vehiculos) {
            sb.append(v).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Concesionario app = new Concesionario();
			app.setVisible(true);
		});
	}
}
