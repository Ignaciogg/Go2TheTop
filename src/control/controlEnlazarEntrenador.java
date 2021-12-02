package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

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
import model.Usuario;

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

			stage.setScene(new Scene(root));

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
				
				
				Entrenador e= new ficheros().leerEntrenador("src/files/entrenadores/" + tableEntrenadores.getSelectionModel().getSelectedItem().getUserId() + ".jsonl");
				controladmin.setUsuario(user,e);

				Stage stage = (Stage) botonVolver.getScene().getWindow();
				stage.setTitle("gO2theTop - Enlazar Usuarios");

				stage.setScene(new Scene(root));

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
		Gson gson = new Gson();
		Usuario user = null;
		ficheros files = new ficheros();
		try (BufferedReader br = new BufferedReader(new FileReader("src/files/login.jsonl"))) {

			String linea;
			while ((linea = br.readLine()) != null) {
				user = gson.fromJson(linea, Usuario.class);
				if (user.getUserType().equalsIgnoreCase("entrenador")) {
					if(user.getUserId().equalsIgnoreCase(dni)) {
						users.add(files.leerEntrenador("src/files/entrenadores/" + user.getUserId() + ".jsonl"));
					}
				}
			}

		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		return users;
	}
	
	public ObservableList<Entrenador> observableList() {
		ObservableList<Entrenador> users = FXCollections.observableArrayList();
		Gson gson = new Gson();
		Usuario user = null;
		ficheros files = new ficheros();
		try (BufferedReader br = new BufferedReader(new FileReader("src/files/login.jsonl"))) {

			String linea;
			while ((linea = br.readLine()) != null) {
				user = gson.fromJson(linea, Usuario.class);
				if (user.getUserType().equalsIgnoreCase("entrenador")) {
					users.add(files.leerEntrenador("src/files/entrenadores/" + user.getUserId() + ".jsonl"));
				}
			}

		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		return users;
	}

	public void setUsuario(Administrador u) {
		user = u;
		this.inicializarTabla();

	}
}
