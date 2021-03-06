package vista;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Vista que se encarga del �rea de administraci�n.
 * Realiza las siguientes operaciones
 * - Dar de alta y baja a todos los empleados y directivos de la empresa.
 * - Registrar las novedades de los veh�culos y lleva el control del estado de cada operaci�n de 
 * mantenimiento.
 * - Actualizar y gestionar las listas de precios de los transportes y carries.
 * - Seleccionar las compa��as de seguridad paraacompa�ar a los veh�culos cuando sea necesario 
 * manteniendo los precios de las mismas.
 * - Llevar un registro de las compa��as de seguros, donde figura el tipo de seguro que brinda, 
 * sobre qu� tipo de mercader�as y las tarifas asociadas los mismos.
 * @author Daniel PC
 *
 */

public class PanelAdministracion extends JFrame {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAdministracion frame = new PanelAdministracion();
					frame.setVisible(true);
					Dimension d = new Dimension();
					d.setSize(700,600);
					frame.setSize(d); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public PanelAdministracion() {
		setBackground(new Color(102, 255, 153));
		setTitle("Panel de administraci\u00F3n");
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(21, 21, 622, 385);
		getContentPane().add(tabbedPane);
		
		JPanel EmpresasSeguros = new JPanel();
		tabbedPane.addTab("Empresas Seguros", null, EmpresasSeguros, null);
		EmpresasSeguros.setLayout(null);
		
		JLabel lblEmpresasDisponibles = new JLabel("Empresas:");
		lblEmpresasDisponibles.setBounds(112, 41, 97, 26);
		EmpresasSeguros.add(lblEmpresasDisponibles);
		
		JComboBox listadoEmpresasSeguros = new JComboBox();
		listadoEmpresasSeguros.setBounds(234, 38, 339, 32);
		EmpresasSeguros.add(listadoEmpresasSeguros);
		
		JLabel lblDatos = new JLabel("Datos:");
		lblDatos.setBounds(21, 93, 92, 26);
		EmpresasSeguros.add(lblDatos);
		
		table = new JTable();
		table.setBounds(46, 194, 550, -53);
		EmpresasSeguros.add(table);
		
		JPanel Carries = new JPanel();
		tabbedPane.addTab("Carries", null, Carries, null);
		Carries.setLayout(null);
		
		JLabel lblCarries = new JLabel("Carries:");
		lblCarries.setBounds(53, 35, 72, 26);
		Carries.add(lblCarries);
		
		JComboBox listadoCarries = new JComboBox();
		listadoCarries.setBounds(159, 32, 316, 32);
		Carries.add(listadoCarries);
		
		JLabel lblDatos_1 = new JLabel("Listado:");
		lblDatos_1.setBounds(53, 181, 92, 32);
		Carries.add(lblDatos_1);
		
		tblListadoCarries = new JTable();
		tblListadoCarries.setBounds(31, 302, 565, -65);
		Carries.add(tblListadoCarries);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(53, 110, 92, 26);
		Carries.add(lblPrecio);
		
		txtPrecioCarrier = new JTextField();
		txtPrecioCarrier.setBounds(159, 107, 186, 32);
		Carries.add(txtPrecioCarrier);
		txtPrecioCarrier.setColumns(10);
		
		JPanel MantenimientoVehiculos = new JPanel();
		tabbedPane.addTab("Mantenimiento Vehiculos", null, MantenimientoVehiculos, null);
		MantenimientoVehiculos.setLayout(null);
		
		JComboBox listadoVehiculos = new JComboBox();
		listadoVehiculos.setBounds(285, 18, 209, 32);
		MantenimientoVehiculos.add(listadoVehiculos);
		
		JLabel lblVehiculos = new JLabel("Vehiculos");
		lblVehiculos.setBounds(139, 21, 92, 26);
		MantenimientoVehiculos.add(lblVehiculos);
		
		mantenimientosVehiculo = new JTable();
		mantenimientosVehiculo.setBounds(36, 304, 560, -115);
		MantenimientoVehiculos.add(mantenimientosVehiculo);
		
		JLabel lblListadoDeMantenimientos = new JLabel("Listado de mantenimientos:");
		lblListadoDeMantenimientos.setBounds(21, 147, 279, 26);
		MantenimientoVehiculos.add(lblListadoDeMantenimientos);
		
		JButton btnAgregarMantenimiento = new JButton("Agregar mantenimiento");
		btnAgregarMantenimiento.setBounds(176, 91, 263, 35);
		MantenimientoVehiculos.add(btnAgregarMantenimiento);
		
		JPanel EmpresasSeguridad = new JPanel();
		tabbedPane.addTab("Empresas Seguridad", null, EmpresasSeguridad, null);
		EmpresasSeguridad.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Empresas de seguridad:");
		lblNewLabel.setBounds(47, 32, 245, 26);
		EmpresasSeguridad.add(lblNewLabel);
		
		JComboBox listadoEmpresasSeguridad = new JComboBox();
		listadoEmpresasSeguridad.setBounds(306, 29, 290, 32);
		EmpresasSeguridad.add(listadoEmpresasSeguridad);
		
		JLabel lblPrecioDelServicio = new JLabel("Precio del servicio:");
		lblPrecioDelServicio.setBounds(47, 103, 175, 26);
		EmpresasSeguridad.add(lblPrecioDelServicio);
		
		txtPrecioServicioEmpSeg = new JTextField();
		txtPrecioServicioEmpSeg.setBounds(306, 100, 186, 32);
		EmpresasSeguridad.add(txtPrecioServicioEmpSeg);
		txtPrecioServicioEmpSeg.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(215, 171, 141, 35);
		EmpresasSeguridad.add(btnGuardar);
		
		JPanel ABMEmpleados = new JPanel();
		tabbedPane.addTab("ABM Empleados", null, ABMEmpleados, null);
		ABMEmpleados.setLayout(null);
		
		JButton btnAltaEmpleado = new JButton("Alta empleado");
		btnAltaEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaEmpleado altaEmpleado = new AltaEmpleado();
				altaEmpleado.setVisible(true);
				Dimension d = new Dimension();
				d.setSize(700,600);
				altaEmpleado.setSize(d); 
			}
		});
		btnAltaEmpleado.setBounds(240, 35, 167, 35);
		ABMEmpleados.add(btnAltaEmpleado);
		
		JButton btnModificacinEmpleado = new JButton("Modificaci\u00F3n empleado");
		btnModificacinEmpleado.setBounds(186, 105, 274, 35);
		ABMEmpleados.add(btnModificacinEmpleado);
		
		JButton btnBajaEmpleado = new JButton("Baja empleado");
		btnBajaEmpleado.setBounds(229, 175, 189, 35);
		ABMEmpleados.add(btnBajaEmpleado);
		
		JButton btnListadoEmpleados = new JButton("Listado empleados");
		btnListadoEmpleados.setBounds(215, 245, 216, 35);
		ABMEmpleados.add(btnListadoEmpleados);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3327786882089806661L;
	private JTable mantenimientosVehiculo;
	private JTextField txtPrecioServicioEmpSeg;
	private JTable table;
	private JTable tblListadoCarries;
	private JTextField txtPrecioCarrier;
}
