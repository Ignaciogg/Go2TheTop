package control;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Entrenador;

public class controlFeedbackEntrenador {

	Entrenador mister;
	
    @FXML
    private Button botonEnviar;

    @FXML
    private Button botonVolver;

    @FXML
    private Text entren;

    @FXML
    private TextField textoFeedback;

    @FXML
    void enviar(ActionEvent event) {

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

			stage.setScene(new Scene(root));

        }catch (Exception e) {
			e.printStackTrace();
		}
    }

	public void setUsuario(Entrenador user) {
		mister = user;
		entren.setText("Chat de " + mister.getName());
		//cargarChat();
		//Aqui iria el cargar feedback
	}
}

