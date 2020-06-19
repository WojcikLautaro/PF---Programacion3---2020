package razas.clasesNoConcretas;

import java.util.ArrayList;

import atributosDeRazaYClase.Atributes;
import atributosDeRazaYClase.AtributosBase;
import clases.clasesConcretas.Brujo;
import clases.clasesConcretas.Cazador;
import clases.clasesConcretas.Druida;
import clases.clasesConcretas.Guerrero;
import clases.clasesConcretas.Mago;
import clases.clasesConcretas.Paladin;
import clases.clasesConcretas.Picaro;
import clases.clasesConcretas.Sacerdote;
import clases.habilidades.Habilidad;
import clases.interfaces.ClaseBase;
import clases.recursos.Recursos;
import razas.clasesConcretas.Draenel;
import razas.clasesConcretas.Elfo;
import razas.clasesConcretas.Enano;
import razas.clasesConcretas.Goblin;
import razas.clasesConcretas.Humano;
import razas.clasesConcretas.NoMuerto;
import razas.clasesConcretas.Orco;
import razas.clasesConcretas.Trol;
import razas.excepciones.ClaseNoAceptadaParaRazaException;

/**
 * Clase base que se usa para describir la funcionalidad de un personaje y un
 * conjunto de funciones fabrica y enums para facilitar la creacion de estos.
 * 
 * @author lautarowojcik
 */
public abstract class RazaBase<T extends ClaseBase> {
	/**
	 * Alianzas posibles.
	 */
	public static enum POSIBLES_ALIANZAS {
		EXILIADOS, GUARDIANES, SIN_ALIANZA
	}

	/**
	 * Clases posibles.
	 */
	public static enum POSIBLES_CLASES {
		GUERRERO, PALADIN, CAZADOR, PICARO, SACERDOTE, MAGO, BRUJO, DRUIDA, SIN_CLASE;
	}

	/**
	 * Razas posibles.
	 */
	public static enum POSIBLES_RAZAS {
		ORCO, NOMUERTO, TROL, GOBLIN, HUMANO, ELFO, ENANO, DRAENEL, SIN_RAZA
	}

	/**
	 * Razas que pertenecen a la alianza exiliada.
	 */
	public static enum RAZAS_EXILIADAS {
		ORCO, NOMUERTO, TROL, GOBLIN
	}

	/**
	 * Razas que pertenecen a la alianza guardiana.
	 */
	public static enum RAZAS_GUARDIANAS {
		HUMANO, ELFO, ENANO, DRAENEL
	}

	/**
	 * Metodo para facilitar la creacion de personajes.
	 * 
	 * @param raza  Raza que va a ser el personaje, una de las especificadas en
	 *              {@code POSIBLES_RAZAS}.
	 * @param clase Clase que va a ser el personaje, una de las especificadas en
	 *              {@code POSIBLES_CLASES}.
	 * @param nick  Nombre que va a tener el personaje.
	 * @throws ClaseNoAceptadaParaRazaException Devuelve una excepcion en caso de que la clase del
	 *                   personaje no sea correspondiente a la raza.
	 * @return Un personaje terminado.
	 */
	public final static RazaBase<?> getNuevoPersonaje(POSIBLES_RAZAS raza, POSIBLES_CLASES clase, String nick)
			throws ClaseNoAceptadaParaRazaException {
		return getNuevoPersonaje(raza, clase, nick, 0);
	}

