package razas.ClasesConcretas;

import atributes.AtributosBase;
import clases.interfaces.ClaseBase;
import razas.ClasesNoConcretas.RazaBase;

public class Draenel <T extends ClaseBase> extends RazaBase<T> {
	public Draenel(String nickname,T clase) throws Exception {
		super(nickname, clase);
	}
	
	public Draenel(String nickname,T clase, int lvl) throws Exception {
		super(nickname, clase, lvl);
	}

	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		return POSIBLES_RAZAS.DRAENEL;
	}

	@Override
	protected POSIBLES_ALIANZAS getEnumAliance() {
		return POSIBLES_ALIANZAS.GUARDIANES;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		return "Un draenel";
	}

	@Override
	protected AtributosBase getBaseAtributesFromRace() {
		AtributosBase base = new AtributosBase(
				21,
				17,
				19,
				21,
				22,
				23
				);

		return base;
	}
	
	@Override
	protected boolean getEsUnaClaseAceptada(razas.ClasesNoConcretas.RazaBase.POSIBLES_CLASES c) {
		switch (c) {
			case BRUJO:
				return true;
			case SACERDOTE:
				return true;
			case MAGO:
				return true;
			default: 
				return false;
		}
	}
}
