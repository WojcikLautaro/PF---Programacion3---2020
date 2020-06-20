package personajes.administradorUsuariosParaPersonajes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import personajes.administradorDePersonajes.AdministradorDePersonajes;
import personajes.administradorUsuariosParaPersonajes.interfaces.ProblemaAlGuardarElArchivoException;
import personajes.administradorUsuariosParaPersonajes.interfaces.UsuarioNoRegistradoException;
import personajes.administradorUsuariosParaPersonajes.interfaces.UsuarioOcupadoException;

/**
 * Una clase dedicada a manejar la persistencia y administrar los usuarios
 * registrados y una clave relacionada a un conjunto de ellos.
 * 
 * @author lautarowojcik
 */
public class AdministradorDeUsuariosParaPersonajes {
	/**
	 * Metodo estatico que inicializa un
	 * {@code AdministradorDeUsuariosParaPersonajes} desde un archivo.
	 * 
	 * @param nombreDeArchivo Nombre del archivo a cargar.
	 * @return Devuelve un nuevo {@code AdministradorDeUsuariosParaPersonajes}
	 *         inicializado desde un archivo, en caso de tener un error con el
	 *         archivo se devuelve uno nuevo.
	 */
	public static AdministradorDeUsuariosParaPersonajes cargar(String nombreDeArchivo) {
		ObjectInputStream objectInputStream = null;
		AdministradorDeUsuariosParaPersonajes admin;

		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(nombreDeArchivo));

			try {
				admin = fromJSONObject(new JSONObject((String) objectInputStream.readObject()));
			}

			catch (ClassNotFoundException | JSONException | IOException e) {
				admin = new AdministradorDeUsuariosParaPersonajes();
			}

