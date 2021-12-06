package control;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Deportista;
import model.Usuario;

public class controlDeportista {

	private Deportista user;

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
    void verChat(ActionEvent event) {
    	System.out.println("VER CHAT");
    }

    @FXML
    void verDatos(ActionEvent event) {
    	System.out.println("VER DATOS");
    }

    @FXML
    void verEstadisticas(ActionEvent event) {
    	System.out.println("VER ESTAD");
    	try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEstadisticas.fxml"));
			controlEstadisticas controlEst = new controlEstadisticas();
			loader.setController(controlEst);
			Parent root = loader.load();
			controlEst.setUsuario(user);
			Stage stageActual = (Stage) botonEstadisticas.getScene().getWindow();
			stageActual.setTitle("gO2theTop - Estadisticas");

			stageActual.setScene(new Scene(root));

        }catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void verFeedback(ActionEvent event) {
    	System.out.println("VER FEEDBACK");
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

				stage.setScene(new Scene(root));

	        }catch (Exception e) {
				e.printStackTrace();
			}

	    }

	public void setUsuario(Deportista u) {
    	user = u;
    	bienvenide.setText("Bienvenide " + u.getName());
    }
}
