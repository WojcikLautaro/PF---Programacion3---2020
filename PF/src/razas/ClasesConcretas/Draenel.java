package razas.ClasesConcretas;

import atributes.Atributes;
import atributes.AtributosBase;

import clases.interfaces.IMage;
import razas.ClasesNoConcretas.RazaBase;
import razas.InterfacesClasesConcretas.HerenciaDraenelana;

public class Draenel <T extends HerenciaDraenelana> extends RazaBase<T>{

import razas.ClasesNoConcretas.RazaBase;
import razas.InterfacesClasesConcretas.HerenciaDraenelana;

public class Draenel <T extends HerenciaDraenelana> extends RazaBase<T> {
	public Draenel(String nickname,T clase) {
		super(nickname, clase);
	}
	
	public Draenel(String nickname,T clase, Atributes attr, int lvl) {
		super(nickname, clase, attr, lvl);
	}

	@Override
	protected POSIBLES_RAZAS getEnumRace() {
		return POSIBLES_RAZAS.DRAENEL;
	}

	@Override
	protected POSIBLES_ALIANZAS getEnumAliance() {
		return POSIBLES_ALIANZAS.GUARDIANES;
	}

	@Override
	protected String getDescripcionDePersonaje() {
		return "Un draenel";
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
