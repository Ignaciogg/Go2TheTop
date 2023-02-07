package control;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.BBDD;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Usuario;

public class controlLogin implements Initializable{

	@FXML
	private TextField userNameText;

	@FXML
	private PasswordField passwordText;

	@FXML
	private Button botonLogin;

	@FXML
    private ImageView slide;

	int count = 0;

	@FXML
	void comprobarLogin(ActionEvent event) {
		BBDD bd = new BBDD();
		Usuario usuario = bd.IniciarSesion(userNameText.getText(), passwordText.getText());
		if(usuario!=null) {
			String rol = usuario.getUserType();
			switch (rol) {
			case "administrador":
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAdmin.fxml"));
					controlAdmin controlAdmin1 = new controlAdmin();
					loader.setController(controlAdmin1);
					Parent root = loader.load();
					controlAdmin1.setUsuario(usuario);

					Stage stage = (Stage) botonLogin.getScene().getWindow();

					stage.setTitle("gO2theTop - Administrador");

					stage.setScene(new Scene(root, botonLogin.getScene().getWidth(), botonLogin.getScene().getHeight()));

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

					Stage stage = (Stage) botonLogin.getScene().getWindow();

					stage.setTitle("gO2theTop - Deportista");
					stage.setScene(new Scene(root, botonLogin.getScene().getWidth(), botonLogin.getScene().getHeight()));

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

					controlEntren1.setUsuario(usuario);

					Stage stage = (Stage) botonLogin.getScene().getWindow();

					stage.setTitle("gO2theTop - Entrenador");

					stage.setScene(new Scene(root, botonLogin.getScene().getWidth(), botonLogin.getScene().getHeight()));

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

	public void slideShow(){

		ArrayList<Image> images = new ArrayList<Image>();
		images.add(new Image("/montana1.jpg"));
		images.add(new Image("/montana2.jpg"));
		images.add(new Image("/montana3.jpg"));
		images.add(new Image("/montana4.jpg"));
		images.add(new Image("/montana5.jpg"));

		Timeline timeline = new Timeline(new KeyFrame (Duration.seconds(4), event -> {
			slide.setImage(images.get(count));
			count ++;
			if(count == 5){
				count = 0;
			}
		}));

		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources){
		slideShow();
	}
}