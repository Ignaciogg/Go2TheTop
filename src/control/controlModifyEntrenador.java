package control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

import com.google.gson.Gson;

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
import model.Entrenador;
import model.Usuario;

public class controlModifyEntrenador extends controlModificarUsuario{

	
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

    
    public void escribirLogin(Usuario nuevo){
        Gson gson = new Gson();
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/files/login.jsonl",true));
            bw.newLine();
            bw.append(gson.toJson(nuevo));
            bw.flush();
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void escribirPersona(Usuario nuevo, String ruta){
        Gson gson = new Gson();
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
            bw.write(gson.toJson(nuevo));
            bw.flush();
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void confirmarModify(ActionEvent event) {
      	
        	
    	System.out.println(dni);
    	user.borrarUsuario(dni);

    	try{
    		System.out.println("MODIFICA EL USUARIO"); 		
    		
    		String id = nuevoId.getText();
    		System.out.println(id);
    		String mail = nuevoEmail.getText();
    		System.out.println(mail);
    		String password = nuevaContraseña.getText();
    		System.out.println(password);
    		String type="Entrenador";
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
	    	
        	Entrenador nuevo2 = new Entrenador (id, mail, password, name, lastname, day, gen, gen, act);
        	System.out.println("El usuario que se va a modificar es: " + nuevo.toString());
        	String ruta = "src/files/administradores/" + dni + ".jsonl";

            escribirLogin(nuevo);
            escribirPersona(nuevo2, ruta);
    		
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
    

	/*public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}*/

}
