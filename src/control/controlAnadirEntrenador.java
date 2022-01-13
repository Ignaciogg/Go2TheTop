package control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.jfoenix.controls.JFXTextField;

import application.ficheros;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Administrador;
import model.Entrenador;
import model.Usuario;

public class controlAnadirEntrenador {

	private Administrador user;

    @FXML
    private Button botonVolver;

    @FXML
    private Button botonCrearEntrenador;

    @FXML
    private JFXTextField fieldUserId;

    @FXML
    private JFXTextField fieldEmail;

    @FXML
    private JFXTextField fieldPassword;

    @FXML
    private JFXTextField fieldNombre;

    @FXML
    private JFXTextField fieldApellidos;

    @FXML
    private JFXTextField fieldFecha;

    @FXML
    private JFXTextField fieldGenero;

    @FXML
    void crearEntrenador(ActionEvent event) {

    	try{
    		System.out.println("CREAR ENTRENADOR");

        	String dni = fieldUserId.getText();
        	String ema = fieldEmail.getText();
        	String pas = fieldPassword.getText();
        	String use = "entrenador";
        	String nom = fieldNombre.getText();
        	String ape = fieldApellidos.getText();
        	String fec = fieldFecha.getText();
        	String gen = fieldGenero.getText();
        	Boolean act = true;

        	Usuario nuevo = new Usuario (dni, ema, pas, use);
        	Entrenador nuevo2 = new Entrenador (dni, ema, pas, use, nom, ape, fec, gen, act);

        	System.out.println("El usuario que se va a anadir es: " + nuevo2.toString());
        	String ruta = "src/files/entrenadores/" + dni + ".jsonl";
        	
        	ficheros fichero = new ficheros();
        	fichero.escribirLogin(nuevo);
        	fichero.escribirPersona(nuevo2, ruta);

            volverAdmin(event);

    	}catch (Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void volverAdmin(ActionEvent event) {
    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAnadirUsuario.fxml"));
        	controlAnadirUsuario controlAnadirUsuario = new controlAnadirUsuario();
			loader.setController(controlAnadirUsuario);
			Parent root = loader.load();

			controlAnadirUsuario.setUser(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Crear Usuario");

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

        }catch (Exception e) {
			e.printStackTrace();
		}
    }

	public void setUsuario(Administrador u) {
		user = u;
	}

}