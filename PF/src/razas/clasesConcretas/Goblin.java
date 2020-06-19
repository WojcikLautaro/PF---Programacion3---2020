package razas.clasesConcretas;

import atributosDeRazaYClase.AtributosBase;
import clases.interfaces.ClaseBase;
import razas.clasesNoConcretas.Exiliados;
import razas.excepciones.ClaseNoAceptadaParaRazaException;

/**
 * Clase que implementa metodos abstractos de {@code RazaBase<?>}
 * 
 * @author lautarowojcik
 */
public final class Goblin<T extends ClaseBase> extends Exiliados<T> {
	public Goblin(String nickname, T clase) throws ClaseNoAceptadaParaRazaException {
		super(nickname, clase);
	}

	public Goblin(String nickname, T clase, int lvl) throws ClaseNoAceptadaParaRazaException {
		super(nickname, clase, lvl);
	}

	@Override
	protected AtributosBase getBaseAtributesFromRace() {
		AtributosBase base = new AtributosBase(1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000);

		return base;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		return "Un goblin";
	}

	@Override
	protected POSIBLES_ALIANZAS getEnumAliance() {
		return POSIBLES_ALIANZAS.EXILIADOS;
	}

	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		return POSIBLES_RAZAS.GOBLIN;
	}

	@Override
	protected boolean getEsUnaClaseAceptada(razas.clasesNoConcretas.RazaBase.POSIBLES_CLASES c) {
		switch (c) {
		case PICARO:
			return true;
		case GUERRERO:
			return true;
		case BRUJO:
			return true;
		default:
			return false;
		}
	}
}
