package razas.ClasesConcretas;

import atributes.Atributes;
import atributes.AtributosBase;
import razas.ClasesNoConcretas.Exiliados;
import razas.InterfacesClasesConcretas.HerenciaNoMuerta;

public class NoMuerto <T extends HerenciaNoMuerta> extends Exiliados<T> {
	public NoMuerto(String nickname,T clase) {
		super(nickname, clase);
	}
	
	public NoMuerto(String nickname, T clase, Atributes attr, int lvl) {
		super(nickname, clase, attr, lvl);
	}

	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		return POSIBLES_RAZAS.NOMUERTO;
	}

	@Override
	protected POSIBLES_ALIANZAS getEnumAliance() {
		return POSIBLES_ALIANZAS.EXILIADOS;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		return "Un no muerto";
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
