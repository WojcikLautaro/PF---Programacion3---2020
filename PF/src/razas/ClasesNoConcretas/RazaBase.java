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

public abstract class RazaBase<T extends ClaseBase> {
	public static enum RAZAS_EXILIADAS {
		ORCO, NOMUERTO, TROL, GOBLIN
	}

	public static enum RAZAS_GUARDIANAS {
		HUMANO, ELFO, ENANO, DRAENEL
	}

	public static enum POSIBLES_ALIANZAS {
		EXILIADOS, GUARDIANES, SIN_ALIANZA
	}

	public static enum POSIBLES_CLASES {
		GUERRERO, PALADIN, CAZADOR, PICARO, SACERDOTE, MAGO, BRUJO, DRUIDA, SIN_CLASE;
	}

	public static enum POSIBLES_RAZAS {
		ORCO, NOMUERTO, TROL, GOBLIN, HUMANO, ELFO, ENANO, DRAENEL, SIN_RAZA
	}

	/*
	 * Orco -> Guerrero, Paladin, Picaro, Cazador Trol -> Guerrero, Brujo Goblin ->
	 * Picaro, Guerrero, Brujo No muerto -> Brujo, Sacerdote, Mago
	 * 
	 * Humano -> Guerrero, Paladin, Picaro, Cazador Elfo -> Druida, Brujo,
	 * Sacerdote, Mago Enano -> Picaro, Guerrero, Paladin Draenel -> Brujo,
	 * Sacerdote, Mago
	 */

	public final static RazaBase<?> getNuevoPersonaje(POSIBLES_RAZAS raza, POSIBLES_CLASES clase, String nick)
			throws Exception {
		return getNuevoPersonaje(raza, clase, nick, 0);
	}

	public final static RazaBase<?> getNuevoPersonaje(POSIBLES_RAZAS raza, POSIBLES_CLASES clase, String nick,
			int nivel) throws Exception {
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
			break;
		}

		throw new Exception();
	}

	protected POSIBLES_ALIANZAS alianza;

	protected POSIBLES_RAZAS raza;
	protected POSIBLES_CLASES clase;
	protected String characterDescription;
	protected String nick;

	protected Integer lvl;
	protected float experiencia;
	protected Recursos resources;

	protected Atributes atributes;

	protected ArrayList<Habilidad> habilidades;

	/**
	 * @param String nickname: el nombre del nuevo personaje.
	 * @return Devuelve un objeto de la clase "BaseRace" nuevo. este metodo esta
	 *         dedicado a personajes recien creados.
	 */

	public RazaBase(String nickname, T clase) throws Exception {
		if (getEsUnaClaseAceptada(clase.getEnumDeClase()))
			this.clase = clase.getEnumDeClase();
		else
			throw new Exception("Clase no aceptada: " + clase.getEnumDeClase());

		this.atributes = new Atributes(getBaseAtributesFromRace(), clase.getMultiplicadorDeAtributosDeClase());

		this.resources = clase.getClassResources();
		this.habilidades = new ArrayList<>(clase.getClassAbilities());

		this.raza = getEnumRace();
		this.alianza = getEnumAliance();

		this.characterDescription = getDescripcionDePersonaje();
		this.nick = nickname;
		this.lvl = 0;
		this.experiencia = 0;
	}

	public RazaBase(String nickname, T clase, int lvl) throws Exception {
		this(nickname, clase);
		this.lvl = lvl;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RazaBase<?>) {
			if (this.getNick().equals(((RazaBase<?>) obj).getNick())) {
				return true;
			}
		}

		return false;
	}

	protected abstract AtributosBase getBaseAtributesFromRace();

	public String getCharacterDescription() {
		return this.characterDescription;
	}

	protected abstract String getDescripcionDePersonaje();

	protected abstract POSIBLES_ALIANZAS getEnumAliance();

	protected abstract POSIBLES_RAZAS getEnumRace();

	protected abstract boolean getEsUnaClaseAceptada(POSIBLES_CLASES c);

	public ArrayList<Habilidad> getHabilidades() {
		return habilidades;
	}

	public Integer getLvl() {
		return this.lvl;
	}

	public String getNick() {
		return this.nick;
	}

	public POSIBLES_ALIANZAS getNombreDeAlianza() {
		return this.alianza;
	}

	public POSIBLES_CLASES getNombreDeClase() {
		return this.clase;
	}

	public POSIBLES_RAZAS getNombreDeRaza() {
		return this.raza;
	}

	@Override
	public int hashCode() {
		return 0;
	}

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