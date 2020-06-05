package character;

import java.util.ArrayList;
import atributes.Atributes;
import atributes.BaseAtributes;
import clases.BaseClas;

public abstract class BaseRace <T extends BaseClas>{
	public static enum POSIBLE_ALIANCES {
		EXILIADOS,
		GUARDIANES,
		NOALIANCE
	}
	public static enum POSIBLE_RACES {
		ORCO,
		NOMUERTO,
		TROL,
		GOBLIN,
		HUMANO,
		ELFO,
		ENANO,
		DRAENEL,
		NORACE
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
	public static enum POSIBLE_CLASES {
		GUERRERO, 
		PALADÍN, 
		CAZADOR, 
		PÍCARO, 
		SACERDOTE, 
		MAGO,
		BRUJO,
		DRUIDA,
		NO_CLASS
	}
	
	public POSIBLE_ALIANCES aliance;
	public POSIBLE_RACES race;
	public POSIBLE_CLASES job;
	
	public String characterDescription;
	public String nick;
	public Integer lvl;
	
	public Resources resources;
	public Atributes atributes;
	public ArrayList <Ability> abilities;
	
	/**
	 * @param String nickname: el nombre dek nuevo personaje.
	 * @return Devuelve un objeto de la clase "BaseRace" nuevo. este metodo esta dedicado a personajes recien creados.
	 */
	
	public BaseRace (String nickname) {
		this.atributes = new Atributes (getBaseAtributesFromRace());
		this.atributes.setAtributesMultiplier(T.getBaseAtributesFromClas());
		
		this.resources = T.getClassResources();
		this.abilities = new ArrayList <> (T.getClassAbilities());
		
		this.job = T.getEnumClas ();
		this.race = getEnumRace ();
		this.aliance = getEnumAliance ();
		
		this.characterDescription = getCharacterDescription ();
		this.nick = nickname;
		this.lvl = 0;
	}
	
	public BaseRace (String nickname, Atributes attr, int lvl) {
		this(nickname);
		
		this.atributes = new Atributes (getBaseAtributesFromRace());
		this.lvl = lvl;
	}
	
	protected static POSIBLE_RACES getEnumRace () {
		return POSIBLE_RACES.NORACE;
	}
	
	protected static POSIBLE_ALIANCES getEnumAliance () {
		return POSIBLE_ALIANCES.NOALIANCE;
	}
	
	protected static String getCharacterDescription () {
		return "";
	}
	
	protected static BaseAtributes getBaseAtributesFromRace () {
		BaseAtributes base = new BaseAtributes();
		base.setCarism		(1000);
		base.setDexterity	(1000);
		base.setDivinity	(1000);
		base.setEndurance	(1000);
		base.setInteligence	(1000);
		base.setLuck		(1000);
		base.setStrenght	(1000);
		base.setWisdom		(1000);
			
		return base;
	}
}