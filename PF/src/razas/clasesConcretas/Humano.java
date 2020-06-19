package razas.clasesConcretas;

import atributosDeRazaYClase.AtributosBase;
import clases.interfaces.ClaseBase;
import razas.clasesNoConcretas.Guardianes;
import razas.excepciones.ClaseNoAceptadaParaRazaException;

/**
 * Clase que implementa metodos abstractos de {@code RazaBase<?>}
 * 
 * @author lautarowojcik
 */
public final class Humano<T extends ClaseBase> extends Guardianes<T> {
	public Humano(String nickname, T clase) throws ClaseNoAceptadaParaRazaException {
		super(nickname, clase);
	}

	public Humano(String nickname, T clase, int lvl) throws ClaseNoAceptadaParaRazaException {
		super(nickname, clase, lvl);
	}

	@Override
	protected AtributosBase getBaseAtributesFromRace() {
		AtributosBase base = new AtributosBase(1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000);

		return base;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		return "Un humano";
	}

	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		return POSIBLES_RAZAS.HUMANO;
	}

	@Override
	protected boolean getEsUnaClaseAceptada(razas.clasesNoConcretas.RazaBase.POSIBLES_CLASES c) {
		switch (c) {
		case GUERRERO:
			return true;
		case PALADIN:
			return true;
		case PICARO:
			return true;
		case CAZADOR:
			return true;
		default:
			return false;
		}
	}
}
