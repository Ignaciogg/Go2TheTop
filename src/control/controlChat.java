package control;

import model.Deportista;
import model.Entrenador;
import model.Mensaje;

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
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class controlChat {

	private Deportista dep;
	
	private Entrenador entren;

	@FXML
    private Button botonVolver;

    @FXML
    private Text depor;

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
    	bd.escribirChat(new Mensaje (dep.getName(), textoMensaje.getText()), dep);
    	textoMensaje.clear();
    	cargarChat();
    }

    @FXML
    void volver(ActionEvent event) {
    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewDepor.fxml"));
        	System.out.println("vuelvo");
        	controlDeportista controlDep = new controlDeportista();
			loader.setController(controlDep);
			Parent root = loader.load();
			
			controlDep.setUsuario(dep);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Deportista");

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

        }catch (Exception e) {
			e.printStackTrace();
		}
    }

	public void setUsuario(Deportista user, Entrenador ent) {
		BBDD bd = new BBDD();
		dep = user;
		entren = ent;
		depor.setText("Chat de " + user.getName() + " y "+ entren.getName());
		cargarChat();
	}

}
