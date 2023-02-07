package control;

import java.io.IOException;

import com.jfoenix.controls.JFXTextField;

import application.BBDD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Administrador;
import model.Deportista;
import model.Usuario;

public class controlAnadirDeportista {

	private Administrador user;

	@FXML
    private Button botonVolver;

    @FXML
    private Button botonCrearDepor;

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
    private JFXTextField fieldPeso;

    @FXML
    private JFXTextField fieldAltura;

    @FXML
    void crearDepor(ActionEvent event) {

    	try{
    		System.out.println("CREAR DEPORTISTA");

        	String dni = fieldUserId.getText();
        	String ema = fieldEmail.getText();
        	String pas = fieldPassword.getText();
        	String use = "deportista";
        	String nom = fieldNombre.getText();
        	String ape = fieldApellidos.getText();
        	String fec = fieldFecha.getText();
        	String gen = fieldGenero.getText();
        	// El peso y la altura los tenemos como floats así que los pillamos como string y los convertimos
        	String pes = fieldPeso.getText();
        	float pes2 = Float.parseFloat(pes);
        	String alt = fieldAltura.getText();
        	float alt2 = Float.parseFloat(alt);
        	Boolean act = true;

        	Deportista nuevo = new Deportista (dni, ema, pas, use, nom, ape, fec, gen, act);
        	nuevo.setPeso(pes2);
        	nuevo.setAltura(alt2);
        	BBDD bd = new BBDD();
        	bd.escribirPersona(nuevo);
        	bd.escribirDeportista(nuevo);
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