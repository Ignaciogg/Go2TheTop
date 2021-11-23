package control;

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

public class controlBorrarUsuario {

	private Administrador user;

    @FXML
    private Button botonVolver;

    @FXML
    private JFXTextField textfielUser;

    @FXML
    private Button botonBorrar;

    @FXML
    void borrarUser(ActionEvent event) {
    	String dni = textfielUser.getText();
    	System.out.println(dni);

    	System.out.println(user.toString());

    	user.borrarUsuario(dni);
    }

    @FXML
    void volverAdmin(ActionEvent event) {

    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAdmin.fxml"));
        	controlAdmin controlAdmin = new controlAdmin();
			loader.setController(controlAdmin);
			Parent root = loader.load();

			controlAdmin.setUsuario(user);

			Stage stage = new Stage();
			stage.setTitle("gO2theTop - Administrador");

			stage.setScene(new Scene(root));
			stage.show();
			Stage s_entren = (Stage) botonVolver.getScene().getWindow();
			s_entren.close();

        }catch (Exception e) {
			e.printStackTrace();
		}

    }

	public void setUser(Administrador user) {
		this.user = user;
	}


}