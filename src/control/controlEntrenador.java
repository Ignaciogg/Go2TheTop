package control;

import com.jfoenix.controls.JFXTextArea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Usuario;

public class controlEntrenador {

	private Usuario user;

	@FXML
    private Text nombreUser;

    @FXML
    private Button botonCerrarSesion;


    @FXML
    void cerrarSesion(ActionEvent event) {
		 try {

	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewLogin.fxml"));
				controlLogin controlLog = new controlLogin();
				loader.setController(controlLog);
				Parent root = loader.load();

				Stage stage = new Stage();
				stage.setTitle("gO2theTop - Login");

				stage.setScene(new Scene(root));
				stage.show();
				Stage s_entren = (Stage) botonCerrarSesion.getScene().getWindow();
				s_entren.close();

	        }catch (Exception e) {
				e.printStackTrace();
			}

	    }

	public void setUsuario(Usuario u) {
    	user = u;
    	nombreUser.setText(u.getUserId());

    }

}
