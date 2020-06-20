package personajes.atributosDeRazaYClase;

/**
 * Clase que se usa para contener los multiplicadores de atributos.
 * 
 * @author lautarowojcik
 */
public class AtributeMultipliers {
	protected float luck;
	protected float divinity;
	protected float carism;
	protected float endurance;
	protected float strenght;
	protected float inteligence;
	protected float wisdom;
	protected float dexterity;

	public AtributeMultipliers() {
		strenght = 1;
		inteligence = 1;
		wisdom = 1;
		dexterity = 1;
		luck = 1;
		divinity = 1;
		carism = 1;
		endurance = 1;
	}

	public AtributeMultipliers(float luck, float divinity, float carism, float endurance, float strenght,
			float inteligence, float wisdom, float dexterity) {
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

	public Float getCarism() {
		return carism;
	}

	public Float getDexterity() {
		return dexterity;
	}

	public Float getDivinity() {
		return divinity;
	}

	public Float getEndurance() {
		return endurance;
	}

	public Float getInteligence() {
		return inteligence;
	}

	public Float getLuck() {
		return luck;
	}

	public Float getStrenght() {
		return strenght;
	}

	public Float getWisdom() {
		return wisdom;
	}

	public void setCarism(float carism) {
		this.carism = carism;
	}

	public void setDexterity(float dexterity) {
		this.dexterity = dexterity;
	}

	public void setDivinity(float divinity) {
		this.divinity = divinity;
	}

	public void setEndurance(float endurance) {
		this.endurance = endurance;
	}

	public void setInteligence(float inteligence) {
		this.inteligence = inteligence;
	}

	public void setLuck(float luck) {
		this.luck = luck;
	}

	public void setStrenght(float strenght) {
		this.strenght = strenght;
	}

	public void setWisdom(float wisdom) {
		this.wisdom = wisdom;
	}
}