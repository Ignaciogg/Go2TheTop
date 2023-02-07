package control;

import javafx.scene.control.Button;
import javafx.scene.control.Labeled;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.BBDD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.DatosSensores;
import model.Deportista;
import model.Sesion;
import model.Usuario;

public class controlEstadisticas2{

	private Sesion sesion;

	private Deportista user;

	 @FXML
	 private Button botonVolver;

	 @FXML
	 private LineChart<DatosSensores, String> graficaFrec;

	 @FXML
	 private LineChart<DatosSensores, String> graficaO2;

	 @FXML
	 private LineChart<DatosSensores, String> graficaVel;

	 @FXML
	 private Text frecMax;

	 @FXML
	 private Text frecMed;

	 @FXML
	 private Text o2Max;

	 @FXML
	 private Text o2Med;

	 @FXML
	 private Text velMax;

	 @FXML
	 private Text velMed;

	 @FXML
	 private TextField textoFeedback;

	@FXML
	 private TextField textoFmax;

	@FXML
	 private TextField textoFmedia;

	@FXML
	private TextField textoOmax;

	@FXML
	private TextField textoOmedio;

	@FXML
	private TextField textoVmax;

	@FXML
	private TextField textoVmedia;


    void mostrarFrecuencia() {

    	XYChart.Series serie1 = new XYChart.Series();
    	int max = 0;
    	int media = 0;

    	BBDD bd = new BBDD();
    	ArrayList <DatosSensores> array = bd.obtenerDato(sesion.getId_Sesion(), "Frecuencia cardiaca");
    	System.out.println(array.size());

    	for(int i = 0; i<array.size(); i++){
    		serie1.getData().add(new XYChart.Data<String, Integer>(Integer.toString(i+1), Integer.parseInt(array.get(i).getValor())));
    		if(Integer.parseInt(array.get(i).getValor()) > max) {
				max = Integer.parseInt(array.get(i).getValor());
			}
    		media+= Integer.parseInt(array.get(i).getValor());
    	}

    	textoFmax.setText(Integer.toString(max));
    	media = media/array.size();
		textoFmedia.setText(Integer.toString(media));
		graficaFrec.getData().add(serie1);

    }

    void mostrarNivelO2() {

    	XYChart.Series serie2 = new XYChart.Series();
    	int max = 0;
    	int media = 0;

    	BBDD bd = new BBDD();
    	ArrayList <DatosSensores> array = bd.obtenerDato(sesion.getId_Sesion(), "Oxigeno");

    	for(int i = 0; i<array.size(); i++){
    		serie2.getData().add(new XYChart.Data<String, Integer>(Integer.toString(i+1), Integer.parseInt(array.get(i).getValor())));
    		if(Integer.parseInt(array.get(i).getValor()) > max) {
				max = Integer.parseInt(array.get(i).getValor()) ;
			}
    		media+= Integer.parseInt(array.get(i).getValor());
    	}

    	textoOmax.setText(Integer.toString(max));
    	media = media/array.size();
		textoOmedio.setText(Integer.toString(media));
		graficaO2.getData().add(serie2);
    }

    void mostrarVelocidad() {

    	XYChart.Series serie3 = new XYChart.Series();
    	int max = 0;
    	int media = 0;

    	BBDD bd = new BBDD();
    	ArrayList <DatosSensores> array = bd.obtenerDato(sesion.getId_Sesion(), "Velocidad");

    	for(int i = 0; i<array.size(); i++){
    		serie3.getData().add(new XYChart.Data<String, Integer>(Integer.toString(i+1), Integer.parseInt(array.get(i).getValor())));
    		if(Integer.parseInt(array.get(i).getValor()) > max) {
				max = Integer.parseInt(array.get(i).getValor()) ;
			}
    		media+= Integer.parseInt(array.get(i).getValor());
    	}

    	textoVmax.setText(Integer.toString(max));
    	media = media/array.size();
		textoVmedia.setText(Integer.toString(media));
		graficaVel.getData().add(serie3);
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

	public void setUsuario(Deportista u, Sesion sesion2) {
    	user = u;
    	sesion = sesion2;

    	if(!sesion2.getFeedback().equals("")){
    		System.out.print(sesion2.getFeedback());
    		textoFeedback.setText(sesion2.getFeedback());
    	}
    	mostrarFrecuencia();
    	mostrarNivelO2();
    	mostrarVelocidad();
    }

}