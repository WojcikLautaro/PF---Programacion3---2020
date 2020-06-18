package atributosDeRazaYClase;

public class Atributes {
	/*
	 * Posibles atributos: Fuerza, Inteligencia, Sabiduria, Destreza, Suerte,
	 * Divinidad, Carisma, Aguante;
	 */

	public AtributosBase baseAtributes;
	public AtributeMultipliers multipliers;

	public Atributes() {
		this.baseAtributes = new AtributosBase();
		this.multipliers = new AtributeMultipliers();
	}

	/**
∫	 * @param baseAtributes
	 */
	public Atributes(AtributosBase baseAtributes) {
		this.baseAtributes = baseAtributes;
		this.multipliers = new AtributeMultipliers();
	}

	public Atributes(AtributosBase baseAtributes, AtributeMultipliers multipliers) {
		this.baseAtributes = baseAtributes;
		this.multipliers = multipliers;
	}

	public Float getCharisma() {
		return baseAtributes.getCarism() * multipliers.getCarism();
	}

	public Float getDexterity() {
		return baseAtributes.getDexterity() * multipliers.getDexterity();
	}

	public Float getDivinity() {
		return baseAtributes.getDivinity() * multipliers.getDivinity();
	}

	public Float getEndurance() {
		return baseAtributes.getEndurance() * multipliers.getEndurance();
	}

	public Float getInteligence() {
		return baseAtributes.getInteligence() * multipliers.getInteligence();
	}

	public Float getLuck() {
		return baseAtributes.getLuck() * multipliers.getLuck();
	}

	public Float getStrenght() {
		return baseAtributes.getStrenght() * multipliers.getStrenght();
	}

	public Float getWisdom() {
		return baseAtributes.getWisdom() * multipliers.getWisdom();
	}

	public void setAtributesMultiplier(AtributeMultipliers multipliers) {
		this.multipliers = multipliers;
	}

	public void setBaseAtributes(AtributosBase baseAtributes) {
		this.baseAtributes = baseAtributes;
	}
}
