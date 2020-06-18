package razas.clasesNoConcretas;

import clases.interfaces.ClaseBase;

public abstract class Guardianes<T extends ClaseBase> extends RazaBase<T> {
	public Guardianes(String nickname, T clase) throws Exception {
		super(nickname, clase);
	}

	public Guardianes(String nickname, T clase, int lvl) throws Exception {
		super(nickname, clase, lvl);
	}

	@Override
	protected POSIBLES_ALIANZAS getEnumAliance() {
		return POSIBLES_ALIANZAS.GUARDIANES;
	}
}
