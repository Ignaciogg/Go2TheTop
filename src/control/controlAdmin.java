package control;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfoenix.controls.JFXTextArea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Administrador;
import model.Deportista;
import model.Entrenador;
import model.Usuario;

public class controlAdmin {

	private Usuario user;

    @FXML
    private Text nombrePantalla;

    @FXML
    private Button btn_Logout;

    @FXML
    private JFXTextArea miLista;


    @FXML
    void cerrarSesionA(ActionEvent event) {
		 try {

	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewLogin.fxml"));
				controlLogin controlLog = new controlLogin();
				loader.setController(controlLog);
				Parent root = loader.load();

				Stage stage = new Stage();
				stage.setTitle("HearthHealth - Login");

				stage.setScene(new Scene(root));
				stage.show();
				Stage s_cuidador = (Stage) btn_Logout.getScene().getWindow();
				s_cuidador.close();

	        }catch (Exception e) {
				e.printStackTrace();
			}

	    }

	public void setUsuario(Usuario u) {
    	user = u;
    	nombrePantalla.setText(u.getUserId());

    	ObjectMapper mapper = new ObjectMapper();
    	ObjectMapper mapper2 = new ObjectMapper();
    	ObjectMapper mapper3 = new ObjectMapper();

	       try {

	    	   Deportista[] deportistas = mapper.readValue(new File("deportistas.json"), Deportista[].class);

	    	   for (int i = 0; i<=deportistas.length-1; i++)
	    		   miLista.appendText(deportistas[i].getUserId() + " -  " + deportistas[i].getEmail() + ", " + deportistas[i].getUserType() + "\r\n");


	    	   Entrenador[] entrenadores = mapper2.readValue(new File("entrenadores.json"), Entrenador[].class);

	    	   for (int i = 0; i<=entrenadores.length-1; i++)
	    		   miLista.appendText(entrenadores[i].getUserId() + " -  " + entrenadores[i].getEmail() + ", " + entrenadores[i].getUserType() +"\r\n");


	    	   Administrador[] admins = mapper3.readValue(new File("admins.json"), Administrador[].class);

	    	   for (int i = 0; i<=admins.length-1; i++)
	    		   miLista.appendText(admins[i].getUserId() + " -  " + admins[i].getEmail() + ", " + admins[i].getUserType() +"\r\n");



		  } catch (IOException e) {
			e.printStackTrace();
		  }


    }
}
