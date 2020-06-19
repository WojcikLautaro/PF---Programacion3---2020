package administradorDePersonajes.excepciones;

import razas.clasesNoConcretas.RazaBase;

public class PersonajeOcupadoException extends Exception {
	private RazaBase<?> personaje;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1246064252820502365L;

	public PersonajeOcupadoException(RazaBase<?> personaje) {
		super("Personaje ya existe");
		
		this.personaje = personaje;
	}

	public RazaBase<?> getPersonaje() {
		return personaje;
	}
}