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
import javafx.stage.Stage;
import model.Deportista;
import model.Sesion;
import model.Usuario;

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
    void mostrarFrecuencia(ActionEvent event) throws FileNotFoundException {
    	System.out.println("Mostrar Frecuencia Cardiaca");
    	grafica.getData().clear();
    	Gson gson = new Gson();
    	Sesion sesion1 = null;
    	String linea;
    	String[] sesiones;

    	try {
			BufferedReader br = new BufferedReader(new FileReader("src/files/sesiones/"+ user.getUserId() +".jsonl"));

			while ((linea = br.readLine()) != null){
				sesion1 = gson.fromJson(linea, Sesion.class);
			}

	    	XYChart.Series serie1 = new XYChart.Series();
			serie1.getData().add(new XYChart.Data("1", sesion1.getValorF1()));
			serie1.getData().add(new XYChart.Data("2", sesion1.getValorF2()));
			serie1.getData().add(new XYChart.Data("3", sesion1.getValorF3()));
			serie1.getData().add(new XYChart.Data("4", sesion1.getValorF4()));

			grafica.getData().add(serie1);

		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void mostrarNivelO2(ActionEvent event) {
    	System.out.println("Mostrar Nivel O2");
    	grafica.getData().clear();
    	Gson gson = new Gson();
    	Sesion sesion2 = null;
    	String linea;
    	String[] sesiones;

    	try {
			BufferedReader br = new BufferedReader(new FileReader("src/files/sesiones/"+ user.getUserId() +".jsonl"));

			while ((linea = br.readLine()) != null){
				sesion2 = gson.fromJson(linea, Sesion.class);
			}

	    	XYChart.Series serie1 = new XYChart.Series();
			serie1.getData().add(new XYChart.Data("1", sesion2.getValorO1()));
			serie1.getData().add(new XYChart.Data("2", sesion2.getValorO2()));
			serie1.getData().add(new XYChart.Data("3", sesion2.getValorO3()));
			serie1.getData().add(new XYChart.Data("4", sesion2.getValorO4()));

			grafica.getData().add(serie1);

		} catch (IOException e) {
			e.printStackTrace();
		}

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