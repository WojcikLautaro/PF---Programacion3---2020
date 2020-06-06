package razas;

import java.util.ArrayList;
import atributes.Atributes;
import atributes.AtributosBase;
import clases.ClaseBase;
import habilidades.Habilidad;
import recursos.Recursos;

public abstract class RazaBase <T extends ClaseBase>{
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
	
	protected POSIBLES_ALIANZAS aliance;
	protected POSIBLES_RAZAS race;
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
	
	public RazaBase (String nickname) {
		this.atributes = new Atributes (getBaseAtributesFromRace(), T.getMultiplicadorDeAtributosDeClase());
		
		this.resources = T.getClassResources();
		this.abilities = new ArrayList <> (T.getClassAbilities());
		
		this.clase = T.getEnumDeClase ();
		this.race = getEnumRace ();
		this.aliance = getEnumAliance ();
		
		this.characterDescription = getDescripcionDePersonaje ();
		this.nick = nickname;
		this.lvl = 0;
		this.experiencia = 0;
	}
	
	public RazaBase (String nickname, Atributes attr, int lvl) {
		this(nickname);
		
		this.atributes = new Atributes (getBaseAtributesFromRace());
		this.lvl = lvl;
	}
	
	protected abstract POSIBLES_RAZAS getEnumRace ();
	protected abstract POSIBLES_ALIANZAS getEnumAliance ();
	protected abstract String getDescripcionDePersonaje ();
	
	protected abstract AtributosBase getBaseAtributesFromRace ();
}