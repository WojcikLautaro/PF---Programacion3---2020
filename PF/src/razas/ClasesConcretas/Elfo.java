package razas.ClasesConcretas;

import atributes.Atributes;
import atributes.AtributosBase;
import clases.ClaseBase;
import razas.RazaBase;

public class Elfo <T extends ClaseBase> extends RazaBase<T> {
	public Elfo(String nickname,T clase) {
		super(nickname, clase);
	}
	
	public Elfo(String nickname,T clase, Atributes attr, int lvl) {
		super(nickname, clase, attr, lvl);
	}

	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		return POSIBLES_RAZAS.ELFO;
	}

	@Override
	protected POSIBLES_ALIANZAS getEnumAliance() {
		return POSIBLES_ALIANZAS.GUARDIANES;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		return "Un elfo";
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
}
