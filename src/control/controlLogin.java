package control;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Usuario;
import model.UsuarioGson;

public class controlLogin {

    @FXML
    private TextField emailText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button botonLogin;

    @FXML
    void comprobarLogin(ActionEvent event) {
    	Usuario usuario = gsonUsuario.comprobarUsuario(getEmailText(), getPasswordText());
		String rol;


		if (usuario != null) {
			rol = usuario.getUserType();

			switch (rol) {

			case "admin":

				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAdmin.fxml"));
					controlAdmin controlAdmin1 = new controlAdmin();
					loader.setController(controlAdmin1);
					Parent root = loader.load();

					controlAdmin1.setUsuario(usuario);

					Stage stage = new Stage();

					stage.setTitle("gO2theTop - Administrador");

					stage.setScene(new Scene(root));
					stage.show();
					Stage s_login = (Stage) botonLogin.getScene().getWindow();
					s_login.hide();

				} catch (Exception e) {
					e.printStackTrace();
				}

				break;

			case "deportista":

				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewDepor.fxml"));
					controlDeportista controlDepor1 = new controlDeportista();
					loader.setController(controlDepor1);
					Parent root = loader.load();

					controlDepor1.setUsuario(usuario);

					Stage stage = new Stage();

					stage.setTitle("gO2theTop - Deportista");

					stage.setScene(new Scene(root));
					stage.show();
					Stage s_login = (Stage) botonLogin.getScene().getWindow();
					s_login.hide();

				} catch (Exception e) {
					e.printStackTrace();
				}

				break;

			case "Entrenador":

				try {

					FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEntrenador.fxml"));
					controlEntrenador controlEntren1 = new controlEntrenador();
					loader.setController(controlEntren1);
					Parent root = loader.load();

					controlEntren1.cargarEntrenador(usuario.getUserId());

					Stage stage = new Stage();

					stage.setTitle("gO2theTop - Seleccion");

					stage.setScene(new Scene(root));
					stage.show();


					Stage s_login = (Stage) botonLogin.getScene().getWindow();
					s_login.hide();

				} catch (Exception e) {
					e.printStackTrace();
				}

				break;

			}

		}

		else {

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/errorLogin.fxml"));

				Parent root = loader.load();

				Stage stage2 = new Stage();
				stage2.setTitle("gO2theTop - Error");
				stage2.setScene(new Scene(root));
				stage2.show();
				PauseTransition pause = new PauseTransition(Duration.seconds(2));
				pause.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						System.out.println("End");
						stage2.close();
					}
				});

				pause.play();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }
}