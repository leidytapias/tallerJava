package claseabstractas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;

//import Figura;

public class TiendaGeometrica extends JFrame{
	
	private JComboBox<String> tipoFigura;
	private JPanel formularioTinda;
	private JTextField circuloField, areaField;
    
    private ArrayList<Figura> figura;
	
  public TiendaGeometrica() {
    	
        // Inicializar la lista de vehículos
        figura = new ArrayList<>();

        // Configuración de la ventana principal
        setTitle("Gestión de Vehículos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de selección de tipo de vehículo
        JPanel tipoPanel = new JPanel();
        tipoVehiculoCombo = new JComboBox<>(new String[]{"Carro", "Camión", "Motocicleta"});
        tipoVehiculoCombo.addActionListener(e -> actualizarFormulario());
        tipoPanel.add(new JLabel("Tipo de Vehículo:"));
        tipoPanel.add(tipoVehiculoCombo);
        add(tipoPanel, BorderLayout.NORTH);

        // Panel para el formulario
        formularioPanel = new JPanel();
        formularioPanel.setLayout(new BoxLayout(formularioPanel, BoxLayout.Y_AXIS));
        add(formularioPanel, BorderLayout.CENTER);

        // Campos generales del vehículo
        marcaField = new JTextField(10);
        modeloField = new JTextField(10);
        añoField = new JTextField(10);

        // Campos específicos
        puertasField = new JTextField(10); // Para Carro
        cargaField = new JTextField(10); // Para Camión
        esAutomaticaCheckBox = new JCheckBox("¿Es automatica?"); // Para Motocicleta

        actualizarFormulario(); // Cargar formulario inicial

        // Botón para guardar el vehículo
        JButton guardarButton = new JButton("Guardar Vehículo");
        guardarButton.addActionListener(e -> guardarVehiculo());
        add(guardarButton, BorderLayout.SOUTH);

        // Botón para mostrar los vehículos guardados
        JButton mostrarButton = new JButton("Mostrar Vehículos");
        mostrarButton.addActionListener(e -> mostrarVehiculos());
        add(mostrarButton, BorderLayout.EAST);
    }

}