	/**
	 * Metodo para facilitar la creacion de personajes.
	 * 
	 * @param raza  Raza que va a ser el personaje, una de las especificadas en
	 *              {@code POSIBLES_RAZAS}.
	 * @param clase Clase que va a ser el personaje, una de las especificadas en
	 *              {@code POSIBLES_CLASES}.
	 * @param nick  Nombre que va a tener el personaje.
	 * @param nivel Nivel que va a tener el personaje.
	 * @throws ClaseNoAceptadaParaRazaException Devuelve una excepcion en caso de que la clase del
	 *                   personaje no sea correspondiente a la raza.
	 * @return Un personaje terminado.
	 */
	public final static RazaBase<?> getNuevoPersonaje(POSIBLES_RAZAS raza, POSIBLES_CLASES clase, String nick,
			int nivel) throws ClaseNoAceptadaParaRazaException {
		switch (raza) {
		case ORCO:
			switch (clase) {
			case GUERRERO:
				return new Orco<>(nick, new Guerrero(), nivel);
			case PALADIN:
				return new Orco<>(nick, new Paladin(), nivel);
			case CAZADOR:
				return new Orco<>(nick, new Cazador(), nivel);
			case PICARO:
				return new Orco<>(nick, new Picaro(), nivel);
			case SACERDOTE:
				return new Orco<>(nick, new Sacerdote(), nivel);
			case MAGO:
				return new Orco<>(nick, new Mago(), nivel);
			case BRUJO:
				return new Orco<>(nick, new Brujo(), nivel);
			case DRUIDA:
				return new Orco<>(nick, new Druida(), nivel);

			default:
				break;
			}

		case NOMUERTO:
			switch (clase) {
			case GUERRERO:
				return new NoMuerto<>(nick, new Guerrero(), nivel);
			case PALADIN:
				return new NoMuerto<>(nick, new Paladin(), nivel);
			case CAZADOR:
				return new NoMuerto<>(nick, new Cazador(), nivel);
			case PICARO:
				return new NoMuerto<>(nick, new Picaro(), nivel);
			case SACERDOTE:
				return new NoMuerto<>(nick, new Sacerdote(), nivel);
			case MAGO:
				return new NoMuerto<>(nick, new Mago(), nivel);
			case BRUJO:
				return new NoMuerto<>(nick, new Brujo(), nivel);
			case DRUIDA:
				return new NoMuerto<>(nick, new Druida(), nivel);

			default:
				break;
			}

		case TROL:
			switch (clase) {
			case GUERRERO:
				return new Trol<>(nick, new Guerrero(), nivel);
			case PALADIN:
				return new Trol<>(nick, new Paladin(), nivel);
			case CAZADOR:
				return new Trol<>(nick, new Cazador(), nivel);
			case PICARO:
				return new Trol<>(nick, new Picaro(), nivel);
			case SACERDOTE:
				return new Trol<>(nick, new Sacerdote(), nivel);
			case MAGO:
				return new Trol<>(nick, new Mago(), nivel);
			case BRUJO:
				return new Trol<>(nick, new Brujo(), nivel);
			case DRUIDA:
				return new Trol<>(nick, new Druida(), nivel);

			default:
				break;
			}

		case GOBLIN:
			switch (clase) {
			case GUERRERO:
				return new Goblin<>(nick, new Guerrero(), nivel);
			case PALADIN:
				return new Goblin<>(nick, new Paladin(), nivel);
			case CAZADOR:
				return new Goblin<>(nick, new Cazador(), nivel);
			case PICARO:
				return new Goblin<>(nick, new Picaro(), nivel);
			case SACERDOTE:
				return new Goblin<>(nick, new Sacerdote(), nivel);
			case MAGO:
				return new Goblin<>(nick, new Mago(), nivel);
			case BRUJO:
				return new Goblin<>(nick, new Brujo(), nivel);
			case DRUIDA:
				return new Goblin<>(nick, new Druida(), nivel);

			default:
				break;
			}

		case HUMANO:
			switch (clase) {
			case GUERRERO:
				return new Humano<>(nick, new Guerrero(), nivel);
			case PALADIN:
				return new Humano<>(nick, new Paladin(), nivel);
			case CAZADOR:
				return new Humano<>(nick, new Cazador(), nivel);
			case PICARO:
				return new Humano<>(nick, new Picaro(), nivel);
			case SACERDOTE:
				return new Humano<>(nick, new Sacerdote(), nivel);
			case MAGO:
				return new Humano<>(nick, new Mago(), nivel);
			case BRUJO:
				return new Humano<>(nick, new Brujo(), nivel);
			case DRUIDA:
				return new Humano<>(nick, new Druida(), nivel);

			default:
				break;
			}

		case ELFO:
			switch (clase) {
			case GUERRERO:
				return new Elfo<>(nick, new Guerrero(), nivel);
			case PALADIN:
				return new Elfo<>(nick, new Paladin(), nivel);
			case CAZADOR:
				return new Elfo<>(nick, new Cazador(), nivel);
			case PICARO:
				return new Elfo<>(nick, new Picaro(), nivel);
			case SACERDOTE:
				return new Elfo<>(nick, new Sacerdote(), nivel);
			case MAGO:
				return new Elfo<>(nick, new Mago(), nivel);
			case BRUJO:
				return new Elfo<>(nick, new Brujo(), nivel);
			case DRUIDA:
				return new Elfo<>(nick, new Druida(), nivel);

			default:
				break;
			}

		case ENANO:
			switch (clase) {
			case GUERRERO:
				return new Enano<>(nick, new Guerrero(), nivel);
			case PALADIN:
				return new Enano<>(nick, new Paladin(), nivel);
			case CAZADOR:
				return new Enano<>(nick, new Cazador(), nivel);
			case PICARO:
				return new Enano<>(nick, new Picaro(), nivel);
			case SACERDOTE:
				return new Enano<>(nick, new Sacerdote(), nivel);
			case MAGO:
				return new Enano<>(nick, new Mago(), nivel);
			case BRUJO:
				return new Enano<>(nick, new Brujo(), nivel);
			case DRUIDA:
				return new Enano<>(nick, new Druida(), nivel);

			default:
				break;
			}

		case DRAENEL:
			switch (clase) {
			case GUERRERO:
				return new Draenel<>(nick, new Guerrero(), nivel);
			case PALADIN:
				return new Draenel<>(nick, new Paladin(), nivel);
			case CAZADOR:
				return new Draenel<>(nick, new Cazador(), nivel);
			case PICARO:
				return new Draenel<>(nick, new Picaro(), nivel);
			case SACERDOTE:
				return new Draenel<>(nick, new Sacerdote(), nivel);
			case MAGO:
				return new Draenel<>(nick, new Mago(), nivel);
			case BRUJO:
				return new Draenel<>(nick, new Brujo(), nivel);
			case DRUIDA:
				return new Draenel<>(nick, new Druida(), nivel);

			default:
				break;
			}

		default:
			return null;
		}
	}

