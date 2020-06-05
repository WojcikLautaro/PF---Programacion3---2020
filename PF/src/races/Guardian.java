package races;

import java.util.ArrayList;

import character.Ability;
import character.BaseRace;
import character.Resources;

public abstract class Guardian extends BaseRace {
	public static enum POSIBLE_ALIANCES { Guardianes }
	public static enum POSIBLE_RACES { 
		Humano,
		Elfo,
		Enano,
		Draenel
	};

	public Guardian(Resources resources, ArrayList<Ability> abilities) {
		super(resources, abilities);
		// TODO Auto-generated constructor stub
	}
}
