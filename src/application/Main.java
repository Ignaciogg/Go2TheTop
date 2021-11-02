package application;

import control.controlLogin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public String usuarioLogin;

	@Override

	public void start(Stage primaryStage) {
	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewLogin.fxml"));
			controlLogin control = new controlLogin();
			loader.setController(control);
			Parent root = loader.load();
			primaryStage.setTitle("HearthHealth - Login");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
