package application;

import java.io.IOException;
import control.controlLogin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {


     @Override
        public void start(Stage primaryStage) throws Exception {
            try {
            	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewLogin.fxml"));
    			controlLogin control = new controlLogin();
    			loader.setController(control);
    			Parent root = loader.load();
    			primaryStage.setTitle("gO2theTop - Login");
    			primaryStage.setScene(new Scene(root));
    			primaryStage.show();

                }catch (IOException f) {

                    f.printStackTrace();
                }
        }

    public static void main(String[] args) {
        launch(args);
    }
}