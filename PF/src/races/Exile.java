package races;

import java.util.ArrayList;

import atributes.BaseAtributes;
import character.Ability;
import character.BaseRace;
import character.Resources;

public abstract class Exile extends BaseRace {
	public static enum POSIBLE_ALIANCES { Exiliados }
	public static enum POSIBLE_RACES { 
		Orco,
		NoMuerto,
		Trol,
		Goblin
	};
	
	public Exile(Resources resources, ArrayList<Ability> abilities) {
		super(resources, abilities);
		// TODO Auto-generated constructor stub
	}
}
