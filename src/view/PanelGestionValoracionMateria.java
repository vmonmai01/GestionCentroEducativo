package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;

import controller.ControladorEstudiante;
import controller.ControladorMateria;
import controller.ControladorProfesor;
import controller.ControladorValoracionMateria;
import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.ValoracionMateria;

public class PanelGestionValoracionMateria extends JPanel {
	private JTextField jtfId;
	private JTextField jtfValoracion;
	JComboBox<Profesor> jcbProfesor;
	JComboBox<Estudiante> jcbEstudiante;
	JComboBox<Materia> jcbMateria;
	JButton btnPrimero, btnAnterior, btnSiguiente, btnUltimo;
	
	/**
	 * Create the panel.
	 */
	public PanelGestionValoracionMateria() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{112, 72, 149, 0};
//		gridBagLayout.rowHeights = new int[]{77, 20, 20, 20, 20, 20, 20, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel Titulo = new JLabel("Gestión Valoracion Materia");
		Titulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_Titulo = new GridBagConstraints();
		gbc_Titulo.insets = new Insets(0, 0, 5, 0);
		gbc_Titulo.gridwidth = 2;
		gbc_Titulo.gridx = 1;
		gbc_Titulo.gridy = 1;
		add(Titulo, gbc_Titulo);
		
		JLabel lblNewLabel = new JLabel("ID :");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		jtfId.setEditable(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.gridx = 2;
		gbc_jtfId.gridy = 2;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID Profesor :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 3;
		add(jcbProfesor, gbc_comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("ID Estudiante :");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbEstudiante = new JComboBox<Estudiante>();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 4;
		add(jcbEstudiante, gbc_comboBox_1);
		
		JLabel lblNewLabel_3 = new JLabel("ID Materia :");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 5;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 2;
		gbc_comboBox_2.gridy = 5;
		add(jcbMateria, gbc_comboBox_2);
		
		JLabel lblNewLabel_4 = new JLabel("Valoración:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 6;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfValoracion = new JTextField();
		GridBagConstraints gbc_jtfValoracion = new GridBagConstraints();
		gbc_jtfValoracion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfValoracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfValoracion.gridx = 2;
		gbc_jtfValoracion.gridy = 6;
		add(jtfValoracion, gbc_jtfValoracion);
		jtfValoracion.setColumns(10);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 7;
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
				cargarEnPantalla(ControladorValoracionMateria.findPrevious(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnAnterior);

		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorValoracionMateria.findNext(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnSiguiente);

		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorValoracionMateria.findLast());
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

		cargarProfesorEnJCombo();
		cargarEstudianteEnJCombo();
		cargarMateriaEnJCombo();
		cargarPrimero();
	}
	
	
	/*
	 * Acciones
	 */

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
			if (ControladorValoracionMateria.eliminar(actualId) != 1) {
				JOptionPane.showMessageDialog(null, "Algo ha salido mal");
			} else {
				// Cargo otro registro en pantalla
				ValoracionMateria vmAnterior = ControladorValoracionMateria.findPrevious(actualId);
				if (vmAnterior != null) {
					cargarEnPantalla(vmAnterior);
				} else {
					ValoracionMateria vmSiguiente = ControladorValoracionMateria.findNext(actualId);
					if (vmSiguiente != null) {
						cargarEnPantalla(vmSiguiente);
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
		this.jtfValoracion.setText("0");
		if (this.jcbProfesor.getItemCount() > 0) {
			this.jcbProfesor.setSelectedIndex(0);
		}
		if (this.jcbEstudiante.getItemCount() > 0) {
			this.jcbEstudiante.setSelectedIndex(0);
		}
		if (this.jcbMateria.getItemCount() > 0) {
			this.jcbMateria.setSelectedIndex(0);
		}

	}

	/**
	 * 
	 */
	private void guardar() {
		ValoracionMateria vm = new ValoracionMateria();
		vm.setId(Integer.parseInt(this.jtfId.getText()));
		Profesor p = (Profesor) this.jcbProfesor.getSelectedItem();
		vm.setId_Profesor(p.getId());
		Estudiante e = (Estudiante) this.jcbEstudiante.getSelectedItem();
		vm.setId_Estudiante(e.getId());
		Materia m = (Materia) this.jcbMateria.getSelectedItem();
		vm.setId_Materia(m.getId());
		vm.setValoracion(Float.parseFloat(this.jtfValoracion.getText()));

		String strError = "No se ha podido guardar";
		if (vm.getId() == 0) {
			int nuevoIdInsertado = ControladorValoracionMateria.insertar(vm);
			if (nuevoIdInsertado < 1) {
				JOptionPane.showMessageDialog(null, strError);
			} else {
				this.jtfId.setText("" + nuevoIdInsertado);
			}
		} else {
			if (ControladorValoracionMateria.modificar(vm) != 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
		}

	}
	
	private void cargarProfesorEnJCombo() {
		List<Profesor> profesores = ControladorProfesor.findAll();
		for (Profesor profesor : profesores) {
			this.jcbProfesor.addItem(profesor);
		}
	}
	
	private void cargarEstudianteEnJCombo() {
		List<Estudiante> estudiantes = ControladorEstudiante.findAll();
		for (Estudiante estudiante : estudiantes) {
			this.jcbEstudiante.addItem(estudiante);
		}
	}
	
	private void cargarMateriaEnJCombo() {
		List<Materia> materias = ControladorMateria.findAll();
		for (Materia materia : materias) {
			this.jcbMateria.addItem(materia);
		}
	}

	/**
	 * 
	 */
	private void cargarPrimero() {
		cargarEnPantalla(ControladorValoracionMateria.findFirst());
	}

	/**
	 * 
	 * @param m
	 */
	private void cargarEnPantalla(ValoracionMateria vm) {
		if (vm != null) {
			this.jtfId.setText("" + vm.getId());
			this.jtfValoracion.setText("" + vm.getValoracion());
			for (int i = 0; i < this.jcbProfesor.getItemCount(); i++) {
				Profesor p = this.jcbProfesor.getItemAt(i);
				if (vm.getId_Profesor() == p.getId()) {
					this.jcbProfesor.setSelectedIndex(i);
				}
			}
			for (int i = 0; i < this.jcbEstudiante.getItemCount(); i++) {
				Estudiante e = this.jcbEstudiante.getItemAt(i);
				if (vm.getId_Estudiante() == e.getId()) {
					this.jcbEstudiante.setSelectedIndex(i);
				}
			}
			for (int i = 0; i < this.jcbMateria.getItemCount(); i++) {
				Materia m = this.jcbMateria.getItemAt(i);
				if (vm.getId_Materia() == m.getId()) {
					this.jcbMateria.setSelectedIndex(i);
				}
			}

		}

		// Habilito y deshabilito botones de navegación
		if (ControladorValoracionMateria.findPrevious(Integer.parseInt(jtfId.getText())) == null) {
			this.btnPrimero.setEnabled(false);
			this.btnAnterior.setEnabled(false);
		} else {
			this.btnPrimero.setEnabled(true);
			this.btnAnterior.setEnabled(true);
		}

		if (ControladorValoracionMateria.findNext(Integer.parseInt(jtfId.getText())) == null) {
			this.btnUltimo.setEnabled(false);
			this.btnSiguiente.setEnabled(false);
		} else {
			this.btnUltimo.setEnabled(true);
			this.btnSiguiente.setEnabled(true);
		}

	}

}
