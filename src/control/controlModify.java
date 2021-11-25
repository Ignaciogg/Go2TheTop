package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Administrador;

public class controlModify {

	private Administrador user;
	
    @FXML
    private Text bienvenide;
    
    @FXML
    private Button botonConfirmarModify;

    @FXML
    private Button botonModify;
    
    @FXML
    private Button botonVolver;

    @FXML
    private TextField nuevaContraseña;

    @FXML
    private TextField nuevaFecha;

    @FXML
    private TextField nuevoApellido;

    @FXML
    private TextField nuevoGenero;

    @FXML
    private TextField nuevoNombre;

    @FXML
    void confirmarModify(ActionEvent event) {
    	/*String dni = nuevaContraseña.getText();
    	System.out.println(dni);

    	System.out.println(user.toString());

    	user.modificarUsuario(dni);*/
    }

    @FXML
    void volverAdmin(ActionEvent event) {

    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewModificarUsuario.fxml"));
        	controlAdmin controlAdmin = new controlAdmin();
			loader.setController(controlAdmin);
			Parent root = loader.load();

			controlAdmin.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Administrador");

			stage.setScene(new Scene(root));

        }catch (Exception e) {
			e.printStackTrace();
		}

    }
    
    public void setUser(Administrador user) {
		this.user = user;
	}


}
