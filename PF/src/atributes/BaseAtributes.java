package atributes;

public class BaseAtributes {
	protected int strenght;
	protected int inteligence;
	protected int wisdom;
	protected int dexterity;
	protected int luck;
	protected int divinity;
	protected int carism;
	protected int endurance;
	
	public BaseAtributes () {
		strenght = 0;
		inteligence = 0;
		wisdom = 0;
		dexterity = 0;
		luck = 0;
		divinity = 0;
		carism = 0;
		endurance = 0;
	}
	
	public BaseAtributes(
			int strenght, 
			int inteligence, 
			int wisdom, 
			int dexterity, 
			int luck, 
			int divinity, 
			int carism,
			int endurance
			) {
		super();
		this.strenght = strenght;
		this.inteligence = inteligence;
		this.wisdom = wisdom;
		this.dexterity = dexterity;
		this.luck = luck;
		this.divinity = divinity;
		this.carism = carism;
		this.endurance = endurance;
	}
	
	public Integer getStrenght() {
		return strenght;
	}
	public void setStrenght(Integer strenght) {
		this.strenght = strenght;
	}
	public Integer getInteligence() {
		return inteligence;
	}
	public void setInteligence(Integer inteligence) {
		this.inteligence = inteligence;
	}
	public Integer getWisdom() {
		return wisdom;
	}
	public void setWisdom(Integer wisdom) {
		this.wisdom = wisdom;
	}
	public Integer getDexterity() {
		return dexterity;
	}
	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}
	public Integer getLuck() {
		return luck;
	}
	public void setLuck(Integer luck) {
		this.luck = luck;
	}
	public Integer getDivinity() {
		return divinity;
	}
	public void setDivinity(Integer divinity) {
		this.divinity = divinity;
	}
	public Integer getCarism() {
		return carism;
	}
	public void setCarism(Integer carism) {
		this.carism = carism;
	}
	public Integer getEndurance() {
		return endurance;
	}
	public void setEndurance(Integer endurance) {
		this.endurance = endurance;
	}
}