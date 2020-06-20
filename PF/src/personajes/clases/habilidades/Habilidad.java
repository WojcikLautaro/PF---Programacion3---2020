package personajes.clases.habilidades;

/**
 * Clase que contiene los nombres de habilidad y sus descripciones.
 * 
 * @author lautarowojcik
 */
public abstract class Habilidad {
	protected String nombre;

	// Escala en base a los artibutos del pj
	protected String descripcion;

	/*
	 * public static enum TipoDeHabilidad { HABILIDAD_ACTIVA, HABILIDAD_PASIVA }
	 * public String tipoDeHabilidad; public Float cooldown; public Float charge;
	 * public String costType; public Float cost;
	 */

	public Habilidad(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}
}
