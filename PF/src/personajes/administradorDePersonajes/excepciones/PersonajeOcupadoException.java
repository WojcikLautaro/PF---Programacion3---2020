package personajes.administradorDePersonajes.excepciones;

import personajes.razas.clasesNoConcretas.RazaBase;

public class PersonajeOcupadoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1246064252820502365L;

	private RazaBase<?> personaje;

	public PersonajeOcupadoException(RazaBase<?> personaje) {
		super("Personaje ya existe.\n");

		this.personaje = personaje;
	}

	public RazaBase<?> getPersonaje() {
		return personaje;
	}
}