package razas.ClasesConcretas;

import atributes.Atributes;
import atributes.AtributosBase;
import razas.ClasesNoConcretas.RazaBase;
import razas.InterfacesClasesConcretas.HerenciaHumana;

public class Humano <T extends HerenciaHumana> extends RazaBase<T> {
	public Humano(String nickname,T clase) {
		super(nickname, clase);
		// TODO Auto-generated constructor stub
	}
	
	public Humano(String nickname,T clase, Atributes attr, int lvl) {
		super(nickname, clase, attr, lvl);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		return POSIBLES_RAZAS.HUMANO;
	}

	@Override
	protected POSIBLES_ALIANZAS getEnumAliance() {
		return POSIBLES_ALIANZAS.GUARDIANES;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		return "Un humano";
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
