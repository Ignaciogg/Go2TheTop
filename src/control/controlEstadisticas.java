package control;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Deportista;

public class controlEstadisticas implements Initializable{

	private Deportista user;

	@FXML
    private Button botonVolver;

    @FXML
    private ToggleGroup grafica2;

    @FXML
    private RadioButton frecuencia;

    @FXML
    private RadioButton nivelo2;

    @FXML
    private LineChart<?, ?> grafica;

    @FXML
    private DatePicker datepicker1;

    @FXML
    private DatePicker datepicker2;

    @FXML
    void mostrarFrecuencia(ActionEvent event) {
    	System.out.println("Mostrar Frecuencia Cardiaca");
    	grafica.getData().clear();

    	XYChart.Series serie1 = new XYChart.Series();
		serie1.getData().add(new XYChart.Data("1", 85));
		serie1.getData().add(new XYChart.Data("2", 100));
		serie1.getData().add(new XYChart.Data("3", 110));
		serie1.getData().add(new XYChart.Data("4", 120));
		serie1.getData().add(new XYChart.Data("5", 120));
		serie1.getData().add(new XYChart.Data("6", 115));

		grafica.getData().add(serie1);

    }

    @FXML
    void mostrarNivelO2(ActionEvent event) {
    	System.out.println("Mostrar Nivel O2");
    	grafica.getData().clear();

    	XYChart.Series serie1 = new XYChart.Series();
		serie1.getData().add(new XYChart.Data("1", 99));
		serie1.getData().add(new XYChart.Data("2", 97));
		serie1.getData().add(new XYChart.Data("3", 94));
		serie1.getData().add(new XYChart.Data("4", 91));
		serie1.getData().add(new XYChart.Data("5", 89));
		serie1.getData().add(new XYChart.Data("6", 85));

		grafica.getData().add(serie1);

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		XYChart.Series serie = new XYChart.Series();
		serie.getData().add(new XYChart.Data("1", 85));
		serie.getData().add(new XYChart.Data("2", 100));
		serie.getData().add(new XYChart.Data("3", 110));

		grafica.getData().add(serie);
	}

}
