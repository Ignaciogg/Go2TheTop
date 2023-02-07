package control;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import com.google.gson.Gson;
import com.jfoenix.controls.JFXTextField;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Deportista;
import model.Entrenador;
import model.Sesion;
import model.Usuario;

public class controlEstadisticasEntrenador {

	private Entrenador user;

	@FXML
	private Button botonVolver;

	@FXML
	private Button buttonChatEntrenador;

	@FXML
	private Button buttonVerEstadisticas;

	@FXML
	private TableView<Deportista> tablaEntrenador;

	@FXML
	private TableColumn<Deportista, String> colDeportista;

	@FXML
	private TableColumn<Deportista, String> colApellido;

	@FXML
	private TableColumn<Deportista, String> colEmail;

	@FXML
	private TableColumn<Deportista, Float> colPeso;

	@FXML
	private TableColumn<Deportista, Float> colAltura;

    @FXML
    void volverEntrenador(ActionEvent event) {
    	try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEntren.fxml"));
			controlEntrenador controlEntren = new controlEntrenador();
			loader.setController(controlEntren);
			Parent root = loader.load();
			controlEntren.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Entrenador");

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

		} catch (Exception e) {
			e.printStackTrace();
		}
    }


    @FXML
    void chatEntrenador(ActionEvent event) {
    	System.out.println("VER CHAT");
    	if (tablaEntrenador.getSelectionModel().getSelectedItem() != null) {
			try {
		    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewChatEntrenador.fxml"));
				controlChatEntrenador controlChatEntren = new controlChatEntrenador();
				loader.setController(controlChatEntren);
				Parent root = loader.load();

				Deportista depor = tablaEntrenador.getSelectionModel().getSelectedItem();
				controlChatEntren.setUsuario(user,depor);

				Stage stageActual = (Stage) buttonChatEntrenador.getScene().getWindow();
				stageActual.setTitle("gO2theTop - Chat");

				stageActual.setScene(new Scene(root, buttonChatEntrenador.getScene().getWidth(), buttonChatEntrenador.getScene().getHeight()));

		    }catch (Exception e) {
				e.printStackTrace();
			}
    	}
    }

    @FXML
    void verEstadisticas(ActionEvent event) {
    	if (tablaEntrenador.getSelectionModel().getSelectedItem() != null) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEstadisticasEntren1.fxml"));
				controlEstadisticasEntrenador1 controlEstadisticasEntren = new controlEstadisticasEntrenador1();
				loader.setController(controlEstadisticasEntren);
				Parent root = loader.load();

				Deportista depor = tablaEntrenador.getSelectionModel().getSelectedItem();
				controlEstadisticasEntren.setUsuario(depor,user);

				Stage stage = (Stage) botonVolver.getScene().getWindow();
				stage.setTitle("gO2theTop - Seleccion de sesion");

				stage.setScene(new Scene(root, buttonVerEstadisticas.getScene().getWidth(), buttonVerEstadisticas.getScene().getHeight()));

			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    }

    public void inicializarTabla() {
		BBDD bd = new BBDD();
		colDeportista.setCellValueFactory(new PropertyValueFactory<Deportista, String>("Name"));
		colApellido.setCellValueFactory(new PropertyValueFactory<Deportista, String>("Lastnames"));
		colEmail.setCellValueFactory(new PropertyValueFactory<Deportista, String>("Email"));
		colPeso.setCellValueFactory(new PropertyValueFactory<Deportista, Float>("Peso"));
		colAltura.setCellValueFactory(new PropertyValueFactory<Deportista, Float>("Altura"));

		tablaEntrenador.setItems(bd.observableListEntrenador(user));
	}

    public void setUsuario(Entrenador u) {

    	user = u;
    	this.inicializarTabla();

    }

}