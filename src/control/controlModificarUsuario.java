package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Administrador;
import model.Usuario;
import javafx.scene.control.TextField;
import application.ficheros;
import com.google.gson.Gson;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;


public class controlModificarUsuario {

	
	private Administrador user;
	
	@FXML
    private Button botonModify;

    @FXML
    private Button botonVolver;

    @FXML
    private TextField textMod;

    
	public static String dni ="";
    
    @FXML
    void modificarUser(ActionEvent event) {
    	
    	dni = textMod.getText();
    	System.out.println(dni);
    	controlModify modif=new controlModify();
    	modif.setVisible(true);
    	System.out.println(user.toString());
    	user.modificarUsuario(dni);
  
    	   	
    	
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewModify.fxml"));
    		controlModify controlModify = new controlModify();
    		loader.setController(controlModify);
    		Parent root = loader.load();
    		
    		controlModify.setUsuario(user);
    		
    		Stage stage = (Stage) botonModify.getScene().getWindow();
    		stage.setTitle("gO2theTop - Modificar Usuario");

    		stage.setScene(new Scene(root));

        }catch (Exception e) {
			e.printStackTrace();
		}
    	
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

