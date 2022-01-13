package control;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Deportista;

public class controlFeedbackDeportista {

	Deportista dep;

    @FXML
    private Button botonVolver;

    @FXML
    private Text depor;

    @FXML
    private TextArea feedbackBox;

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

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

        }catch (Exception e) {
			e.printStackTrace();
		}
    }
	public void setUsuario(Deportista user) {
		dep = user;
		depor.setText("Feedback de " + dep.getName());
		//cargarChat();
		//aqui iria el cargar feedback

	}

}
