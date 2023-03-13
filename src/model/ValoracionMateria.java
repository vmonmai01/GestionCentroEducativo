package model;

public class ValoracionMateria {

	private int id;
	private int id_Profesor;
	private int id_Estudiante;
	private int id_Materia;
	private float valoracion;
	
	public ValoracionMateria() {
		super();
		
	}

	public ValoracionMateria(int id, int id_Profesor, int id_Estudiante, int id_Materia, float valoracion) {
		super();
		this.id = id;
		this.id_Profesor = id_Profesor;			
		this.id_Estudiante = id_Estudiante;
		this.id_Materia = id_Materia;
		this.valoracion = valoracion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_Profesor() {
		return id_Profesor;
	}

	public void setId_Profesor(int id_Profesor) {
		this.id_Profesor = id_Profesor;
	}

	public int getId_Estudiante() {
		return id_Estudiante;
	}

	public void setId_Estudiante(int id_Estudiante) {
		this.id_Estudiante = id_Estudiante;
	}

	public int getId_Materia() {
		return id_Materia;
	}

	public void setId_Materia(int id_Materia) {
		this.id_Materia = id_Materia;
	}

	public float getValoracion() {
		return valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}

	@Override
	public String toString() {
		return "ValoracionMateria [id=" + id + ", id_Profesor=" + id_Profesor + ", id_Estudiante=" + id_Estudiante
				+ ", id_Materia=" + id_Materia + ", valoracion=" + valoracion + "]";
	}

	
	
}
