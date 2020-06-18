package razas.clasesConcretas;

import atributosDeRazaYClase.AtributosBase;
import clases.interfaces.ClaseBase;
import razas.clasesNoConcretas.Guardianes;

public final class Enano<T extends ClaseBase> extends Guardianes<T> {
	public Enano(String nickname, T clase) throws Exception {
		super(nickname, clase);
	}

	public Enano(String nickname, T clase, int lvl) throws Exception {
		super(nickname, clase, lvl);
	}

	@Override
	protected AtributosBase getBaseAtributesFromRace() {
		AtributosBase base = new AtributosBase(1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000);

		return base;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		return "Un enano";
	}

	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		return POSIBLES_RAZAS.ENANO;
	}

	@Override
	protected boolean getEsUnaClaseAceptada(razas.clasesNoConcretas.RazaBase.POSIBLES_CLASES c) {
		switch (c) {
		case PICARO:
			return true;
		case GUERRERO:
			return true;
		case PALADIN:
			return true;
		default:
			return false;
		}
	}
}
