/*
package model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;



public class UsuarioGson {


			public static void serializarArrayAJson() {
				Usuario usuario1 = new Usuario("11111111A " , "email1@email.com ", "aaa", "admin");
				Usuario usuario2 = new Usuario("22222222B " , "email2@email.com ", "bbb", "deportista");
				Usuario usuario3 = new Usuario("33333333C " , "email3@email.com ", "ccc", "entrenador");
				Usuario usuario4 = new Usuario("44444444D " , "email3@email.com ", "ddd", "admin");
				List<Usuario> usuarios = new ArrayList<Usuario>();
				usuarios.add(usuario1);
				usuarios.add(usuario2);
				usuarios.add(usuario3);
				usuarios.add(usuario4);

				Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

		        try(FileWriter writer = new FileWriter("login.json")){
		            prettyGson.toJson(usuarios, writer);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			}


			public static void desserializarJsonAArray() {
				try (Reader reader = new FileReader("login.json")) {
					Gson gson = new Gson();
					Type tipoListaUsuario = new TypeToken<List<Usuario>>(){}.getType();
					List<Usuario> usuarios = gson.fromJson(reader, tipoListaUsuario);

					for (int i=0; i<= usuarios.size(); i++) {
						Usuario usuario = usuarios.get(i);
						System.out.println(usuario);
					}

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			}



			public static Usuario comprobarUsuario(String nombreUsuario, String password) {

				Usuario persona = new Usuario();

			    ObjectMapper mapper = new ObjectMapper();
			       try {
					Usuario[] usuario = mapper.readValue(new File("login.json"), Usuario[].class);

					for (int i = 0; i<=usuario.length-1; i++) {

						if (nombreUsuario.equals((usuario[i].getUsuario()))){

							if(password.equals(usuario[i].getPassword())) {
								persona = usuario[i];
								return persona;
							}
						}
					}

				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			       return null;

				}

			public static Usuario comprobarUsuario2(String nombreUsuario, String nombre, String idNumber) {

						Usuario persona = new Usuario();

				       ObjectMapper mapper = new ObjectMapper();
				       try {
						Usuario[] usuario = mapper.readValue(new File("usuarios.json"), Usuario[].class);

						for (int i = 0; i<=usuario.length-1; i++) {

							if (nombreUsuario.equals((usuario[i].getUsuario()))){

								if(nombre.equals(usuario[i].getNombre())) {

									if(idNumber.equals(usuario[i].getIdNumber())) {

										persona = usuario[i];
										return persona;
								}
							}

						}
						}

					} catch (JsonParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JsonMappingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				       return null;

					}

}
*/