	/**
	 * Alianza a la que va a pertenecer el personaje.
	 */
	protected POSIBLES_ALIANZAS alianza;

	/**
	 * Raza a la que va a pertenecer el personaje.
	 */
	protected POSIBLES_RAZAS raza;

	/**
	 * Clase a la que va a pertenecer el personaje.
	 */
	protected POSIBLES_CLASES clase;

	/**
	 * Descripcion del personaje.
	 */
	protected String characterDescription;

	/**
	 * Nombre del personaje.
	 */
	protected String nick;

	/**
	 * Nivel del personaje.
	 */
	protected Integer lvl;

	/**
	 * Racursos del personaje.
	 */
	protected Recursos resources;

	/**
	 * Atributos del personaje.
	 */
	protected Atributes atributes;

	/**
	 * Habilidades del personaje.
	 */
	protected ArrayList<Habilidad> habilidades;

	/**
	 * @param nickname: el nombre del nuevo personaje.
	 * @param clase:    la clase del nuevo personaje.
	 * @throws ClaseNoAceptadaParaRazaException Devuelve una excepcion en caso de que la clase del
	 *                   personaje no sea correspondiente a la raza.
	 */
	public RazaBase(String nickname, T clase) throws ClaseNoAceptadaParaRazaException {
		if (getEsUnaClaseAceptada(clase.getEnumDeClase()))
			this.clase = clase.getEnumDeClase();
		else
			throw new ClaseNoAceptadaParaRazaException(clase);

		this.atributes = new Atributes(getBaseAtributesFromRace(), clase.getMultiplicadorDeAtributosDeClase());

		this.resources = clase.getClassResources();
		this.habilidades = new ArrayList<>(clase.getClassAbilities());

		this.raza = getEnumRace();
		this.alianza = getEnumAliance();

		this.characterDescription = getDescripcionDePersonaje();
		this.nick = nickname;
		this.lvl = 0;
	}

