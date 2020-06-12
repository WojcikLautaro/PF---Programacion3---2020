package razas.ClasesConcretas;

import atributes.Atributes;
import atributes.AtributosBase;
import razas.ClasesNoConcretas.Exiliados;
import razas.InterfacesClasesConcretas.HerenciaTroll;

public class Trol <T extends HerenciaTroll> extends Exiliados<T> {
	public Trol(String nickname,T clase) {
		super(nickname, clase);
	}
	
	public Trol(String nickname,T clase, Atributes attr, int lvl) {
		super(nickname, clase, attr, lvl);
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