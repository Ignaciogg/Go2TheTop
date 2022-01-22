package control;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.gson.Gson;

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
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Stage;
import model.Deportista;
import model.Sesion;
import model.Usuario;

public class controlEstadisticas2 implements Initializable{

	private Sesion sesioncita;

	private Deportista user;

	@FXML
    private Button botonVolver;

	@FXML
    private Button buttonMapa;

    @FXML
    private ToggleGroup grafica2;

    @FXML
    private TextField textoFeedback;

    @FXML
    private RadioButton frecuencia;

    @FXML
    private RadioButton nivelo2;

    @FXML
    private LineChart<?, ?> grafica;

    @FXML
    void mostrarFrecuencia(ActionEvent event) throws FileNotFoundException {
    	System.out.println("Mostrar Frecuencia");
    	grafica.getData().clear();

    	XYChart.Series serie1 = new XYChart.Series();
		serie1.getData().add(new XYChart.Data("1", sesioncita.getValorF1()));
		serie1.getData().add(new XYChart.Data("2", sesioncita.getValorF2()));
		serie1.getData().add(new XYChart.Data("3", sesioncita.getValorF3()));
		serie1.getData().add(new XYChart.Data("4", sesioncita.getValorF4()));

		serie1.setName("Frecuencia cardiaca");
		grafica.getData().add(serie1);

    }

    @FXML
    void mostrarNivelO2(ActionEvent event) {
    	System.out.println("Mostrar Nivel O2");
    	grafica.getData().clear();

    	XYChart.Series serie1 = new XYChart.Series();
		serie1.getData().add(new XYChart.Data("1", sesioncita.getValorO1()));
		serie1.getData().add(new XYChart.Data("2", sesioncita.getValorO2()));
		serie1.getData().add(new XYChart.Data("3", sesioncita.getValorO3()));
		serie1.getData().add(new XYChart.Data("4", sesioncita.getValorO4()));

		serie1.setName("Nivel de O2");
		grafica.getData().add(serie1);
    }

    @FXML
    void volverDeportista(ActionEvent event) {

    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewDepor.fxml"));
        	controlDeportista controlDep = new controlDeportista();
			loader.setController(controlDep);
			Parent root = loader.load();

			controlDep.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Deportista");

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

        }catch (Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void verMapa(ActionEvent event) {
    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Mapa.fxml"));
        	controlMapa controlEntren = new controlMapa();
			loader.setController(controlEntren);
			Parent root = loader.load();

			Stage stage = (Stage) buttonMapa.getScene().getWindow();
			stage.setTitle("gO2theTop - Mapa");

			stage.setScene(new Scene(root, buttonMapa.getScene().getWidth(), buttonMapa.getScene().getHeight()));

        }catch (Exception e) {
			e.printStackTrace();
		}
    }

	public void setUsuario(Deportista u, Sesion sesion) {
    	user = u;
    	sesioncita = sesion;

    	if(!sesion.getFeedback().equals("")){
    		textoFeedback.setText(sesion.getFeedback());
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		XYChart.Series serie = new XYChart.Series();

		grafica.getData().add(serie);
	}

}