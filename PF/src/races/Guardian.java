package races;

import java.util.ArrayList;

import character.Ability;
import character.BaseRace;
import character.Resources;
import clases.BaseClas;

public abstract class Guardian <T extends BaseClas> extends BaseRace <T> {
	public static enum POSIBLE_ALIANCES { Guardianes }
	public static enum POSIBLE_RACES { 
		Humano,
		Elfo,
		Enano,
		Draenel
	};

	public Guardian(Resources resources, ArrayList<Ability> abilities) {
		super();
		// TODO Auto-generated constructor stub
	}
}
