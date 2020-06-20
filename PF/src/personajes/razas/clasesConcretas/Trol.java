package personajes.razas.clasesConcretas;

import personajes.atributosDeRazaYClase.AtributosBase;
import personajes.clases.interfaces.ClaseBase;
import personajes.razas.clasesNoConcretas.Exiliados;
import personajes.razas.excepciones.ClaseNoAceptadaParaRazaException;

public final class Trol<T extends ClaseBase> extends Exiliados<T> {
	public Trol(String nickname, T clase) throws ClaseNoAceptadaParaRazaException {
		super(nickname, clase);
	}

	public Trol(String nickname, T clase, int lvl) throws ClaseNoAceptadaParaRazaException {
		super(nickname, clase, lvl);
	}

	@Override
	protected AtributosBase getBaseAtributesFromRace() {
		AtributosBase base = new AtributosBase(1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000);

		return base;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		return "Un trol";
	}

	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		return POSIBLES_RAZAS.TROL;
	}

	@Override
	protected boolean getEsUnaClaseAceptada(personajes.razas.clasesNoConcretas.RazaBase.POSIBLES_CLASES c) {
		switch (c) {
		case GUERRERO:
			return true;
		case BRUJO:
			return true;
		default:
			return false;
		}
	}
}