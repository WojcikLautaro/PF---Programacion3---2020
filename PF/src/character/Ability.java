package character;

import atributes.Atributes;

public abstract class Ability {
	public String nombre;

	//Escala en base a los artibutos del pj
	public String descripcion;
	
	//TODO posible implementacion
	/* public static enum TipoDeHabilidad { HABILIDAD_ACTIVA, HABILIDAD_PASIVA }
	 * public String tipoDeHabilidad;
	 * public Float cooldown;
	 * public Float charge;
	 * public String costType;
	 * public Float cost;
	 */
	
	public Ability (Atributes attr, Resources rsrc) {
		
	}
	
	public void efecto () {}
}
