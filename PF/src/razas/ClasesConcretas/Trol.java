package razas.ClasesConcretas;

import atributes.AtributosBase;
import clases.interfaces.ClaseBase;
import razas.ClasesNoConcretas.Exiliados;

public class Trol <T extends ClaseBase> extends Exiliados<T> {
	public Trol(String nickname,T clase) throws Exception {
		super(nickname, clase);
	}
	
	public Trol(String nickname,T clase, int lvl) throws Exception {
		super(nickname, clase, lvl);
	}

	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		return POSIBLES_RAZAS.TROL;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		return "Un trol";
	}

	@Override
	protected AtributosBase getBaseAtributesFromRace() {
		AtributosBase base = new AtributosBase(
				24,
				22,
				23,
				16,
				21,
				15
				);

		return base;
	}
	
	@Override
	protected boolean getEsUnaClaseAceptada(razas.ClasesNoConcretas.RazaBase.POSIBLES_CLASES c) {
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