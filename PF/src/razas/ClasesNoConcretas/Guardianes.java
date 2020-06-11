package razas.ClasesNoConcretas;

import clases.interfaces.ClaseBase;

public abstract class Guardianes <T extends ClaseBase> extends RazaBase <T> {
	public Guardianes(String nickname, T clase) throws Exception {
		super(nickname, clase);
		// TODO Auto-generated constructor stub
	}

	public Guardianes(String nickname, T clase, int lvl) throws Exception {
		super(nickname, clase, lvl);
		// TODO Auto-generated constructor stub
	}
	
	protected POSIBLES_ALIANZAS getEnumAliance () {
		return POSIBLES_ALIANZAS.GUARDIANES;
	}
}
