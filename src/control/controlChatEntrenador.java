package control;

import java.util.ArrayList;

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
import model.Entrenador;
import model.Mensaje;

public class controlChatEntrenador {

	Entrenador mister;

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
    	ficheros fichero = new ficheros();
    	String ruta = "src/files/chats/"+ mister.getUserId() +".jsonl";
    	ArrayList <Mensaje> miChat = fichero.leerChat(ruta);

    	for(int i = 0; i < miChat.size(); i++){
    		chatBox.appendText(miChat.get(i).getNombre() + " : " + miChat.get(i).getTexto());
    		chatBox.appendText("\n");
    	}

    }

    @FXML
    void enviar(ActionEvent event) {

    	ficheros fichero = new ficheros();
    	fichero.escribirChat(new Mensaje (mister.getName(), textoMensaje.getText()), ("src/files/chats/"+ mister.getUserId() +".jsonl"));
    	cargarChat();
    }

    @FXML
    void volver(ActionEvent event) {
    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEntren.fxml"));
        	controlEntrenador controlEntren = new controlEntrenador();
			loader.setController(controlEntren);
			Parent root = loader.load();

			controlEntren.setUsuario(mister);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Entrenador");

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

        }catch (Exception e) {
			e.printStackTrace();
		}
    }

	public void setUsuario(Entrenador user) {
		mister = user;
		entren.setText("Chat de " + mister.getName());
		cargarChat();
	}
}

