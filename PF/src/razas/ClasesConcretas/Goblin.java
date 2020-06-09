package razas.ClasesConcretas;

import atributes.Atributes;
import atributes.AtributosBase;
import clases.ClaseBase;
import razas.Exiliados;

public class Goblin <T extends ClaseBase> extends Exiliados<T> {
	public Goblin(String nickname,T clase) {
		super(nickname, clase);
	}
	
	public Goblin(String nickname, T clase, Atributes attr, int lvl) {
		super(nickname, clase, attr, lvl);
	}

	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		return POSIBLES_RAZAS.GOBLIN;
	}

	@Override
	protected POSIBLES_ALIANZAS getEnumAliance() {
		// TODO Auto-generated method stub
		return POSIBLES_ALIANZAS.EXILIADOS;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		return "Un goblin";
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
