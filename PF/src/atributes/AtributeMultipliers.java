package atributes;

/**
 * 
 * Los multiplicadores de cada atributo segun su clase y raza.
 * 
 */

public class AtributeMultipliers {
	protected float strenghtMult;
	protected float dexterityMult;
	protected float enduranceMult;
	protected float inteligenceMult;
	protected float luckMult;
	protected float wisdomMult;
	
	
	public AtributeMultipliers () {
		strenghtMult = 0;
		enduranceMult = 0;
		dexterityMult = 0;
		inteligenceMult = 0;
		luckMult = 0;
		wisdomMult = 0;
	}
	
	public AtributeMultipliers (
			float strenghtMult,
			float dexterityMult,
			float enduranceMult, 
			float luckMult, 
			float inteligenceMult, 
			float wisdomMult
			) {
		super();
		this.strenghtMult = strenghtMult;
		this.dexterityMult = dexterityMult;
		this.enduranceMult = enduranceMult;
		this.inteligenceMult = inteligenceMult;
		this.luckMult = luckMult;
		this.wisdomMult = wisdomMult;
		
	}
	
	public Float getLuckMult() {
		return luckMult;
	}
	public void setLuckMult(float luckMult) {
		this.luckMult = luckMult;
	}
	public Float getEnduranceMult() {
		return enduranceMult;
	}
	public void setEnduranceMult(float enduranceMult) {
		this.enduranceMult = enduranceMult;
	}
	public Float getStrenghtMult() {
		return strenghtMult;
	}
	public void setStrenghtMult(float strenghtMult) {
		this.strenghtMult = strenghtMult;
	}
	public Float getInteligenceMult() {
		return inteligenceMult;
	}
	public void setInteligenceMult(float inteligenceMult) {
		this.inteligenceMult = inteligenceMult;
	}
	public Float getWisdomMult() {
		return wisdomMult;
	}
	public void setWisdomMult(float wisdomMult) {
		this.wisdomMult = wisdomMult;
	}
	public Float getDexterityMult() {
		return dexterityMult;
	}
	public void setDexterityMult(float dexterityMult) {
		this.dexterityMult = dexterityMult;
	}
}	