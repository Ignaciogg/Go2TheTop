package control;

import java.io.File;
import java.io.IOException;

import application.ficheros;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Administrador;
import model.Usuario;

public class controlAdmin {

	private Usuario user;

    @FXML
    private Text nombreUser;

    @FXML
    private Button botonCerrarSesion;
    
	@FXML
	private TextField userEmailText;


    @FXML
    void cerrarSesion(ActionEvent event) {
		 try {

	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewLogin.fxml"));
				controlLogin controlLog = new controlLogin();
				loader.setController(controlLog);
				Parent root = loader.load();

				Stage stage = new Stage();
				stage.setTitle("gO2theTop - Login");

				stage.setScene(new Scene(root));
				stage.show();
				Stage s_admin = (Stage) botonCerrarSesion.getScene().getWindow();
				s_admin.close();

	        }catch (Exception e) {
				e.printStackTrace();
			}

	    }

    @FXML
    void borrarUsusario(ActionEvent event) {
		ficheros files = new ficheros();
    	Administrador admin = files.leerAdministrador("src/files/administradores/" + user.getUserId() + ".jsonl");
    	
    	admin.borrarUsuario(userEmailText.getText());
    	/*
    	try {

	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewLogin.fxml"));
				controlLogin controlLog = new controlLogin();
				loader.setController(controlLog);
				Parent root = loader.load();

				Stage stage = new Stage();
				stage.setTitle("gO2theTop - Login");

				stage.setScene(new Scene(root));
				stage.show();
				Stage s_admin = (Stage) botonCerrarSesion.getScene().getWindow();
				s_admin.close();

	        }catch (Exception e) {
				e.printStackTrace();
			}
			*/
	    }
	public void setUsuario(Usuario u) {
    	user = u;
    }
}