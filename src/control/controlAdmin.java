package control;


import java.util.ArrayList;

import application.BBDD;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
	private TableView<Usuario> tableAdmin;

	 @FXML
	 private TableColumn<Usuario, String> colUserId;

	 @FXML
	 private TableColumn<Usuario, String> colEmail;

	 @FXML
	 private TableColumn<Usuario, String> colUserType;

	 ArrayList<Usuario> usersArray;

    @FXML
    void cerrarSesion(ActionEvent event) {
		 try {

	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewLogin.fxml"));
				controlLogin controlLog = new controlLogin();
				loader.setController(controlLog);
				Parent root = loader.load();

				Stage stage = (Stage) botonCerrarSesion.getScene().getWindow();
				stage.setTitle("gO2theTop - Login");

				stage.setScene(new Scene(root, botonCerrarSesion.getScene().getWidth(), botonCerrarSesion.getScene().getHeight()));

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
				System.out.println(user.getName());

				Stage stage = (Stage) botonBorrar.getScene().getWindow();
				stage.setTitle("gO2theTop - Borrar Usuario");

				stage.setScene(new Scene(root, botonBorrar.getScene().getWidth(), botonBorrar.getScene().getHeight()));

			}catch (Exception e) {
				e.printStackTrace();
			}
	    }

    @FXML
    void aniadirUsuario(ActionEvent event) {
    	try {
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewAnadirUsuario.fxml"));
				controlAnadirUsuario controlAna = new controlAnadirUsuario();
				loader.setController(controlAna);
				Parent root = loader.load();
				controlAna.setUser(user);
				Stage stageActual = (Stage) botonBorrar.getScene().getWindow();
				stageActual.setTitle("gO2theTop - Anadir Usuario");

				stageActual.setScene(new Scene(root, botonBorrar.getScene().getWidth(), botonBorrar.getScene().getHeight()));

	        }catch (Exception e) {
				e.printStackTrace();
			}
	    }

    @FXML
    void enlazarUsuarios(ActionEvent event) {
    	try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEnlazarUsuarios.fxml"));
			controlEnlazarEntrenador controlEnl = new controlEnlazarEntrenador();
			loader.setController(controlEnl);
			Parent root = loader.load();
			controlEnl.setUsuario(user);
			Stage stageActual = (Stage) botonBorrar.getScene().getWindow();
			stageActual.setTitle("gO2theTop - Enlazar Usuario");

			stageActual.setScene(new Scene(root, botonBorrar.getScene().getWidth(), botonBorrar.getScene().getHeight()));

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
			controlMod.setUser(user);
			Stage stage = (Stage) botonModificar.getScene().getWindow();
			stage.setTitle("gO2theTop - Modificar Usuario");

			stage.setScene(new Scene(root, botonModificar.getScene().getWidth(), botonModificar.getScene().getHeight()));

	        }catch (Exception e) {
				e.printStackTrace();
			}
	    }

    private void inicializarTabla() {

		colUserId.setCellValueFactory(new PropertyValueFactory<Usuario,String>("userId"));
		colEmail.setCellValueFactory(new PropertyValueFactory<Usuario,String>("email"));
		colUserType.setCellValueFactory(new PropertyValueFactory<Usuario,String>("userType"));
		BBDD bd = new BBDD();
		tableAdmin.setItems(bd.observableList());
	}



    public void setUsuario(Usuario usuario) {
    	user = new Administrador(
				usuario.getUserId(),
				usuario.getEmail(),
				usuario.getPassword(),
				usuario.getUserType(),
				usuario.getName(),
				usuario.getLastnames(),
				usuario.getBirthday(),
				usuario.getGenre(),
				usuario.getActive());

    	if(usuario.getGenre().equals("hombre") || usuario.getGenre().equals("Masculino")){
    		bienvenide.setText("Bienvenido " + usuario.getName());
    	}else if(usuario.getGenre().equals("mujer") || usuario.getGenre().equals("Femenino")) {
    		bienvenide.setText("Bienvenida " + usuario.getName());
    	}
    	this.inicializarTabla();

    }
}