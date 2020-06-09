package razas;

import atributes.Atributes;
import atributes.AtributosBase;
import clases.ClaseBase;

public class Orco <T extends ClaseBase> extends Exiliados <T> {
	public Orco(String nickname,T clase) {
		super(nickname, clase);
		// TODO Auto-generated constructor stub
	}
	
	public Orco(String nickname,T clase, Atributes attr, int lvl) {
		super(nickname, clase, attr, lvl);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		return POSIBLES_RAZAS.ORCO;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		return Messages.getString("Orco.Description"); //$NON-NLS-1$
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
