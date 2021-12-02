package control;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Administrador;
import model.Deportista;
import model.Entrenador;

public class controlEnlazarConfirmacion {

	private Administrador user;
	private Entrenador entrenador;
	private Deportista deportista;

	@FXML
	private Button botonVolver;
	
	@FXML
	private Text textoEntrenador;
	
	@FXML
	private Text textoDeportista;

	@FXML
	private Button botonConfirmar;

	@FXML
	void volverAdmin(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAdmin.fxml"));
			controlAdmin controladmin = new controlAdmin();
			loader.setController(controladmin);
			Parent root = loader.load();
			controladmin.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Admin");

			stage.setScene(new Scene(root));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void confirmar(ActionEvent event) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAdmin.fxml"));
			controlAdmin controladmin = new controlAdmin();
			loader.setController(controladmin);
			Parent root = loader.load();

			controladmin.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Admin");

			stage.setScene(new Scene(root));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setUsuario(Administrador u, Entrenador e, Deportista d) {
		user = u;
		entrenador = e;
		deportista = d;
		textoEntrenador.setText(e.getUserId()+" - "+e.getName()+ " "+e.getLastnames());
		textoDeportista.setText(d.getUserId()+" - "+d.getName()+ " "+d.getLastnames());
	}
}
