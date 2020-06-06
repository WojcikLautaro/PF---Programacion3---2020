package razas;

import atributes.Atributes;
import atributes.AtributosBase;
import clases.Guerrero;

public class Orco <T extends Guerrero> extends Exiliados <T>{

	/*
	 * Orco -> Guerrero, Paladin, Picaro, Cazador
	 * Trol -> Guerrero, Brujo
	 * Goblin -> Picaro, Guerrero, Brujo
	 * No muerto -> Brujo, Sacerdote, Mago
	 * 
	 * Humano -> Guerrero, Paladin, Picaro, Cazador
	 * Elfo -> Druida, Brujo, Sacerdote, Mago
	 * Enano -> Picaro, Guerrero, Paladin
	 * Draenel -> Brujo, Sacerdote, Mago
	 */
	
	public Orco(String nickname) {
		super(nickname);
		// TODO Auto-generated constructor stub
	}
	
	public Orco(String nickname, Atributes attr, int lvl) {
		super(nickname, attr, lvl);
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
