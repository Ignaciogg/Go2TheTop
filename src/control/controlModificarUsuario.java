package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Administrador;
import javafx.scene.control.TextField;

public class controlModificarUsuario {
	
	private Administrador user;

    @FXML
    private Button botonVolver;

    @FXML
    private Button botonModify;
    
    @FXML
    private TextField textMod;
    
    @FXML
    void modificarUser(ActionEvent event) {

    	String dni = textMod.getText();
    	System.out.println(dni);

    	System.out.println(user.toString());

    	user.modificarUsuario(dni);
    	
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
    
    public void setUser(Administrador user) {
		this.user = user;
	}

}

