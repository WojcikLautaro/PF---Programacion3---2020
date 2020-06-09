package atributes;

public class AtributeMultipliers {
	protected float luck;
	protected float divinity;
	protected float carism;
	protected float endurance;
	protected float strenght;
	protected float inteligence;
	protected float wisdom;
	protected float dexterity;
	
	public AtributeMultipliers () {
		strenght = 1;
		inteligence = 1;
		wisdom = 1;
		dexterity = 1;
		luck = 1;
		divinity = 1;
		carism = 1;
		endurance = 1;
	}
	
	public AtributeMultipliers (
			float luck, 
			float divinity, 
			float carism,
			float endurance, 
			float strenght,
			float inteligence, 
			float wisdom, 
			float dexterity
			) {
		super();
		this.luck = luck;
		this.divinity = divinity;
		this.carism = carism;
		this.endurance = endurance;
		this.strenght = strenght;
		this.inteligence = inteligence;
		this.wisdom = wisdom;
		this.dexterity = dexterity;
	}
	
	public Float getLuck() {
		return luck;
	}
	public void setLuck(float luck) {
		this.luck = luck;
	}
	public Float getDivinity() {
		return divinity;
	}
	public void setDivinity(float divinity) {
		this.divinity = divinity;
	}
	public Float getCarism() {
		return carism;
	}
	public void setCarism(float carism) {
		this.carism = carism;
	}
	public Float getEndurance() {
		return endurance;
	}
	public void setEndurance(float endurance) {
		this.endurance = endurance;
	}
	public Float getStrenght() {
		return strenght;
	}
	public void setStrenght(float strenght) {
		this.strenght = strenght;
	}
	public Float getInteligence() {
		return inteligence;
	}
	public void setInteligence(float inteligence) {
		this.inteligence = inteligence;
	}
	public Float getWisdom() {
		return wisdom;
	}
	public void setWisdom(float wisdom) {
		this.wisdom = wisdom;
	}
	public Float getDexterity() {
		return dexterity;
	}
	public void setDexterity(float dexterity) {
		this.dexterity = dexterity;
	}
}	