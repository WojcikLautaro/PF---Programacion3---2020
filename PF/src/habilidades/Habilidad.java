package habilidades;

public abstract class Habilidad {
	protected String nombre;

	//Escala en base a los artibutos del pj
	protected String descripcion;
	
	//TODO posible implementacion
	/* public static enum TipoDeHabilidad { HABILIDAD_ACTIVA, HABILIDAD_PASIVA }
	 * public String tipoDeHabilidad;
	 * public Float cooldown;
	 * public Float charge;
	 * public String costType;
	 * public Float cost;
	 */
	
	public Habilidad (String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public String getNombre () {
		return this.nombre;
	}
	
	public String getDescripcion () {
		return this.descripcion;
	}
}
