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
				Deportista deportista= new ficheros().leerDeportista("src/files/deportistas/" + tableDeportistas.getSelectionModel().getSelectedItem().getUserId() + ".jsonl");
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
		Gson gson = new Gson();
		Usuario user = null;
		ficheros files = new ficheros();
		try (BufferedReader br = new BufferedReader(new FileReader("src/files/login.jsonl"))) {

			String linea;
			while ((linea = br.readLine()) != null) {
				user = gson.fromJson(linea, Usuario.class);
				if (user.getUserType().equalsIgnoreCase("Deportista")) {
					if (user.getUserId().equalsIgnoreCase(dni)) {
						users.add(files.leerDeportista("src/files/Deportistas/" + user.getUserId() + ".jsonl"));
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

	public ObservableList<Deportista> observableList() {
		ObservableList<Deportista> users = FXCollections.observableArrayList();
		Gson gson = new Gson();
		Usuario user = null;
		ficheros files = new ficheros();
		try (BufferedReader br = new BufferedReader(new FileReader("src/files/login.jsonl"))) {

			String linea;
			while ((linea = br.readLine()) != null) {
				user = gson.fromJson(linea, Usuario.class);
				if (user.getUserType().equalsIgnoreCase("deportista")) {
					users.add(files.leerDeportista("src/files/deportistas/" + user.getUserId() + ".jsonl"));
				}
			}

		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		return users;
	}

	public void setUsuario(Administrador u, Entrenador e) {
		user = u;
		entrenador = e;
		this.inicializarTabla();

	}
}
