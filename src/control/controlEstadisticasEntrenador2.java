package control;

import application.ficheros;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Deportista;
import model.Entrenador;
import model.Mensaje;
import model.Sesion;

public class controlEstadisticasEntrenador2 {
	
	private Sesion sesioncita;

	private Deportista user;
	
	private Entrenador mister;


    @FXML
    private Button botonVolver;

    @FXML
    private Button buttonMapa;

    @FXML
    private RadioButton frecuencia;

    @FXML
    private ToggleGroup grafica2;

    @FXML
    private RadioButton nivelo2;

    @FXML
    private LineChart<?, ?> grafica;
    
    @FXML
    private TextField textoFeedback;

    @FXML
    private Button botonEnviar;

    @FXML
    void enviar(ActionEvent event) {
    	ficheros fichero = new ficheros();
    	fichero.escribirFeedback(new Mensaje (mister.getName(), textoFeedback.getText()), ("src/files/sesiones/"+ user.getUserId() +".jsonl"));
    }

    @FXML
    void mostrarFrecuencia(ActionEvent event) {
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
    void verMapa(ActionEvent event) {
    	
    }

    @FXML
    void volverEntrenador(ActionEvent event) {

    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEntren.fxml"));
        	controlEntrenador controlEntren = new controlEntrenador();
			loader.setController(controlEntren);
			Parent root = loader.load();

			controlEntren.setUsuario(mister);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Entrenador");

			stage.setScene(new Scene(root));

        }catch (Exception e) {
			e.printStackTrace();
		}

    }
    
    public void setUsuario(Deportista u, Sesion sesion, Entrenador mis) {
    	user = u;
    	sesioncita = sesion;
    	mister=mis;

    }

}
