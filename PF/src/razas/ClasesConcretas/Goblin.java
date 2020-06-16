package razas.ClasesConcretas;

import atributes.AtributosBase;
import clases.interfaces.ClaseBase;
import razas.ClasesNoConcretas.Exiliados;

public final class Goblin <T extends ClaseBase> extends Exiliados<T> {
	public Goblin(String nickname,T clase) throws Exception {
		super(nickname, clase);
	}
	
	public Goblin(String nickname, T clase, int lvl) throws Exception {
		super(nickname, clase, lvl);
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
	
	@Override
	protected boolean getEsUnaClaseAceptada(razas.ClasesNoConcretas.RazaBase.POSIBLES_CLASES c) {
		switch (c) {
			case PÍCARO:
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
