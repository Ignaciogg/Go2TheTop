package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Administrador;
import model.Usuario;
import javafx.scene.control.TextField;
import application.BBDD;

public class controlModificarUsuario {

	private Administrador user;

	@FXML
	private Button botonModify;

	@FXML
	private Button botonVolver;

	@FXML
	private TextField textMod;

	public static String dni = "";

	@FXML
	void modificarUser(ActionEvent event) {

		dni = textMod.getText();
		System.out.println(dni);

		BBDD bd = new BBDD();
		Usuario persona = bd.buscarUsuarioid(dni);

		if (persona != null) {

			switch (persona.getUserType()) {
			case "administrador":

				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewModifyAdmin.fxml"));
					controlModifyAdmin controlModify = new controlModifyAdmin();
					loader.setController(controlModify);
					Parent root = loader.load();

					controlModify.setUsuario(user, persona);

					Stage stage = (Stage) botonModify.getScene().getWindow();
					stage.setTitle("gO2theTop - Modificar Administrador");

					stage.setScene(new Scene(root, botonModify.getScene().getWidth(), botonModify.getScene().getHeight()));

				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case "entrenador":

				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewModifyEntrenador.fxml"));
					controlModifyEntrenador controlModify1 = new controlModifyEntrenador();
					loader.setController(controlModify1);
					Parent root = loader.load();

					controlModify1.setUsuario(user,persona);

					Stage stage = (Stage) botonModify.getScene().getWindow();
					stage.setTitle("gO2theTop - Modificar Entrenador");

					stage.setScene(new Scene(root, botonModify.getScene().getWidth(), botonModify.getScene().getHeight()));

				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case "deportista":

				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewModifyDeportista.fxml"));
					controlModifyDeportista controlModify2 = new controlModifyDeportista();
					loader.setController(controlModify2);
					Parent root = loader.load();

					controlModify2.setUsuario(user,persona);

					Stage stage = (Stage) botonModify.getScene().getWindow();
					stage.setTitle("gO2theTop - Modificar Deportista");

					stage.setScene(new Scene(root, botonModify.getScene().getWidth(), botonModify.getScene().getHeight()));

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			}

		} else {
			System.out.println("No hemos encontrado el usuario");
		}

	}

	@FXML
	void volverAdmin(ActionEvent event) {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAdmin.fxml"));
			controlAdmin controlAdmin = new controlAdmin();
			loader.setController(controlAdmin);
			Parent root = loader.load();

			controlAdmin.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Administrador");

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setUser(Administrador user) {
		this.user = user;
	}

}