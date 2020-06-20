package personajes.clases.recursos;

/**
 * Clase que contiene los recursos de una clase.
 * 
 * @author lautarowojcik
 */
public class Recursos {
	/*
	 * Posibles recursos vida, mana, furia, stamina;
	 */

	protected MaximosRecursos maxRec;

	protected float vida;
	protected float mana;
	protected float furia;
	protected float stamina;

	public Recursos(MaximosRecursos maxRec) {
		super();
		this.maxRec = maxRec;
		this.vida = maxRec.getVida();
		this.mana = maxRec.getMana();
		this.furia = maxRec.getFuria();
		this.stamina = maxRec.getStamina();
	}

	public Recursos(MaximosRecursos maxRec, float vida, float mana, float furia, float stamina) {
		super();
		this.maxRec = maxRec;
		this.vida = vida;
		this.mana = mana;
		this.furia = furia;
		this.stamina = stamina;
	}

	public float getFuria() {
		return furia;
	}

	public float getMana() {
		return mana;
	}

	public int getMaxFuria() {
		return maxRec.getFuria();
	}

	public int getMaxMana() {
		return maxRec.getMana();
	}

	public int getMaxStamina() {
		return maxRec.getStamina();
	}

	public int getMaxVida() {
		return maxRec.getVida();
	}

	public float getStamina() {
		return stamina;
	}

	public float getVida() {
		return vida;
	}

	public void setFuria(float furia) {
		this.furia = furia;

		if (this.furia < 0)
			this.furia = 0;
	}

	public void setMana(float mana) {
		this.mana = mana;

		if (this.mana < 0)
			this.mana = 0;
	}

	public void setMaxFuria(int furia) {
		maxRec.setFuria(furia);

		if (getFuria() > furia)
			setFuria(furia);
	}

	public void setMaxMana(int mana) {
		maxRec.setMana(mana);

		if (getMana() > mana)
			setMana(mana);
	}

	public void setMaxStamina(int stamina) {
		maxRec.setStamina(stamina);

		if (getStamina() > stamina)
			setStamina(stamina);
	}

	public void setMaxVida(int vida) {
		maxRec.setVida(vida);

		if (getVida() > vida)
			setVida(vida);
	}

	public void setStamina(float stamina) {
		this.stamina = stamina;

		if (this.stamina < 0)
			this.stamina = 0;
	}

	public void setVida(float vida) {
		this.vida = vida;

		if (this.vida < 0)
			this.vida = 0;
	}
}