package control;

import application.ficheros;
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
import model.Enlace;
import model.Entrenador;

public class controlEnlazarConfirmacion {

	private Administrador user;
	private Entrenador entrenador;
	private Deportista deportista;

	@FXML
	private Button botonVolver;

	@FXML
	private Text texto;

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

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void confirmar(ActionEvent event) {

		try {

			ficheros files = new ficheros();
			Enlace en = new Enlace(entrenador.getUserId(), deportista.getUserId());
			files.escribirEnlace(en);

			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAdmin.fxml"));
			controlAdmin controladmin = new controlAdmin();
			loader.setController(controladmin);
			Parent root = loader.load();

			controladmin.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Admin");

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setUsuario(Administrador u, Entrenador e, Deportista d) {
		user = u;
		entrenador = e;
		deportista = d;
		texto.setText("Desea confirmar el enlace entre\n"+e.getUserId()+" - "+e.getName()+ " "+e.getLastnames()+"\n"+d.getUserId()+" - "+d.getName()+ " "+d.getLastnames());
	}
}
