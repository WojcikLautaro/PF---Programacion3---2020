package razas.clasesConcretas;

import atributosDeRazaYClase.AtributosBase;
import clases.interfaces.ClaseBase;
import razas.clasesNoConcretas.Guardianes;

public final class Elfo<T extends ClaseBase> extends Guardianes<T> {
	public Elfo(String nickname, T clase) throws Exception {
		super(nickname, clase);
	}

	public Elfo(String nickname, T clase, int lvl) throws Exception {
		super(nickname, clase, lvl);
	}

	@Override
	protected AtributosBase getBaseAtributesFromRace() {
		AtributosBase base = new AtributosBase(1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000);

		return base;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		return "Un elfo";
	}

	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		return POSIBLES_RAZAS.ELFO;
	}

	@Override
	protected boolean getEsUnaClaseAceptada(razas.clasesNoConcretas.RazaBase.POSIBLES_CLASES c) {
		switch (c) {
		case DRUIDA:
			return true;
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
