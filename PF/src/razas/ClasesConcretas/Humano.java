package razas.ClasesConcretas;

import atributes.Atributes;
import atributes.AtributosBase;
import clases.ClaseBase;
import razas.ClasesNoConcretas.RazaBase;

public class Humano <T extends ClaseBase> extends RazaBase<T> {
	public static enum POSIBLES_CLASES {
		GUERRERO, 
		PALADÍN, 
		CAZADOR, 
		PÍCARO, 
		SACERDOTE, 
		MAGO,
		BRUJO,
		DRUIDA,
		SIN_CLASE
	}
	
	public Humano(String nickname,T clase) throws Exception {
		super(nickname, clase);
		// TODO Auto-generated constructor stub
	}
	
	public Humano(String nickname,T clase, Atributes attr, int lvl) throws Exception {
		super(nickname, clase, lvl);
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

	@Override
	protected boolean getEsUnaClaseAceptada(razas.ClasesNoConcretas.RazaBase.POSIBLES_CLASES c) {
		switch (c) {
			case GUERRERO:
				return true;
			case PALADÍN:
				return true;
			case PÍCARO:
				return true;
			case CAZADOR:
				return true;
			default: 
				return false;
		}
	}
}
