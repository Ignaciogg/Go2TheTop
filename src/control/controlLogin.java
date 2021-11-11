package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

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
import model.Administrador;
import model.Deportista;
import model.Entrenador;
import model.Usuario;

public class controlLogin {

	@FXML
	private TextField emailText;

	@FXML
	private PasswordField passwordText;

	@FXML
	private Button botonLogin;

	public static Usuario iniciarSesion(String email, String pass) {
		Gson gson = new Gson();
		int inicioSesion = 0;
		Usuario persona = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("../files/login.jsonl"));
			String linea;
			while ((linea = br.readLine()) != null && inicioSesion == 0) {
				persona = gson.fromJson(linea, Usuario.class);
				if (persona.getEmail().toLowerCase().equals(email)) {
					System.out.println(persona);
					if (persona.getPassword().equals(pass)) {
						String ruta = "";
						switch (persona.getUserType()) { // Seleccionar la ruta
						case "administrador":
							ruta = "../files/administradores/" + persona.getUserId() + ".jsonl";
							try {
								br = new BufferedReader(new FileReader(ruta));
								persona = gson.fromJson(br.readLine(), Administrador.class);
							} catch (IOException ex) {
								System.out.println(ex.getMessage());
							}
							break;

						case "entrenador":
							ruta = "../files/entrenador/" + persona.getUserId() + ".jsonl";
							try {
								br = new BufferedReader(new FileReader(ruta));
								persona = gson.fromJson(br.readLine(), Entrenador.class);
							} catch (IOException ex) {
								System.out.println(ex.getMessage());
							}
							break;

						case "deportista":
							ruta = "../ficheros/deportista/" + persona.getUserId() + ".jsonl";
							try {
								br = new BufferedReader(new FileReader(ruta));
								persona = gson.fromJson(br.readLine(), Deportista.class);
							} catch (IOException ex) {
								System.out.println(ex.getMessage());
							}
							break;
						}
						System.out.println("Has iniciado sesion correctamente");
						inicioSesion = 1;
					} else {
						System.out.println("la contrasena introducida no es correcta");
						inicioSesion = 2;
					}
				}
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		if (inicioSesion == 1) {
			return persona;
		}
		System.out.println("Los datos de inicio de sesion no son correctos");
		return null;
	}

	@FXML
	void comprobarLogin(ActionEvent event) {
		Usuario usuario = iniciarSesion(emailText.getText(), passwordText.getText());
		String rol = usuario.getUserType();

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

				controlEntren1.setUsuario(usuario);

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
		default:
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