package control;

import java.awt.Button;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Deportista;
import model.Usuario;

public class controlEstadisticas {

	private Deportista user;

	@FXML
    private Button botonVolver;

    @FXML
    private RadioButton frecuencia;

    @FXML
    private ToggleGroup grafica2;

    @FXML
    private RadioButton actividad;

    @FXML
    private RadioButton temperatura;

    @FXML
    private LineChart<?, ?> grafica;

    @FXML
    void mostrarActividad(ActionEvent event) {

    }

    @FXML
    void mostrarFrecuencia(ActionEvent event) {

    }

    @FXML
    void mostrarTemperatura(ActionEvent event) {

    }

    @FXML
    void volverDeportista(ActionEvent event) {
    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewDeportista.fxml"));
        	controlDeportista controlDep = new controlDeportista();
			loader.setController(controlDep);
			Parent root = loader.load();

			controlDep.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Deportista");

			stage.setScene(new Scene(root));

        }catch (Exception e) {
			e.printStackTrace();
		}
    }

	public void setUsuario(Deportista u) {
    	user = u;
    }

}
