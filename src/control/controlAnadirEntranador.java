package control;

import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Administrador;
import model.Entrenador;
import model.Usuario;

public class controlAnadirEntranador {

	private Administrador user;

    @FXML
    private Button botonVolver;

    @FXML
    private Button botonCrearEntrenador;

    @FXML
    private ToggleButton toggleAdmin;

    @FXML
    private ToggleGroup seleccionUsuario;

    @FXML
    private ToggleButton toggleEntrenador;

    @FXML
    private ToggleButton toggleDeportista;

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
        	String use = "administrador";
        	String nom = fieldNombre.getText();
        	String ape = fieldApellidos.getText();
        	String fec = fieldFecha.getText();
        	String gen = fieldGenero.getText();
        	Boolean act = true;

        	Usuario nuevo = new Usuario (dni, ema, pas, use, nom, ape, fec, gen, act);
        	Entrenador nuevo2 = new Entrenador (dni, ema, pas, use, nom, ape, fec, gen, act);

    	}catch (Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void selectAdmin(ActionEvent event) {

    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAnadirAdmin.fxml"));
        	controlAnadirAdmin controlAnadirAdmin = new controlAnadirAdmin();
			loader.setController(controlAnadirAdmin);
			Parent root = loader.load();

			controlAnadirAdmin.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Crear Usuario");

			stage.setScene(new Scene(root));

        }catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void selectDeportista(ActionEvent event) {

    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAnadirDeportista.fxml"));
        	controlAnadirDeportista controlAnadirDeportista = new controlAnadirDeportista();
			loader.setController(controlAnadirDeportista);
			Parent root = loader.load();

			controlAnadirDeportista.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Crear Usuario");

			stage.setScene(new Scene(root));

        }catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void selectEntrenador(ActionEvent event) {
    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAnadirEntrenador.fxml"));
        	controlAnadirAdmin controlAnadirAdmin = new controlAnadirAdmin();
			loader.setController(controlAnadirAdmin);
			Parent root = loader.load();

			controlAnadirAdmin.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Crear Usuario");

			stage.setScene(new Scene(root));

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

			stage.setScene(new Scene(root));

        }catch (Exception e) {
			e.printStackTrace();
		}
    }

	public void setUsuario(Administrador u) {
		user = u;
	}

}