	/**
	 * @param nickname: el nombre del nuevo personaje.
	 * @param clase:    la clase del nuevo personaje.
	 * @param lvl:      el nivel del nuevo personaje.
	 * @throws ClaseNoAceptadaParaRazaException Devuelve una excepcion en caso de que la clase del
	 *                   personaje no sea correspondiente a la raza.
	 */
	public RazaBase(String nickname, T clase, int lvl) throws ClaseNoAceptadaParaRazaException {
		this(nickname, clase);
		this.lvl = lvl;
	}

	/**
	 * Metodo para comparar si un personaje es igual a otro objeto. Esta
	 * implementado para comparar si el nombre de los personajes es igual, entonces
	 * los personajes son iguales.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RazaBase<?>) {
			if (this.getNick().equals(((RazaBase<?>) obj).getNick())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Metodo para obtener los atributos base de una raza.
	 */
	protected abstract AtributosBase getBaseAtributesFromRace();

	/**
	 * Metodo para obtener la descripcion de un personaje.
	 */
	public String getCharacterDescription() {
		return this.characterDescription;
	}

	/**
	 * Metodo para obtener la descripcion de un personaje segun raza.
	 */
	protected abstract String getDescripcionDePersonaje();

	/**
	 * Metodo para obtener la alianza segun raza.
	 */
	protected abstract POSIBLES_ALIANZAS getEnumAliance();

	/**
	 * Metodo para obtener la raza de un personaje segun raza.
	 */
	protected abstract POSIBLES_RAZAS getEnumRace();

	/**
	 * Una funcion para comprobar que la clase es aceptada segun raza.
	 * 
	 * @param c el enum de la clase a ser comprobada.
	 * @return true si es aceptada, sino false.
	 * 
	 * @Descripcion Clases posibles segun raza:
	 *              <p>
	 *              Orco -> Guerrero, Paladin, Picaro, Cazador
	 *              <p>
	 *              Trol -> Guerrero, Brujo
	 *              <p>
	 *              Goblin -> Picaro, Guerrero, Brujo
	 *              <p>
	 *              No muerto -> Brujo, Sacerdote, Mago
	 *              <p>
	 * 
	 *              Humano -> Guerrero, Paladin, Picaro, Cazador
	 *              <p>
	 *              Elfo -> Druida, Brujo, Sacerdote, Mago
	 *              <p>
	 *              Enano -> Picaro, Guerrero, Paladin
	 *              <p>
	 *              Draenel -> Brujo, Sacerdote, Mago
	 */
	protected abstract boolean getEsUnaClaseAceptada(POSIBLES_CLASES c);

	/**
	 * Getter de habilidades.
	 */
	public ArrayList<Habilidad> getHabilidades() {
		return habilidades;
	}

	/**
	 * Getter de nivel.
	 */
	public Integer getLvl() {
		return this.lvl;
	}

	/**
	 * Getter de nombre.
	 */
	public String getNick() {
		return this.nick;
	}

	/**
	 * Getter de alianza.
	 */
	public POSIBLES_ALIANZAS getNombreDeAlianza() {
		return this.alianza;
	}

	/**
	 * Getter de Clase.
	 */
	public POSIBLES_CLASES getNombreDeClase() {
		return this.clase;
	}

	/**
	 * Getter de raza.
	 */
	public POSIBLES_RAZAS getNombreDeRaza() {
		return this.raza;
	}

	/**
	 * Override para el equals.
	 */
	@Override
	public int hashCode() {
		return 0;
	}

	/**
	 * Simple override.
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();

		output.append(getNick());
		output.append(" "); //$NON-NLS-1$
		output.append(getLvl());
		output.append(" "); //$NON-NLS-1$
		output.append(getNombreDeAlianza());
		output.append(" "); //$NON-NLS-1$
		output.append(getNombreDeRaza());
		output.append(" "); //$NON-NLS-1$
		output.append(getNombreDeClase());
		output.append(" "); //$NON-NLS-1$
		output.append(getCharacterDescription());

		return output.toString();
	}
}