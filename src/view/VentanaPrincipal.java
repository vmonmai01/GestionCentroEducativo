package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;



public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	public VentanaPrincipal() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(600, 450));
		JTabbedPane tabedPane = new JTabbedPane();

//		Adicion de Paneles
//		tabedPane.add("Cursos", new PanelGestionCurso());
		tabedPane.add("Curso" , new PanelGestionCurso());
		tabedPane.add("Estudiante", new PanelGestionEstudiante());
		tabedPane.add("Profesor", new PanelGestionProfesor());
		tabedPane.add("Materia", new PanelGestionMateria());
		tabedPane.add("Valoracion Materia" ,new PanelGestionValoracionMateria());
		
		this.setMinimumSize(new Dimension(800, 600));

		this.setContentPane(tabedPane);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		VentanaPrincipal v = new VentanaPrincipal();
		v.setVisible(true);
	}
}
