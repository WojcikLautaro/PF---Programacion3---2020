package razas.ClasesConcretas;

import atributes.Atributes;
import atributes.AtributosBase;
import razas.ClasesNoConcretas.RazaBase;
import razas.InterfacesClasesConcretas.HerenciaEnana;

public class Enano <T extends HerenciaEnana> extends RazaBase<T> {
	public Enano(String nickname,T clase) {
		super(nickname, clase);
	}
	
	public Enano(String nickname,T clase, Atributes attr, int lvl) {
		super(nickname, clase, attr, lvl);
	}

	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		return POSIBLES_RAZAS.ENANO;
	}

	@Override
	protected POSIBLES_ALIANZAS getEnumAliance() {
		return POSIBLES_ALIANZAS.GUARDIANES;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		return "Un enano";
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
