package races;

import java.util.ArrayList;

import character.Ability;
import character.BaseRace;
import character.Resources;
import clases.BaseClas;

public abstract class Exile <T extends BaseClas> extends BaseRace <T> {
	public static enum POSIBLE_ALIANCES { EXILIADOS }
	public static enum POSIBLE_RACES { 
		ORCO,
		NOMUERTO,
		TROL,
		GOBLIN
	}
	
	public Exile(Resources resources, ArrayList<Ability> abilities) {
		super();
		// TODO Auto-generated constructor stub
	}
}
