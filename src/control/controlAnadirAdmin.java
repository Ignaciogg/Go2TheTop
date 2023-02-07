package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXTextField;

import application.BBDD;
import model.Administrador;
import model.Usuario;

public class controlAnadirAdmin {

	private Administrador user;

    @FXML
    private Button botonVolver;

    @FXML
    private Button botonCrearAdmin;

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
    void crearAdmin(ActionEvent event) {

    	try{
    		System.out.println("CREAR ADMIN");

        	String dni = fieldUserId.getText();
        	String ema = fieldEmail.getText();
        	String pas = fieldPassword.getText();
        	String use = "administrador";
        	String nom = fieldNombre.getText();
        	String ape = fieldApellidos.getText();
        	String fec = fieldFecha.getText();
        	String gen = fieldGenero.getText();
        	Boolean act = true;

        	Usuario nuevo = new Usuario (dni, ema, pas, use, nom, ape, fec, gen, act);
        	BBDD bd = new BBDD();
        	bd.escribirPersona(nuevo);

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