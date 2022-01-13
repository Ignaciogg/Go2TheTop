package control;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import com.google.gson.Gson;
import com.jfoenix.controls.JFXTextField;

import application.ficheros;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Deportista;
import model.Entrenador;
import model.Sesion;
import model.Usuario;

public class controlEstadisticasEntrenador {

	private Entrenador user;

	@FXML
	private Button botonSeleccionar;

	@FXML
    private Button botonBuscar;

    @FXML
    private Button botonVolver;

    @FXML
    private JFXTextField nombreUser;

    @FXML
    private Button buttonVerEstadisticas;

    @FXML
    private Button buttonChatEntrenador;

    @FXML
    private JFXTextField textfielUser;

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
    void volver(ActionEvent event) {
    	try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEstadisticasEntren1.fxml"));
			controlEntrenador controlEntren = new controlEntrenador();
			loader.setController(controlEntren);
			Parent root = loader.load();
			controlEntren.setUsuario(user);

			Stage stage = (Stage) botonVolver.getScene().getWindow();
			stage.setTitle("gO2theTop - Entrenador");

			stage.setScene(new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight()));

		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void buscar(ActionEvent event) {
    	colDeportista.setCellValueFactory(new PropertyValueFactory<Deportista,String>("name"));
		colApellido.setCellValueFactory(new PropertyValueFactory<Deportista,String>("lastnames"));
		colEmail.setCellValueFactory(new PropertyValueFactory<Deportista,String>("email"));
		colPeso.setCellValueFactory(new PropertyValueFactory<Deportista,String>("peso"));
		colAltura.setCellValueFactory(new PropertyValueFactory<Deportista,String>("altura"));
		tablaEntrenador.setItems(observableList(textfielUser.getText()));
    }

    @FXML
    void chatEntrenador(ActionEvent event) {
    	System.out.println("VER CHAT");
    	try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewChatEntrenador.fxml"));
			controlChatEntrenador controlChatEntren = new controlChatEntrenador();
			loader.setController(controlChatEntren);
			Parent root = loader.load();
			controlChatEntren.setUsuario(user);
			Stage stageActual = (Stage) buttonChatEntrenador.getScene().getWindow();
			stageActual.setTitle("gO2theTop - Chat");

			stageActual.setScene(new Scene(root, buttonChatEntrenador.getScene().getWidth(), buttonChatEntrenador.getScene().getHeight()));

        }catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void verEstadisticas(ActionEvent event) {

    }

    @FXML
    void seleccionar(ActionEvent event) {
    	if (tablaEntrenador.getSelectionModel().getSelectedItem() != null) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEstadisticasEntren1.fxml"));
				controlEstadisticasEntren1 controlEstadisticasEntren = new controlEstadisticasEntren1();
				loader.setController(controlEstadisticasEntren);
				Parent root = loader.load();
				Deportista deportista= new ficheros().leerDeportista("src/files/deportistas/" + tablaEntrenador.getSelectionModel().getSelectedItem().getUserId() + ".jsonl");
				controlEstadisticasEntren.setUsuario(deportista,user);

				Stage stage = (Stage) botonVolver.getScene().getWindow();
				stage.setTitle("gO2theTop - Seleccion de sesion");

				stage.setScene(new Scene(root, buttonVerEstadisticas.getScene().getWidth(), buttonVerEstadisticas.getScene().getHeight()));

			} catch (Exception e) {
				e.printStackTrace();
			}
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

    public ObservableList<Deportista> observableList(String dni) {
		ObservableList<Deportista> users = FXCollections.observableArrayList();
		Gson gson = new Gson();
		Usuario user = null;
		ficheros files = new ficheros();
		try (BufferedReader br = new BufferedReader(new FileReader("src/files/login.jsonl"))) {

			String linea;
			while ((linea = br.readLine()) != null) {
				user = gson.fromJson(linea, Usuario.class);
				if (user.getUserType().equalsIgnoreCase("Deportista")) {
					if (user.getUserId().equalsIgnoreCase(dni)) {
						users.add(files.leerDeportista("src/files/Deportistas/" + user.getUserId() + ".jsonl"));
					}
				}
			}

		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		return users;
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

        	    System.out.println(entrenID);
        	    System.out.println(user.getUserId());

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
