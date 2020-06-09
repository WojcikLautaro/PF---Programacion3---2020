package razas.ClasesConcretas;

import atributes.Atributes;
import atributes.AtributosBase;
import razas.ClasesNoConcretas.Exiliados;
import razas.InterfacesClasesConcretas.HerenciaOrca;

public class Orco <T extends HerenciaOrca> extends Exiliados <T> {
	public Orco(String nickname,T clase) {
		super(nickname, clase);
	}
	
	public Orco(String nickname,T clase, Atributes attr, int lvl) {
		super(nickname, clase, attr, lvl);
	}

	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		return POSIBLES_RAZAS.ORCO;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		return "Un orco";
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
