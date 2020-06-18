package razas.clasesNoConcretas;

import clases.interfaces.ClaseBase;

public abstract class Exiliados<T extends ClaseBase> extends RazaBase<T> {
	public Exiliados(String nickname, T clase) throws Exception {
		super(nickname, clase);
	}

	public Exiliados(String nickname, T clase, int lvl) throws Exception {
		super(nickname, clase, lvl);
	}

	@Override
	protected POSIBLES_ALIANZAS getEnumAliance() {
		return POSIBLES_ALIANZAS.EXILIADOS;
	}
}
