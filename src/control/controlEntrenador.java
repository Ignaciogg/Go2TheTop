package control;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import model.Deportista;
import model.Entrenador;
import model.Usuario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import com.google.gson.Gson;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import application.ficheros;

public class controlEntrenador {

	private Entrenador user;

	@FXML
    private JFXTextField nombreUser;

    @FXML
    private Button botonCerrarSesion;

    @FXML
    private TableView<Deportista> tablaEntrenador;

    @FXML
    private TableColumn<Deportista, String> colDeportista;

    @FXML
    private TableColumn<Deportista, String> colApellido;

    @FXML
    private TableColumn<Deportista, String> colEmail;

    @FXML
    private TableColumn<Deportista, String> colPeso;

    @FXML
    private TableColumn<Deportista, String> colAltura;


    ArrayList<Deportista> deportistaArray;


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

    private void inicializarTabla(Usuario user) {
 
		colDeportista.setCellValueFactory(new PropertyValueFactory<Deportista,String>("name"));
		colApellido.setCellValueFactory(new PropertyValueFactory<Deportista,String>("lastnames"));
		colEmail.setCellValueFactory(new PropertyValueFactory<Deportista,String>("email"));
		colPeso.setCellValueFactory(new PropertyValueFactory<Deportista,String>("peso"));
		colAltura.setCellValueFactory(new PropertyValueFactory<Deportista,String>("altura"));

		tablaEntrenador.setItems(observableList(user));

	}
  

    public ObservableList<Deportista> observableList(Usuario user){
        ObservableList<Deportista> deportistas = FXCollections.observableArrayList();
        Gson gson = new Gson();
        Deportista dep = null;
    	String fichero = "", entrenID, deporID="";
    	
    	try (BufferedReader br = new BufferedReader(new FileReader("src/files/enlaces.jsonl"))) {

    	    String linea;
    	    while ((linea = br.readLine()) != null) {
    	        fichero = linea;
    	        System.out.println(fichero);
    	        Properties properties = gson.fromJson(fichero, Properties.class);

        	    entrenID=(String) properties.get("entrenadorID");

            	if(user.getUserId().equals(entrenID)) {
            		deporID= (String) properties.get("deportistaID");
            		dep = new ficheros().leerDeportista("src/files/deportistas/" + deporID + ".jsonl");
                    deportistas.add(dep);
            	}
    	    }

    	} catch (FileNotFoundException ex) {
    	    System.out.println(ex.getMessage());
    	} catch (IOException ex) {
    	    System.out.println(ex.getMessage());
    	}
  
        
        return deportistas;
    }


	public void setUsuario(Entrenador u) {
    	user = u;
    	if(u.getGenre().equals("hombre")){
    		nombreUser.setText("Bienvenido " + u.getName());
    	}else if(u.getGenre().equals("mujer")) {
    		nombreUser.setText("Bienvenida " + u.getName());
    	}

    	this.inicializarTabla(u);


    }

}