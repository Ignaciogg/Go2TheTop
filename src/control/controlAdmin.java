package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

				stage.setScene(new Scene(root));

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

				Stage stage = (Stage) botonBorrar.getScene().getWindow();
				stage.setTitle("gO2theTop - Borrar Usuario");

				stage.setScene(new Scene(root));
				
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

				stageActual.setScene(new Scene(root));

	        }catch (Exception e) {
				e.printStackTrace();
			}
	    }

    @FXML
    void enlazarUsuarios(ActionEvent event) {
    	try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEnlazarUsuarios.fxml"));
			controlAnadirUsuario controlAna = new controlAnadirUsuario();
			loader.setController(controlAna);
			Parent root = loader.load();
			controlAna.setUser(user);
			Stage stageActual = (Stage) botonBorrar.getScene().getWindow();
			stageActual.setTitle("gO2theTop - Anadir Usuario");

			stageActual.setScene(new Scene(root));

        }catch (Exception e) {
			e.printStackTrace();
		}
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

			stage.setScene(new Scene(root));

	        }catch (Exception e) {
				e.printStackTrace();
			}
	    }
    
    private void inicializarTabla() {
    	 
		colUserId.setCellValueFactory(new PropertyValueFactory<Usuario,String>("userId"));
		colEmail.setCellValueFactory(new PropertyValueFactory<Usuario,String>("email"));
		colUserType.setCellValueFactory(new PropertyValueFactory<Usuario,String>("userType"));
		

		tableAdmin.setItems(observableList());

	}
  

    public ObservableList<Usuario> observableList(){
        ObservableList<Usuario> users = FXCollections.observableArrayList();
        Gson gson = new Gson();
        Usuario user = null;
    	String fichero = "";
    	
    	try (BufferedReader br = new BufferedReader(new FileReader("src/files/login.jsonl"))) {

    	    String linea;
    	    while ((linea = br.readLine()) != null) {
    	        fichero = linea;
    	        user = gson.fromJson(fichero, Usuario.class);
    	        users.add(user);
    	    }

    	} catch (FileNotFoundException ex) {
    	    System.out.println(ex.getMessage());
    	} catch (IOException ex) {
    	    System.out.println(ex.getMessage());
    	}
    	
        return users;
    }

    public void setUsuario(Administrador u) {
    	user = u;
    	bienvenide.setText("Bienvenide " + user.getName());
    	this.inicializarTabla();
    	
    }
}