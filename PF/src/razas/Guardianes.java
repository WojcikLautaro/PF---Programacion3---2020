package razas;

import atributes.Atributes;
import clases.ClaseBase;

public abstract class Guardianes <T extends ClaseBase> extends RazaBase <T> {
	public Guardianes(String nickname) {
		super(nickname);
		// TODO Auto-generated constructor stub
	}

	public Guardianes(String nickname, Atributes attr, int lvl) {
		super(nickname, attr, lvl);
		// TODO Auto-generated constructor stub
	}
	
	protected POSIBLES_ALIANZAS getEnumAliance () {
		return POSIBLES_ALIANZAS.GUARDIANES;
	}
}
