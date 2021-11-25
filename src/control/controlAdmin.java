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
import model.Usuario;

public class controlAdmin {

	private Administrador user;

    @FXML
    private Text bienvenide;

    @FXML
    private Button botonCerrarSesion;

    @FXML
    private Button botonAniadir;

    @FXML
    private Button botonBorrar;

    @FXML
    private Button botonEnlazar;
    
    @FXML
    private Button botonModificar;

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

    @FXML
    void borrarUsuario(ActionEvent event) {
    	try {

	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewBorrarUsuario.fxml"));
				controlBorrarUsuario controlBor = new controlBorrarUsuario();
				loader.setController(controlBor);
				Parent root = loader.load();
				
				controlBor.setUser(user);

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

    @FXML
    void aniadirUsuario(ActionEvent event) {
    	try {

	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAnadirUsuario.fxml"));
				controlBorrarUsuario controlBor = new controlBorrarUsuario();
				loader.setController(controlBor);
				Parent root = loader.load();

				Stage stage = new Stage();
				stage.setTitle("gO2theTop - Anadir Usuario");

				stage.setScene(new Scene(root));
				stage.show();
				Stage s_admin = (Stage) botonBorrar.getScene().getWindow();
				s_admin.close();

	        }catch (Exception e) {
				e.printStackTrace();
			}
	    }

    @FXML
    void enlazarUsuarios(ActionEvent event) {
    	try {


	        }catch (Exception e) {
				e.printStackTrace();
			}
	    }
    @FXML
    void modificarUsuario(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewModificarUsuario.fxml"));
			controlModificarUsuario controlMod = new controlModificarUsuario();
			loader.setController(controlMod);
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("gO2theTop - Modificar Usuario");

			stage.setScene(new Scene(root));
			stage.show();
			Stage s_admin = (Stage) botonModificar.getScene().getWindow();
			s_admin.close();

	        }catch (Exception e) {
				e.printStackTrace();
			}
	    }

    public void setUsuario(Administrador u) {
    	user = u;
    	bienvenide.setText("Bienvenide " + user.getName());
    }
}