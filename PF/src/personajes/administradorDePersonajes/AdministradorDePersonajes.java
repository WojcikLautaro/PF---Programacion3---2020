package personajes.administradorDePersonajes;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import personajes.administradorDePersonajes.excepciones.PersonajeOcupadoException;
import personajes.administradorUsuariosParaPersonajes.interfaces.UsuarioNoRegistradoException;
import personajes.razas.clasesNoConcretas.RazaBase;

/**
 * Una clase dedicada a administrar un conjunto de personajes registrados y una
 * clave relacionada a un conjunto de ellos.
 * 
 * @author lautarowojcik
 */
public final class AdministradorDePersonajes {
	/**
	 * Metodo estatico que transforma un {@code JSONArray} a un
	 * {@code AdministradorDePersonajes}
	 */
	public static AdministradorDePersonajes fromJSONArray(JSONArray personajesArray) {
		ArrayList<RazaBase<?>> personajes = new ArrayList<>();
		try {
			for (int i = 0; true; i++) {
				personajes.add(RazaBase.fromJSONObject(personajesArray.getJSONObject(i)));
			}
		}
		
		catch (JSONException e) {
		}
		
		return new AdministradorDePersonajes(personajes);
	}

	protected ArrayList<RazaBase<?>> personajes;

	/**
	 * Un constructor que inicializa desde cero los datos.
	 */
	public AdministradorDePersonajes() {
		personajes = new ArrayList<>();
	}

	/**
	 * Un constructor que inicializa con datos.
	 */
	public AdministradorDePersonajes(ArrayList<RazaBase<?>> personajes) {
		this.personajes = personajes;
	}

	/**
	 * Un metodo para aniadir un personaje.
	 * 
	 * @param nuevoPersonaje personaje a ser aniadido.
	 * @throws PersonajeOcupadoException Devuelve una excepcion cuando el personaje
	 *                                   ya existe para el usuario.
	 */
	public void aniadirPersonaje(RazaBase<?> nuevoPersonaje) throws PersonajeOcupadoException {
		if (getExistePersonaje(nuevoPersonaje))
			throw new PersonajeOcupadoException(nuevoPersonaje);

		this.personajes.add(nuevoPersonaje);
	}

	/**
	 * Un metodo para eliminar un personaje de un usuario.
	 * 
	 * @param personaje personaje a ser eliminado.
	 */
	public void borrarPersonaje(RazaBase<?> personaje) {
		this.personajes.remove(personaje);
	}

	/**
	 * Un metodo para remplazar un personaje por otro.
	 * 
	 * @param personaje      personaje a ser remplazado.
	 * @param nuevoPersonaje a remplazar.
	 * @throws UsuarioNoRegistradoException Devuelve una excepcion cuando el usuario
	 *                                      no se encuentra registrado.
	 */
	public void cambiarPersonaje(RazaBase<?> personaje, RazaBase<?> nuevoPersonaje) throws PersonajeOcupadoException {
		aniadirPersonaje(nuevoPersonaje);
		borrarPersonaje(personaje);
	}

	/**
	 * Un metodo verificar si un personaje esta registrado en un usuario.
	 * 
	 * @param personaje Personaje a chequear que exista.
	 * @return boolean Devuelve {@code true} o {@code true} depndindo de si encuntra
	 *         registrado el personaje o no.
	 */
	public boolean getExistePersonaje(RazaBase<?> personaje) {
		return this.personajes.contains(personaje);
	}

	/**
	 * Un metodo para recibir un {@code RazaBase<?>} personaje relacionado a un
	 * nombre de personaje.
	 * 
	 * @param nombreDePersonaje Nombre de personaje que se busca.
	 * @return RazaBase Devuelve un {@code RazaBase<?>} personaje relacionado a un
	 *         nombre de usuario o null en caso de no existir.
	 */
	public RazaBase<?> getPersonaje(String nombreDePersonaje) {
		for (RazaBase<?> aux : this.getPersonajes())
			if (aux.getNick().equals(nombreDePersonaje))
				return aux;

		return null;
	}

	/**
	 * Metodo para getear un {@code ArrayList<RazaBase<?>>}.
	 * 
	 * @return Lista de personajes que actual.
	 */
	public ArrayList<RazaBase<?>> getPersonajes() {
		return this.personajes;
	}

	/**
	 * Metodo para setear un {@code ArrayList<RazaBase<?>>}.
	 * 
	 * @param nuevosPersonajes Lista de personajes que setear.
	 */
	public void setPersonajes(ArrayList<RazaBase<?>> nuevosPersonajes) {
		this.personajes = nuevosPersonajes;
	}

	/**
	 * Metodo que transforma un {@code AdministradorDePersonajes} a un
	 * {@code JSONArray}
	 */
	public JSONArray toJSONArray() {
		JSONArray personajesArray = new JSONArray();

		for (RazaBase<?> personajeAux : getPersonajes()) {
			personajesArray.put(personajeAux.toJSONObject());
		}

		return personajesArray;
	}

	@Override
	public String toString() {
		StringBuilder psjs = new StringBuilder();

		for (RazaBase<?> aux : getPersonajes()) {
			psjs.append(aux.toString() + "\n");
		}

		return psjs.toString();
	}
}