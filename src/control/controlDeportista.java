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
				Stage s_depor = (Stage) botonCerrarSesion.getScene().getWindow();
				s_depor.close();

	        }catch (Exception e) {
				e.printStackTrace();
			}

	    }

	public void setUsuario(Deportista u) {
    	user = u;
    	nombreUser.setText(u.getName());

    }
}
