package character;

import java.util.ArrayList;
import atributes.Atributes;
import atributes.BaseAtributes;
import clases.BaseClas;

public abstract class BaseRace <T extends BaseClas>{
	public static enum POSIBLE_ALIANCES {
		EXILIADOS,
		GUARDIANES
	}
	public static enum POSIBLE_RACES {
		ORCO,
		NOMUERTO,
		TROL,
		GOBLIN,
		HUMANO,
		ELFO,
		ENANO,
		DRAENEL
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
	
	public POSIBLE_ALIANCES aliance;
	public POSIBLE_RACES race;
	public T.POSIBLE_CLASES job;
	
	public String characterDescription;
	public ArrayList <String> titles;
	public String nick;
	public Integer lvl;
	
	public Resources resources;
	public Atributes atributes;
	public ArrayList <Ability> abilities;
	
	public BaseRace () {
		this.atributes = new Atributes (getBaseAtributesFromRace());
		this.atributes.setAtributesMultiplier(T.getBaseAtributesFromClas());
		
		this.resources = T.getClassResources();
		this.abilities = new ArrayList <> (T.getClassAbilities());
		
		/*
		aliance;
		race;
		job;
		
		characterDescription;
		titles;
		nick;
		lvl;
		*/
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