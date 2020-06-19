package administradorDePersonajes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import administradorDePersonajes.excepciones.PersonajeOcupadoException;
import administradorDePersonajes.excepciones.ProblemaAlGuardarElArchivoException;
import administradorDePersonajes.excepciones.UsuarioNoRegistradoException;
import administradorDePersonajes.excepciones.UsuarioOcupadoException;
import razas.clasesNoConcretas.RazaBase;
import razas.clasesNoConcretas.RazaBase.POSIBLES_CLASES;
import razas.clasesNoConcretas.RazaBase.POSIBLES_RAZAS;

/**
 * Una clase dedicada a manejar la persistencia y administrar los personajes
 * registrados y una clave relacionada a un conjunto de ellos.
 * 
 * @author lautarowojcik
 */
public final class AdministradorDePersonajes {
	/**
	 * Metodo estatico que inicializa un {@code AdministradorDePersonajes} desde un
	 * archivo.
	 * 
	 * @param nombreDeArchivo Nombre del archivo a cargar.
	 * @return Devuelve un nuevo {@code AdministradorDePersonajes} inicializado
	 *         desde un archivo, en caso de tener un error con el archivo se
	 *         devuelve uno nuevo.
	 */
	public static AdministradorDePersonajes cargar(String nombreDeArchivo) {
		ObjectInputStream objectInputStream = null;
		AdministradorDePersonajes admin;

		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(nombreDeArchivo));

			try {
				admin = new AdministradorDePersonajes(new JSONObject((String) objectInputStream.readObject()));
			}

			catch (ClassNotFoundException | JSONException | IOException e) {
				admin = new AdministradorDePersonajes();
			}
			
