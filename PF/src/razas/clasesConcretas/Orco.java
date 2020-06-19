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
public final class Orco<T extends ClaseBase> extends Exiliados<T> {
	public Orco(String nickname, T clase) throws ClaseNoAceptadaParaRazaException {
		super(nickname, clase);
	}

	public Orco(String nickname, T clase, int lvl) throws ClaseNoAceptadaParaRazaException {
		super(nickname, clase, lvl);
	}

	@Override
	protected AtributosBase getBaseAtributesFromRace() {
		AtributosBase base = new AtributosBase(1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000);

		return base;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		return "Un orco";
	}

	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		return POSIBLES_RAZAS.ORCO;
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
