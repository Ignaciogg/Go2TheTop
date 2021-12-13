package control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import application.ficheros;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import model.ChatDeportista;
import model.Deportista;
import model.Entrenador;
import model.Usuario;


public class controlChat {
	
	private Deportista user;
	private Entrenador entrenador;
	
	
	@FXML
    private Button botonEnviar;

    @FXML
    private Button botonVolver;

    @FXML
    private Text depor;

    @FXML
    private TextField textoMensaje;

    @FXML
    void volver(ActionEvent event) {
    	try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewDepor.fxml"));
			controlDeportista controlDepor = new controlDeportista();
			loader.setController(controlDepor);
			Parent root = loader.load();
			controlDepor.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Deportista");

			stage.setScene(new Scene(root));

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    

	
    @FXML
    void enviar(ActionEvent event) {
    	try {
    		System.out.println("CHAT XD");
			ficheros files = new ficheros();
			ChatDeportista chat=new ChatDeportista(user.getUserId()
					/*, entrenador.getUserId()*/,textoMensaje.getText());
			files.escribirChat(chat);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public void setUsuario(Deportista u) {
    	user = u;
    	depor.setText("Chat de " + user.getName());

    }
}
