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

            	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEstadisticas2.fxml"));
            	controlEstadisticas2 controlE2 = new controlEstadisticas2();
    			loader.setController(controlE2);
    			Parent root = loader.load();

    			//Sesion e = new Sesion().leerSesion("src/files/sesiones/" + user.getUserId() + ".jsonl");
    			String fecha = tableSesiones.getSelectionModel().getSelectedItem().getFecha();
    			Sesion sesionFin = buscar_fecha(fecha);

    			controlE2.setUsuario(user,sesionFin);

    			Stage stage = (Stage) botonSeleccionar.getScene().getWindow();
    			stage.setTitle("gO2theTop - Estadisticas2");

    			stage.setScene(new Scene(root));

            }catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
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
		String linea="";
		Sesion sesion = null;
		ficheros files = new ficheros();

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

	public void setUsuario(Deportista u) {
		user = u;
		this.inicializarTabla();
	}

	public Sesion buscar_fecha(String fecha){
		Sesion sesion = null;
		Sesion sesionFinal=null;
		Gson gson = new Gson();
		String linea="";
		ficheros files = new ficheros();

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
