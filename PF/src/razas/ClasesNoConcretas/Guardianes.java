package razas.ClasesNoConcretas;

import atributes.Atributes;
import razas.InterfasesClasesNoConcretas.HerenciaParaGuardianes;

public abstract class Guardianes <T extends HerenciaParaGuardianes> extends RazaBase <T> {
	public Guardianes(String nickname, T clase) {
		super(nickname, clase);
		// TODO Auto-generated constructor stub
	}

	public Guardianes(String nickname, T clase, Atributes attr, int lvl) {
		super(nickname, clase, attr, lvl);
		// TODO Auto-generated constructor stub
	}
	
	protected POSIBLES_ALIANZAS getEnumAliance () {
		return POSIBLES_ALIANZAS.GUARDIANES;
	}
}
