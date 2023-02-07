package control;

import application.BBDD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Deportista;
import model.Entrenador;
import model.Sesion;

public class controlEstadisticasEntrenador1 {

	private Deportista user;

	private Entrenador mister;

    @FXML
    private Button botonVolver;

    @FXML
    private TableView<Sesion> tableSesiones;

    @FXML
    private TableColumn<Sesion, String> colFecha;

    @FXML
    private Button botonSeleccionar;

    @FXML
    private Button buttonChatEntrenador;


    /*@FXML
    void chatEntrenador(ActionEvent event) {
    	System.out.println("VER CHAT");
    	try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewChatEntrenador.fxml"));
			controlChatEntrenador controlChatEntren = new controlChatEntrenador();
			loader.setController(controlChatEntren);
			Parent root = loader.load();
			controlChatEntren.setUsuario(mister, user);
			Stage stage = (Stage) buttonChatEntrenador.getScene().getWindow();
			stage.setTitle("gO2theTop - Chat");
			stage.setScene(new Scene(root, buttonChatEntrenador.getScene().getWidth(), buttonChatEntrenador.getScene().getHeight()));

        }catch (Exception e) {
			e.printStackTrace();
		}

    }*/

    @FXML
    void seleccionar(ActionEvent event) {
    	if(tableSesiones.getSelectionModel().getSelectedItem() != null) {
    		try {

            	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEstadisticasEntren2.fxml"));
            	controlEstadisticasEntrenador2 controlEntren2 = new controlEstadisticasEntrenador2();
    			loader.setController(controlEntren2);
    			Parent root = loader.load();

    			String fecha = tableSesiones.getSelectionModel().getSelectedItem().getFecha();
    			System.out.println("Sesión seleccionada: " + user.getUserId() + " - " + fecha);
    			
    			BBDD bd = new BBDD();
    			Sesion sesionFin = bd.buscarFecha(fecha);
    			controlEntren2.setUsuario(user,sesionFin,mister);

    			Stage stage = (Stage) botonSeleccionar.getScene().getWindow();
    			stage.setTitle("gO2theTop - EstadisticasEntren1");

    			stage.setScene(new Scene(root, botonSeleccionar.getScene().getWidth(), botonSeleccionar.getScene().getHeight()));

            }catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    }

    @FXML
    void volverEntrenador(ActionEvent event) {

    	try {

    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEstadisticasEntren.fxml"));
			controlEstadisticasEntrenador controlEstadisticasEntren = new controlEstadisticasEntrenador();
			loader.setController(controlEstadisticasEntren);
			Parent root = loader.load();
			controlEstadisticasEntren.setUsuario(mister);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - VerEstadisticasEntrenador");

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));


        }catch (Exception e) {
			e.printStackTrace();
		}
    }

    private void inicializarTabla() {
		BBDD bd = new BBDD();
		colFecha.setCellValueFactory(new PropertyValueFactory<Sesion, String>("fecha"));
		tableSesiones.setItems(bd.verSesiones(user.getUserId()));
	}

	public void setUsuario(Deportista u, Entrenador mis) {
		user = u;
		mister = mis;
		System.out.println((user.getEmail()));
		this.inicializarTabla();
	}


}
