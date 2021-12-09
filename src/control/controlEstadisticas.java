package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Deportista;
import model.Entrenador;
import model.Sesion;
import model.Usuario;

public class controlEstadisticas {

	private Deportista user;

	ArrayList<Sesion> sesionArray;

	@FXML
    private Button botonVolver;

    @FXML
    private TableView<Sesion> tableSesiones;

    @FXML
    private TableColumn<Sesion, String> colFecha;

    @FXML
    private Button botonSeleccionar;

    @FXML
    void seleccionar(ActionEvent event) {

    }

    @FXML
    void volverDeportista(ActionEvent event) {

    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewDepor.fxml"));
        	controlDeportista controlDep = new controlDeportista();
			loader.setController(controlDep);
			Parent root = loader.load();

			controlDep.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Deportista");

			stage.setScene(new Scene(root));

        }catch (Exception e) {
			e.printStackTrace();
		}
    }

	private void inicializarTabla() {
		colFecha.setCellValueFactory(new PropertyValueFactory<Sesion, String>("fecha"));
		tableSesiones.setItems(observableList());
	}

	public ObservableList<Sesion> observableList() {
		ObservableList<Sesion> sesiones = FXCollections.observableArrayList();
		Gson gson = new Gson();
		Sesion sesion = null;
		ficheros files = new ficheros();
		try (BufferedReader br = new BufferedReader(new FileReader("src/files/sesiones/"+ user.getUserId() +".jsonl"))) {

			String linea;

			while ((linea = br.readLine()) != null) {
				sesion = gson.fromJson(linea, Sesion.class);
				sesiones.add(sesion.leerSesion("src/files/sesiones/"+ user.getUserId() +".jsonl"));
			}

		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		return sesiones;
	}

	public void setUsuario(Deportista u) {
		user = u;
		this.inicializarTabla();
	}

}
