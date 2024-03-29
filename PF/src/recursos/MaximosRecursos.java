package recursos;

public class MaximosRecursos { 
	protected int vida;
	protected int mana;
	protected int furia;
	protected int stamina;
	
	public MaximosRecursos(int vida, int mana, int furia, int stamina) {
		super();
		setVida(vida);
		setMana(mana);
		setFuria(furia);
		setStamina(stamina);
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
		
		if(vida < 0)
			this.vida = 0;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
		
		if(mana < 0)
			this.mana = 0;
	}

	public int getFuria() {
		return furia;
	}

	public void setFuria(int furia) {
		this.furia = furia;
		
		if(furia < 0)
			this.furia = 0;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
		
		if(stamina < 0)
			this.stamina = 0;
	}
} 
