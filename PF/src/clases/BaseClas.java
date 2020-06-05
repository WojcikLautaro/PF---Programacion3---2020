package clases;
import java.util.ArrayList;

import atributes.AtributeMultipliers;
import character.Ability;
import character.BaseRace.POSIBLE_CLASES;
import character.Resources;

public abstract class BaseClas {
	private static final String NO_CLASS = "No Class";

	
	
	public static String getClassName () {
		return NO_CLASS;
	}
	
	public static POSIBLE_CLASES getEnumClas () {
		return POSIBLE_CLASES.NO_CLASS;
	}
	
	public static ArrayList<Ability> getClassAbilities () {
		return new ArrayList <> ();
	}
	
	public static Resources getClassResources () {
		Resources resources = null;
		
		return resources;
	}
	
	public static AtributeMultipliers getBaseAtributesFromClas () {
		AtributeMultipliers base = new AtributeMultipliers();
		base.setCarism		(1);
		base.setDexterity	(1);
		base.setDivinity	(1);
		base.setEndurance	(1);
		base.setInteligence	(1);
		base.setLuck		(1);
		base.setStrenght	(1);
		base.setWisdom		(1);
		
		return base;
	}
}
