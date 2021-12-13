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

public class controlChat {
	
	private Deportista user;
	
    @FXML
    private Text depor;
	
    @FXML
    private Button botonVolver;

    @FXML
    void volver(ActionEvent event) {
    	try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewDepor.fxml"));
			controlDeportista controlDepor = new controlDeportista();
			loader.setController(controlDepor);
			Parent root = loader.load();
			controlDepor.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Deportista");

			stage.setScene(new Scene(root));

		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public void setUsuario(Deportista u) {
    	user = u;
    	depor.setText("Chat de " + user.getName());

    }
}
