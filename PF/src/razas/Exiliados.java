package razas;

import atributes.Atributes;
import clases.ClaseBase;

public abstract class Exiliados <T extends ClaseBase> extends RazaBase <T> {
	public Exiliados(String nickname,T clase) {
		super(nickname, clase);
		// TODO Auto-generated constructor stub
	}

	public Exiliados(String nickname,T clase, Atributes attr, int lvl) {
		super(nickname, clase, attr, lvl);
		// TODO Auto-generated constructor stub
	}

	protected POSIBLES_ALIANZAS getEnumAliance () {
		return POSIBLES_ALIANZAS.EXILIADOS;
	}
}
