package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import application.BBDD;
import application.ficheros;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Administrador;
import model.Entrenador;

public class controlEnlazarEntrenador {

	private Administrador user;

	@FXML
	private Button botonVolver;

	@FXML
	private Button botonSeleccionar;

	@FXML
	private Button botonBuscar;

	@FXML
	private TextField textfielUser;

	@FXML
	private TableView<Entrenador> tableEntrenadores;

	@FXML
	private TableColumn<Entrenador, String> colEntrenDNI;

	@FXML
	private TableColumn<Entrenador, String> colEntrenNombre;

	@FXML
	private TableColumn<Entrenador, String> colEntrenApellidos;

	@FXML
	void volverAdmin(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAdmin.fxml"));
			controlAdmin controladmin = new controlAdmin();
			loader.setController(controladmin);
			Parent root = loader.load();
			controladmin.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Admin");

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void seleccionar(ActionEvent event) {

		if(tableEntrenadores.getSelectionModel().getSelectedItem() != null) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEnlazarDeportistas.fxml"));
				controlEnlazarDeportista controladmin = new controlEnlazarDeportista();
				loader.setController(controladmin);
				Parent root = loader.load();

				Entrenador e = new BBDD().leerEntrenador(new BBDD().buscarUsuarioid(tableEntrenadores.getSelectionModel().getSelectedItem().getUserId()));
				//Entrenador e= new ficheros().leerEntrenador("src/files/entrenadores/" + tableEntrenadores.getSelectionModel().getSelectedItem().getUserId() + ".jsonl");
				controladmin.setUsuario(user,e);

				Stage stage = (Stage) botonVolver.getScene().getWindow();
				stage.setTitle("gO2theTop - Enlazar Usuarios");

				stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	void buscar(ActionEvent event) {
		colEntrenDNI.setCellValueFactory(new PropertyValueFactory<Entrenador, String>("userId"));
		colEntrenNombre.setCellValueFactory(new PropertyValueFactory<Entrenador, String>("name"));
		colEntrenApellidos.setCellValueFactory(new PropertyValueFactory<Entrenador, String>("lastnames"));
		tableEntrenadores.setItems(observableList(textfielUser.getText()));
	}

	private void inicializarTabla() {

		colEntrenDNI.setCellValueFactory(new PropertyValueFactory<Entrenador, String>("userId"));
		colEntrenNombre.setCellValueFactory(new PropertyValueFactory<Entrenador, String>("name"));
		colEntrenApellidos.setCellValueFactory(new PropertyValueFactory<Entrenador, String>("lastnames"));
		tableEntrenadores.setItems(observableList());

	}

	public ObservableList<Entrenador> observableList(String dni) {
		ObservableList<Entrenador> users = FXCollections.observableArrayList();
		BBDD bd = new BBDD();
		Connection conn = bd.getConn();
		Entrenador user = null;
		Statement stmt = null;
		String sql;
		try {
			sql = "SELECT * FROM Usuario WHERE userType = 'entrenador' id_Usuario = '"+dni+"'";
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery( sql );
			while ( rs.next() ) {
				user = new Entrenador(
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

	public ObservableList<Entrenador> observableList() {
		
		ObservableList<Entrenador> users = FXCollections.observableArrayList();
		BBDD bd = new BBDD();
		Connection conn = bd.getConn();
		Entrenador user = null;
		Statement stmt = null;
		String sql;
		try {
			sql = "SELECT * FROM Usuario WHERE userType = 'entrenador'";
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery( sql );
			while ( rs.next() ) {
				user = new Entrenador(
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

	public void setUsuario(Administrador u) {
		user = u;
		this.inicializarTabla();

	}
}
