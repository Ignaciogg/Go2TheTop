package control;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Deportista;

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
    void mostrarFrecuencia(ActionEvent event) {
    	System.out.println("Mostrar Frecuencia Cardiaca");

    	grafica.getData().clear();
		Series<String, Number> series = new XYChart.Series<String, Number>();

		for(int i = 2000; i<=2400; i+=100){
			series.getData().add(new XYChart.Data<String, Number>("pepe", i));
		}

		series.setName("Actividad");
		//grafica.getData().add(series);

    }

    @FXML
    void mostrarNivelO2(ActionEvent event) {
    	System.out.println("Mostrar Nivel O2");

    	grafica.getData().clear();
		Series<String, Number> series = new XYChart.Series<String, Number>();

		for(int i = 2000; i<=2400; i+=100){
			series.getData().add(new XYChart.Data<String, Number>("pepe", i));
		}

		series.setName("Actividad");
		//grafica.getData().add(series);

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
