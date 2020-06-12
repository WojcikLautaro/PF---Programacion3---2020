package razas.ClasesConcretas;

import atributes.AtributosBase;
import clases.interfaces.ClaseBase;
import razas.ClasesNoConcretas.RazaBase;

public class Humano <T extends ClaseBase> extends RazaBase<T> {	
	public Humano(String nickname,T clase) throws Exception {
		super(nickname, clase);
		// TODO Auto-generated constructor stub
	}
	
	public Humano(String nickname,T clase, int lvl) throws Exception {
		super(nickname, clase, lvl);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		return POSIBLES_RAZAS.HUMANO;
	}

	@Override
	protected POSIBLES_ALIANZAS getEnumAliance() {
		return POSIBLES_ALIANZAS.GUARDIANES;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		return "Un humano";
	}

	@Override
	protected AtributosBase getBaseAtributesFromRace() {
		AtributosBase base = new AtributosBase(
				23,
				20,
				22,
				20,
				21,
				18
				);

		return base;
	}

	@Override
	protected boolean getEsUnaClaseAceptada(razas.ClasesNoConcretas.RazaBase.POSIBLES_CLASES c) {
		switch (c) {
			case GUERRERO:
				return true;
			case PALADÍN:
				return true;
			case PÍCARO:
				return true;
			case CAZADOR:
				return true;
			default: 
				return false;
		}
	}
}
