package razas.ClasesNoConcretas;

import java.util.ArrayList;
import atributes.Atributes;
import atributes.AtributosBase;
import clases.Brujo;
import clases.Cazador;
import clases.ClaseBase;
import clases.Druida;
import clases.Guerrero;
import clases.Mago;
import clases.Paladin;
import clases.Picaro;
import clases.Sacerdote;
import habilidades.Habilidad;
import razas.ClasesConcretas.Draenel;
import razas.ClasesConcretas.Elfo;
import razas.ClasesConcretas.Enano;
import razas.ClasesConcretas.Goblin;
import razas.ClasesConcretas.Humano;
import razas.ClasesConcretas.NoMuerto;
import razas.ClasesConcretas.Orco;
import razas.ClasesConcretas.Trol;
import recursos.Recursos;

public abstract class RazaBase<T extends ClaseBase> {
	public static enum POSIBLES_ALIANZAS {
		EXILIADOS, GUARDIANES, SIN_ALIANZA
	}

	public static enum POSIBLES_RAZAS {
		ORCO, NOMUERTO, TROL, GOBLIN, HUMANO, ELFO, ENANO, DRAENEL, SIN_RAZA
	}

	public static enum EXILED_RACES {
		ORCO, NOMUERTO, TROL, GOBLIN
	}

	public static enum GUARDIAN_RACES {
		HUMANO, ELFO, ENANO, DRAENEL
	}

	public static enum POSIBLES_CLASES {
		GUERRERO, PALADÍN, CAZADOR, PÍCARO, SACERDOTE, MAGO, BRUJO, DRUIDA, SIN_CLASE;
	}

	/*
	 * Orco -> Guerrero, Paladin, Picaro, Cazador Trol -> Guerrero, Brujo Goblin ->
	 * Picaro, Guerrero, Brujo No muerto -> Brujo, Sacerdote, Mago
	 * 
	 * Humano -> Guerrero, Paladin, Picaro, Cazador Elfo -> Druida, Brujo,
	 * Sacerdote, Mago Enano -> Picaro, Guerrero, Paladin Draenel -> Brujo,
	 * Sacerdote, Mago
	 */

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

	protected abstract POSIBLES_RAZAS getEnumRace();

	protected abstract POSIBLES_ALIANZAS getEnumAliance();

	protected abstract String getDescripcionDePersonaje();

	protected abstract AtributosBase getBaseAtributesFromRace();

	protected abstract boolean getEsUnaClaseAceptada(POSIBLES_CLASES c);

	public POSIBLES_RAZAS getNombreDeRaza() {
		return this.raza;
	}

	public POSIBLES_CLASES getNombreDeClase() {
		return this.clase;
	}

	public POSIBLES_ALIANZAS getNombreDeAlianza() {
		return this.alianza;
	}

	public String getCharacterDescription() {
		return this.characterDescription;
	}

	public String getNick() {
		return this.nick;
	}

	public Integer getLvl() {
		return this.lvl;
	}

	public ArrayList<Habilidad> getHabilidades() {
		return habilidades;
	}

	public static RazaBase<?> getNuevoPersonaje(POSIBLES_RAZAS raza, POSIBLES_CLASES clase, String nick, int nivel)
			throws Exception {
		switch (raza) {
		case ORCO:
			switch (clase) {
			case GUERRERO:
				return new Orco<>(nick, new Guerrero(), nivel);
			case PALADÍN:
				return new Orco<>(nick, new Paladin(), nivel);
			case CAZADOR:
				return new Orco<>(nick, new Cazador(), nivel);
			case PÍCARO:
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
			case PALADÍN:
				return new NoMuerto<>(nick, new Paladin(), nivel);
			case CAZADOR:
				return new NoMuerto<>(nick, new Cazador(), nivel);
			case PÍCARO:
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
			case PALADÍN:
				return new Trol<>(nick, new Paladin(), nivel);
			case CAZADOR:
				return new Trol<>(nick, new Cazador(), nivel);
			case PÍCARO:
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
			case PALADÍN:
				return new Goblin<>(nick, new Paladin(), nivel);
			case CAZADOR:
				return new Goblin<>(nick, new Cazador(), nivel);
			case PÍCARO:
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
			case PALADÍN:
				return new Humano<>(nick, new Paladin(), nivel);
			case CAZADOR:
				return new Humano<>(nick, new Cazador(), nivel);
			case PÍCARO:
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
			case PALADÍN:
				return new Elfo<>(nick, new Paladin(), nivel);
			case CAZADOR:
				return new Elfo<>(nick, new Cazador(), nivel);
			case PÍCARO:
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
			case PALADÍN:
				return new Enano<>(nick, new Paladin(), nivel);
			case CAZADOR:
				return new Enano<>(nick, new Cazador(), nivel);
			case PÍCARO:
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
			case PALADÍN:
				return new Draenel<>(nick, new Paladin(), nivel);
			case CAZADOR:
				return new Draenel<>(nick, new Cazador(), nivel);
			case PÍCARO:
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

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();

		output.append(getNick());
		output.append(" ");
		output.append(getLvl());
		output.append(" ");
		output.append(getNombreDeAlianza());
		output.append(" ");
		output.append(getNombreDeRaza());
		output.append(" ");
		output.append(getNombreDeClase());
		output.append(" ");
		output.append(getCharacterDescription());

		return output.toString();
	}
}