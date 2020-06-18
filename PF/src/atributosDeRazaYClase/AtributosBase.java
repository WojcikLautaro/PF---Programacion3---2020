package atributosDeRazaYClase;

public class AtributosBase {
	protected int strenght;
	protected int inteligence;
	protected int wisdom;
	protected int dexterity;
	protected int luck;
	protected int divinity;
	protected int carism;
	protected int endurance;

	public AtributosBase() {
		strenght = 0;
		inteligence = 0;
		wisdom = 0;
		dexterity = 0;
		luck = 0;
		divinity = 0;
		carism = 0;
		endurance = 0;
	}

	public AtributosBase(int strenght, int inteligence, int wisdom, int dexterity, int luck, int divinity, int carism,
			int endurance) {
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

	public Integer getCarism() {
		return carism;
	}

	public Integer getDexterity() {
		return dexterity;
	}

	public Integer getDivinity() {
		return divinity;
	}

	public Integer getEndurance() {
		return endurance;
	}

	public Integer getInteligence() {
		return inteligence;
	}

	public Integer getLuck() {
		return luck;
	}

	public Integer getStrenght() {
		return strenght;
	}

	public Integer getWisdom() {
		return wisdom;
	}

	public void setCarism(Integer carism) {
		this.carism = carism;
	}

	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}

	public void setDivinity(Integer divinity) {
		this.divinity = divinity;
	}

	public void setEndurance(Integer endurance) {
		this.endurance = endurance;
	}

	public void setInteligence(Integer inteligence) {
		this.inteligence = inteligence;
	}

	public void setLuck(Integer luck) {
		this.luck = luck;
	}

	public void setStrenght(Integer strenght) {
		this.strenght = strenght;
	}

	public void setWisdom(Integer wisdom) {
		this.wisdom = wisdom;
	}
}