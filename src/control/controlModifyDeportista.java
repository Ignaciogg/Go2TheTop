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
import model.Deportista;
import model.Usuario;

public class controlModifyDeportista extends controlModificarUsuario{


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
    private TextField nuevaAltura;

    @FXML
    private TextField nuevoPeso;

    @FXML
    void confirmarModify(ActionEvent event) {


    	System.out.println(dni);
    	user.borrarUsuario(dni);
    	try{
    		System.out.println("MODIFICA EL USUARIO");

    		String id = modificar.getUserId();

    		String mail = nuevoEmail.getText();
    		System.out.println(mail);
    		String password = nuevaContraseña.getText();
    		System.out.println(password);
    		String type="deportista";
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
    		String alt = nuevaAltura.getText();
    		float alt2 = Float.parseFloat(alt);
    		System.out.println(alt);
    		String pes = nuevoPeso.getText();
    		float pes2 = Float.parseFloat(pes);
    		System.out.println(pes);

        	Deportista nuevo = new Deportista (id, mail, password, type, name, lastname, day, gen, act, alt2, pes2);
        	System.out.println("El usuario que se va a modificar es: " + nuevo.toString());

        	BBDD bd = new BBDD();
        	bd.modificarDeportista(nuevo);
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
