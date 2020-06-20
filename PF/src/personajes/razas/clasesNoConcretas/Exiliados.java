package personajes.razas.clasesNoConcretas;

import personajes.clases.interfaces.ClaseBase;
import personajes.razas.excepciones.ClaseNoAceptadaParaRazaException;

/**
 * Clase que implementa metodos abstractos de {@code RazaBase<?>}
 * 
 * @author lautarowojcik
 */
public abstract class Exiliados<T extends ClaseBase> extends RazaBase<T> {
	public Exiliados(String nickname, T clase) throws ClaseNoAceptadaParaRazaException {
		super(nickname, clase);
	}

	public Exiliados(String nickname, T clase, int lvl) throws ClaseNoAceptadaParaRazaException {
		super(nickname, clase, lvl);
	}

	@Override
	protected POSIBLES_ALIANZAS getEnumAliance() {
		return POSIBLES_ALIANZAS.EXILIADOS;
	}
}
