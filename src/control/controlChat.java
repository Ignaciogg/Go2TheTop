package control;

import model.Deportista;
import model.Mensaje;
import application.ficheros;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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

    @FXML
    void enviar(ActionEvent event) {

    	ficheros fichero = new ficheros();
    	//fichero.escribirChat(new Mensaje (dep.getName(), textoMensaje.getText()), "src/files/chats/"+ dep getUserId() +  +".jsonl");


    }

    @FXML
    void volver(ActionEvent event) {

    }

	public void setUsuario(Deportista user) {
		dep = user;
	}

}
