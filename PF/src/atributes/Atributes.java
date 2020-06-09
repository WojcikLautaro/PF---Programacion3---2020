package atributes;

public class Atributes {
	/* Posibles atributos:
	 * Fuerza,
	 * Inteligencia,
	 * Sabiduria,
	 * Destreza,
	 * Suerte,
	 * Divinidad,
	 * Carisma,
	 * Aguante;
	 */
	
	public AtributosBase baseAtributes;
	public AtributeMultipliers multipliers;
	
	public Atributes () {
		this.baseAtributes = new AtributosBase();
		this.multipliers = new AtributeMultipliers();
	}
	
	/**
	 * @param baseAtributes
	 */
	public Atributes (AtributosBase baseAtributes) {
		this.baseAtributes = baseAtributes;
		this.multipliers = new AtributeMultipliers();
	}
	
	public Atributes (AtributosBase baseAtributes, AtributeMultipliers multipliers) {
		this.baseAtributes = baseAtributes;
		this.multipliers = multipliers;
	}
	
	public void setAtributesMultiplier (AtributeMultipliers multipliers) {
		this.multipliers = multipliers;
	}
	
	public void setBaseAtributes (AtributosBase baseAtributes) {
		this.baseAtributes = baseAtributes;
	}
	
	public Float getLuck() {
		return baseAtributes.getLuck() * multipliers.getLuck();
	}
	public Float getDivinity() {
		return baseAtributes.getDivinity() * multipliers.getDivinity();
	}
	public Float getCharisma() {
		return baseAtributes.getCarism() * multipliers.getCarism();
	}
	public Float getEndurance() {
		return baseAtributes.getEndurance() * multipliers.getEndurance();
	}
	public Float getStrenght() {
		return baseAtributes.getStrenght() * multipliers.getStrenght();
	}
	public Float getInteligence() {
		return baseAtributes.getInteligence() * multipliers.getInteligence();
	}
	public Float getWisdom() {
		return baseAtributes.getWisdom() * multipliers.getWisdom();
	}
	public Float getDexterity() {
		return baseAtributes.getDexterity() * multipliers.getDexterity();
	}
}
