package control;

import com.jfoenix.controls.JFXTextField;

import application.ficheros;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    	user.borrarUsuario(textfielUser.getText());
    }

    @FXML
    void volverAdmin(ActionEvent event) {

    }

	public void setUser(Administrador user) {
		this.user = user;
	}

    
}