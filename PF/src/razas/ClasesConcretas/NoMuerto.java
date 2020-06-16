package razas.ClasesConcretas;

import atributes.AtributosBase;
import clases.interfaces.ClaseBase;
import razas.ClasesNoConcretas.Exiliados;

public final class NoMuerto <T extends ClaseBase> extends Exiliados<T> {
	public NoMuerto(String nickname,T clase) throws Exception {
		super(nickname, clase);
	}
	
	public NoMuerto(String nickname, T clase, int lvl) throws Exception {
		super(nickname, clase, lvl);
	}

	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		return POSIBLES_RAZAS.NOMUERTO;
	}

	@Override
	protected POSIBLES_ALIANZAS getEnumAliance() {
		return POSIBLES_ALIANZAS.EXILIADOS;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		return "Un no muerto";
	}

	@Override
	protected AtributosBase getBaseAtributesFromRace() {
		AtributosBase base = new AtributosBase(
				1000,
				1000,
				1000,
				1000,
				1000,
				1000,
				1000,
				1000
				);

		return base;
	}
	
	@Override
	protected boolean getEsUnaClaseAceptada(razas.ClasesNoConcretas.RazaBase.POSIBLES_CLASES c) {
		switch (c) {
			case SACERDOTE:
				return true;
			case BRUJO:
				return true;
			case MAGO:
				return true;
			default: 
				return false;
		}
	}
}
