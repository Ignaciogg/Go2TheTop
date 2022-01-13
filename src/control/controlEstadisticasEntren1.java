package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

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

public class controlEstadisticasEntren1 {

	private Deportista user;

	private Entrenador mister;

	private Sesion sesion;

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
    	if(tableSesiones.getSelectionModel().getSelectedItem() != null) {
    		try {

            	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEstadisticasEntren2.fxml"));
            	controlEstadisticasEntrenador2 controlEntren2 = new controlEstadisticasEntrenador2();
    			loader.setController(controlEntren2);
    			Parent root = loader.load();

    			String fecha = tableSesiones.getSelectionModel().getSelectedItem().getFecha();
    			Sesion sesionFin = buscar_fecha(fecha);

    			controlEntren2.setUsuario(user,sesionFin,mister);
    			System.out.println("Sesión seleccionada: " + user.getUserId() + " - " + fecha);

    			Stage stage = (Stage) botonSeleccionar.getScene().getWindow();
    			stage.setTitle("gO2theTop - EstadisticasEntren1");

    			stage.setScene(new Scene(root, botonSeleccionar.getScene().getWidth(), botonSeleccionar.getScene().getHeight()));

            }catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    }

    @FXML
    void volverEntrenador(ActionEvent event) {

    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEstadisticasEntren.fxml.fxml"));
        	controlEntrenador controlEntren = new controlEntrenador();
			loader.setController(controlEntren);
			Parent root = loader.load();

			controlEntren.setUsuario(mister);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Entrenador");

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

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
		String linea="";
		Sesion sesion = null;

		try (BufferedReader br = new BufferedReader(new FileReader("src/files/sesiones/"+ user.getUserId() +".jsonl"))) {

			while ((linea = br.readLine()) != null) {
				sesion = gson.fromJson(linea, Sesion.class);
				sesiones.add(sesion);
			}


		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		return sesiones;
	}

	public void setUsuario(Deportista u, Entrenador mis) {
		user = u;
		mister=mis;
		this.inicializarTabla();
	}

	public Sesion buscar_fecha(String fecha){
		Sesion sesion = null;
		Sesion sesionFinal=null;
		Gson gson = new Gson();
		String linea="";

		try (BufferedReader br = new BufferedReader(new FileReader("src/files/sesiones/"+ user.getUserId() +".jsonl"))) {

			while ((linea = br.readLine()) != null) {
				sesion = gson.fromJson(linea, Sesion.class);
				if(sesion.getFecha().equals(fecha)){
					sesionFinal = sesion;
				}
			}


		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return sesionFinal;

	}

}
