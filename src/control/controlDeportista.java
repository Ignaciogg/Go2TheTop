package control;


import com.jfoenix.controls.JFXTextField;

import application.BBDD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Deportista;
import model.Entrenador;
import model.Usuario;

public class controlDeportista {

	private Deportista depor;
	
	private Entrenador entren;

    @FXML
    private JFXTextField nameDepor;

    @FXML
    private JFXTextField lastnameDepor;

    @FXML
    private JFXTextField emailDepor;

	@FXML
    private Text bienvenide;


    @FXML
    private Button botonEstadisticas;


    @FXML
    private Button botonChat;

    @FXML
    private Button botonCerrarSesion;


    @FXML
    void verEstadisticas(ActionEvent event) {
    	System.out.println("VER ESTADISTICAS");
    	try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEstadisticas.fxml"));
			controlEstadisticas controlEst = new controlEstadisticas();
			loader.setController(controlEst);
			Parent root = loader.load();
			controlEst.setUsuario(depor);
			Stage stageActual = (Stage) botonEstadisticas.getScene().getWindow();
			stageActual.setTitle("gO2theTop - Estadisticas");
			stageActual.setScene(new Scene(root, botonEstadisticas.getScene().getWidth(), botonEstadisticas.getScene().getHeight()));

        }catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void verChat(ActionEvent event) {
    	System.out.println("VER CHAT");
    	try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewChat.fxml"));
			controlChat controlXat = new controlChat();
			loader.setController(controlXat);
			Parent root = loader.load();
			
			entren = new BBDD().leerEntrenador(new BBDD().buscarUsuarioid(depor.getId_entrenador())); 
			controlXat.setUsuario(depor,entren);
			Stage stageActual = (Stage) botonChat.getScene().getWindow();
			stageActual.setTitle("gO2theTop - Chat");

			stageActual.setScene(new Scene(root, botonChat.getScene().getWidth(), botonChat.getScene().getHeight()));

        }catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void cerrarSesion(ActionEvent event) {
		 try {

	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewLogin.fxml"));
				controlLogin controlLog = new controlLogin();
				loader.setController(controlLog);
				Parent root = loader.load();

				Stage stage = (Stage) botonCerrarSesion.getScene().getWindow();
				stage.setTitle("gO2theTop - Login");

				stage.setScene(new Scene(root, botonCerrarSesion.getScene().getWidth(), botonCerrarSesion.getScene().getHeight()));

	        }catch (Exception e) {
				e.printStackTrace();
			}

	    }

	public void setUsuario(Usuario u) {
		BBDD bd = new BBDD();
		depor = bd.leerDeportista(u);
		System.out.println(depor.getGenre());
    	if(depor.getGenre().equals("Masculino")){
    		bienvenide.setText("Bienvenido " + depor.getName());
    	}else if(depor.getGenre().equals("Femenino")) {
    		bienvenide.setText("Bienvenida " + depor.getName());
    	}

    	nameDepor.setText(depor.getName());
    	lastnameDepor.setText(depor.getLastnames());
    	emailDepor.setText(depor.getEmail());

    }
}
