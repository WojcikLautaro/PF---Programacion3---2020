package razas;

import atributes.Atributes;
import atributes.AtributosBase;
import clases.ClaseBase;

public class Trol <T extends ClaseBase> extends Exiliados<T> {
	public Trol(String nickname,T clase) {
		super(nickname, clase);
		// TODO Auto-generated constructor stub
	}
	
	public Trol(String nickname,T clase, Atributes attr, int lvl) {
		super(nickname, clase, attr, lvl);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		// TODO Auto-generated method stub
		return POSIBLES_RAZAS.TROL;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AtributosBase getBaseAtributesFromRace() {
		// TODO Auto-generated method stub
		return null;
	}
}