package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.JButton;
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

import controller.ControladorCurso;
import controller.ControladorEstudiante;
import controller.ControladorValoracionMateria;
import model.Curso;
import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.ValoracionMateria;

public class PanelGestionCurso extends JPanel {
	private JTextField jtfId;
	private JTextField jtfDescripcion;
	JButton btnPrimero, btnAnterior, btnSiguiente, btnUltimo;
	List<Curso> cursos = ControladorCurso.findAll();
	

	/**
	 * Create the panel.
	 */
	public PanelGestionCurso() {

		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{0, 0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel titulo = new JLabel("Gestión de Curso");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_titulo = new GridBagConstraints();
		gbc_titulo.insets = new Insets(0, 0, 5, 0);
		gbc_titulo.gridwidth = 0;
		gbc_titulo.gridx = 0;
		gbc_titulo.gridy = 0;
		add(titulo, gbc_titulo);

		JLabel lblNewLabel = new JLabel("ID :");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Descripción :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 2;
		add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 0;
		gbc_panel.gridwidth = 0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cargarEnPantalla(ControladorCurso.findFirst());
			}
		});
		panel.add(btnPrimero);

		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cargarEnPantalla(ControladorCurso.findPrevious(Integer.parseInt(jtfId.getText())));

			}
		});
		panel.add(btnAnterior);

		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cargarEnPantalla(ControladorCurso.findNext(Integer.parseInt(jtfId.getText())));

			}
		});
		panel.add(btnSiguiente);

		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cargarEnPantalla(ControladorCurso.findLast());

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
		cargarEnPantalla(ControladorCurso.findFirst());

	}

	/*
	 * Acciones
	 */

	private void cargarEnPantalla(Curso c) {
		if (c != null) {
			this.jtfId.setText("" + c.getId());
			this.jtfDescripcion.setText("" + c.getDescripcion());

		}
		// Habilito y deshabilito botones de navegación
		if (ControladorCurso.findPrevious(Integer.parseInt(jtfId.getText())) == null) {
			this.btnPrimero.setEnabled(false);
			this.btnAnterior.setEnabled(false);
		} else {
			this.btnPrimero.setEnabled(true);
			this.btnAnterior.setEnabled(true);
		}

		if (ControladorCurso.findNext(Integer.parseInt(jtfId.getText())) == null) {
			this.btnUltimo.setEnabled(false);
			this.btnSiguiente.setEnabled(false);
		} else {
			this.btnUltimo.setEnabled(true);
			this.btnSiguiente.setEnabled(true);
		}

	}



	/*
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
			if (ControladorCurso.eliminar(actualId) != 1) {
				JOptionPane.showMessageDialog(null, "Algo ha salido mal");
			} else {
				// Cargo otro registro en pantalla
				Curso vmAnterior = ControladorCurso.findPrevious(actualId);
				if (vmAnterior != null) {
					cargarEnPantalla(vmAnterior);
				} else {
					Curso vmSiguiente = ControladorCurso.findNext(actualId);
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
	private void guardar() {
		Curso c = new Curso();
		c.setId(Integer.parseInt(this.jtfId.getText()));
		c.setDescripcion(this.jtfDescripcion.getText());
		String strError = "No se ha podido guardar";
		if (c.getId() == 0) {
			int nuevoIdInsertado = ControladorCurso.insertar(c);
			if (nuevoIdInsertado < 1) {
				JOptionPane.showMessageDialog(null, strError);
			} else {
				this.jtfId.setText("" + nuevoIdInsertado);
			}
		} else {
			if (ControladorCurso.modificar(c) != 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
		}

	}

	/*
	 * 		
	 */
	private void limpiarDatos() {
		this.jtfId.setText("0");
		this.jtfDescripcion.setText("");

	}

	/**
	 * 
	 */
	private void cargarPrimero() {
		cargarEnPantalla(ControladorCurso.findFirst());
	}

}
