package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Estudiante;




public class ControladorEstudiante {
	/**
	 * 
	 * @return
	 */
	public static List<Estudiante> findAll() {
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from estudiante");
			
			while (rs.next()) {
				Estudiante e = new Estudiante();
				e.setId(rs.getInt("id"));
				e.setNombre(rs.getString("nombre"));
				e.setApellido1(rs.getString("apellido1"));
				e.setApellido2(rs.getString("apellido2"));
				e.setDni(rs.getString("dni"));
				e.setDireccion(rs.getString("direccion"));
				e.setEmail(rs.getString("email"));
				e.setTelefono(rs.getString("telefono"));
				estudiantes.add(e);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return estudiantes;
	}
	
	/**
	 * 
	 * @param rs
	 * @return
	 */
	private static Estudiante getEntidadFromResultSet(String sql) {
		
		Estudiante estudiante = null;
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				estudiante = new Estudiante();
				estudiante.setId(rs.getInt("id"));
				estudiante.setNombre(rs.getString("nombre"));
				estudiante.setApellido1(rs.getString("apellido1"));
				estudiante.setApellido2(rs.getString("apellido2"));
				estudiante.setDni(rs.getString("dni"));
				estudiante.setDireccion(rs.getString("direccion"));
				estudiante.setEmail(rs.getString("email"));
				estudiante.setTelefono(rs.getString("telefono"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return estudiante;
	}
	
	
//	Métodos para encontrar primero, anterior, siguiente y último 
	/**
	 * 
	 * @return			
	 * 				Primero
	 */
	public static Estudiante findFirst () {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.estudiante order by id limit 1");
	}

	/**
	 * 				Último
	 * @return
	 */
	public static Estudiante findLast () {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.estudiante order by id desc limit 1");
	}

	/**
	 * 				Siguiente
	 * @return
	 */
	public static Estudiante findNext (int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.estudiante where id > " + actualId + " order by id limit 1");
	}

	/**
	 * 				Anterior
	 * @return
	 */
	public static Estudiante findPrevious (int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.estudiante where id < " + actualId + " order by id desc limit 1");
	}
 
	
	
	/**
	 * 			
	 * @param c
	 * @return
	 */
	public static int modificar (Estudiante s) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update estudiante set nombre = ?, apellido1 = ?, apellido2 = ?, dni = ?, direccion = ?, email = ?, telefono = ? where id = ?");
		
			ps.setString(1, s.getNombre());
			ps.setString(2, s.getApellido1());
			ps.setString(3, s.getApellido2());
			ps.setString(4, s.getDni());
			ps.setString(5, s.getDireccion());
			ps.setString(6, s.getEmail());
			ps.setString(7, s.getTelefono());
			ps.setInt(8, s.getId());
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
	public static int insertar (Estudiante s) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"insert into estudiante (id, nombre, apellido1, apellido2, dni, direccion, email, telefono) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)");
		
			int siguienteIdValido = getSiguientIdValido();
			ps.setInt(1, siguienteIdValido);
			ps.setString(2, s.getNombre());
			ps.setString(3, s.getApellido1());
			ps.setString(4, s.getApellido2());
			ps.setString(5, s.getDni());
			ps.setString(6, s.getDireccion());
			ps.setString(7, s.getEmail());
			ps.setString(8, s.getTelefono());
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
					"delete from estudiante where id = ?");
		
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
					"select max(id) from estudiante");
		
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
