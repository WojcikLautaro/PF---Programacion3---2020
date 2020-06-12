package razas.ClasesConcretas;

import atributes.AtributosBase;
import clases.interfaces.ClaseBase;
import razas.ClasesNoConcretas.RazaBase;

public class Enano <T extends ClaseBase> extends RazaBase<T> {
	public Enano(String nickname,T clase) throws Exception {
		super(nickname, clase);
	}
	
	public Enano(String nickname,T clase, int lvl) throws Exception {
		super(nickname, clase, lvl);
	}

	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		return POSIBLES_RAZAS.ENANO;
	}

	@Override
	protected POSIBLES_ALIANZAS getEnumAliance() {
		return POSIBLES_ALIANZAS.GUARDIANES;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		return "Un enano";
	}

	@Override
	protected AtributosBase getBaseAtributesFromRace() {
		AtributosBase base = new AtributosBase(
				25,
				16,
				25,
				19,
				19,
				15
				);

		return base;
	}
	
	@Override
	protected boolean getEsUnaClaseAceptada(razas.ClasesNoConcretas.RazaBase.POSIBLES_CLASES c) {
		switch (c) {
			case PÍCARO:
				return true;
			case GUERRERO:
				return true;
			case PALADÍN:
				return true;
			default: 
				return false;
		}
	}
}
