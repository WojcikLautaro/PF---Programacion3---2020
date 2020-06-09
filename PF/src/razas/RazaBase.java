package razas;

import java.util.ArrayList;
import atributes.Atributes;
import atributes.AtributosBase;
import clases.ClaseBase;
import habilidades.Habilidad;
import recursos.Recursos;

public abstract class RazaBase <T extends ClaseBase> {
	public static enum POSIBLES_ALIANZAS {
		EXILIADOS,
		GUARDIANES,
		SIN_ALIANZA
	}
	public static enum POSIBLES_RAZAS {
		ORCO,
		NOMUERTO,
		TROL,
		GOBLIN,
		HUMANO,
		ELFO,
		ENANO,
		DRAENEL,
		SIN_RAZA
	}
	public static enum EXILED_RACES {
		ORCO,
		NOMUERTO,
		TROL,
		GOBLIN
	}
	public static enum GUARDIAN_RACES {
		HUMANO,
		ELFO,
		ENANO,
		DRAENEL
	}
	public static enum POSIBLES_CLASES {
		GUERRERO, 
		PALADÍN, 
		CAZADOR, 
		PÍCARO, 
		SACERDOTE, 
		MAGO,
		BRUJO,
		DRUIDA,
		SIN_CLASE
	}
	
	/*
	 * Orco -> Guerrero, Paladin, Picaro, Cazador
	 * Trol -> Guerrero, Brujo
	 * Goblin -> Picaro, Guerrero, Brujo
	 * No muerto -> Brujo, Sacerdote, Mago
	 * 
	 * Humano -> Guerrero, Paladin, Picaro, Cazador
	 * Elfo -> Druida, Brujo, Sacerdote, Mago
	 * Enano -> Picaro, Guerrero, Paladin
	 * Draenel -> Brujo, Sacerdote, Mago
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
	protected ArrayList <Habilidad> abilities;
	
	/**
	 * @param String nickname: el nombre del nuevo personaje.
	 * @return Devuelve un objeto de la clase "BaseRace" nuevo. este metodo esta dedicado a personajes recien creados.
	 */
	
	public RazaBase (String nickname, T clase) {
		this.atributes = new Atributes (getBaseAtributesFromRace(), clase.getMultiplicadorDeAtributosDeClase());
		
		this.resources = clase.getClassResources();
		this.abilities = new ArrayList <> (clase.getClassAbilities());
		
		this.clase = clase.getEnumDeClase ();
		this.raza = getEnumRace ();
		this.alianza = getEnumAliance ();
		
		this.characterDescription = getDescripcionDePersonaje ();
		this.nick = nickname;
		this.lvl = 0;
		this.experiencia = 0;
	}
	
	public RazaBase (String nickname, T clase, Atributes attr, int lvl) {
		this(nickname, clase);
		
		this.atributes = new Atributes (getBaseAtributesFromRace());
		this.lvl = lvl;
	}
	
	protected abstract POSIBLES_RAZAS getEnumRace ();
	protected abstract POSIBLES_ALIANZAS getEnumAliance ();
	protected abstract String getDescripcionDePersonaje ();
	protected abstract AtributosBase getBaseAtributesFromRace ();
	
	
	public POSIBLES_RAZAS getNombreDeRaza () {
		return this.raza;
	}
	
	public POSIBLES_CLASES getNombreDeClase () {
		return this.clase;
	}
	
	public POSIBLES_ALIANZAS getNombreDeAlianza () {
		return this.alianza;
	}
	
	public String getCharacterDescription () {
		return this.characterDescription;
	}
	
	public String getNick () {
		return this.nick;
	}
	
	public Integer getLvl () {
		return this.lvl;
	}
	
	public ArrayList <Habilidad> getHabilidades () {
		return new ArrayList <> ();
	}
	
	@Override
	public String toString () {
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