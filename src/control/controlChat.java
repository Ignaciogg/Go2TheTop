package control;

import model.Deportista;
import model.Mensaje;

import java.util.ArrayList;

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

public class controlChat {

	Deportista dep;

	@FXML
    private Button botonVolver;

    @FXML
    private Text depor;

    @FXML
    private TextField chatBox;

    @FXML
    private TextField textoMensaje;

    @FXML
    private Button botonEnviar;

    void cargarChat(){
    	ficheros fichero = new ficheros();
    	String ruta = "src/files/chats/"+ dep.getUserId() +".jsonl";
    	ArrayList <Mensaje> miChat = fichero.leerChat(ruta);

    	for(int i = 0; i < miChat.size(); i++){
    		chatBox.appendText(miChat.get(i).getNombre() + " : " + miChat.get(i).getTexto() + "\n");
    	}

    }

    @FXML
    void enviar(ActionEvent event) {

    	ficheros fichero = new ficheros();
    	fichero.escribirChat(new Mensaje (dep.getName(), textoMensaje.getText()), ("src/files/chats/"+ dep.getUserId() +".jsonl"));
    	cargarChat();
    }

    @FXML
    void volver(ActionEvent event) {
    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewDepor.fxml"));
        	controlDeportista controlDep = new controlDeportista();
			loader.setController(controlDep);
			Parent root = loader.load();

			controlDep.setUsuario(dep);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Deportista");

			stage.setScene(new Scene(root));

        }catch (Exception e) {
			e.printStackTrace();
		}
    }

	public void setUsuario(Deportista user) {
		dep = user;
		depor.setText("Chat de " + dep.getName());
		cargarChat();
	}

}
