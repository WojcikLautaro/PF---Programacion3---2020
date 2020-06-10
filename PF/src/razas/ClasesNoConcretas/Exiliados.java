package razas.ClasesNoConcretas;

import clases.ClaseBase;

public abstract class Exiliados <T extends ClaseBase> extends RazaBase <T> {
	public Exiliados(String nickname,T clase) throws Exception {
		super(nickname, clase);
		// TODO Auto-generated constructor stub
	}

	public Exiliados(String nickname,T clase, int lvl) throws Exception {
		super(nickname, clase, lvl);
		// TODO Auto-generated constructor stub
	}

	protected POSIBLES_ALIANZAS getEnumAliance () {
		return POSIBLES_ALIANZAS.EXILIADOS;
	}
}
