package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Administrador;

public class controlAnadirUsuario {

	private Administrador user;

    @FXML
    private Button botonVolver;

    @FXML
    private Button botonAdmin;

    @FXML
    private Button botonEntrenador;

    @FXML
    private Button botonDeportista;

    @FXML
    void selectAdmin(ActionEvent event) {

    	System.out.println("Admin seleccionado");
    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAnadirAdmin.fxml"));
        	controlAnadirAdmin controlAnadirAdmin = new controlAnadirAdmin();
			loader.setController(controlAnadirAdmin);
			Parent root = loader.load();

			controlAnadirAdmin.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Crear Usuario");

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

        }catch (Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void selectDeportista(ActionEvent event) {

    	System.out.println("Deportista seleccionado");

    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAnadirDeportista.fxml"));
        	controlAnadirDeportista controlAnadirDeportista = new controlAnadirDeportista();
			loader.setController(controlAnadirDeportista);
			Parent root = loader.load();

			controlAnadirDeportista.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Crear Usuario");

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

        }catch (Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void selectEntrenador(ActionEvent event) {

    	System.out.println("Entrenador seleccionado");
    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAnadirEntrenador.fxml"));
        	controlAnadirEntrenador controlAnadirEntrenador = new controlAnadirEntrenador();
			loader.setController(controlAnadirEntrenador);
			Parent root = loader.load();

			controlAnadirEntrenador.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Crear Usuario");

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

        }catch (Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void volverAdmin(ActionEvent event) {

    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAdmin.fxml"));
        	controlAdmin controlAdmin = new controlAdmin();
			loader.setController(controlAdmin);
			Parent root = loader.load();

			controlAdmin.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Administrador");

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

        }catch (Exception e) {
			e.printStackTrace();
		}

    }
    public void setUser(Administrador user) {
		this.user = user;
	}

}