package control;

import javax.swing.JFrame;

import application.ficheros;
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

public class controlModifyAdmin extends controlModificarUsuario{

	
	private Administrador user;
	
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
    private TextField nuevoId;

    @FXML
    private TextField nuevoNombre;


    @FXML
    void confirmarModify(ActionEvent event) {
      	
        	
    	System.out.println(dni);
    	
    	try{
    		System.out.println("MODIFICA EL USUARIO"); 		
    		
    		String id = nuevoId.getText();
    		System.out.println(id);
    		String mail = nuevoEmail.getText();
    		System.out.println(mail);
    		String password = nuevaContraseña.getText();
    		System.out.println(password);
    		String type="hay que hacerlo";
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
    		
    		Usuario nuevo = new Usuario(id, mail, password, name, lastname, day, gen, gen, act);
    		
    		user.confirmarModificarUsuario(dni, id, mail, password, name, lastname, day, gen, gen, act);
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

			stage.setScene(new Scene(root));

        }catch (Exception e) {
			e.printStackTrace();
		}

    }
    
    public void setUsuario(Administrador u) {
		user = u;
	}
    

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
