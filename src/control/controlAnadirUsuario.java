package control;

import com.jfoenix.controls.JFXRadioButton;

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
    private JFXRadioButton radioAdmin;

    @FXML
    private JFXRadioButton radioDepor;

    @FXML
    private JFXRadioButton radioEntren;

    @FXML
    void selectAdmin(ActionEvent event) {

    	System.out.println("Admin seleccionado");

    }

    @FXML
    void selectDepor(ActionEvent event) {

    	System.out.println("Deportista seleccionado");

    }

    @FXML
    void selectEntren(ActionEvent event) {

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