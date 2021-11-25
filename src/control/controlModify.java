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
    	
    	String password = nuevaContraseña.getText();
    	System.out.println(password);
    	user.modificarUsuario(password);
    	
    	String name = nuevoNombre.getText();
    	System.out.println(name);
    	user.modificarUsuario(name);
    	
    	String lastname = nuevoApellido.getText();
    	System.out.println(lastname);
    	user.modificarUsuario(lastname);
    	
    	String day = nuevaFecha.getText();
    	System.out.println(day);
    	user.modificarUsuario(day);
    	
    	String sex = nuevoGenero.getText();
    	System.out.println(sex);
    	user.modificarUsuario(sex);
    	
    }

    @FXML
    void volverAdmin(ActionEvent event) {

    	try {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewModificarUsuario.fxml"));
        	controlModificarUsuario controlModificarUsuario = new controlModificarUsuario();
			loader.setController(controlModificarUsuario);
			Parent root = loader.load();

			controlModificarUsuario.setUser(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Modificar Usuario");

			stage.setScene(new Scene(root));

        }catch (Exception e) {
			e.printStackTrace();
		}

    }
    
    public void setUser(Administrador user) {
		this.user = user;
	}


}
