package control;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Entrenador;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class controlEntrenador {

	private Entrenador user;

	@FXML
    private JFXTextField nombreUser;

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
    private ImageView fotoMister;

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
			stage.setTitle("gO2theTop - VerEstadisticasEntrenador");

			stage.setScene(new Scene(root, botonSeleccionar.getScene().getWidth(), botonSeleccionar.getScene().getHeight()));

        }catch (Exception e) {
			e.printStackTrace();
		}

    }

    public void setUsuario(Entrenador u) {
    	user = u;
    	if(u.getGenre().equals("hombre") || u.getGenre().equals("masculino")){
    		nombreUser.setText("Bienvenido " + u.getName());
    	}else if(u.getGenre().equals("mujer") || u.getGenre().equals("femenino")) {
    		nombreUser.setText("Bienvenida " + u.getName());
    	}

    	nameEntrenador.setText(user.getName());
    	lastnameEntren.setText(user.getLastnames());
    	emailEntren.setText(user.getEmail());

    	Image image = new Image ("file:recursos/"+ user.getUserId() +".jpg");

    	fotoMister.setImage(image);

    }


}