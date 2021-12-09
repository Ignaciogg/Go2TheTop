package control;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import model.Deportista;
import model.Entrenador;
import model.Usuario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import com.google.gson.Gson;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import application.ficheros;



public class controlEntrenador {

	private Entrenador user;

	@FXML
    private JFXTextField nombreUser;

	@FXML
    private Button botonCerrarSesion;

    @FXML
    private Button buttonVerEstadisticas;

    @FXML
    private Button buttonChatEntrenador;

    @FXML
    private JFXTextField nameEntrenador;

    @FXML
    private JFXTextField lastnameEntren;

    @FXML
    private JFXTextField emailEntren;

    @FXML
    private JFXTextField passEntren;

    @FXML
    private Button botonModificarDatos;


    @FXML
    void modificarDatos(ActionEvent event) {
    	
    }

    @FXML
    void cerrarSesion(ActionEvent event) {
		 try {

	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewLogin.fxml"));
				controlLogin controlLog = new controlLogin();
				loader.setController(controlLog);
				Parent root = loader.load();

				Stage stage = (Stage) botonCerrarSesion.getScene().getWindow();
				stage.setTitle("gO2theTop - Login");

				stage.setScene(new Scene(root));

	        }catch (Exception e) {
				e.printStackTrace();
			}

	    }
    
    @FXML
    void chatEntrenador(ActionEvent event) {

    }

    @FXML
    void verEstadisticas(ActionEvent event) {
    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEstadisticasEntren.fxml"));
			controlEstadisticasEntrenador controlEstadisticasEntren = new controlEstadisticasEntrenador();
			loader.setController(controlEstadisticasEntren);
			Parent root = loader.load();
			controlEstadisticasEntren.setUsuario(user);

			Stage stage = (Stage) buttonVerEstadisticas.getScene().getWindow();
			stage.setTitle("gO2theTop - VerEstadisticasEntrenador");	

			stage.setScene(new Scene(root));

        }catch (Exception e) {
			e.printStackTrace();
		}


    }


    
    public void setUsuario(Entrenador u) {
    	user = u; 
    	if(u.getGenre().equals("hombre")){
    		nombreUser.setText("Bienvenido " + u.getName());
    	}else if(u.getGenre().equals("mujer")) {
    		nombreUser.setText("Bienvenida " + u.getName());
    	}
    	
    	nameEntrenador.setText(user.getName());
    	lastnameEntren.setText(user.getLastnames());
    	emailEntren.setText(user.getEmail());
    	passEntren.setText(user.getPassword());

    }


}