			finally {
				objectInputStream.close();
			}
		}

		catch (IOException e) {
			admin = new AdministradorDeUsuariosParaPersonajes();
		}

		return admin;
	}

	/**
	 * Un metodo estatico para traducir un {@code JSONObject} a un
	 * {@code AdministradorDeUsuariosParaPersonajes}
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
	public static AdministradorDeUsuariosParaPersonajes fromJSONObject(JSONObject wrraperObject) {
		HashMap<String, AdministradorDePersonajes> auxHashMap = new HashMap<>();

		JSONArray personajesPorUsuarios;
		JSONObject personajesPorUsuario;

		try {
			personajesPorUsuarios = wrraperObject.getJSONArray("PersonajesPorUsuarios");
			try {
				for (int i = 0; true; i++) {
					personajesPorUsuario = personajesPorUsuarios.getJSONObject(i);
					auxHashMap.put(personajesPorUsuario.getString("NombreDeUsuario"),
							AdministradorDePersonajes.fromJSONArray(personajesPorUsuario.getJSONArray("Personajes")));
				}
			}
			catch (JSONException e) { }
		}

		catch (JSONException e) {
			return new AdministradorDeUsuariosParaPersonajes();
		}

		return new AdministradorDeUsuariosParaPersonajes(auxHashMap);
	}

	protected HashMap<String, AdministradorDePersonajes> personajesPorUsuarios;

	/**
	 * Un constructor que inicializa desde cero los datos.
	 */
	public AdministradorDeUsuariosParaPersonajes() {
		this.personajesPorUsuarios = new HashMap<>();
	}

	/**
	 * Un constructor que carga los datos desde un
	 * {@code HashMap <String, AdministradorDePersonajes>}.
	 */
	public AdministradorDeUsuariosParaPersonajes(HashMap<String, AdministradorDePersonajes> personajesPorUsuarios) {
		this.personajesPorUsuarios = personajesPorUsuarios;
	}

	/**
	 * Un metodo para registrar un nombre de usuario, si el personaje ya existe no
	 * hace nada.
	 * 
	 * @param nombreDeUsuario Nombre de usuario a registrar.
	 */
	public void aniadirUsuario(String nombreDeUsuario) {
		if (!getExisteUsuario(nombreDeUsuario))
			this.personajesPorUsuarios.put(nombreDeUsuario, new AdministradorDePersonajes());
	}

	/**
	 * Un metodo para eliminar un usuario, los datos asociados se eliminan tambien.
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
	 * @throws UsuarioNoRegistradoException Devuelve una excepcion cuando el usuario
	 *                                      no se encuentra registrado.
	 * 
	 * @throws UsuarioOcupadoException      Devuelve una excepcion cuando el nuevo
	 *                                      nombre de usuario esta ocupado.
	 */
	public void cambiarNombreDeUsuario(String nombreDeUsuario, String nuevoNombreDeUsuario)
			throws UsuarioNoRegistradoException, UsuarioOcupadoException {
		if (getExisteUsuario(nuevoNombreDeUsuario))
			throw new UsuarioOcupadoException(nuevoNombreDeUsuario);

		if (!getExisteUsuario(nombreDeUsuario))
			throw new UsuarioNoRegistradoException(nombreDeUsuario);

		aniadirUsuario(nuevoNombreDeUsuario);
		setAdministradorDePersonajesDeUsuario(nuevoNombreDeUsuario,
				getAdministradorDePersonajesDeUsuario(nombreDeUsuario));
		borrarUsuario(nombreDeUsuario);
	}

	/**
	 * Un metodo para getear el {@code AdministradorDePersonajes} de un usuario.
	 * 
	 * @param nombreDeUsuario Nombre de usuario al que el
	 *                        {@code AdministradorDePersonajes} esta relacionado.
	 * @throws UsuarioNoRegistradoException Devuelve una excepcion cuando el nombre
	 *                                      de usuario no esta registrado.
	 */
	public AdministradorDePersonajes getAdministradorDePersonajesDeUsuario(String nombreDeUsuario)
			throws UsuarioNoRegistradoException {
		if (!getExisteUsuario(nombreDeUsuario))
			throw new UsuarioNoRegistradoException(nombreDeUsuario);

		return this.personajesPorUsuarios.get(nombreDeUsuario);
	}

	/**
	 * Un metodo para recibir un {@code AdministradorDePersonajes} relacionado a un
	 * nombre de usuario. no devuelve una excepcion en caso de que el usuario no se
	 * encuentre registrado sino que devuelve un nuevo
	 * {@code AdministradorDePersonajes}.
	 * 
	 * @param nombreDeUsuario Nombre de usuario al que el
	 *                        {@code AdministradorDePersonajes} esta relacionado.
	 * @return Devuelve un {@code AdministradorDePersonajes} relacionado a un nombre
	 *         de usuario o devuelve uno nuevo en caso de que no se encuentre
	 *         registrado el usuario.
	 */
	public AdministradorDePersonajes getAdministradorDePersonajesDeUsuarioNoExepcion(String nombreDeUsuario) {
		try {
			return getAdministradorDePersonajesDeUsuario(nombreDeUsuario);
		} catch (Exception e) {
			return new AdministradorDePersonajes();
		}
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
	 * Un metodo para guardar guardar a un archivo la lista de personajes y los
	 * nombres de usuario relacionados.
	 * 
	 * @param nombreDeArchivo Nombre del archivo a guardar.
	 * @throws ProblemaAlGuardarElArchivoException Devuelve una excepcion cuando una
	 *                                             ocurre un error al guardar el
	 *                                             arhivo.
	 */
	public void guardar(String nombreDeArchivo) throws ProblemaAlGuardarElArchivoException {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(nombreDeArchivo));
			objectOutputStream.writeObject(toJSONObject().toString());
			objectOutputStream.close();
		}

		catch (IOException e) {
			throw new ProblemaAlGuardarElArchivoException(e);
		}
	}

	/**
	 * Un metodo para setear el {@code AdministradorDePersonajes} de un usuario.
	 * 
	 * @param nombreDeUsuario Nombre de usuario al que el
	 *                        {@code AdministradorDePersonajes} esta relacionado.
	 * @throws UsuarioNoRegistradoException Devuelve una excepcion cuando el nombre
	 *                                      de usuario no esta registrado.
	 */
	public void setAdministradorDePersonajesDeUsuario(String nombreDeUsuario,
			AdministradorDePersonajes nuevoAdministradorDePersonajes) throws UsuarioNoRegistradoException {
		if (!getExisteUsuario(nombreDeUsuario))
			throw new UsuarioNoRegistradoException(nombreDeUsuario);

		this.personajesPorUsuarios.put(nombreDeUsuario, nuevoAdministradorDePersonajes);
	}

	/**
	 * Un metodo para traducir un {@code HashMap<String, AdministradorDePersonajes>}
	 * a un {@code JSONObject}
	 * 
	 * @param hashMap {@code HashMap<String, AdministradorDePersonajes>} Contiene
	 *                cada nombre de usuario relacionado a un
	 *                {@code AdministradorDePersonajes} que contiene sus personajes.
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
	protected JSONObject toJSONObject() {
		Iterator<Entry<String, AdministradorDePersonajes>> entryIterator = this.personajesPorUsuarios.entrySet()
				.iterator();
		Entry<String, AdministradorDePersonajes> auxEntry = null;

		JSONArray personajesPorUsuarios = new JSONArray();
		JSONObject personajesPorUsuario;

		while (entryIterator.hasNext()) {
			auxEntry = entryIterator.next();

			personajesPorUsuario = new JSONObject();

			try {
				personajesPorUsuario.put("Personajes", auxEntry.getValue().toJSONArray());
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
		StringBuilder psjs = new StringBuilder();
		Iterator<Entry<String, AdministradorDePersonajes>> entryIterator = this.personajesPorUsuarios.entrySet()
				.iterator();
		Entry<String, AdministradorDePersonajes> auxEntry = null;

		while (entryIterator.hasNext()) {
			auxEntry = entryIterator.next();

			psjs.append(auxEntry.getKey().toString() + ":\n");
			psjs.append(auxEntry.getValue().toString() + "\n");
		}

		return psjs.toString();
	}
}
