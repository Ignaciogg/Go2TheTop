package control;

import javafx.scene.control.ToggleButton;
import com.gluonhq.charm.glisten.control.ToggleButtonGroup;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Administrador;

public class controlAnadirUsuario {

	private Administrador user;

    @FXML
    private Button botonVolver;

    @FXML
    private ToggleButtonGroup toggleGroup;

    @FXML
    private ToggleButton toggleAdmin;

    @FXML
    private ToggleButton toggleEntrenador;

    @FXML
    private ToggleButton toggleDeportista;

    @FXML
    void selectAdmin(ActionEvent event) {

    	System.out.println("Admin seleccionado");

    }

    @FXML
    void selectDeportista(ActionEvent event) {

    	System.out.println("Deportista seleccionado");

    }

    @FXML
    void selectEntrentrenador(ActionEvent event) {

    	System.out.println("Entrenador seleccionado");

    }

    @FXML
    void volverAdmin(ActionEvent event) {

    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAdmin.fxml"));
        	controlAdmin controlAdmin = new controlAdmin();
			loader.setController(controlAdmin);
			Parent root = loader.load();

			controlAdmin.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Administrador");

			stage.setScene(new Scene(root));

        }catch (Exception e) {
			e.printStackTrace();
		}

    }

}