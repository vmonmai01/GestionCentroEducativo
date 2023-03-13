package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.ValoracionMateria;




public class ControladorValoracionMateria {
	
	/**
	 * 
	 * @param rs
	 * @return
	 */
	private static ValoracionMateria getEntidadFromResultSet(String sql) {
		
		ValoracionMateria valormateria = null;
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				valormateria = new ValoracionMateria();
				valormateria.setId(rs.getInt("id"));					
				valormateria.setId_Profesor(rs.getInt("idProfesor"));
				valormateria.setId_Estudiante(rs.getInt("idEstudiante"));
				valormateria.setId_Materia(rs.getInt("idMateria"));
				valormateria.setValoracion(rs.getFloat("valoracion"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return valormateria;
	}
	
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static ValoracionMateria findFirst () {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.valoracionmateria order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static ValoracionMateria findLast () {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.valoracionmateria order by id desc limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static ValoracionMateria findNext (int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.valoracionmateria where id > " + actualId + " order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static ValoracionMateria findPrevious (int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.valoracionmateria where id < " + actualId + " order by id desc limit 1");
	}

	

	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int modificar (ValoracionMateria vm) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update valoracionmateria set idProfesor = ?, idEstudiante = ?, idMateria = ?, valoracion = ? where id = ?");
		
			ps.setInt(1, vm.getId_Profesor());
			ps.setInt(2, vm.getId_Estudiante());
			ps.setInt(3, vm.getId_Materia());
			ps.setFloat(4, vm.getValoracion());
			ps.setInt(5, vm.getId());
			int rows = ps.executeUpdate();
			ps.close();
			conn.close();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int insertar (ValoracionMateria vm) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"insert into valoracionmateria (id, idProfesor, idEstudiante, idMateria, valoracion) "
					+ " values (?, ?, ?, ?, ?)");
		
			int siguienteIdValido = getSiguientIdValido();
			ps.setInt(1, siguienteIdValido);
			ps.setInt(2, vm.getId_Estudiante());
			ps.setInt(3, vm.getId_Materia());
			ps.setFloat(4, vm.getValoracion());
			ps.setInt(5, vm.getId());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return siguienteIdValido;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int eliminar (int id) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"delete from valoracionmateria where id = ?");
		
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			ps.close();
			conn.close();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 
	 * @return
	 */
	private static int getSiguientIdValido () {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"select max(id) from valoracionmateria");
		
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int maximoIdActual = rs.getInt(1);
				return maximoIdActual + 1;
			}
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
