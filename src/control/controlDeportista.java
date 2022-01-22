package control;


import com.jfoenix.controls.JFXTextField;

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

public class controlDeportista {

	private Deportista user;

   @FXML
    private ImageView fotoDepor;

    @FXML
    private JFXTextField nameDepor;

    @FXML
    private JFXTextField lastnameDepor;

    @FXML
    private JFXTextField emailDepor;

	@FXML
    private Text bienvenide;

	@FXML
    private Button botonDatos;

    @FXML
    private Button botonEstadisticas;

    @FXML
    private Button botonFeedback;

    @FXML
    private Button botonChat;

    @FXML
    private Button botonCerrarSesion;


    @FXML
    void verDatos(ActionEvent event) {
    	System.out.println("VER DATOS");
    }

    @FXML
    void verEstadisticas(ActionEvent event) {
    	System.out.println("VER ESTADISTICAS");
    	try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEstadisticas.fxml"));
			controlEstadisticas controlEst = new controlEstadisticas();
			loader.setController(controlEst);
			Parent root = loader.load();
			controlEst.setUsuario(user);
			Stage stageActual = (Stage) botonEstadisticas.getScene().getWindow();
			stageActual.setTitle("gO2theTop - Estadisticas");

			stageActual.setScene(new Scene(root, botonEstadisticas.getScene().getWidth(), botonEstadisticas.getScene().getHeight()));

        }catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void verFeedback(ActionEvent event) {
    	System.out.println("VER FEEDBACK");
    }

    @FXML
    void verChat(ActionEvent event) {
    	System.out.println("VER CHAT");
    	try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewChat.fxml"));
			controlChat controlXat = new controlChat();
			loader.setController(controlXat);
			Parent root = loader.load();
			controlXat.setUsuario(user);
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

	public void setUsuario(Deportista u) {
		user = u;
    	if(u.getGenre().equals("hombre") || u.getGenre().equals("masculino")){
    		bienvenide.setText("Bienvenido " + u.getName());
    	}else if(u.getGenre().equals("mujer") || u.getGenre().equals("femenino")) {
    		bienvenide.setText("Bienvenida " + u.getName());
    	}

    	nameDepor.setText(user.getName());
    	lastnameDepor.setText(user.getLastnames());
    	emailDepor.setText(user.getEmail());

    	Image image = new Image ("file:recursos/"+ user.getUserId() +".jpg");

    	fotoDepor.setImage(image);
    }
}
