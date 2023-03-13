package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

import controller.ControladorProfesor;

import model.Profesor;

import java.awt.FlowLayout;
import javax.swing.JButton;

public class PanelGestionProfesor extends JPanel {
	
	private JTextField jtfNombre;
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JTextField jtfDni;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	private JTextField jtfId;
	JButton btnPrimero, btnAnterior, btnSiguiente, btnUltimo;

	/**
	 * Create the panel.
	 */
	public PanelGestionProfesor() {
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{0, 0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblPanelGestinEstudiante = new JLabel("Panel Gestión Profesor");
		lblPanelGestinEstudiante.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblPanelGestinEstudiante = new GridBagConstraints();
		gbc_lblPanelGestinEstudiante.insets = new Insets(0, 0, 5, 0);
		gbc_lblPanelGestinEstudiante.gridwidth = 0;
		gbc_lblPanelGestinEstudiante.gridx = 0;
		gbc_lblPanelGestinEstudiante.gridy = 0;
		add(lblPanelGestinEstudiante, gbc_lblPanelGestinEstudiante);

		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		jtfId.setColumns(10);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 0;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.gridwidth = 0;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Apellido1:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfApellido1 = new JTextField();
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.gridwidth = 0;
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 0);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 1;
		gbc_jtfApellido1.gridy = 3;
		add(jtfApellido1, gbc_jtfApellido1);
		jtfApellido1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Apellido 2:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfApellido2 = new JTextField();
		jtfApellido2.setColumns(10);
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.gridwidth = 0;
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 0);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 4;
		add(jtfApellido2, gbc_jtfApellido2);

		JLabel lblNewLabel_4 = new JLabel("DNI:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfDni = new JTextField();
		jtfDni.setColumns(10);
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.gridwidth = 0;
		gbc_jtfDni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 5;
		add(jtfDni, gbc_jtfDni);

		JLabel lblNewLabel_5 = new JLabel("Dirección:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfDireccion = new JTextField();
		jtfDireccion.setColumns(10);
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.gridwidth = 0;
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 6;
		add(jtfDireccion, gbc_jtfDireccion);

		JLabel lblNewLabel_6 = new JLabel("@ e-mail:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtfEmail = new JTextField();
		jtfEmail.setColumns(10);
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.gridwidth = 0;
		gbc_jtfEmail.anchor = GridBagConstraints.EAST;
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 7;
		add(jtfEmail, gbc_jtfEmail);

		JLabel lblNewLabel_7 = new JLabel("Teléfono");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 8;
		add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtfTelefono = new JTextField();
		jtfTelefono.setColumns(10);
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.gridwidth = 0;
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 8;
		add(jtfTelefono, gbc_jtfTelefono);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 9;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPrimero();
			}
		});
		panel.add(btnPrimero);

		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorProfesor.findPrevious(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnAnterior);

		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorProfesor.findNext(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnSiguiente);

		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorProfesor.findLast());
			}
		});
		panel.add(btnUltimo);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarDatos();
			}
		});
		panel.add(btnNuevo);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		panel.add(btnEliminar);

//		Método para mostrar predeterminado
		cargarPrimero();
	}

	/**
	 * 
	 */
	private void eliminar() {
		String posiblesRespuestas[] = { "Sí", "No" };
		// En esta opción se utiliza un showOptionDialog en el que personalizo el icono
		// mostrado
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Realmente desea eliminar?", "Eliminación",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, posiblesRespuestas,
				posiblesRespuestas[1]);
		if (opcionElegida == 0) {
			int actualId = Integer.parseInt(this.jtfId.getText());
			if (ControladorProfesor.eliminar(actualId) != 1) {
				JOptionPane.showMessageDialog(null, "Algo ha salido mal");
			} else {
				// Cargo otro registro en pantalla
				Profesor pAnterior = ControladorProfesor.findPrevious(actualId);
				if (pAnterior != null) {
					cargarEnPantalla(pAnterior);
				} else {
					Profesor pSiguiente = ControladorProfesor.findNext(actualId);
					if (pSiguiente != null) {
						cargarEnPantalla(pSiguiente);
					} else { // No quedan registros, has eliminado el único
						limpiarDatos();
					}
				}
			}
		}

	}

	/**
	 * 
	 */
	private void limpiarDatos() {
		this.jtfId.setText("0");
		this.jtfNombre.setText("");
		this.jtfApellido1.setText("");
		this.jtfApellido2.setText("");
		this.jtfDni.setText("");
		this.jtfDireccion.setText("");
		this.jtfEmail.setText("");
		this.jtfTelefono.setText("");
	}

	/**
	 * 
	 */
	private void guardar() {
		Profesor p = new Profesor();
		p.setId(Integer.parseInt(this.jtfId.getText()));
		p.setNombre(this.jtfNombre.getText());
		p.setApellido1(this.jtfApellido1.getText());
		p.setApellido2(this.jtfApellido2.getText());
		p.setDni(this.jtfDni.getText());
		p.setDireccion(this.jtfDireccion.getText());
		p.setEmail(this.jtfEmail.getText());
		p.setTelefono(this.jtfTelefono.getText());

		String strError = "No se ha podido guardar";
		if (p.getId() == 0) {
			int nuevoIdInsertado = ControladorProfesor.insertar(p);
			if (nuevoIdInsertado < 1) {
				JOptionPane.showMessageDialog(null, strError);
			} else {
				this.jtfId.setText("" + nuevoIdInsertado);
			}
		} else {
			if (ControladorProfesor.modificar(p) != 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
		}

	}

	/**
	 * 
	 */
	private void cargarPrimero() {
		cargarEnPantalla(ControladorProfesor.findFirst());
	}

	/**
	 * 
	 * @param m
	 */
	private void cargarEnPantalla(Profesor p) {
		if (p != null) {
			this.jtfId.setText("" + p.getId());
			this.jtfNombre.setText(p.getNombre());
			this.jtfApellido1.setText(p.getApellido1());
			this.jtfApellido2.setText(p.getApellido2());
			this.jtfDni.setText(p.getDni());
			this.jtfDireccion.setText(p.getDireccion());
			this.jtfEmail.setText(p.getEmail());
			this.jtfTelefono.setText(p.getTelefono());

		}

		// Habilito y deshabilito botones de navegación
		if (ControladorProfesor.findPrevious(Integer.parseInt(jtfId.getText())) == null) {
			this.btnPrimero.setEnabled(false);
			this.btnAnterior.setEnabled(false);
		} else {
			this.btnPrimero.setEnabled(true);
			this.btnAnterior.setEnabled(true);
		}

		if (ControladorProfesor.findNext(Integer.parseInt(jtfId.getText())) == null) {
			this.btnUltimo.setEnabled(false);
			this.btnSiguiente.setEnabled(false);
		} else {
			this.btnUltimo.setEnabled(true);
			this.btnSiguiente.setEnabled(true);
		}

	}

}
