package atributes;

public class Atributes {
	
	/**
	 * 
	 * Los atributos, estos variaran segun clase y raza. Su totalidad se calcula en base a 
	 * los atributos base de cada clase y raza, multiplicada por su multiplicadores.
	 *
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
		return baseAtributes.getLuck() * multipliers.getLuckMult();
	}
	public Float getEndurance() {
		return baseAtributes.getEndurance() * multipliers.getEnduranceMult();
	}
	public Float getStrenght() {
		return baseAtributes.getStrenght() * multipliers.getStrenghtMult();
	}
	public Float getInteligence() {
		return baseAtributes.getInteligence() * multipliers.getInteligenceMult();
	}
	public Float getWisdom() {
		return baseAtributes.getWisdom() * multipliers.getWisdomMult();
	}
	public Float getDexterity() {
		return baseAtributes.getDexterity() * multipliers.getDexterityMult();
	}
}
