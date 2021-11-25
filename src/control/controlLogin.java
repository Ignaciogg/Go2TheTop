package control;

import application.ficheros;
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

public class controlLogin {

	@FXML
	private TextField userNameText;

	@FXML
	private PasswordField passwordText;

	@FXML
	private Button botonLogin;

	@FXML
	void comprobarLogin(ActionEvent event) {
		ficheros files = new ficheros();
		Usuario usuario = files.IniciarSesion(userNameText.getText(), passwordText.getText());
		if(usuario!=null) {
			String rol = usuario.getUserType();
			switch (rol) {
			case "administrador":
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAdmin.fxml"));
					controlAdmin controlAdmin1 = new controlAdmin();
					loader.setController(controlAdmin1);

					Parent root = loader.load();

					controlAdmin1.setUsuario(files.leerAdministrador("src/files/administradores/" + usuario.getUserId() + ".jsonl"));

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

					controlDepor1.setUsuario(files.leerDeportista("src/files/deportistas/" + usuario.getUserId() + ".jsonl"));

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
			case "entrenador":
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEntren.fxml"));
					controlEntrenador controlEntren1 = new controlEntrenador();
					loader.setController(controlEntren1);
					Parent root = loader.load();

					controlEntren1.setUsuario(files.leerEntrenador("src/files/entrenadores/" + usuario.getUserId() + ".jsonl"));

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
		}else {
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