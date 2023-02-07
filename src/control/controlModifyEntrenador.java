package control;

import application.BBDD;
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

public class controlModifyEntrenador extends controlModificarUsuario{


	private Administrador user;
	private Usuario modificar;

	@FXML
    private Text bienvenide;

    @FXML
    private Button botonConfirmarModify;

    @FXML
    private Button botonVolver;

    @FXML
    private TextField nuevaContraseña;

    @FXML
    private TextField nuevaFecha;

    @FXML
    private TextField nuevoApellido;

    @FXML
    private TextField nuevoEmail;

    @FXML
    private TextField nuevoGenero;

    @FXML
    private TextField nuevoNombre;

    @FXML
    void confirmarModify(ActionEvent event) {


    	System.out.println(dni);

    	try{
    		System.out.println("MODIFICA EL USUARIO");

    		String id = modificar.getUserId();

    		String mail = nuevoEmail.getText();
    		System.out.println(mail);
    		String password = nuevaContraseña.getText();
    		System.out.println(password);
    		String type="entrenador";
    		System.out.println(type);
    		String name = nuevoNombre.getText();
    		System.out.println(name);
    		String lastname = nuevoApellido.getText();
    		System.out.println(lastname);
    		String day = nuevaFecha.getText();
    		System.out.println(day);
    		String gen = nuevoGenero.getText();
    		System.out.println(gen);
    		Boolean act = true;


    		Usuario nuevo = new Usuario(id, mail, password, type, name, lastname, day, gen, act);
        	System.out.println("El usuario que se va a modificar es: " + nuevo.toString());

        	BBDD bd = new BBDD();
        	bd.modificarUsuario(nuevo);
        	volverAdmin(event);

    	}catch (Exception e) {
			e.printStackTrace();
		}


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

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

        }catch (Exception e) {
			e.printStackTrace();
		}

    }

    public void setUsuario(Administrador u, Usuario mod) {
		user = u;
		modificar = mod;
	}

}
