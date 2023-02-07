package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.google.gson.Gson;

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
import model.Deportista;
import model.Entrenador;
import model.Deportista;
import model.Usuario;

public class controlEnlazarDeportista {

	private Administrador user;

	private Entrenador entrenador;

	@FXML
	private Button botonVolver;

	@FXML
	private Button botonSeleccionar;

	@FXML
	private Button botonBuscar;

	@FXML
	private TextField textfielUser;

	@FXML
	private TableView<Deportista> tableDeportistas;

	@FXML
	private TableColumn<Deportista, String> colDeporDNI;

	@FXML
	private TableColumn<Deportista, String> colDeporNombre;

	@FXML
	private TableColumn<Deportista, String> colDeporApellidos;

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
		if (tableDeportistas.getSelectionModel().getSelectedItem() != null) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEnlazarConfirmacion.fxml"));
				controlEnlazarConfirmacion controladmin = new controlEnlazarConfirmacion();
				loader.setController(controladmin);
				Parent root = loader.load();

				BBDD bd = new BBDD();

				Usuario usu1 = bd.buscarUsuarioid(tableDeportistas.getSelectionModel().getSelectedItem().getUserId());
				Deportista deportista = bd.leerDeportista(usu1);
				//Deportista deportista= new ficheros().leerDeportista("src/files/deportistas/" + tableDeportistas.getSelectionModel().getSelectedItem().getUserId() + ".jsonl");
				controladmin.setUsuario(user, entrenador, deportista);

				Stage stage = (Stage) botonVolver.getScene().getWindow();
				stage.setTitle("gO2theTop - Admin");

				stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@FXML
	void buscar(ActionEvent event) {
		colDeporDNI.setCellValueFactory(new PropertyValueFactory<Deportista, String>("userId"));
		colDeporNombre.setCellValueFactory(new PropertyValueFactory<Deportista, String>("name"));
		colDeporApellidos.setCellValueFactory(new PropertyValueFactory<Deportista, String>("lastnames"));
		tableDeportistas.setItems(observableList(textfielUser.getText()));
	}

	private void inicializarTabla() {

		colDeporDNI.setCellValueFactory(new PropertyValueFactory<Deportista, String>("userId"));
		colDeporNombre.setCellValueFactory(new PropertyValueFactory<Deportista, String>("name"));
		colDeporApellidos.setCellValueFactory(new PropertyValueFactory<Deportista, String>("lastnames"));
		tableDeportistas.setItems(observableList());

	}

	public ObservableList<Deportista> observableList(String dni) {
		ObservableList<Deportista> users = FXCollections.observableArrayList();

		BBDD bd = new BBDD();
		Connection conn = bd.getConn();
		Deportista user = null;
		Statement stmt = null;
		String sql;
		try {
			sql = "SELECT * FROM Usuario WHERE userType = 'deportista' AND id_Usuario = '"+dni+"'";
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery( sql );
			while ( rs.next() ) {
				user = new Deportista(
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

	public ObservableList<Deportista> observableList() {

		ObservableList<Deportista> users = FXCollections.observableArrayList();
		BBDD bd = new BBDD();
		Connection conn = bd.getConn();
		Deportista user = null;
		Statement stmt = null;
		String sql;
		try {
			sql = "SELECT * FROM Usuario WHERE userType = 'deportista'";
            System.out.println("sql Select: "+sql);
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery( sql );
			while ( rs.next() ) {
				user = new Deportista(
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

	public void setUsuario(Administrador u, Entrenador e) {
		user = u;
		entrenador = e;
		this.inicializarTabla();

	}
}