			finally {
				objectInputStream.close();
			}
		}

		catch (IOException e) {
			admin = new AdministradorDePersonajes();
		}

		return admin;
	}

	/**
	 * Metodo estatico que transforma un {@code ArrayList<RazaBase<?>>} a un
	 * {@code JSONArray}
	 */
	protected static JSONArray getJsonArrayFromPersonajesArray(ArrayList<RazaBase<?>> personajes) {
		JSONArray personajesArray = new JSONArray();

		for (RazaBase<?> personajeAux : personajes) {
			personajesArray.put(getJsonFromPersonaje(personajeAux));
		}

		return personajesArray;
	}

	/**
	 * Metodo estatico que transforma un {@code RazaBase<?>} a un {@code JSONObject}
	 */
	protected static JSONObject getJsonFromPersonaje(RazaBase<?> personaje) {
		JSONObject personajeJson = new JSONObject();
		try {
			personajeJson.put("Nombre", personaje.getNick());
			personajeJson.put("NombreDeRaza", personaje.getNombreDeRaza());
			personajeJson.put("NombreDeClase", personaje.getNombreDeClase());
			personajeJson.put("Nivel", personaje.getLvl());
		}

		catch (JSONException e) {
			personajeJson = new JSONObject();
		}

		return personajeJson;
	}

	/**
	 * Metodo estatico que transforma un {@code JSONObject} a un {@code RazaBase<?>}
	 */
	protected static RazaBase<?> getPersonajeFromJson(JSONObject jsonObject) {
		RazaBase<?> personaje = null;
		try {
			RazaBase.POSIBLES_RAZAS raza = POSIBLES_RAZAS.valueOf(jsonObject.getString("NombreDeRaza"));
			RazaBase.POSIBLES_CLASES clase = POSIBLES_CLASES.valueOf(jsonObject.getString("NombreDeClase"));
			String nick = jsonObject.getString("Nombre");
			int nivel = jsonObject.getInt("Nivel");

			personaje = RazaBase.getNuevoPersonaje(raza, clase, nick, nivel);
		}

		catch (Exception e) {
			personaje = null;
		}

		return personaje;
	}

	/**
	 * Metodo estatico que transforma un {@code JSONArray} a un
	 * {@code ArrayList<RazaBase<?>>}
	 */
	protected static ArrayList<RazaBase<?>> getPersonajesArrayFromJsonArray(JSONArray personajesArray) {
		ArrayList<RazaBase<?>> personajes = new ArrayList<>();

		for (int o = 0; true; o++) {
			try {
				personajes.add(getPersonajeFromJson(personajesArray.getJSONObject(o)));
			}

			catch (Exception e) {
				break;
			}
		}

		return personajes;
	}

	protected HashMap<String, ArrayList<RazaBase<?>>> personajesPorUsuarios;

	/**
	 * Un constructor que inicializa desde cero los datos.
	 */
	public AdministradorDePersonajes() {
		personajesPorUsuarios = new HashMap<>();
	}

	/**
	 * Un constructor que carga los datos desde un {@code JSONObject}.
	 */
	protected AdministradorDePersonajes(JSONObject json) {
		personajesPorUsuarios = fromJSONObject(json);
	}

	/**
	 * Un metodo para aniadir un personaje a un usuario.
	 * 
	 * @param nombreDeUsuario Nombre de usuario al que esta relacionado el personaje
	 *                        a aniadir.
	 * @param nuevoPersonaje  personaje a ser aniadido.
	 * @throws UsuarioNoRegistradoException Devuelve una excepcion cuando el usuario no se encuentra
	 *                   registrado.
	 *                   
	 * @throws PersonajeOcupadoException Devuelve una excepcion cuando el personaje ya existe para el usuario.
	 */
	public void aniadirPersonajeAUsuario(String nombreDeUsuario, RazaBase<?> nuevoPersonaje) throws UsuarioNoRegistradoException, PersonajeOcupadoException {
		if (!getExisteUsuario(nombreDeUsuario))
			throw new UsuarioNoRegistradoException(nombreDeUsuario);

		if (getExistePersonajeEnUsuario(nombreDeUsuario, nuevoPersonaje))
			throw new PersonajeOcupadoException(nuevoPersonaje);

		getPersonajesDeUsuario(nombreDeUsuario).add(nuevoPersonaje);
	}

	/**
	 * Un metodo para registrar un nombre de usuario, si el personaje ya existe no
	 * hace nada.
	 * 
	 * @param nombreDeUsuario Nombre de usuario a registrar.
	 */
	public void aniadirUsuario(String nombreDeUsuario) {
		if (!getExisteUsuario(nombreDeUsuario))
			this.personajesPorUsuarios.put(nombreDeUsuario, new ArrayList<>());
	}

	/**
	 * Un metodo para eliminar un personaje de un usuario.
	 * 
	 * @param nombreDeUsuario Nombre de usuario al que esta relacionado el
	 *                        personaje.
	 * @param personaje       personaje a ser eliminado.
	 * @throws UsuarioNoRegistradoException Devuelve una excepcion cuando el usuario no se encuentra
	 *                   registrado.
	 */
	public void borrarPersonajeDeUsuario(String nombreDeUsuario, RazaBase<?> personaje) throws UsuarioNoRegistradoException {
		getPersonajesDeUsuario(nombreDeUsuario).remove(personaje);
	}

	/**
	 * Un metodo para eliminar un usuario, los personajes se eliminan tambien.
	 * 
	 * @param nombreDeUsuario Nombre de usuario a eliminar.
	 */
	public void borrarUsuario(String nombreDeUsuario) {
		this.personajesPorUsuarios.remove(nombreDeUsuario);
	}

	/**
	 * Un metodo para remplazar un nombre de usuario por otro, los personajes se
	 * mantienen.
	 * 
	 * @param nombreDeUsuario      Nombre de usuario a ser remplazado.
	 * @param nuevoNombreDeUsuario Nombre de usuario a remplazar.
	 * @throws UsuarioNoRegistradoException Devuelve una excepcion cuando el usuario no se encuentra
	 *                   registrado.
	 *                   
	 * @throws UsuarioOcupadoException Devuelve una excepcion cuando el nuevo nombre de usuario esta ocupado.
	 */
	public void cambiarNombreDeUsuario(String nombreDeUsuario, String nuevoNombreDeUsuario) throws UsuarioNoRegistradoException, UsuarioOcupadoException {
		if (getExisteUsuario(nuevoNombreDeUsuario))
			throw new UsuarioOcupadoException(nuevoNombreDeUsuario);

		if (!getExisteUsuario(nombreDeUsuario))
			throw new UsuarioNoRegistradoException(nombreDeUsuario);

		aniadirUsuario(nuevoNombreDeUsuario);
		setPersonajesDeUsuario(nuevoNombreDeUsuario, getPersonajesDeUsuario(nombreDeUsuario));
		borrarUsuario(nombreDeUsuario);
	}

	/**
	 * Un metodo para remplazar un personaje por otro, relacionados a un usuario.
	 * 
	 * @param nombreDeUsuario Nombre de usuario al que estan relacionados los
	 *                        personajes.
	 * @param personaje       personaje a ser remplazado.
	 * @param nuevoPersonaje  a remplazar.
	 * @throws UsuarioNoRegistradoException Devuelve una excepcion cuando el usuario no se encuentra
	 *                   registrado.
	 *                   
	 * @throws UsuarioNoRegistradoException Devuelve una excepcion cuando el personaje ya se encuentra
	 *                   registrado para el usuario.
	 */
	public void cambiarPersonajeDeUsuario(String nombreDeUsuario, RazaBase<?> personaje, RazaBase<?> nuevoPersonaje)
			throws UsuarioNoRegistradoException, PersonajeOcupadoException {
		aniadirPersonajeAUsuario(nombreDeUsuario, nuevoPersonaje);
		borrarPersonajeDeUsuario(nombreDeUsuario, personaje);
	}

	/**
	 * Un metodo para traducir un {@code JSONObject} a un
	 * {@code HashMap<String, ArrayList<RazaBase<?>>>}
	 * 
	 * @param wrraperObject un {@code JSONObject} que contenga: <blockquote>
	 *                      {@code String} Clave: "PersonajesPorUsuarios",
	 *                      {@code JSONArray} Valor: Una coleccion de
	 *                      {@code JSONObject} que contiene: <blockquote>
	 *                      {@code String} Clave: "NombreDeUsuario", {@code String}
	 *                      Valor: Nombre de usuario. {@code String} Clave:
	 *                      "Personajes", {@code JSONArray} Valor: Una coleccion de
	 *                      {@code JSONObject} que contiene: <blockquote>
	 *                      {@code String} Clave: "Nombre", {@code String} Valor:
	 *                      Nombre de personaje.
	 *                      <p>
	 *                      {@code String} Clave: "NombreDeRaza", {@code String}
	 *                      Valor: Nombre de raza.
	 *                      <p>
	 *                      {@code String} Clave: "NombreDeClase", {@code String}
	 *                      Valor: Nombre de clase.
	 *                      <p>
	 *                      {@code String} Clave: "Nivel", {@code Integer} Valor:
	 *                      Nivel de personaje.
	 *                      <p>
	 *                      </blockquote> </blockquote> </blockquote>
	 */
	protected HashMap<String, ArrayList<RazaBase<?>>> fromJSONObject(JSONObject wrraperObject) {
		HashMap<String, ArrayList<RazaBase<?>>> auxHashMap = new HashMap<>();

		JSONArray personajesPorUsuarios;
		JSONObject personajesPorUsuario;

		try {
			personajesPorUsuarios = wrraperObject.getJSONArray("PersonajesPorUsuarios");
			for (int i = 0; true; i++) {
				try {
					personajesPorUsuario = personajesPorUsuarios.getJSONObject(i);
					auxHashMap.put(personajesPorUsuario.getString("NombreDeUsuario"),
							getPersonajesArrayFromJsonArray(personajesPorUsuario.getJSONArray("Personajes")));
				}

				catch (JSONException e) {
					break;
				}
			}
		}

		catch (JSONException e) {
		}

		return auxHashMap;
	}

	/**
	 * Un metodo verificar si un personaje esta registrado en un usuario.
	 * 
	 * @param nombreDeUsuario Nombre de usuario al que esta relacionado el
	 *                        personaje.
	 * @param nuevoPersonaje  Personaje a chequear que exista.
	 * @return boolean Devuelve {@code true} o {@code true} depndindo de si encuntra
	 *         registrado el personaje o no.
	 * @throws Exception Devuelve una excepcion cuando el usuario no se encuentra
	 *                   registrado.
	 */
	public boolean getExistePersonajeEnUsuario(String nombreDeUsuario, RazaBase<?> nuevoPersonaje) {
		return this.personajesPorUsuarios.get(nombreDeUsuario).contains(nuevoPersonaje);
	}

	/**
	 * Un metodo verificar si un nombre de usuario esta registrado.
	 * 
	 * @param nombreDeUsuario Nombre de usuario que se comprueba.
	 * @return boolean Devuelve {@code true} o {@code true} depndindo de si encuntra
	 *         registrado el nombre de usuario o no.
	 */
	public boolean getExisteUsuario(String nombreDeUsuario) {
		return this.personajesPorUsuarios.containsKey(nombreDeUsuario);
	}

	/**
	 * Un metodo para recibir un {@code RazaBase<?>} personaje relacionado a un
	 * nombre de usuario y un nombre de personaje.
	 * 
	 * @param nombreDeUsuario   Nombre de usuario al que el personaje esta
	 *                          relacionado.
	 * @param nombreDePersonaje Nombre de personaje que se busca.
	 * @return RazaBase Devuelve un {@code RazaBase<?>} personaje relacionado a un
	 *         nombre de usuario o null en caso de no existir.
	 * @throws UsuarioNoRegistradoException Devuelve una excepcion cuando el usuario no se encuentra
	 *                   registrado.
	 */
	public RazaBase<?> getPersonajeDeUsuario(String nombreDeUsuario, String nombreDePersonaje) throws UsuarioNoRegistradoException {
		for (RazaBase<?> aux : getPersonajesDeUsuario(nombreDeUsuario))
			if (aux.getNick().equals(nombreDePersonaje))
				return aux;

		return null;
	}

	/**
	 * Un metodo para recibir un {@code ArrayList<RazaBase>} relacionado a un nombre
	 * de usuario.
	 * 
	 * @param nombreDeUsuario Nombre de usuario al que la lista de personajes esta
	 *                        relacionada.
	 * @return Devuelve un {@code ArrayList<RazaBase<?>>} relacionado a un nombre de
	 *         usuario.
	 * @throws UsuarioNoRegistradoException Devuelve una excepcion cuando el usuario no se encuentra
	 *                   registrado.
	 */
	public ArrayList<RazaBase<?>> getPersonajesDeUsuario(String nombreDeUsuario) throws UsuarioNoRegistradoException {
		if (!getExisteUsuario(nombreDeUsuario))
			throw new UsuarioNoRegistradoException(nombreDeUsuario);

		return this.personajesPorUsuarios.get(nombreDeUsuario);
	}

	/**
	 * Un metodo para recibir un {@code ArrayList<RazaBase<?>>} relacionado a un
	 * nombre de usuario. no devuelve una excepcion en caso de que el usuario no se
	 * encuentre registrado sino que devuelve un nuevo
	 * {@code ArrayList<RazaBase<?>>}.
	 * 
	 * @param nombreDeUsuario Nombre de usuario al que la lista de personajes esta
	 *                        relacionada.
	 * @return Devuelve un {@code ArrayList<RazaBase<?>>} relacionado a un nombre de
	 *         usuario o devuelve un nuevo {@code ArrayList<RazaBase<>>} en caso de
	 *         que no se encuentre registrado el usuario.
	 */
	public ArrayList<RazaBase<?>> getPersonajesDeUsuarioNoExepcion(String nombreDeUsuario) {
		try {
			return getPersonajesDeUsuario(nombreDeUsuario);
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	/**
	 * Un metodo para guardar guardar a un archivo la lista de personajes y los
	 * nombres de usuario relacionados.
	 * 
	 * @param nombreDeArchivo Nombre del archivo a guardar.
	 * @throws ProblemaAlGuardarElArchivoException Devuelve una excepcion cuando una ocurre un error al
	 *                   guardar el arhivo.
	 */
	public void guardar(String nombreDeArchivo) throws ProblemaAlGuardarElArchivoException {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(nombreDeArchivo));
			objectOutputStream.writeObject(toJSONObject(this.personajesPorUsuarios).toString());
			objectOutputStream.close();
		}

		catch (IOException e) {
			throw new ProblemaAlGuardarElArchivoException(e);
		}
	}

	/**
	 * Un metodo para mostrar a consola un {@code ArrayList<RazaBase<?>>}
	 * perteneciente a un usuario, mas su nombre.
	 * 
	 * @param nombreDeUsuario Nombre de usuario al que corresponde la lista de
	 *                        personajes.
	 * @throws UsuarioNoRegistradoException Devuelve una excepcion cuando el usuario no se encuentra
	 *                   registrado.
	 */
	public void mostrarPersonajesDeUsuario(String nombreDeUsuario) throws UsuarioNoRegistradoException {
		System.out.println("Nombre de usuario: " + nombreDeUsuario);

		for (RazaBase<?> aux : getPersonajesDeUsuario(nombreDeUsuario)) {
			System.out.println(aux);
		}
	}

	/**
	 * Metodo para setear un {@code ArrayList<RazaBase<?>>} a un nombre de usuario.
	 * 
	 * @param nombreDeUsuario  Nombre de usuario al que corresponde la lista de
	 *                         personajes.
	 * @param nuevosPersonajes Lista de personajes que setear al usuario.
	 * @throws UsuarioNoRegistradoException Devuelve una excepcion cuando el usuario no se encuentra
	 *                   registrado.
	 */
	public void setPersonajesDeUsuario(String nombreDeUsuario, ArrayList<RazaBase<?>> nuevosPersonajes)
			throws UsuarioNoRegistradoException {
		if (!getExisteUsuario(nombreDeUsuario))
			throw new UsuarioNoRegistradoException(nombreDeUsuario);

		this.personajesPorUsuarios.put(nombreDeUsuario, nuevosPersonajes);
	}

	/**
	 * Un metodo para traducir un {@code HashMap<String, ArrayList<RazaBase<?>>>} a
	 * un {@code JSONObject}
	 * 
	 * @param hashMap {@code HashMap<String, ArrayList<RazaBase<?>>>} Contiene cada
	 *                nombre de usuario relacionado a un
	 *                {@code ArrayList<RazaBase<?>>} que contiene sus personajes.
	 * @return Devulve un {@code JSONObject} que contiene: <blockquote>
	 *         {@code String} Clave: "PersonajesPorUsuarios", {@code JSONArray}
	 *         Valor: Una coleccion de {@code JSONObject} que contiene: <blockquote>
	 *         {@code String} Clave: "NombreDeUsuario", {@code String} Valor: Nombre
	 *         de usuario. {@code String} Clave: "Personajes", {@code JSONArray}
	 *         Valor: Una coleccion de {@code JSONObject} que contiene: <blockquote>
	 *         {@code String} Clave: "Nombre", {@code String} Valor: Nombre de
	 *         personaje.
	 *         <p>
	 *         {@code String} Clave: "NombreDeRaza", {@code String} Valor: Nombre de
	 *         raza.
	 *         <p>
	 *         {@code String} Clave: "NombreDeClase", {@code String} Valor: Nombre
	 *         de clase.
	 *         <p>
	 *         {@code String} Clave: "Nivel", {@code Integer} Valor: Nivel de
	 *         personaje.
	 *         <p>
	 *         </blockquote> </blockquote> </blockquote>
	 */
	protected JSONObject toJSONObject(HashMap<String, ArrayList<RazaBase<?>>> hashMap) {
		Iterator<Entry<String, ArrayList<RazaBase<?>>>> entryIterator = hashMap.entrySet().iterator();
		Entry<String, ArrayList<RazaBase<?>>> auxEntry = null;

		JSONArray personajesPorUsuarios = new JSONArray();
		JSONObject personajesPorUsuario;

		while (entryIterator.hasNext()) {
			auxEntry = entryIterator.next();

			personajesPorUsuario = new JSONObject();

			try {
				personajesPorUsuario.put("Personajes", getJsonArrayFromPersonajesArray(auxEntry.getValue()));
				personajesPorUsuario.put("NombreDeUsuario", auxEntry.getKey());
			}

			catch (JSONException e) {
			}

			finally {
				personajesPorUsuarios.put(personajesPorUsuario);
			}
		}

		JSONObject wrraperObject = new JSONObject();

		try {
			wrraperObject.put("PersonajesPorUsuarios", personajesPorUsuarios);
		}

		catch (JSONException e) {
		}

		return wrraperObject;
	}

	/**
	 * Override del metodo {@code toString}
	 * 
	 * @return Devulve un {@code String} que contiene cada usuario y su
	 *         {@code ArrayList<RazaBase<?>>} correspondiente.
	 */
	@Override
	public String toString() {
		return this.personajesPorUsuarios.toString();
	}
}