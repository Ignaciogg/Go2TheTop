package control;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Administrador;
import model.Entrenador;
import model.Usuario;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.text.Text;

public class controlEntrenador {

	private Entrenador user;

	@FXML
    private Text bienvenide;

	@FXML
    private Button botonCerrarSesion;

    @FXML
    private Button botonSeleccionar;

    @FXML
    private JFXTextField nameEntrenador;

    @FXML
    private JFXTextField lastnameEntren;

    @FXML
    private JFXTextField emailEntren;

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

    @FXML
    void seleccionar(ActionEvent event) {
    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEstadisticasEntren.fxml"));
			controlEstadisticasEntrenador controlEstadisticasEntren = new controlEstadisticasEntrenador();
			loader.setController(controlEstadisticasEntren);
			Parent root = loader.load();
			controlEstadisticasEntren.setUsuario(user);

			Stage stage = (Stage) botonSeleccionar.getScene().getWindow();
			stage.setTitle("gO2theTop - Seleccionar Deportista");

			stage.setScene(new Scene(root, botonSeleccionar.getScene().getWidth(), botonSeleccionar.getScene().getHeight()));

        }catch (Exception e) {
			e.printStackTrace();
		}

    }

    public void setUsuario(Usuario u) {
    	user = new Entrenador(
				u.getUserId(),
				u.getEmail(),
				u.getPassword(),
				u.getUserType(),
				u.getName(),
				u.getLastnames(),
				u.getBirthday(),
				u.getGenre(),
				u.getActive());

    	System.out.println(user.getName());
    	if(u.getGenre().equals("Masculino")){
    		bienvenide.setText("Bienvenido " + user.getName());
    	}else if(u.getGenre().equals("Femenino")) {
    		bienvenide.setText("Bienvenida " + user.getName());
    	}

    	nameEntrenador.setText(user.getName());
    	lastnameEntren.setText(user.getLastnames());
    	emailEntren.setText(user.getEmail());


    }


}