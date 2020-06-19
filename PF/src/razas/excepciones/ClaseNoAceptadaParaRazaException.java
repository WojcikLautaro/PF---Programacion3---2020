package razas.excepciones;

import clases.interfaces.ClaseBase;

public class ClaseNoAceptadaParaRazaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 408901262805964006L;
	
	private ClaseBase clase;

	public ClaseNoAceptadaParaRazaException(ClaseBase clase) {
		super("Clase no aceptada: " + clase.getEnumDeClase());
		this.clase = clase;
	}

	public ClaseBase getClase() {
		return clase;
	}

}
