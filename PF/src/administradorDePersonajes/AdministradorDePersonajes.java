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

import razas.ClasesNoConcretas.RazaBase;
import razas.ClasesNoConcretas.RazaBase.POSIBLES_CLASES;
import razas.ClasesNoConcretas.RazaBase.POSIBLES_RAZAS;

public class AdministradorDePersonajes  {
	protected HashMap<String, ArrayList<RazaBase<?>>> personajesPorUsuarios;
	
	public AdministradorDePersonajes() {
		personajesPorUsuarios = new HashMap <> ();
	}
	
	protected AdministradorDePersonajes(JSONObject json) {
		personajesPorUsuarios = fromJSONObject(json);
	}
	
	protected JSONObject toJSONObject (HashMap<String, ArrayList<RazaBase<?>>> hashMap) {
		Iterator <Entry<String, ArrayList<RazaBase<?>>>> entryIterator = hashMap.entrySet().iterator();
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
			
			catch (JSONException e) {}
			
			finally {
				personajesPorUsuarios.put(personajesPorUsuario);
			}
		}

		JSONObject wrraperObject = new JSONObject();
		
		try {
			wrraperObject.put("PersonajesPorUsuarios", personajesPorUsuarios);
		} 
		
		catch (JSONException e) {}
		
		return wrraperObject;
	}

	protected static JSONObject getJsonFromPersonaje (RazaBase<?>  personaje) {
		JSONObject personajeJson = new JSONObject();
		try {
			personajeJson.put("Nombre", 		personaje.getNick());
			personajeJson.put("NombreDeRaza", 	personaje.getNombreDeRaza());
			personajeJson.put("NombreDeClase", 	personaje.getNombreDeClase());
			personajeJson.put("Nivel", 			personaje.getLvl());
		}
			
		catch (JSONException e) {
			personajeJson = new JSONObject();
		}
			
		return personajeJson;
	}
	
	protected static JSONArray getJsonArrayFromPersonajesArray (ArrayList<RazaBase<?>>  personajes) {
		JSONArray personajesArray = new JSONArray();
		
		for(RazaBase<?> personajeAux : personajes) {
			personajesArray.put(getJsonFromPersonaje(personajeAux));
		}
		
		return personajesArray;
	}
	
	protected HashMap<String, ArrayList<RazaBase<?>>> fromJSONObject (JSONObject wrraperObject) {
		HashMap<String, ArrayList<RazaBase<?>>> auxHashMap = new HashMap <> ();
		
		JSONArray personajesPorUsuarios;
		JSONObject personajesPorUsuario;
		
		try {
			personajesPorUsuarios = wrraperObject.getJSONArray("PersonajesPorUsuarios");
			for(int i = 0; true; i++) {
				try {
					personajesPorUsuario = personajesPorUsuarios.getJSONObject(i);
					auxHashMap.put(
						personajesPorUsuario.getString("NombreDeUsuario"), 
						getPersonajesArrayFromJsonArray(personajesPorUsuario.getJSONArray("Personajes"))
					);
				} 
				
				catch (JSONException e) {
					break;
				}	
			}
		} 
		
		catch (JSONException e) {}
		
		return auxHashMap;
	}
	
	protected static ArrayList<RazaBase<?>>  getPersonajesArrayFromJsonArray (JSONArray  personajesArray) {
		ArrayList<RazaBase<?>> personajes = new ArrayList <> ();
		
		for(int o = 0; true; o++) {
			try {
				personajes.add(getPersonajeFromJson(personajesArray.getJSONObject(o)));
			} 
			
			catch (Exception e) {
				break;
			}	
		}
		
		return personajes;
	}
	
	protected static RazaBase<?> getPersonajeFromJson (JSONObject jsonObject) {
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
	
	public static AdministradorDePersonajes cargar (String nombreDeArchivo) {
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
	
	public void guardar (String nombreDeArchivo) throws IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(nombreDeArchivo));
		objectOutputStream.writeObject(toJSONObject(this.personajesPorUsuarios).toString());	
		objectOutputStream.close();
	}

	public void aniadirUsuario (String nombreDeUsuario) {
		if(!this.personajesPorUsuarios.containsKey(nombreDeUsuario)) 
			this.personajesPorUsuarios.put(nombreDeUsuario, new ArrayList <> ());
	}
	
	public void borrarUsuario (String nombreDeUsuario) {
		this.personajesPorUsuarios.remove(nombreDeUsuario);
	}
	
	public void cambiarNombreDeUsuario (String nombreDeUsuario, String nuevoNombreDeUsuario) throws Exception {
		if(this.personajesPorUsuarios.containsKey(nuevoNombreDeUsuario) || !this.personajesPorUsuarios.containsKey(nuevoNombreDeUsuario))
			throw new Exception();
		
		ArrayList<RazaBase<?>> auxPersonajes = this.personajesPorUsuarios.get(nombreDeUsuario);
		this.personajesPorUsuarios.put(nuevoNombreDeUsuario, auxPersonajes);
		this.personajesPorUsuarios.remove(nombreDeUsuario);
	}
	
	public ArrayList<RazaBase<?>> getPersonajesDeUsuario (String nombreDeUsuario) {
		return this.personajesPorUsuarios.get(nombreDeUsuario);
	}
	
	public void aniadirPersonajeAUsuario (String nombreDeUsuario, RazaBase<?> nuevoPersonaje) throws Exception {
		if(!this.personajesPorUsuarios.containsKey(nombreDeUsuario))
			aniadirUsuario(nombreDeUsuario);
		
		if(this.personajesPorUsuarios.get(nombreDeUsuario).contains(nuevoPersonaje))
			throw new Exception();
		
		this.personajesPorUsuarios.get(nombreDeUsuario).add(nuevoPersonaje);
	}
	
	public RazaBase<?> getPersonajeDeUsuario (String nombreDeUsuario, String nombreDePersonaje) throws Exception {
		if(!this.personajesPorUsuarios.containsKey(nombreDeUsuario))
			throw new Exception();
		
		for(RazaBase<?> aux : this.personajesPorUsuarios.get(nombreDeUsuario))
			if(aux.getNick().equals(nombreDePersonaje)) 
				return aux;
	
		return null;
	}
	
	public void borrarPersonajeDeUsuario (String nombreDeUsuario, RazaBase<?> personaje) throws Exception {
		if(!this.personajesPorUsuarios.containsKey(nombreDeUsuario))
			throw new Exception();
		
		this.personajesPorUsuarios.get(nombreDeUsuario).remove(personaje);
	}
	
	public void cambiarPersonajeDeUsuario (String nombreDeUsuario, RazaBase<?> personaje, RazaBase<?> nuevoPersonaje) throws Exception {
		RazaBase<?> aux = personaje;
		
		borrarPersonajeDeUsuario(nombreDeUsuario, personaje);
		
		if(this.personajesPorUsuarios.get(nombreDeUsuario).contains(nuevoPersonaje)) {
			aniadirPersonajeAUsuario(nombreDeUsuario, aux);
			throw new Exception();
		}
			
		aniadirPersonajeAUsuario(nombreDeUsuario, nuevoPersonaje);
	}
	
	@Override
	public String toString() {
		return this.personajesPorUsuarios.toString();
	}
}