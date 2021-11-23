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

public class controlAdmin {

	private Administrador user;

    @FXML
    private Text nombreUser;

    @FXML
    private Button botonCerrarSesion;
    
    @FXML
    private Button botonAniadir;
    
    @FXML
    private Button botonBorrar;
    
    @FXML
    private Button botonEnlazar;
    
	@FXML
	private TextField userEmailText;


    @FXML
    void cerrarSesion(ActionEvent event) {
		 try {

	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewLogin.fxml"));
				controlLogin controlLog = new controlLogin();
				loader.setController(controlLog);
				Parent root = loader.load();

				Stage stage = new Stage();
				stage.setTitle("gO2theTop - Login");

				stage.setScene(new Scene(root));
				stage.show();
				Stage s_admin = (Stage) botonCerrarSesion.getScene().getWindow();
				s_admin.close();

	        }catch (Exception e) {
				e.printStackTrace();
			}

	    }

    void aniadirUsuario(ActionEvent event) {
    	
    }
    
    @FXML
    void borrarUsuario(ActionEvent event) {
    	try {

	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewBorrrarUsuario.fxml"));
				controlBorrarUsuario controlBor = new controlBorrarUsuario();
				loader.setController(controlBor);
				Parent root = loader.load();

				Stage stage = new Stage();
				stage.setTitle("gO2theTop - Borrar Usuario");

				stage.setScene(new Scene(root));
				stage.show();
				Stage s_admin = (Stage) botonBorrar.getScene().getWindow();
				s_admin.close();

	        }catch (Exception e) {
				e.printStackTrace();
			}
	    }
	
    void enlazarUsuarios(ActionEvent event) {
		
	}
	
    public void setUsuario(Administrador u) {
    	user = u;
    	nombreUser.setText(user.getName());
    }
}