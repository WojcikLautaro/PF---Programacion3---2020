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

import razas.clasesNoConcretas.RazaBase;
import razas.clasesNoConcretas.RazaBase.POSIBLES_CLASES;
import razas.clasesNoConcretas.RazaBase.POSIBLES_RAZAS;

public final class AdministradorDePersonajes {
	public static AdministradorDePersonajes cargar(String nombreDeArchivo) {
		ObjectInputStream objectInputStream = null;
		AdministradorDePersonajes admin;

		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(nombreDeArchivo));

			try {
				admin = new AdministradorDePersonajes(new JSONObject((String) objectInputStream.readObject()));
				objectInputStream.close();
			}

			catch (ClassNotFoundException | JSONException | IOException e) {
				admin = new AdministradorDePersonajes();
			}
		}

		catch (IOException e) {
			admin = new AdministradorDePersonajes();
		}

		return admin;
	}

	protected static JSONArray getJsonArrayFromPersonajesArray(ArrayList<RazaBase<?>> personajes) {
		JSONArray personajesArray = new JSONArray();

		for (RazaBase<?> personajeAux : personajes) {
			personajesArray.put(getJsonFromPersonaje(personajeAux));
		}

		return personajesArray;
	}

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

	public AdministradorDePersonajes() {
		personajesPorUsuarios = new HashMap<>();
	}

	protected AdministradorDePersonajes(JSONObject json) {
		personajesPorUsuarios = fromJSONObject(json);
	}

	public void añadirPersonajeAUsuario(String nombreDeUsuario, RazaBase<?> nuevoPersonaje) throws Exception {
		if (!getExisteUsuario(nombreDeUsuario))
			throw new Exception("Usuario no existente");

		if (getExistePersonajeEnUsuario(nombreDeUsuario, nuevoPersonaje))
			throw new Exception("Personaje ya existe");

		getPersonajesDeUsuarioNoExepcion(nombreDeUsuario).add(nuevoPersonaje);
	}

	public void añadirUsuario(String nombreDeUsuario) {
		if (!getExisteUsuario(nombreDeUsuario))
			this.personajesPorUsuarios.put(nombreDeUsuario, new ArrayList<>());
	}

	public void borrarPersonajeDeUsuario(String nombreDeUsuario, RazaBase<?> personaje) throws Exception {
		getPersonajesDeUsuario(nombreDeUsuario).remove(personaje);
	}

	public void borrarUsuario(String nombreDeUsuario) {
		this.personajesPorUsuarios.remove(nombreDeUsuario);
	}

	public void cambiarNombreDeUsuario(String nombreDeUsuario, String nuevoNombreDeUsuario) throws Exception {
		if (getExisteUsuario(nuevoNombreDeUsuario) || !getExisteUsuario(nombreDeUsuario))
			throw new Exception();

		añadirUsuario(nuevoNombreDeUsuario);
		setPersonajesDeUsuario(nuevoNombreDeUsuario, getPersonajesDeUsuario(nombreDeUsuario));
		borrarUsuario(nombreDeUsuario);
	}

	public void cambiarPersonajeDeUsuario(String nombreDeUsuario, RazaBase<?> personaje, RazaBase<?> nuevoPersonaje)
			throws Exception {
		añadirPersonajeAUsuario(nombreDeUsuario, nuevoPersonaje);
		borrarPersonajeDeUsuario(nombreDeUsuario, personaje);
	}

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

	public boolean getExistePersonajeEnUsuario(String nombreDeUsuario, RazaBase<?> nuevoPersonaje) {
		return this.personajesPorUsuarios.get(nombreDeUsuario).contains(nuevoPersonaje);
	}

	public boolean getExisteUsuario(String nombreDeUsuario) {
		return this.personajesPorUsuarios.containsKey(nombreDeUsuario);
	}

	public RazaBase<?> getPersonajeDeUsuario(String nombreDeUsuario, String nombreDePersonaje) throws Exception {
		for (RazaBase<?> aux : getPersonajesDeUsuario(nombreDeUsuario))
			if (aux.getNick().equals(nombreDePersonaje))
				return aux;

		return null;
	}

	public ArrayList<RazaBase<?>> getPersonajesDeUsuario(String nombreDeUsuario) throws Exception {
		if (!getExisteUsuario(nombreDeUsuario))
			throw new Exception("Usuario no existente");

		return this.personajesPorUsuarios.get(nombreDeUsuario);
	}

	public ArrayList<RazaBase<?>> getPersonajesDeUsuarioNoExepcion(String nombreDeUsuario) {
		try {
			return getPersonajesDeUsuario(nombreDeUsuario);
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	public void guardar(String nombreDeArchivo) throws IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(nombreDeArchivo));
		objectOutputStream.writeObject(toJSONObject(this.personajesPorUsuarios).toString());
		objectOutputStream.close();
	}

	public void mostrarPersonajesDeUsuario(String nombreDeUsuario) throws Exception {
		System.out.println("Nombre de usuario: " + nombreDeUsuario);

		for (RazaBase<?> aux : getPersonajesDeUsuario(nombreDeUsuario)) {
			System.out.println(aux);
		}
	}

	public void setPersonajesDeUsuario(String nombreDeUsuario, ArrayList<RazaBase<?>> nuevosPersonajes)
			throws Exception {
		if (!getExisteUsuario(nombreDeUsuario))
			throw new Exception("Usuario no existente");

		this.personajesPorUsuarios.put(nombreDeUsuario, nuevosPersonajes);
	}

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

	@Override
	public String toString() {
		return this.personajesPorUsuarios.toString();
	}
}