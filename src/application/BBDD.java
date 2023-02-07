package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.DatosSensores;
import model.Deportista;
import model.Enlace;
import model.Entrenador;
import model.Mensaje;
import model.Sesion;
import model.Usuario;

public class BBDD {


	// Database credentials
    static final String USER = "pri_gO2theTop";
    static final String PASS = "go2thetop";

    Connection conn = null;

    public BBDD() {
    	try {
            //STEP 1: Register JDBC driver
        	Class.forName("org.mariadb.jdbc.Driver");

            //STEP 2: Open a connection
            conn = DriverManager.getConnection("jdbc:mariadb://195.235.211.197/prigO2theTop", USER, PASS);
            System.out.println("Conectado a la Base de Datos...");
        }catch(Exception e){
        	e.printStackTrace();
        }
	}

	public Connection getConn() {
		return conn;
	}

	public Usuario IniciarSesion(String email, String password) {
		Usuario persona = buscarUsuario(email);

		if (persona != null && persona.getPassword().equals(password)) {
			return persona;
		} else {
			return null;
		}
	}

	public Usuario buscarUsuario(String email) {
		Usuario personaBuscada = null;
		Statement stmt = null;
		String sql;
		try {
			sql = "SELECT * FROM Usuario WHERE email = '"+email+"'";
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery( sql );
			while ( rs.next() ) {
				personaBuscada = new Usuario(
						rs.getString("id_Usuario"),
						rs.getString("email"),
						rs.getString("pass"),
						rs.getString("userType"),
						rs.getString("nombre"),
						rs.getString("apellidos"),
						rs.getDate("fechaNacimiento").toString(),
						rs.getString("genero"),
						rs.getBoolean("activo")
				);
			}
			System.out.println(personaBuscada.toString());
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return personaBuscada;
	}

	public Usuario buscarUsuarioid(String dni) {
		Usuario personaBuscada = null;
		Statement stmt = null;
		String sql;
		try {
			sql = "SELECT * FROM Usuario WHERE id_Usuario = '"+dni+"'";
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery( sql );
			while ( rs.next() ) {
				personaBuscada = new Usuario(
						rs.getString("id_Usuario"),
						rs.getString("email"),
						rs.getString("pass"),
						rs.getString("userType"),
						rs.getString("nombre"),
						rs.getString("apellidos"),
						rs.getDate("fechaNacimiento").toString(),
						rs.getString("genero"),
						rs.getBoolean("activo")
				);
			}
			System.out.println(personaBuscada.toString());
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return personaBuscada;
	}

	public Entrenador leerEntrenador(Usuario persona) {
		Entrenador entren =  new Entrenador(
				persona.getUserId(),
				persona.getEmail(),
				persona.getPassword(),
				persona.getUserType(),
				persona.getName(),
				persona.getLastnames(),
				persona.getBirthday(),
				persona.getGenre(),
				persona.getActive());

		return entren;
	}

	public Deportista leerDeportista(Usuario persona) {
		Deportista deportista = new Deportista(
				persona.getUserId(),
				persona.getEmail(),
				persona.getPassword(),
				persona.getUserType(),
				persona.getName(),
				persona.getLastnames(),
				persona.getBirthday(),
				persona.getGenre(),
				persona.getActive());

		Statement stmt = null;
		String sql;
		try {
			sql = "SELECT * FROM Deportista WHERE id_Deportista = '"+persona.getUserId()+"'";
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery( sql );
			while ( rs.next() ) {
				deportista.setPeso(rs.getFloat("peso"));
				deportista.setAltura(rs.getFloat("altura"));
				deportista.setId_entrenador(rs.getString("id_Entrenador"));
			}
			System.out.println(deportista.toString());
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return deportista;
	}

	public void escribirPersona(Usuario persona) {
		Statement stmt = null;
		String sql;
		try {
			int activo=(persona.getActive())?1:0;
			sql = "insert INTO Usuario VALUES ("
					+"'"+persona.getUserId()+"',"
					+"'"+persona.getEmail()+"',"
					+"'"+persona.getPassword()+"',"
					+"'"+persona.getName()+"',"
					+"'"+persona.getLastnames()+"',"
					+"'"+persona.getUserType()+"',"
					+"'"+persona.getBirthday()+"',"
					+"'"+persona.getGenre()+"',"
					+"'"+activo+"'"
					+ ")" ;
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            if(persona.getUserType().equals("deportista")) {
    			escribirDeportista((Deportista) persona);
            }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void escribirDeportista(Deportista persona) {
		Statement stmt = null;
		String sql;
		try {
			sql = "insert INTO Deportista VALUES ("
					+"'"+persona.getUserId()+"',"
					+"'"+persona.getId_entrenador()+"',"
					+"'"+persona.getAltura()+"',"
					+"'"+persona.getPeso()+"'"
					+ ")" ;
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eliminarUsuario(String userId) {
		Statement stmt = null;
		String sql;
		try {
			sql = "UPDATE Usuario SET activo = 0 WHERE id_Usuario = '"+userId+"'";
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void modificarUsuario(Usuario user) {
		Statement stmt = null;
		String sql;
		try {
			sql = "UPDATE Usuario SET email ='"+user.getEmail()+"', pass ='"+user.getPassword()+"',"
					+ "nombre ='"+user.getName()+"', apellidos ='"+user.getLastnames()+"', userType = '"+user.getUserType()
					+ "', fechaNacimiento ='"+user.getBirthday()+"', genero ='"+user.getGenre()
					+ "' WHERE id_Usuario = '"+user.getUserId()+"'";
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void modificarDeportista(Deportista depor) {
		Usuario user = new Usuario(depor.getUserId(), depor.getEmail(), depor.getPassword(), depor.getUserType(), depor.getName(),
									depor.getLastnames(), depor.getBirthday(), depor.getGenre(), depor.getActive());
		modificarUsuario(user);
		Statement stmt = null;
		String sql;
		try {
			sql = "UPDATE Deportista SET altura ='"+depor.getAltura()+"', peso ='"+depor.getPeso()
					+ "' WHERE id_Deportista = '"+depor.getUserId()+"'";
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void asignarEntrenador(String id_deportista, String id_entrenador) {
		Statement stmt = null;
		String sql;
		try {
			sql = "UPDATE Deportista SET id_Entrenador = '"+id_entrenador+"' WHERE id_Deportista = '"+id_deportista+"'";
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ObservableList<Usuario> observableList(){

		ObservableList<Usuario> users = FXCollections.observableArrayList();
		Usuario user = null;
		Statement stmt = null;
		String sql;
		try {
			sql = "SELECT * FROM Usuario WHERE activo = 1";
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery( sql );
			while ( rs.next() ) {
				user = new Usuario(
					rs.getString("id_Usuario"),
					rs.getString("email"),
					rs.getString("pass"),
					rs.getString("userType"),
					rs.getString("nombre"),
					rs.getString("apellidos"),
					rs.getDate("fechaNacimiento").toString(),
					rs.getString("genero"),
					rs.getBoolean("activo")
				);
				users.add(user);
			}
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}


	public ObservableList<Deportista> observableListEntrenador(Entrenador entren){

		ObservableList<Deportista> users = FXCollections.observableArrayList();
		Deportista depor = null;
		Usuario user = null;
		Statement stmt = null;
		String sql;
		String sql2;
		try {
			sql2 = "SELECT id_Deportista FROM Deportista WHERE id_Entrenador = '" + entren.getUserId() + "'";
			System.out.println("sql: "+sql2);
			stmt = conn.createStatement();
			ResultSet rs2 = stmt.executeQuery(sql2);

			while ( rs2.next() ) {
				sql = "SELECT * FROM Usuario WHERE id_Usuario = '" + rs2.getString("id_Deportista") + "'";
	            System.out.println("sql Select: "+sql);
				ResultSet rs = stmt.executeQuery( sql );
				while ( rs.next() ) {
					user = new Usuario(
							rs.getString("id_Usuario"),
							rs.getString("email"),
							rs.getString("pass"),
							rs.getString("userType"),
							rs.getString("nombre"),
							rs.getString("apellidos"),
							rs.getDate("fechaNacimiento").toString(),
							rs.getString("genero"),
							rs.getBoolean("activo")
					);

					depor = leerDeportista(user);
					users.add(depor);
				}
				rs.close();
			}
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}


	public ObservableList<Sesion> verSesiones(String idDepor){
		ObservableList<Sesion> sesiones = FXCollections.observableArrayList();
		Sesion sesion = null;
		Statement stmt = null;
		String sql;
		try {
			sql = "SELECT * FROM Sesion WHERE id_Deportista = '"+idDepor+"'";
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery( sql );
			while ( rs.next() ) {
				sesion = new Sesion(
					rs.getInt("id_Sesion"),
					rs.getString("id_Deportista"),
					rs.getString("fecha_hora_inicio").substring(0, rs.getString("fecha_hora_inicio").length()-2),
					rs.getString("feedback")
				);
				sesiones.add(sesion);
			}
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sesiones;
	}

	public Sesion leerSesion(String id_Sesion) {

		Sesion sesion = null;
		Statement stmt = null;
		String sql;
		try {
			sql = "SELECT * FROM Sesion WHERE id_Sesion = '"+id_Sesion+"'";
			System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery( sql );
			while ( rs.next() ) {
				sesion = new Sesion(
						rs.getInt("id_Sesion"),
						rs.getString("id_Deportista"),
						rs.getString("fecha_hora_inicio").substring(0, rs.getString("fecha_hora_inicio").length()-2),
						rs.getString("feedback")
				);
			}
			System.out.println(sesion.toString());
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sesion;
	}

	public void escribirEnlace(Enlace en) {
		Statement stmt = null;
		String sql;
		try {
			sql = "UPDATE Deportista SET id_Entrenador = '"+en.getEntrenadorID()+"' WHERE id_Deportista = '"+en.getDeportistaID()+"'";
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Mensaje> leerChat(Deportista depor) {
		ArrayList<Mensaje> lista = new ArrayList<Mensaje>();
		Statement stmt = null;
		String sql;
		try {
			sql = "SELECT * FROM Chat WHERE id_Deportista = '"+ depor.getUserId() +"'";
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery( sql );
			Mensaje men;
			while ( rs.next() ) {
				men = new Mensaje(rs.getString("emisor"), rs.getString("contenido"));
				lista.add(men);
			}
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void escribirChat(Mensaje mensaje, Deportista depor) {
		Statement stmt = null;
		String sql;
		java.util.Date date=new java.util.Date();
		java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
		try {
			sql = "insert INTO Chat VALUES ("
					+"'"+depor.getUserId()+"',"
					+"'"+mensaje.getNombre() +"',"
					+"'"+mensaje.getTexto()+"',"
					+"'"+ sqlTime +"'"
					+ ")" ;
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void escribirFeedback(Sesion sesion, String fb){
		Statement stmt = null;
		String sql;
		try {
			sql = "UPDATE Sesion SET feedback = '"+fb+"' WHERE id_Sesion = '"+sesion.getId_Sesion()+"'";
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Sesion buscarFecha(String fecha){
		Sesion sesionBuscada = null;
		Statement stmt = null;
		String sql;
		try {
			sql = "SELECT * FROM Sesion WHERE fecha_hora_inicio = '"+fecha+"'";
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery( sql );
			while ( rs.next() ) {
				sesionBuscada = new Sesion(
					rs.getInt("id_Sesion"),
					rs.getString("id_Deportista"),
					rs.getTimestamp("fecha_hora_inicio").toString(),
					rs.getString("feedback")
				);
			}
			System.out.println(sesionBuscada.toString());
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sesionBuscada;
	}

	public ArrayList <DatosSensores>  obtenerDato (int idSesion, String tipo){
		ArrayList <DatosSensores> listaDatos = new ArrayList <DatosSensores>();
		int dat=0, ses=0;
		String sens=null, fech=null, val=null;
		DatosSensores dato;

		Statement stmt = null;
		String sql;
		try {
			sql = "SELECT * FROM Datos_Sensores WHERE id_Sesion = '"+idSesion+"' AND sensor = '"+tipo+"'";
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery( sql );
			while ( rs.next() ) {
				dat = rs.getInt("id_Dato");
				ses = rs.getInt("id_Sesion");
				sens = rs.getString("sensor");
				fech = rs.getString("fecha_hora_lectura").substring(0, rs.getString("fecha_hora_lectura").length()-2);
				val = rs.getString("valor");

				dato = new DatosSensores(dat,ses,sens,fech,val);
				listaDatos.add(dato);

			}
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listaDatos;
	}

	//Método para medir distancias entre dos puntos
	public static float CoordenadaasToMetros(float lat1, float lng1, float lat2, float lng2) {
		double earthRadius = 6371; //kilometers
		double dLat = Math.toRadians(lat2-lat1);
		double dLng = Math.toRadians(lng2-lng1);
		double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(dLng/2) * Math.sin(dLng/2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		float dist = (float) (earthRadius * c); return dist;
	}

}
