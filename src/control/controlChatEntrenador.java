package control;

import java.util.ArrayList;

import application.BBDD;
import application.ficheros;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Deportista;
import model.Entrenador;
import model.Mensaje;
import model.Usuario;

public class controlChatEntrenador {

	private Entrenador mister;
	private Deportista dep;

	@FXML
    private Button botonVolver;

    @FXML
    private Text entren;

    @FXML
    private TextArea chatBox;

    @FXML
    private TextField textoMensaje;

    @FXML
    private Button botonEnviar;


    void cargarChat(){

    	chatBox.clear();
    	BBDD bd = new BBDD();
    	ArrayList <Mensaje> miChat = bd.leerChat(dep);

    	for(int i = 0; i < miChat.size(); i++){
    		chatBox.appendText(miChat.get(i).getNombre() + " : " + miChat.get(i).getTexto());
    		chatBox.appendText("\n");
    	}

    }

    @FXML
    void enviar(ActionEvent event) {
    	BBDD bd = new BBDD();
    	bd.escribirChat(new Mensaje (mister.getName(), textoMensaje.getText()), dep);
    	textoMensaje.clear();
    	cargarChat();
    }

    /*@FXML
    void volver(ActionEvent event) {
    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEntren.fxml"));
        	controlEntrenador controlEntren = new controlEntrenador();
			loader.setController(controlEntren);
			Parent root = loader.load();

			Usuario user = new Usuario(mister.getUserId(),
					mister.getEmail(),
					mister.getPassword(),
					mister.getUserType(),
					mister.getName(),
					mister.getLastnames(),
					mister.getBirthday(),
					mister.getGenre(),
					mister.getActive());
			
			controlEntren.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Entrenador");

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

        }catch (Exception e) {
			e.printStackTrace();
		}
    }*/
    
    @FXML
    void volver(ActionEvent event) {

    	try {

    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEstadisticasEntren.fxml"));
			controlEstadisticasEntrenador controlEstadisticasEntren = new controlEstadisticasEntrenador();
			loader.setController(controlEstadisticasEntren);
			Parent root = loader.load();
			controlEstadisticasEntren.setUsuario(mister);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - VerEstadisticasEntrenador");

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));


        }catch (Exception e) {
			e.printStackTrace();
		}
    }

	public void setUsuario(Entrenador user, Deportista depor) {
		dep = depor;
		mister = user;
		String texto = "Chat de " + mister.getName() + " y " + dep.getName();
		System.out.println(texto);
		entren.setText(texto);
		cargarChat();
	}
}

