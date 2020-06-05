package atributes;

public class Atributes {
	public static enum POSIBLE_ATRIBUTES { 
		STRENGHT,
		INTELIGENCE,
		WISDOM,
		DEXTERITY,
		LUCK,
		DIVINITY,
		CHARISM,
		ENDURANCE;
	}
	
	protected BaseAtributes baseAtributes;
	protected AtributeMultipliers multipliers;
	
	public Atributes (BaseAtributes baseAtributes) {
		this.baseAtributes = baseAtributes;
		multipliers = new AtributeMultipliers();
	}
	
	public void setAtributesMultiplier (AtributeMultipliers multipliers) {
		this.multipliers = multipliers;
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
	
	public void setDexterity(int dexterity) {
		this.baseAtributes.setDexterity(dexterity);
	}
	public void setLuck(int luck) {
		this.baseAtributes.setLuck(luck);
	}
	public void setWisdom(int wisdom) {
		this.baseAtributes.setWisdom(wisdom);
	}
	public void setDivinity(int divinity) {
		this.baseAtributes.setDivinity(divinity);
	}
	public void setEndurance(int endurance) {
		this.baseAtributes.setEndurance(endurance);
	}
	public void setStrenght(int strenght) {
		this.baseAtributes.setStrenght(strenght);
	}
	public void setInteligence(int inteligence) {
		this.baseAtributes.setInteligence(inteligence);
	}
	public void setCharisma(int carism) {
		this.baseAtributes.setCarism(carism);
	}
	
	public void setDexterityMultiplier(Float dexterity) {
		this.multipliers.setDexterity(dexterity);
	}
	public void setLuckMultiplier(Float luck) {
		this.multipliers.setLuck(luck);
	}
	public void setWisdomMultiplier(Float wisdom) {
		this.multipliers.setWisdom(wisdom);
	}
	public void setDivinityMultiplier(Float divinity) {
		this.multipliers.setDivinity(divinity);
	}
	public void setEnduranceMultiplier(Float endurance) {
		this.multipliers.setEndurance(endurance);
	}
	public void setStrenghtMultiplier(Float strenght) {
		this.multipliers.setStrenght(strenght);
	}
	public void setInteligenceMultiplier(Float inteligence) {
		this.multipliers.setInteligence(inteligence);
	}
	public void setCharismaMultiplier(Float carism) {
		this.multipliers.setCarism(carism);
	}
}
