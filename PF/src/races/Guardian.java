package races;

import java.util.ArrayList;

import character.Ability;
import character.BaseRace;
import character.Resources;
import clases.BaseClas;

public abstract class Guardian <T extends BaseClas> extends BaseRace <T> {
	public static enum POSIBLE_ALIANCES { GUARDIANES }
	public static enum POSIBLE_RACES { 
		HUMANO,
		ELFO,
		ENANO,
		DRAENEL
	};

	public Guardian(Resources resources, ArrayList<Ability> abilities) {
		super();
		// TODO Auto-generated constructor stub
	}
}
