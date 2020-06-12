package atributes;


public class AtributosBase {
	protected int strenght;
	protected int dexterity;
	protected int endurance;
	protected int inteligence;
	protected int luck;
	protected int wisdom;

	
	public AtributosBase () {
		strenght = 0;
		dexterity = 0;
		endurance = 0;
		inteligence = 0;
		luck = 0;
		wisdom = 0;
	}
	
	public AtributosBase(
			int strenght, 
			int dexterity, 
			int endurance,
			int inteligence, 
			int luck, 
			int wisdom
			){
		super();
		this.strenght = strenght;
		this.dexterity = dexterity;
		this.endurance = endurance;
		this.inteligence = inteligence;
		this.luck = luck;
		this.wisdom = wisdom;
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
	public Integer getEndurance() {
		return endurance;
	}
	public void setEndurance(Integer endurance) {
		this.endurance = endurance;
	}
}